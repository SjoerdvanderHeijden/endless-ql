package ql.types;

import ql.visitors.TypeVisitor;

public class String extends Type {
    public String(int lineNumber, java.lang.String name) {
        super(lineNumber, name);
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
