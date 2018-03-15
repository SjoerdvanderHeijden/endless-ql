package com.chariotit.uva.sc.qdsl.ql.ast.node.type;

import com.chariotit.uva.sc.qdsl.ql.ast.ExpressionType;
import com.chariotit.uva.sc.qdsl.ql.ast.node.Expression;
import com.chariotit.uva.sc.qdsl.ql.ast.node.TypeNode;
import com.chariotit.uva.sc.qdsl.ql.ast.visitor.NodeVisitor;

public class MoneyTypeNode extends TypeNode {

    public MoneyTypeNode(Integer lineNumber, Integer columnNumber) {
        super(lineNumber, columnNumber);
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.MONEY;
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {
        visitor.visitMoneyType(this);
    }
}
