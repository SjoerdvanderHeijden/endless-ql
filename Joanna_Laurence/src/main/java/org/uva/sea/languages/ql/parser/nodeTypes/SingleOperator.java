package org.uva.sea.languages.ql.parser.nodeTypes;

import org.antlr.v4.runtime.Token;
import org.uva.sea.languages.ql.parser.elements.expressions.Expression;
import org.uva.sea.languages.ql.parser.visitor.IASTVisitor;

public abstract class SingleOperator extends Expression {
    private final Expression value;

    protected SingleOperator(Token token, Expression value) {
        super(token);
        this.value = value;
    }

    public Expression getValue() {
        return this.value;
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
