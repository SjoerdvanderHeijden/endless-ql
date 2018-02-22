import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String [ ] args){
        try {
            ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(args[0]));
            FormLexer lexer = new FormLexer(input);
            FormParser parser = new FormParser(new CommonTokenStream(lexer));
            FormParser.Form_builderContext tree = parser.form_builder();
            FormBaseListener extractor = new FormBaseListener();
            ParseTreeWalker.DEFAULT.walk(extractor, tree);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}