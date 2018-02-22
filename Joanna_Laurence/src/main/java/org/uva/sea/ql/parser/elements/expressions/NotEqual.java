package org.uva.sea.ql.parser.elements.expressions;

import org.antlr.v4.runtime.Token;
import org.uva.sea.ql.parser.NodeType;
import org.uva.sea.ql.parser.elements.ASTNode;
import org.uva.sea.ql.parser.elements.types.Type;
import org.uva.sea.ql.parser.nodeTypes.BinaryOperator;
import org.uva.sea.ql.traverse.Visitor;

public class NotEqual extends BinaryOperator {
    public NotEqual(Token token, ASTNode lhs, ASTNode rhs) {
        super(token, lhs, rhs);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type getType() {
        return new Type(NodeType.BOOLEAN);
    }
}
