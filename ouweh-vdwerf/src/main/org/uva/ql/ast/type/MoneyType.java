package org.uva.ql.ast.type;

import org.uva.ql.visitor.TypeVisitor;

public class MoneyType extends Type {

    @Override
    public boolean isCompatible(Type type) {
        return this.getClass().equals(type.getClass());
    }

    @Override
    public String toString() {
        return "MoneyType";
    }

    @Override
    public <T, C> T accept(TypeVisitor<T, C> visitor, C context) {
        return visitor.visit(this, context);
    }
}
