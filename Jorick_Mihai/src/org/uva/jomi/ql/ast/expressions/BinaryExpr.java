package org.uva.jomi.ql.ast.expressions;

import org.uva.jomi.ql.ast.QLToken;
import org.uva.jomi.ql.ast.QLType;

public abstract class BinaryExpr extends Expr {
	private final Expr left;
	private final QLToken operator;
	private final Expr right;
	
	public BinaryExpr(Expr left, QLToken operator, Expr right) {
		this.left = left;
		this.operator = operator;
		this.right = right;
	}
	
	public Expr getLeftExpr() {
		return left;
	}
	
	public QLType getLeftExprType() {
		return left.getType();
	}
	
	public void setLeftExprType(QLType type) {
		left.setType(type);
	}
	
	public Expr getRightExpr() {
		return right;
	}
	
	public QLType getRightExprType() {
		return right.getType();
	}
	
	public void setRightExprType(QLType type) {
		right.setType(type);
	}

	public QLToken getOperator() {
		return operator;
	}
	
	public String getOperatorName() {
		return operator.getLexeme();
	}


}