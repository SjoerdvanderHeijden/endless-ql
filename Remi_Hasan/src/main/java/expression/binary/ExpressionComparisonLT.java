package expression.binary;

import expression.Expression;
import expression.variable.ExpressionVariable;

public class ExpressionComparisonLT extends ExpressionComparison {

    public ExpressionComparisonLT(Expression left, Expression right) {
        super(left, right, "<");
    }

    @Override
    public ExpressionVariable evaluate() {
        ExpressionVariable leftEvaluated = this.left.evaluate();
        ExpressionVariable rightEvaluated = this.right.evaluate();
        return leftEvaluated.lt(rightEvaluated);
    }
}