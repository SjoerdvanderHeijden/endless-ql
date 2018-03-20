package ql.ast.model.expressions.binary.comparision;

import ql.ast.model.expressions.Expression;
import ql.ast.model.expressions.binary.BinaryExpression;
import ql.ast.visitors.ASTNodeVisitor;

public class Equal extends BinaryExpression {
    public Equal(Expression leftSide, Expression rightSide, MetaInformation metaInformation) {
        super(leftSide, rightSide, metaInformation);
    }

    public Equal(Expression leftSide, Expression rightSide) {
        super(leftSide, rightSide);
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visit(this);
    }}
