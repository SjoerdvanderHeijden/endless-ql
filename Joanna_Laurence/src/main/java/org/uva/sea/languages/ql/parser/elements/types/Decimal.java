package org.uva.sea.languages.ql.parser.elements.types;

import org.antlr.v4.runtime.Token;
import org.uva.sea.languages.ql.parser.NodeType;
import org.uva.sea.languages.ql.parser.elements.ASTNode;
import org.uva.sea.languages.ql.parser.visitor.IASTVisitor;

public class Decimal extends ASTNode {
    private final double value;

    public Decimal(Token token, String value) {
        super(token);
        this.value = Double.parseDouble(value);
    }

    public Decimal(Token token, double value) {
        super(token);
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    public Type getType() {
        return new Type(NodeType.DECIMAL);
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}