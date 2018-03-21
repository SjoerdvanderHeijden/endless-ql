package loader.QL;

import antlr.ql.FormLexer;
import antlr.ql.FormParser;
import antlr.qls.StylesheetLexer;
import antlr.qls.StylesheetParser;
import domain.model.ast.FormNode;
import domain.model.stylesheet.Stylesheet;
import loader.QLS.QLSLoader;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class QLBuilder {

    public FormNode toFormNode(String qlSource){
        // Parse input field and create AST
        CharStream stream = CharStreams.fromString(qlSource);
        FormLexer lexer = new FormLexer(stream);

        FormParser parser = new FormParser(new CommonTokenStream(lexer));

        //parser.setErrorHandler(new BailErrorStrategy()); // TODO look at error handling
        //parser.addErrorListener(new ToolBarErrorListener(lblErrorField));

        FormParser.FormBuilderContext tree = parser.formBuilder();
        QLLoader loader = new QLLoader();
        ParseTreeWalker.DEFAULT.walk(loader, tree);

        return loader.getFormNode();
    }

    public Stylesheet toStylesheet(String qlsSource, FormNode formNode){
        CharStream qlsStream = CharStreams.fromString(qlsSource);
        StylesheetLexer qlsLexer = new StylesheetLexer(qlsStream);

        StylesheetParser qlsParser = new StylesheetParser(new CommonTokenStream(qlsLexer));

        //qlsParser.setErrorHandler(new BailErrorStrategy());
        //qlsParser.addErrorListener(new ToolBarErrorListener(lblErrorField));

        StylesheetParser.StylesheetBuilderContext stylesheetTree= qlsParser.stylesheetBuilder();
        QLSLoader qlsLoader = new QLSLoader(formNode);
        ParseTreeWalker.DEFAULT.walk(qlsLoader, stylesheetTree);

        return qlsLoader.getStyleSheet();
    }

}
