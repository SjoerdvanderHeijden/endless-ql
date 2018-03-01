package ql.ast.expression;

import ql.ast.expression.literal.Literal;
import ql.ast.expression.literal.UndefinedLiteral;
import ql.ast.type.Type;
import ql.visitors.interfaces.ExpressionVisitor;

public class Negation extends UnaryOperator {

    public Negation(Expression operand) { 
        super(operand);
    }

    @Override
    public <E> E accept(ExpressionVisitor<E> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String getOperator() {
        return "!";
    }
    
    @Override
    public Type getType() {
        return operand.getType().parse(new UndefinedLiteral()).negation().getType();
    }

    @Override
    public Literal<?> evaluate() {
        return operand.evaluate().negation();
    }
}
