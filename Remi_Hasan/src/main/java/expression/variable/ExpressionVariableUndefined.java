package expression.variable;

import expression.ReturnType;

public class ExpressionVariableUndefined extends ExpressionVariable<Object> {

    public ExpressionVariableUndefined() {
        super(false);
    }

    @Override
    public ExpressionVariable evaluate() {
        return this;
    }

    @Override
    public boolean isSettable() {
        return false;
    }

    @Override
    public ReturnType getReturnType() {
        return ReturnType.UNDEFINED;
    }

    @Override
    public void setValue(String value) {
        throw new UnsupportedOperationException("Cannot set undefined variable");
    }

    @Override
    public Boolean getBooleanValue() {
        return false;
    }

    // Undefined should be treated as 'false' in boolean cases, so implement boolean functions

    @Override
    public ExpressionVariable and(ExpressionVariable other) {
        return new ExpressionVariableBoolean(false);
    }

    @Override
    public ExpressionVariable or(ExpressionVariable other) {
        if (other.value == null)
            return new ExpressionVariableBoolean(false);
        return new ExpressionVariableBoolean(Boolean.parseBoolean(other.value.toString()));
    }

    @Override
    public ExpressionVariable not() {
        return new ExpressionVariableBoolean(true);
    }
}