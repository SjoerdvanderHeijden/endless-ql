package com.chariotit.uva.sc.qdsl.ast.ql.node.operator;

import com.chariotit.uva.sc.qdsl.ast.ExpressionValue;
import com.chariotit.uva.sc.qdsl.ast.NumberExpressionValue;
import com.chariotit.uva.sc.qdsl.ast.ql.node.Expression;
import com.chariotit.uva.sc.qdsl.ast.ql.visitor.NodeVisitor;

public class DivideOp extends Operator implements BinaryOperator, MoneyOperator, IntegerOperator {

    public DivideOp(Integer lineNumber, Integer columnNumber) {
        super(lineNumber, columnNumber);
    }

    @Override
    public ExpressionValue evaluate(Expression leftExpression, Expression rightExpression) {
        if (!(leftExpression.getExpressionValue() instanceof NumberExpressionValue)) {
            throw new RuntimeException("Incompatible expression type");
        }

        return ((NumberExpressionValue) leftExpression.getExpressionValue())
                .divide(
                (NumberExpressionValue)rightExpression.getExpressionValue());
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {
        visitor.visitDivideOp(this);
    }
}