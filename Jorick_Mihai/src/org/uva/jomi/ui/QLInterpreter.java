package org.uva.jomi.ui;

import java.util.List;

import org.uva.jomi.ql.ast.expressions.AdditionExpr;
import org.uva.jomi.ql.ast.expressions.AndExpr;
import org.uva.jomi.ql.ast.expressions.BooleanExpr;
import org.uva.jomi.ql.ast.expressions.DivisionExpr;
import org.uva.jomi.ql.ast.expressions.EqualExpr;
import org.uva.jomi.ql.ast.expressions.Expr;
import org.uva.jomi.ql.ast.expressions.GreaterThanExpr;
import org.uva.jomi.ql.ast.expressions.GreaterThanOrEqualExpr;
import org.uva.jomi.ql.ast.expressions.GroupingExpr;
import org.uva.jomi.ql.ast.expressions.IdentifierExpr;
import org.uva.jomi.ql.ast.expressions.IntegerExpr;
import org.uva.jomi.ql.ast.expressions.LessThanExpr;
import org.uva.jomi.ql.ast.expressions.LessThanOrEqualExpr;
import org.uva.jomi.ql.ast.expressions.MultiplicationExpr;
import org.uva.jomi.ql.ast.expressions.NotEqualExpr;
import org.uva.jomi.ql.ast.expressions.OrExpr;
import org.uva.jomi.ql.ast.expressions.StringExpr;
import org.uva.jomi.ql.ast.expressions.SubtractionExpr;
import org.uva.jomi.ql.ast.expressions.UnaryNotExpr;
import org.uva.jomi.ql.ast.statements.BlockStmt;
import org.uva.jomi.ql.ast.statements.ComputedQuestionStmt;
import org.uva.jomi.ql.ast.statements.FormStmt;
import org.uva.jomi.ql.ast.statements.IfElseStmt;
import org.uva.jomi.ql.ast.statements.IfStmt;
import org.uva.jomi.ql.ast.statements.QuestionStmt;
import org.uva.jomi.ql.ast.statements.Stmt;
import org.uva.jomi.ql.interpreter.BooleanValue;
import org.uva.jomi.ql.interpreter.GenericValue;
import org.uva.jomi.ql.interpreter.IntegerValue;
import org.uva.jomi.ql.interpreter.StringValue;


public class QLInterpreter implements Stmt.Visitor<Void>, Expr.Visitor<GenericValue> {
	
	public void interpret(List<Stmt> statements) {
		for (Stmt statement : statements) {
			execute(statement);
		}
	}
	
	public void catchException() {
		try {
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private GenericValue evaluate(Expr expr) {
		return expr.accept(this);
	}
	
	private void execute(Stmt stmt) {
		stmt.accept(this);
	}

	@Override
	public GenericValue visit(IdentifierExpr expr) {
		// TODO - Remove dependency on GenericValue
		return (GenericValue) SymbolTable.getInstance().get(expr.getName());
	}

	@Override
	public GenericValue visit(GroupingExpr expr) {
		return expr.visitInnerExpr(this);
	}

	@Override
	public Void visit(FormStmt stmt) {
		stmt.visitBlockStmt(this);
		return null;
	}

	@Override
	public Void visit(BlockStmt stmt) {
		stmt.getStatements().forEach( statement -> statement.accept(this));
		return null;
	}

	@Override
	public Void visit(QuestionStmt stmt) {
		// TODO Interpret QuestionStmt.
		return null;
	}
	
	@Override
	public Void visit(ComputedQuestionStmt stmt) {
		GenericValue value = evaluate(stmt.getExp());
		String name = stmt.getIdentifierName();
		SymbolTable.getInstance().put(name, value);
		return null;	
	}

	@Override
	public Void visit(IfStmt stmt) {
		// TODO Interpret IfStmt.
		return null;
	}

	@Override
	public Void visit(IfElseStmt stmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericValue visit(AdditionExpr expr) {
		GenericValue left = expr.visitLeftExpr(this);
		GenericValue right = expr.visitRightExpr(this);
		return left.add(right);
	}

	@Override
	public GenericValue visit(SubtractionExpr expr) {
		GenericValue left = expr.visitLeftExpr(this);
		GenericValue right = expr.visitRightExpr(this);
		return left.subtract(right);
	}

	@Override
	public GenericValue visit(MultiplicationExpr expr) {
		GenericValue left = expr.visitLeftExpr(this);
		GenericValue right = expr.visitRightExpr(this);
		return left.multiply(right);
	}

	@Override
	public GenericValue visit(DivisionExpr expr) {
		GenericValue left = expr.visitLeftExpr(this);
		GenericValue right = expr.visitRightExpr(this);
		return left.divide(right);
	}

	@Override
	public GenericValue visit(LessThanExpr expr) {
		GenericValue left = expr.visitLeftExpr(this);
		GenericValue right = expr.visitRightExpr(this);
		return left.less(right);
	}

	@Override
	public GenericValue visit(LessThanOrEqualExpr expr) {
		GenericValue left = expr.visitLeftExpr(this);
		GenericValue right = expr.visitRightExpr(this);
		return left.lessOrEqual(right);
	}

	@Override
	public GenericValue visit(GreaterThanExpr expr) {
		GenericValue left = expr.visitLeftExpr(this);
		GenericValue right = expr.visitRightExpr(this);
		return left.greater(right);
	}

	@Override
	public GenericValue visit(GreaterThanOrEqualExpr expr) {
		GenericValue left = expr.visitLeftExpr(this);
		GenericValue right = expr.visitRightExpr(this);
		return left.greaterOrEqual(right);
	}

	@Override
	public GenericValue visit(NotEqualExpr expr) {
		GenericValue left = expr.visitLeftExpr(this);
		GenericValue right = expr.visitRightExpr(this);
		return left.notEqual(right);
	}

	@Override
	public GenericValue visit(EqualExpr expr) {
		GenericValue left = expr.visitLeftExpr(this);
		GenericValue right = expr.visitRightExpr(this);
		return left.equal(right);
	}

	@Override
	public GenericValue visit(AndExpr expr) {
		GenericValue left = expr.visitLeftExpr(this);
		GenericValue right = expr.visitRightExpr(this);
		return left.and(right);
	}

	@Override
	public GenericValue visit(OrExpr expr) {
		GenericValue left = expr.visitLeftExpr(this);
		GenericValue right = expr.visitRightExpr(this);
		return left.or(right);
	}

	@Override
	public GenericValue visit(UnaryNotExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IntegerValue visit(IntegerExpr expr) {
		return new IntegerValue(expr.getValue());
	}

	@Override
	public GenericValue visit(StringExpr expr) {
		return new StringValue(expr.getValue());
	}

	@Override
	public GenericValue visit(BooleanExpr expr) {
		return new BooleanValue(expr.getValue());
	}

}