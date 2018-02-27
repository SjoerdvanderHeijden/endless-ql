package ast.literal;

import checking.value.StringValue;
import visiting.LiteralVisitor;

public class StringLiteral extends Literal{
	
	private final StringValue value;
	
    public StringLiteral(String value){
    	this.value = new StringValue(value);
    }

    @Override
	public StringValue getValue() {
		return value;
	}
    
	@Override
	public <T, U> T accept(LiteralVisitor<T, U> visitor, U ctx) {
		return visitor.visit(this, ctx);
	}

	
}
