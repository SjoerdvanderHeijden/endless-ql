package ql.ast.type;

import ql.ast.expression.literal.Literal;
import ql.ast.expression.literal.StrLiteral;
import ql.evaluator.value.parse.ToStr;
import ql.visitors.interfaces.TypeVisitor;

public class Str extends Type {

    private StrLiteral value;

    public Literal<String> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "string";
    }

    @Override
    public boolean equals(Type t) {
        return t.isString();
    }

    @Override
    public boolean isString() {
        return true;
    }
    
    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public StrLiteral parse(Literal<?> value) {
        return (StrLiteral) value.accept(new ToStr());
    }
}
