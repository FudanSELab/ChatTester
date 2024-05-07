#Zappos-JSON User Guide

1. [Overview](#TOC-Overview)
2. [ZJ performance](#TOC-ZJ-Performance)
3. [Goals for ZJ](#TOC-Goals-for-ZJ)
4. [Using ZJ](#TOC-Using-ZJ)
  * [Using ZJ with Maven](#TOC-ZJ-With-Maven)
  * [Primitives Examples](#TOC-Primitives-Examples)
  * [Object Examples](#TOC-Object-Examples)
  * [Nested Object Examples](#TOC-Nested-Object-Examples)
  * [Array Examples](#TOC-Array-Examples)
  * [Collections Examples](#TOC-Collections-Examples)
  * [Maps Examples](#TOC-Maps-Examples)
  * [Object Formatter Examples](#TOC-Object-Formatter-Examples)
  * [Annotation Examples](#TOC-Annotation-Examples)
  * [Base64 Examples](#TOC-Base64-Examples)
  
## <a name="TOC-Overview"></a>Overview
Zappos-json is a Java library that can be used to convert plain old Java objects (POJO) 
into their JSON representation, and vice versa. It uses code generation technique
to improve the performance by inlining serialization-related code into a generated class file.
The attributes in Java object must have accessor and mutator (getter and setter) methods in order to be included
in the process of either serialization or deserialization. The reason why zappos-json requires accessor and mutator
is because it doesn't use reflection API to access a private field. It may look a bit not flexible to have a public 
accessor and mutator for a private field at first but it's quite practical to have them rather than updating 
the private field directly.

## <a name="TOC-ZJ-Performance"></a>ZJ Performance
Zappos-json is designed from the ground up with performance in mind. It's thread-safe and it should perform very fast
because it generates the custom code for serializing and de-serializing based on your Java class definition. 
It uses javasisst toolkit to write a custom byte code that is optimized for your bean specifically.

## <a name="TOC-Goals-for-ZJ"></a>Goals for ZJ
* Provide an easy way to convert POJO to JSON and vice versa. 
* Allow any objects conforming to JavaBeans conventions to be converted to and from JSON
* Allow custom representations for objects
* Support arbitrarily complex objects
* Generate compact JSON output.
 
## <a name="TOC-Using-ZJ"></a>Using ZJ
The primary class to use is [`ZapposJson`](zappos-json/src/main/java/com/zappos/json/ZapposJson.java) 
which you can create by calling `ZapposJson.getIntance()`. The object is a singleton and it is thread-safe.
You can share the same instance throughout your application.  If you have different setting for each instance,
you can create another instance by calling `ZapposJson.getIntance(settingName)`.

## <a name="TOC-ZJ-With-Maven"></a>Using ZJ with Maven
You can use the ZJ version available in Maven Central by adding the following dependency:

```xml
<dependencies>
    <dependency>
      <groupId>com.zappos</groupId>
      <artifactId>zappos-json</artifactId>
      <version>0.1-alpha</version>
    </dependency>
</dependencies>
```

### <a name="TOC-Primitives-Examples"></a>Primitives Examples

```java
//Serialization
ZapposJson zj = ZapposJson.getInstance();
zj.toJson(1);            // ==> 1
zj.toJson("abc");        // ==> "abcd"
zj.toJson(new Long(10)); // ==> 10
int[] values = { 1 };
zj.toJson(values);       // ==> [1]

//Deserialization
int one = zj.fromJson("1", int.class);
Integer two = zj.fromJson("2", Integer.class);
Long three = zj.fromJson("1", Long.class);
Boolean yes = zj.fromJson("true", Boolean.class);
String str = zj.fromJson("\"abc\"", String.class);
```
### <a name="TOC-Object-Examples"></a>Object Examples

The class that can be used with ZJ must have public default constructor. All the properties that you
want to serialize/deserialize must have a pair of getter and setter. Otherwise, they will be ignored.

```java
public class MyObject {
  private int value1 = 1;
  private String value2 = "abc";
  private boolean value3 = true;
  public int getValue1() {
    return value1;
  }
  public void setValue1(int value1) {
    this.value1 = value1;
  }
  public String getValue2() {
    return value2;
  }
  public void setValue2(String value2) {
    this.value2 = value2;
  }
  public boolean isValue3() {
    return value3;
  }
  public void setValue3(boolean value3) {
    this.value3 = value3;
  }
}

MyObject obj = new MyObject();
ZapposJson zj = ZapposJson.getInstance();
String json = zj.toJson(obj);
System.out.println(json); 
//{"value1":1,"value2":"abc","value3":true}
obj = zj.fromJson(json, MyObject.class);
```

### <a name="TOC-Nested-Object-Examples"></a>Nested Object Examples

You can use nested object by embedding one class to another as long as there is no circular references
between them. You also can use nested class but the nested class must be public and static since
ZJ cannot access the parent reference and there is no plan to support dynamic nested class in the future. Google Gson  
 
```java
public class NestedObject {
  public static class Foo {
    private Bar bar = new Bar();
    public Bar getBar() {
      return bar;
    }
    public void setBar(Bar bar) {
      this.bar = bar;
    }
  }
  
  public static class Bar {
    public String name = "Anonymous";
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
  }
}

ZapposJson zj = ZapposJson.getInstance();
String json = zj.toJson(new Foo());
System.out.println(json);
//{"bar":{"name":"Anonymous"}}
Foo foo = zj.fromJson(json, Foo.class);
System.out.println(foo.getBar().getName());
//Anonymous
```

### <a name="TOC-Array-Examples"></a>Array Examples
 
```java
public class Foo {
  private Long[] bigNumbers = new Long[]{10L,20L,30L};
  public Long[] getBigNumbers() {
    return bigNumbers;
  }
  public void setBigNumbers(Long[] bigNumbers) {
    this.bigNumbers = bigNumbers;
  }
}
public class Array {
  private int[] smallNumbers = new int[]{1,2,3};
  private String[] strings = new String[]{"A", "B", "C"};
  private Foo foo = new Foo();
  public int[] getSmallNumbers() {
    return smallNumbers;
  }
  public void setSmallNumbers(int[] smallNumbers) {
    this.smallNumbers = smallNumbers;
  }
  public String[] getStrings() {
    return strings;
  }
  public void setStrings(String[] strings) {
    this.strings = strings;
  }
  public Foo getFoo() {
    return foo;
  }
  public void setFoo(Foo foo) {
    this.foo = foo;
  }
}

ZapposJson zj = ZapposJson.getInstance();
String json = zj.toJson(new Array());
System.out.println(json);
//{"foo":{"bigNumbers":[10,20,30]},"smallNumbers":[1,2,3],"strings":["A","B","C"]}
Array array = zj.fromJson(json, Array.class);
System.out.println(Arrays.toString(array.getSmallNumbers()));
//[1,2,3]
System.out.println(Arrays.toString(array.getStrings()));
//[A, B, C]
System.out.println(Arrays.toString(array.getFoo().getBigNumbers()));
//[10,20,30]
    
```
Currently, we don't support multi-dimensional array but we do support array of object type.

### <a name="TOC-Collection-Examples"></a>Collection Examples

```java
public class MyCollection {
  private Collection<String> first;
  private List<String> second;
  private LinkedList<Integer> third;
  public Collection<String> getFirst() {
    return first;
  }
  public void setFirst(Collection<String> first) {
    this.first = first;
  }
  public List<String> getSecond() {
    return second;
  }
  public void setSecond(List<String> second) {
    this.second = second;
  }
  public LinkedList<Integer> getThird() {
    return third;
  }
  public void setThird(LinkedList<Integer> third) {
    this.third = third;
  }
}

MyCollection col = new MyCollection();
List<String> first = new LinkedList<>();
first.add("A");first.add("B");first.add("C");
col.setFirst(first);
List<String> second = new LinkedList<>();
second.add("D");second.add("E");second.add("F");
col.setSecond(second);
LinkedList<Integer> third = new LinkedList<>();
third.add(1);third.add(2);third.add(3);
col.setThird(third);
ZapposJson zj = ZapposJson.getInstance();
String json = zj.toJson(col);
System.out.println(json);
//{"first":["A","B","C"],"second":["D","E","F"],"third":[1,2,3]}
col = zj.fromJson(json, MyCollection.class);
System.out.println(col.getFirst());
//[A, B, C]
System.out.println(col.getFirst().getClass());
//class java.util.ArrayList
System.out.println(col.getSecond());
//[D, E, F]
System.out.println(col.getSecond().getClass());
//class java.util.ArrayList
System.out.println(col.getThird());
//[1, 2, 3]
System.out.println(col.getThird().getClass());
//class java.util.LinkedList
```
Note that the default implementation of either Collection or List is ArrayList. 
Same as multi-dimensional array, ZJ doesn't support collection of collection yet.
The collection of collection is quite more difficult than multi-dimensional array because
the generic type will be erased by the compiler. There is no way to retrieve the type
information at run-time. We have to implement type hinting to overcome that limitation.


### <a name="TOC-Map-Examples"></a>Map Examples

```java
public class Foo {
  private String name;
  /**
   * Empty constructor is required when you have other constructors.
   */
  public Foo(){} 
  public Foo(String name){
    this.name = name;
  }
  @Override public String toString(){
    return name;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
public class MyMap {
  
  private Map<String, Integer> map1;
  
  private TreeMap<String, Foo> map2;

  public Map<String, Integer> getMap1() {
    return map1;
  }
  public void setMap1(Map<String, Integer> map1) {
    this.map1 = map1;
  }
  public TreeMap<String, Foo> getMap2() {
    return map2;
  }
  public void setMap2(TreeMap<String, Foo> map2) {
    this.map2 = map2;
  }
}

MyMap map = new MyMap();
Map<String, Integer> map1 = new Hashtable<>();
map1.put("A", 1);map1.put("B", 2);map1.put("C", 3);
map.setMap1(map1);
TreeMap<String, Foo> map2 = new TreeMap<>();
map2.put("A", new Foo("Ant"));
map2.put("B", new Foo("Boy"));
map2.put("C", new Foo("Cat"));
map.setMap2(map2);
ZapposJson zj = ZapposJson.getInstance();
String json = zj.toJson(map);
System.out.println(json);
//{"map1":{"A":1,"C":3,"B":2},"map2":{"A":{"name":"Ant"},"B":{"name":"Boy"},"C":{"name":"Cat"}}}
map = zj.fromJson(json, MyMap.class);
System.out.println(map.getMap1());
//{A=1, B=2, C=3}
System.out.println(map.getMap1().getClass());
//class java.util.HashMap
System.out.println(map.getMap2());
//{A=Ant, B=Boy, C=Cat}
System.out.println(map.getMap2().getClass());
//class java.util.TreeMap
```

Note that ZJ will use HashMap as the default implementation of Map interface if you don't provide
the concrete type of Map. Current limitation is that the map key must be string and ZJ doesn't 
support either Map of Map or Map of Collection. The type hinting is required because the generic type
will be erased by the compiler. Type hinting will be introduce in future version.

### <a name="TOC-Object-Formatter-Examples"></a>Object Formatter Examples

If you have the object that should represent scalar value in JSON format, you should
register the object formatter for that type of object. Otherwise, ZJ will treat that object
as a regular bean.
*Example:*
You have java.util.Date object and you want to produce the JSON data in milliseconds format.

```java
ZapposJson zj = ZapposJson.getInstance();
String json = zj.toJson(new Date());
System.out.println(json);
```

ZapposJson treat java.util.Date object as regular bean and produce the JSON like the following
```javascript
{"date":24,"day":4,"hours":14,"minutes":43,"month":11,"seconds":13,"time":1450996993350,"timezoneOffset":480,"year":115}
```
That's not what you want. You want a time in milliseconds. So, you have to define a custom object formatter for java.util.Date type.

```java
public class JavaDateFormatter extends AbstractValueFormatter<Date> {
  
  @Override
  public Date cast(Object obj) {
    return Date.class.cast(obj);
  }
  
  @Override
  public String format(ZapposJson zapposJson, Date object) {
    if(getPattern() != null){
      return toJsonValue(zapposJson, new SimpleDateFormat(getPattern()).format(object));
    }
    return String.valueOf(((Date) object).getTime());
  }
  
  @Override
  public Date parse(ZapposJson zapposJson, String string) throws Exception {
    if(getPattern() != null){
      return new SimpleDateFormat(getPattern()).parse(string);
    }
    return new Date(Long.parseLong(string));
  }

  @Override
  public ValueFormatter<Date> newInstance() {
    return new JavaDateFormatter();
  }
  
}
```

After you have defined JavaDateFormatter class, a custom object formatter for java.util.Date, 
you have to apply it to ZJ instance.

```java
ZapposJson zj = ZapposJson.getInstance();
zj.addValueFormatter(java.util.Date.class, new JavaDateFormatter());
String json = zj.toJson(new Date());
System.out.println(json);
//1450997530071
Date date = zj.fromJson(json, Date.class);
System.out.println(date);
//Thu Dec 24 14:52:10 PST 2015
```
ZJ comes with a set of default object formatters. You don't have to define most of the common
object such as java.math.BigDecimal, java.math.BigInteger, java.util.Date, java.sql.Date,
java.sql.Time, java.sql.Timestamp, java.time.Instant, java.time.LocalDate.

### <a name="TOC-Annotation-Examples"></a>Annotation Examples

```java
public static enum Gender {
  Male, Female, NoneOfAbove
}
public static class Foo {
  @JsonKey("first_name")
  private String firstName = "Chewbacca";
  
  @JsonFormat("MMM dd,yyyy")
  private Date birthdate;
  
  @JsonIgnore
  private Foo ignoreMe;
  
  @JsonEnum(EnumValue.STRING)
  private Gender gender;

  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public Date getBirthdate() {
    return birthdate;
  }
  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }
  public Foo getIgnoreMe() {
    return ignoreMe;
  }
  public void setIgnoreMe(Foo ignoreMe) {
    this.ignoreMe = ignoreMe;
  }
  public Gender getGender() {
    return gender;
  }
  public void setGender(Gender gender) {
    this.gender = gender;
  }
}

Foo foo = new Foo();
foo.setFirstName("Chewbacca");
foo.setBirthdate(new SimpleDateFormat("MMM dd, yyyy").parse("May 25, 1977"));
foo.setIgnoreMe(new Foo());
foo.setGender(Gender.Male);
ZapposJson zj = ZapposJson.getInstance();
String json = zj.toJson(foo);
System.out.println(json);
foo = zj.fromJson(json, Foo.class);
System.out.println(foo.getFirstName()); //Chewbacca
System.out.println(foo.getBirthdate()); //Wed May 25 00:00:00 PDT 1977
System.out.println(foo.getGender()); //Male
System.out.println(foo.getIgnoreMe()); //null
```

Sometimes the naming convention is different between platforms and you have to 
convert CamelCase to snake_case and vise versa. @JsonKey annotation allows you to 
use a custom key for an annotated property. There are also other annotations that
you can use to customize how ZJ serialize/deserialize.

### <a name="TOC-Base64-Examples"></a>Base64 Examples

ZJ encodes the byte array using Base64 algorithm automatically.

```java
public class ByteArrayBean {

  byte data[] = "it's supposed to be binary data".getBytes();

  public byte[] getData() {
    return data;
  }
  public void setData(byte[] data) {
    this.data = data;
  }
}
ByteArrayBean bean = new ByteArrayBean();
byte data[] = "it's supposed to be binary data".getBytes();
String base64 = Base64.getEncoder().encodeToString(data);
bean.setData(data);
String json = zapposJson.toJson(bean);
System.out.println(json);
//{"data":"aXQncyBzdXBwb3NlZCB0byBiZSBiaW5hcnkgZGF0YQ=="}
```







