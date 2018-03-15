package org.uva.app;

import org.uva.ql.ast.Form;
import org.uva.ql.evaluator.FormEvaluator;
import org.uva.ql.evaluator.data.ExpressionTable;
import org.uva.ql.evaluator.data.StatementTable;
import org.uva.ql.evaluator.data.ValueTable;
import org.uva.gui.GUIHandler;
import org.uva.ql.parsing.ASTBuilder;
import org.uva.ql.validation.QLValidator;
import org.uva.qls.QLSBuilder;
import org.uva.qls.ast.Stylesheet;
import org.uva.qls.evaluator.StyleEvaluator;
import org.uva.qls.validation.QLSValidator;

import java.util.logging.LogManager;
import java.util.logging.Logger;


public class App {

    private App() {
        Logger logger = Logger.getGlobal();
        LogManager.getLogManager().reset();
        logger.addHandler(new LogHandler());

        String input = new InputHandler().readFile("input/test/circularDependency.ql");
//        String input = new InputHandler().getUserInput("ql");
        ASTBuilder builder = new ASTBuilder();
        Form form = builder.buildAST(input);

        String qlsInput = new InputHandler().readFile("input/default.qls");
//        String input = new InputHandler().getUserInput("qls");
        QLSBuilder QLSBuilder = new QLSBuilder();
        Stylesheet stylesheet = QLSBuilder.buildAST(qlsInput);

        QLValidator validator = new QLValidator(form);
        validator.run();

        QLSValidator qlsValidator = new QLSValidator(validator.getQuestions(), stylesheet);
//        qlsValidator.run();

        FormEvaluator formEvaluator = new FormEvaluator(new ExpressionTable(), new StatementTable(), new ValueTable(), form);
        StyleEvaluator styleEvaluator = new StyleEvaluator();

        GUIHandler guiHandler = new GUIHandler(formEvaluator, styleEvaluator);
    }

    public static void main(String[] args) {
        new App();
    }
}
