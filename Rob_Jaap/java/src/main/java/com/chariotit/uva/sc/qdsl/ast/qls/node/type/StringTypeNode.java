package com.chariotit.uva.sc.qdsl.ast.qls.node.type;

import com.chariotit.uva.sc.qdsl.ast.ql.type.ExpressionType;
import com.chariotit.uva.sc.qdsl.ast.common.SourceFilePosition;
import com.chariotit.uva.sc.qdsl.ast.qls.node.TypeNode;
import com.chariotit.uva.sc.qdsl.ast.qls.visitor.NodeVisitor;

public class StringTypeNode extends TypeNode {

    public StringTypeNode(SourceFilePosition filePosition) {
        super(filePosition);
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.STRING;
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {
        visitor.visitStringType(this);
    }
}
