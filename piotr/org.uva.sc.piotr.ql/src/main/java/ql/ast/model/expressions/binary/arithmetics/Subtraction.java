package ql.ast.model.expressions.binary.arithmetics;

import ql.ast.model.expressions.Expression;
import ql.ast.model.expressions.binary.BinaryExpression;
import ql.ast.visitors.ASTNodeVisitor;

public class Subtraction extends BinaryExpression {
    public Subtraction(Expression leftSide, Expression rightSide, MetaInformation metaInformation) {
        super(leftSide, rightSide, metaInformation);
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visit(this);
    }}
