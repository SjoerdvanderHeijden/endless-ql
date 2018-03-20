package org.uva.sea.languages.qls.interpreter.staticAnalysis;

import org.uva.sea.languages.ql.interpreter.dataObject.MessageTypes;
import org.uva.sea.languages.ql.interpreter.staticAnalysis.helpers.Messages;
import org.uva.sea.languages.ql.parser.elements.Form;
import org.uva.sea.languages.ql.parser.visitor.BaseASTVisitor;
import org.uva.sea.languages.qls.parser.elements.Stylesheet;
import org.uva.sea.languages.qls.parser.elements.specification.Question;
import org.uva.sea.languages.qls.parser.visitor.BaseStyleASTVisitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CheckAllQuestionsInQLQLS extends QuestionAnalysis implements IQLSStaticAnalysis {

    /**
     * Hide constructor
     */
    private CheckAllQuestionsInQLQLS() {

    }

    /**
     * Perform the check
     *
     * @return Warnings
     */
    public Messages doCheck(Form form, Stylesheet stylesheet) {

        Messages messages = new Messages();

        List<String> qlQuestions = this.getQlQuestionNames(form);
        List<String> qlsQuestions = this.getQlSQuestionNames(stylesheet);
        messages.addMessageList(this.checkListsEqual(qlQuestions, qlsQuestions, "QLS misses question: "));
        messages.addMessageList(this.checkListsEqual(qlsQuestions, qlQuestions, "QL misses question: "));

        return messages;
    }

    /**
     * @param firstList
     * @param secondList
     * @param errorMessage
     * @return
     */
    private Messages checkListsEqual(List<String> firstList, Collection<String> secondList, String errorMessage) {
        Messages messages = new Messages();

        Collection<String> difference = new ArrayList<>(firstList);
        difference.removeAll(secondList);
        for (String question : difference) {
            messages.addMessage(errorMessage + question, MessageTypes.ERROR);
        }

        return messages;
    }

    /**
     * Get all QL question names
     *
     * @param form AST node
     * @return The names
     */
    private List<String> getQlQuestionNames(Form form) {
        List<String> questionNames = new ArrayList<>();
        form.accept(new BaseASTVisitor<Void>() {
            @Override
            public Void visit(org.uva.sea.languages.ql.parser.elements.Question node) {
                questionNames.add(node.getVariable().getVariableName());
                return super.visit(node);
            }
        });
        return questionNames;
    }

    /**
     * Hide the visitor, make only doCheck visible
     */
    public static class Checker implements IQLSStaticAnalysis {
        @Override
        public Messages doCheck(Form form, Stylesheet stylesheet) {
            IQLSStaticAnalysis checker = new CheckAllQuestionsInQLQLS();
            return checker.doCheck(form, stylesheet);
        }
    }
}