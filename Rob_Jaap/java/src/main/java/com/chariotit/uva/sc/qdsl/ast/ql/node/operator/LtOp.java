package com.chariotit.uva.sc.qdsl.ast.ql.node.operator;

import com.chariotit.uva.sc.qdsl.ast.ql.visitor.NodeVisitor;

public class LtOp extends Operator implements BinaryOperator, MoneyOperator, IntegerOperator,
        BooleanResultOperator {

    public LtOp(Integer lineNumber, Integer columnNumber) {
        super(lineNumber, columnNumber);
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {
        visitor.visitLtOp(this);
    }
}