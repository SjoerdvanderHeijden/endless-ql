package org.uva.ql.app;

import antlr.generated.QLLexer;
import antlr.generated.QLParser;
import org.uva.ql.ast.Form;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.parsing.ASTBuilder;
import org.uva.ql.parsing.ParseTreeVisitor;
import org.uva.ql.validation.Validator;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class App {

    private App() {
        try {
            byte[] a = Files.readAllBytes(Paths.get("input/default.ql"));
            String input = new String(a);

            ASTBuilder builder = new ASTBuilder();
            Form form = builder.buildAST(input);

            Validator validator = new Validator();
            validator.execute(form);
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void main (String [] args) {
        new App();
    }
}
