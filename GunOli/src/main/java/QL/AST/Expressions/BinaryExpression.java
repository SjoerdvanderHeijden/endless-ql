package QL.AST.Expressions;

public abstract class BinaryExpression extends Expression {
    private Expression exprLeft;
    private Expression exprRight;
    private String operator;

    public BinaryExpression(String operator, Expression exprLeft, Expression exprRight, int lineNumber){
        super(lineNumber);
        setExprRight(exprRight);
        setExprLeft(exprLeft);
        setOperator(operator);
    }

    public Expression getExprLeft() {
        return exprLeft;
    }

    public void setExprLeft(Expression exprLeft) {
        this.exprLeft = exprLeft;
    }

    public Expression getExprRight() {
        return exprRight;
    }

    public void setExprRight(Expression exprRight) {
        this.exprRight = exprRight;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return this.exprLeft.toString() + this.operator + this.exprRight.toString();
    }
}
