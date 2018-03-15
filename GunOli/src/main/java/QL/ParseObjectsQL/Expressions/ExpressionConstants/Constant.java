package QL.ParseObjectsQL.Expressions.ExpressionConstants;

import QL.ParseObjectsQL.Expressions.Expression;

public abstract class Constant<T> extends Expression<T> {
    private T value;

    public Constant(T value) {
        setValue(value);
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public Constant<T> evaluate() {
        return this;
    }

    public abstract String toString();
}
