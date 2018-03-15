package org.uva.sea.languages.ql.interpreter;

import org.antlr.v4.runtime.CharStreams;
import org.uva.sea.languages.ql.interpreter.dataObject.EvaluationResult;
import org.uva.sea.languages.ql.interpreter.dataObject.MessageTypes;
import org.uva.sea.languages.ql.interpreter.dataObject.ParseResult;
import org.uva.sea.languages.ql.interpreter.dataObject.questionData.QuestionData;
import org.uva.sea.languages.ql.interpreter.evaluate.ExpressionEvaluator;
import org.uva.sea.languages.ql.interpreter.evaluate.FormEvaluator;
import org.uva.sea.languages.ql.interpreter.evaluate.SymbolTable;
import org.uva.sea.languages.ql.interpreter.evaluate.valueTypes.Value;
import org.uva.sea.languages.ql.interpreter.staticAnalysis.*;
import org.uva.sea.languages.ql.interpreter.staticAnalysis.CircularExpressionDependencies.Checker;
import org.uva.sea.languages.ql.interpreter.staticAnalysis.helpers.Messages;
import org.uva.sea.languages.ql.parser.elements.Form;
import org.uva.sea.languages.ql.parser.elements.Question;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Evaluator {

    private final ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

    private final ASTGenerator astGenerator = new ASTGenerator();

    private final List<IQLStaticAnalysis> staticAnalyses = Arrays.asList(new IQLStaticAnalysis[]{
            new LinkAndCheckVariableUsage.Checker(),
            new TypeCheck.Checker(),
            new CheckDuplicateLabels.Checker(),
            new CheckIncorrectDuplicateQuestions.Checker(),
            new CircularQuestionDependencies.Checker(),
            new Checker()
    });

    /**
     * Generates questions with values
     *
     * @param qlFile      Specification of the GUI
     * @param symbolTable The current state of the program
     * @return List of questions that should be displayed
     */
    public EvaluationResult evaluate(String qlFile, SymbolTable symbolTable) throws IOException {

        Messages evaluationMessages = new Messages();

        ParseResult<Form> parseResult = this.parse(qlFile);
        evaluationMessages.addMessageList(parseResult.getMessages());
        if (evaluationMessages.hasMessagePresent(MessageTypes.ERROR)) {
            return new EvaluationResult(new ArrayList<>(), parseResult.getMessages(), parseResult.getAst());
        }

        evaluationMessages.addMessageList(this.performStaticAnalysis(parseResult));
        if (evaluationMessages.hasMessagePresent(MessageTypes.ERROR)) {
            return new EvaluationResult(new ArrayList<>(), evaluationMessages, parseResult.getAst());
        }

        return this.evaluateQuestions(parseResult, symbolTable, evaluationMessages);
    }

    /**
     * Evaluate AST
     *
     * @param parseResult        Parse result
     * @param symbolTable        Symbol table
     * @param evaluationMessages Message container
     * @return
     */
    private EvaluationResult evaluateQuestions(ParseResult<Form> parseResult, SymbolTable symbolTable, Messages evaluationMessages) {
        FormEvaluator evaluator = new FormEvaluator();
        List<Question> questions = evaluator.evaluate(parseResult.getAst(), symbolTable);
        List<QuestionData> questionData = this.evaluateQuestionValues(questions, symbolTable);
        return new EvaluationResult(questionData, evaluationMessages, parseResult.getAst());
    }

    /**
     * Does the static analysis on the parse result
     *
     * @param parseResult Parse result
     */
    private Messages performStaticAnalysis(ParseResult<Form> parseResult) {
        Messages returnMessage = new Messages();
        for (IQLStaticAnalysis staticAnalysis : this.staticAnalyses) {
            Messages analysisMessages = staticAnalysis.doCheck(parseResult.getAst());
            returnMessage.addMessageList(analysisMessages);
        }
        return returnMessage;
    }

    /**
     * ApplyQLSStyle questions, and return results
     *
     * @param symbolTable Symbol table
     * @param questions   questions that are converted
     * @return Interpreted questions
     */
    private List<QuestionData> evaluateQuestionValues(Iterable<Question> questions, SymbolTable symbolTable) {
        List<QuestionData> questionDataList = new ArrayList<>();
        for (Question question : questions) {
            Value value = this.getQuestionValue(question, symbolTable);
            questionDataList.add(new QuestionData(question, value));
        }
        return questionDataList;
    }

    /**
     * Compute valueTypes or get the valueTypes from the symbol table
     *
     * @param symbolTable Symbol table
     * @param question    Questions
     * @return Value of the questionData
     */
    private Value getQuestionValue(Question question, SymbolTable symbolTable) {
        if (question.getValue() != null)
            return this.expressionEvaluator.evaluate(question.getValue(), symbolTable);

        return symbolTable.getValue(question.getVariable().getVariableName());
    }

    /**
     * Generate the AST
     *
     * @param guiSpecification Specification of the GUI
     */
    private ParseResult<Form> parse(String guiSpecification) throws IOException {
        return this.astGenerator.createAST(CharStreams.fromStream(new FileInputStream(guiSpecification)));
    }
}
