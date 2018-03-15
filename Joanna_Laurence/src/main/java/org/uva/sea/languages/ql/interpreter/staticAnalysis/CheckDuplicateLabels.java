package org.uva.sea.languages.ql.interpreter.staticAnalysis;

import org.uva.sea.languages.ql.interpreter.dataObject.MessageTypes;
import org.uva.sea.languages.ql.interpreter.staticAnalysis.helpers.Messages;
import org.uva.sea.languages.ql.parser.elements.Form;
import org.uva.sea.languages.ql.parser.elements.Question;
import org.uva.sea.languages.ql.parser.visitor.BaseASTVisitor;

import java.util.HashMap;
import java.util.Map;

public class CheckDuplicateLabels extends BaseASTVisitor<Void> implements IQLStaticAnalysis {


    private Messages messages = new Messages();

    /**
     * Labels that are associated with variables
     */
    private Map<String, String> labels = new HashMap<>();

    /**
     * Hide constructor
     */
    private CheckDuplicateLabels() {

    }

    /**
     * Report warning
     *
     * @param node The node that caused the warning
     */
    private void error(Question node) {
        this.messages.addMessage("Label:" + node.getLabel() + " is already linked to another variable on line: " + node.getLine() + " column: " + node.getColumn(), MessageTypes.WARNING);
    }

    /**
     * Perform the check
     *
     * @param node The form node
     * @return Warnings
     */
    public Messages doCheck(Form node) {
        node.accept(this);
        return this.messages;
    }

    /**
     * Check the questions
     *
     * @param node
     * @return
     */
    public Void visit(Question node) {
        super.visit(node);

        String labelLink = this.labels.get(node.getLabel());
        boolean labelLinkedToOtherVariable = labelLink != null && !labelLink.equals(node.getVariable().getVariableName());

        if (labelLinkedToOtherVariable) {
            this.error(node);
            return null;
        }

        linkQuestionVariableToLabel(node);
        return null;
    }

    /**
     * Link label to variable
     *
     * @param node
     */
    private void linkQuestionVariableToLabel(Question node) {
        this.labels.put(node.getLabel(), node.getVariable().getVariableName());
    }

    /**
     * Hide the visitor, make only doCheck visible
     */
    public static class Checker implements IQLStaticAnalysis {
        @Override
        public Messages doCheck(Form node) {
            IQLStaticAnalysis checker = new CheckDuplicateLabels();
            return checker.doCheck(node);
        }
    }
}
