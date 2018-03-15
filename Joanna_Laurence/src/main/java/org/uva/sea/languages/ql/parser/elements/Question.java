package org.uva.sea.languages.ql.parser.elements;

import org.antlr.v4.runtime.Token;
import org.uva.sea.languages.ql.parser.elements.types.Type;
import org.uva.sea.languages.ql.parser.elements.types.Variable;
import org.uva.sea.languages.ql.parser.visitor.IASTVisitor;


public class Question extends ASTNode {

    private final String label;
    private final Variable variable;
    private final Type nodeType;
    private final ASTNode value;

    public Question(Token token, String label, Variable variable, Type nodeType, ASTNode value) {
        super(token);
        this.label = label;
        this.variable = variable;
        this.nodeType = nodeType;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public Variable getVariable() {
        return variable;
    }

    public Type getNodeType() {
        return nodeType;
    }

    /**
     * The valueTypes that is defined in ql
     *
     * @return
     */
    public ASTNode getValue() {
        return this.value;
    }

    public Type getType() {
        return nodeType;
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
