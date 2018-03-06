package ast.statement;

import ast.literal.Identifier;
import ast.type.Type;
import utils.CodeReference;
import visiting.StatementVisitor;

public class NormalQuestion extends Question {
	//TODO what condition?
	
	public NormalQuestion(Identifier id, String name, Type type, CodeReference location) {
		super(id, name, type, location);
	}

	@Override
	public <T, U> T accept(StatementVisitor<T, U> visitor, U ctx) {
		// TODO Auto-generated method stub
		//return null;
		return visitor.visit(this, ctx);
	}
}