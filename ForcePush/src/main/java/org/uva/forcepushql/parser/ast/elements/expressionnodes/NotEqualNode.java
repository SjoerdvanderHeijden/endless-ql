package org.uva.forcepushql.parser.ast.elements.expressionnodes;

import org.uva.forcepushql.parser.ast.visitors.ASTExpressionVisitor;
import org.uva.forcepushql.parser.ast.visitors.ASTVisitor;
import org.uva.forcepushql.parser.ast.elements.InfixExpressionNode;

public class NotEqualNode extends InfixExpressionNode
{
    public NotEqualNode() {
        super(true);
    }

    @Override
    public String accept(ASTVisitor visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public Boolean accept(ASTExpressionVisitor visitor)
    {
        return visitor.visit(this);
    }
}
