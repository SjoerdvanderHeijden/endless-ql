package com.chariotit.uva.sc.qdsl.ast.ql.node;

import com.chariotit.uva.sc.qdsl.ast.common.SourceFilePosition;
import com.chariotit.uva.sc.qdsl.ast.ql.node.operator.BinaryOperator;
import com.chariotit.uva.sc.qdsl.ast.ql.node.operator.Operator;
import com.chariotit.uva.sc.qdsl.ast.ql.symboltable.SymbolTable;
import com.chariotit.uva.sc.qdsl.ast.ql.visitor.NodeVisitor;

import java.util.Set;

public class ConstBinOpExpression extends Expression {

    private Constant constant;
    private Operator operator;
    private Expression expression;

    public ConstBinOpExpression(Constant constant,
                                Operator operator,
                                Expression expression,
                                SourceFilePosition filePosition) {
        super(filePosition);
        this.constant = constant;
        this.operator = operator;
        this.expression = expression;
    }

    public Constant getConstant() {
        return constant;
    }

    public void setConstant(Constant constant) {
        this.constant = constant;
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
        constant.evaluate(symbolTable);
        expression.evaluate(symbolTable);

        setExpressionValue(((BinaryOperator)operator).evaluate(symbolTable, constant, expression));
    }

    @Override
    public Set<String> getPrerequisites() {
        return expression.getPrerequisites();
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {
        constant.acceptVisitor(visitor);
        operator.acceptVisitor(visitor);
        expression.acceptVisitor(visitor);

        visitor.visitConstBinOpExpression(this);
    }
}
