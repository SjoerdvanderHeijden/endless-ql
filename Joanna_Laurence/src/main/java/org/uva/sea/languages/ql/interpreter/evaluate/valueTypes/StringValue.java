package org.uva.sea.languages.ql.interpreter.evaluate.valueTypes;

import org.uva.sea.languages.ql.interpreter.exceptions.EvaluationException;
import org.uva.sea.languages.ql.parser.NodeType;
import org.uva.sea.languages.ql.parser.visitor.BaseValueVisitor;

public class StringValue extends Value {

    private final String stringValue;

    public StringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return this.stringValue;
    }

    @Override
    public Value isEqual(Value value) throws EvaluationException {
        return value.isEqual(this);
    }

    @Override
    public Value isEqual(StringValue value) {
        return new BooleanValue(this.stringValue.equals(value.getStringValue()));
    }

    @Override
    public Value isNotEqual(Value value) throws EvaluationException {
        return value.isNotEqual(this);
    }

    @Override
    public Value isNotEqual(StringValue value) {
        return new BooleanValue(!this.stringValue.equals(value.getStringValue()));
    }

    @Override
    public <T> T accept(BaseValueVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public NodeType getType() {
        return NodeType.STRING;
    }

    @Override
    public String toString() {
        return this.stringValue;
    }

    public StringValue clone() throws CloneNotSupportedException {
        return (StringValue) super.clone();
    }
}
