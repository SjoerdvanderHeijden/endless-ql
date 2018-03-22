package com.chariotit.uva.sc.qdsl.ast.ql.node;

import com.chariotit.uva.sc.qdsl.ast.ql.node.operator.Operator;
import com.chariotit.uva.sc.qdsl.ast.ql.node.operator.UnaryOperator;
import com.chariotit.uva.sc.qdsl.ast.ql.symboltable.SymbolTable;
import com.chariotit.uva.sc.qdsl.ast.ql.visitor.NodeVisitor;

import java.util.Set;

public class UnOpExpression extends Expression {

    private Operator operator;
    private Expression expression;

    public UnOpExpression(Operator operator, Expression expression, Integer lineNumber, Integer
            columnNumber) {
        super(lineNumber, columnNumber);
        this.operator = operator;
        this.expression = expression;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void evaluate(SymbolTable symbolTable) {
        expression.evaluate(symbolTable);

        if (!(operator instanceof UnaryOperator)) {
            throw new RuntimeException("Incompatible operator type");
        }

        setExpressionValue(((UnaryOperator)operator).evaluate(expression));
    }

    @Override
    public Set<String> getPrerequisites() {
        return expression.getPrerequisites();
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {
        operator.acceptVisitor(visitor);
        expression.acceptVisitor(visitor);

        visitor.visitUnOpExpression(this);
    }
}
