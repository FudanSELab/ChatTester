import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


// method does not override or implement a method from a supertype
public class ExtractClassFromOverride {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = args[0];
        String LineNumber = args[1];
        String className = OverrideDeal(filePath, LineNumber);
//        System.out.println(className);

    }
    public static String OverrideDeal(String filePath, String LineNumber) throws FileNotFoundException {
        String className = "";
        // Parse the input file
        CompilationUnit cu = StaticJavaParser.parse(new File(filePath));

        // Define a visitor to find methods with the @Override annotation
        MethodDeclarationVisitor visitor = new MethodDeclarationVisitor();

        // Visit all the nodes in the AST to find methods with the @Override annotation
        cu.accept(visitor, null);

        // Print the class names of methods with the @Override annotation
        for (MethodDeclaration method : visitor.getFoundMethods()) {
            String lineRange = method.getRange().get().toString();
            if (!lineRange.contains(LineNumber)) continue;
            ObjectCreationExpr parentNode = (ObjectCreationExpr) method.getParentNode().get();
            ClassOrInterfaceType type = parentNode.getType();
            className = type.toString();

            if (className != null) {
                System.out.println(className);
            }
        }
        return  className;
    }

    // A visitor to find methods with the @Override annotation
    private static class MethodDeclarationVisitor extends VoidVisitorAdapter<Void> {
        private final List<MethodDeclaration> foundMethods = new ArrayList<>();

        @Override
        public void visit(MethodDeclaration md, Void arg) {
            // Check if the method has the @Override annotation
            for (AnnotationExpr annotation : md.getAnnotations()) {
                if (annotation.getName().getIdentifier().equals("Override")) {
                    foundMethods.add(md);
                    break;
                }
            }

            super.visit(md, arg);
        }

        public List<MethodDeclaration> getFoundMethods() {
            return foundMethods;
        }
    }
}
