import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.Statement;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import com.github.javaparser.ast.body.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.github.javaparser.ast.PackageDeclaration;

public class PublicInfo_collection {
    public static void main(String args[]) throws IOException {

        String filePath = args[0];
        String ClassName = args[1];

        String ClassInfo = Deal_underTest(filePath, ClassName);
        System.out.println(ClassInfo);
    }

    public static String Deal_underTest(String filePath, String ClassName) throws IOException{
       
        List<HashMap<String,String>> underTest_list = new ArrayList<>();

        // file read
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        String sourceCode = new String(bytes, StandardCharsets.UTF_8);

        CompilationUnit cu = StaticJavaParser.parse(sourceCode);

        //  public method signature
        List<String> public_method_signature = new ArrayList<>();
        // public field declaration
        List<String> public_field = new ArrayList<>();

        try{
            for (TypeDeclaration<?> type : cu.getTypes()) {
                for (BodyDeclaration<?> member : type.getMembers()) {
                    if (member instanceof FieldDeclaration) {
                        FieldDeclaration field = (FieldDeclaration) member;
                        if(field.isPublic()){
                            public_field.add(field.toString());
                        }
                    }
                    if (member instanceof MethodDeclaration) {
                        MethodDeclaration method = (MethodDeclaration) member;
                        if(method.isPublic()){
                            public_method_signature.add(method.getDeclarationAsString()+";");
                        }
                    }
                    if (member instanceof ConstructorDeclaration) {
                        ConstructorDeclaration method = (ConstructorDeclaration) member;
                        if(method.isPublic()){
                            public_method_signature.add(method.getDeclarationAsString()+";");
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        // for package
        PackageDeclaration packageDeclaration = cu.getPackageDeclaration().orElse(null);
        String packageName = packageDeclaration.getNameAsString();

        List<ClassOrInterfaceDeclaration> classes = cu.getNodesByType(ClassOrInterfaceDeclaration.class);
        // get the class declaration
        String PublicInfo = "";
        for (ClassOrInterfaceDeclaration classDeclaration : classes) {
            String modifers = String.valueOf(classDeclaration.getModifiers()).replace("[","").replace("]","").replace(",","");
            String Class_declaration = modifers+"class "+classDeclaration.getNameAsString()+" {\n";

            if (classDeclaration.getNameAsString().equals(ClassName)){
                String Info = packageDeclaration +"\n" + Class_declaration + "\n" + String.join("\n",public_field) + "\n" + String.join("\n",public_method_signature) + "\n}";
                PublicInfo = Info.replaceAll("(?m)^[ \t]*\r?\n", "");  
            }
        }

        return PublicInfo;
    }



}
