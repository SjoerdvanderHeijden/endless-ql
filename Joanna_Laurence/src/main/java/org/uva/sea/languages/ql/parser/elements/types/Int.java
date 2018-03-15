package org.uva.sea.languages.ql.parser.elements.types;

import org.antlr.v4.runtime.Token;
import org.uva.sea.languages.ql.parser.NodeType;
import org.uva.sea.languages.ql.parser.elements.ASTNode;
import org.uva.sea.languages.ql.parser.visitor.IASTVisitor;

public class Int extends ASTNode {
    private final int value;

    public Int(Token token, String value) {
        super(token);
        this.value = Integer.parseInt(value);
    }

    public Int(Token token, int value) {
        super(token);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Type getType() {
        return new Type(NodeType.INTEGER);
    }
}
