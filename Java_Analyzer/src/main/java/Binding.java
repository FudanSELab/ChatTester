import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

public class Binding {
    public static void main(String args[]) throws FileNotFoundException {
        String fileName = "";
        String methodName = "";
        String target = getObjectType(fileName, methodName);
        System.out.println(target);
    }

    public static String getObjectType(String fileName, String methodName) throws FileNotFoundException {
        CompilationUnit compilationUnit = StaticJavaParser.parse(new FileInputStream(fileName));

        class MethodNameVisitor extends VoidVisitorAdapter<Void> {
            String targetMethodName;
            String targetClassName = null;

            public MethodNameVisitor(String methodName) {
                this.targetMethodName = methodName;
            }

            @Override
            public void visit(MethodDeclaration n, Void arg) {
                super.visit(n, arg);
                System.out.println(n.getNameAsString());
                if (n.getNameAsString().equals(targetMethodName)) {
                    targetClassName = n.getParentNode().get().getChildNodes().stream()
                            .filter(node -> node instanceof com.github.javaparser.ast.type.Type)
                            .findFirst()
                            .map(typeNode -> ((com.github.javaparser.ast.type.Type) typeNode).toString())
                            .orElse(null);
                }
            }
        }

        MethodNameVisitor visitor = new MethodNameVisitor(methodName);
        visitor.visit(compilationUnit, null);

        return visitor.targetClassName;
    }
}
