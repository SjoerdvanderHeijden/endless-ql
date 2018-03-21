package nl.uva.js.qlparser.logic;

import lombok.SneakyThrows;
import nl.uva.js.qlparser.antlr.QLLexer;
import nl.uva.js.qlparser.antlr.QLParser;
import nl.uva.js.qlparser.models.ql.expressions.Form;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FormBuilder {

    @SneakyThrows(IOException.class)
    public static Form parseFormFromLocation(String location) {
        return parseFormFromString(new String(Files.readAllBytes(Paths.get(location))));
    }

    public static Form parseFormFromString(String qlInput) {
        ErrorListener errorListener = new ErrorListener();

        QLLexer lexer = new QLLexer(CharStreams.fromString(qlInput));
        lexer.addErrorListener(errorListener);
        QLParser parser = new QLParser(new CommonTokenStream(lexer));
        parser.addErrorListener(errorListener);

        Form form = new QLVisitor().visitForm(parser.form());
        form.checkType();

        return form;
    }
}
