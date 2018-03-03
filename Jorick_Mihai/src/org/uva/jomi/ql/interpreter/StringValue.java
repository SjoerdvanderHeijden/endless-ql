package org.uva.jomi.ql.interpreter;

public class StringValue implements GenericValue {
	private final String value;
	
	public StringValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	@Override
	public GenericValue add(GenericValue rightHandSideValue) {
		return rightHandSideValue.add(this);
	}

	@Override
	public GenericValue add(IntegerValue leftHandSideValue) {
		addError(leftHandSideValue.getClass(), this.getClass());
		return null;
	}

	@Override
	public GenericValue add(StringValue leftHandSideValue) {
		return new StringValue(leftHandSideValue.getValue().concat(this.getValue()));
	}
}