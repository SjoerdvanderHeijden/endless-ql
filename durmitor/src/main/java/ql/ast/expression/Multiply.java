package ql.ast.expression;

import ql.ast.expression.literal.Literal;
import ql.visitors.interfaces.ExpressionVisitor;

public class Multiply extends BinaryOperator {

    public Multiply(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public <E> E accept(ExpressionVisitor<E> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String getOperator() {
        return "*";
    }
    
    @Override
    public Literal<?> evaluate() {
        return firstOperand.evaluate().multiply(secondOperand.evaluate());
    }
}
