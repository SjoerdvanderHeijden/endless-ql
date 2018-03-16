package org.uva.ql.validation;

import org.uva.app.LogHandler;
import org.uva.ql.ast.Form;
import org.uva.ql.ast.Question;
import org.uva.ql.ast.expression.unary.Parameter;
import org.uva.ql.validation.checker.*;
import org.uva.ql.validation.collector.ParameterMapping;
import org.uva.ql.validation.collector.QuestionContext;
import org.uva.ql.validation.collector.SymbolTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class QLValidator {

    private final LogHandler handler;
    private Form form;

    public QLValidator(Form form) {
        this.form = form;
        this.handler = (LogHandler) Logger.getGlobal().getHandlers()[0];
    }

    private List<Checker> getCheckers() {
        List<Question> questions = new QuestionContext(form).getQuestions();
        SymbolTable symbolTable = new SymbolTable(form);
        Map<String, List<Parameter>> parameterMapping = new ParameterMapping(form).getParameterMapping();


        List<Checker> checkers = new ArrayList<>();

        QuestionChecker questionChecker = new QuestionChecker(questions);
        checkers.add(questionChecker);

        ParameterChecker parameterChecker = new ParameterChecker(symbolTable, parameterMapping);
        checkers.add(parameterChecker);

        DependencyChecker dependencyChecker = new DependencyChecker(parameterMapping);
        checkers.add(dependencyChecker);

        TypeChecker typeChecker = new TypeChecker(form, symbolTable);
        checkers.add(typeChecker);

        return checkers;
    }

    public void run() {
        for (Checker checker : getCheckers()) {
            if (handler.hasErrors()) {
                break;
            }
            checker.runCheck();
        }
    }
}