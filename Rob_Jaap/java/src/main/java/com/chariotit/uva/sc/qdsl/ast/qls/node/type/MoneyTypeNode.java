package com.chariotit.uva.sc.qdsl.ast.qls.node.type;

import com.chariotit.uva.sc.qdsl.ast.ExpressionType;
import com.chariotit.uva.sc.qdsl.ast.common.SourceFilePosition;
import com.chariotit.uva.sc.qdsl.ast.qls.node.TypeNode;
import com.chariotit.uva.sc.qdsl.ast.qls.visitor.NodeVisitor;

public class MoneyTypeNode extends TypeNode {

    public MoneyTypeNode(SourceFilePosition filePosition) {
        super(filePosition);
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
