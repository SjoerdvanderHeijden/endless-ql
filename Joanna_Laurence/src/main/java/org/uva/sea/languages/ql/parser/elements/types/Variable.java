package org.uva.sea.languages.ql.parser.elements.types;

import org.antlr.v4.runtime.Token;
import org.uva.sea.languages.ql.parser.NodeType;
import org.uva.sea.languages.ql.parser.elements.ASTNode;
import org.uva.sea.languages.ql.parser.elements.Question;
import org.uva.sea.languages.ql.parser.visitor.IASTVisitor;

public class Variable extends ASTNode {
    private final String variableName;

    private Question linkedQuestion = null;

    public Variable(Token token, String variableName) {
        super(token);
        this.variableName = variableName;
    }

    public String getVariableName() {
        return this.variableName;
    }

    public Question getLinkedQuestion() {
        return this.linkedQuestion;
    }

    public void setLinkedQuestion(Question linkedQuestion) {
        this.linkedQuestion = linkedQuestion;
    }

    public Type getType() {
        if (this.linkedQuestion == null) {
            System.out.println("Variable information should be set before requesting type information");
            return new Type(NodeType.UNKNOWN);
        }

        return this.linkedQuestion.getType();
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
