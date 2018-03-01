package expression.binary;

import expression.Expression;
import expression.ReturnType;

public abstract class ExpressionComparison extends ExpressionBinary {

    ExpressionComparison(Expression left, Expression right, String opString) {
        super(left, right, opString);
    }

    @Override
    public ReturnType getReturnType() {
        return ReturnType.BOOLEAN;
    }
}