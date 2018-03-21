package nl.uva.js.qlparser.wrappers.arithmetic;

import com.fasterxml.jackson.annotation.JsonValue;

public class CalculatableInteger extends Calculatable<Integer> {
    private CalculatableInteger(Integer value) {
        super(value);
    }

    public CalculatableInteger(String value) {
        super(Integer.valueOf(value));
    }

    @Override
    @JsonValue
    Integer get() {
        return super.get();
    }

    @Override
    public Calculatable<Integer> plus(Calculatable<Integer> other) {
        return new CalculatableInteger(this.get() + other.get());
    }

    @Override
    public Calculatable<Integer> min(Calculatable<Integer> other) {
        return new CalculatableInteger(this.get() - other.get());
    }

    @Override
    public Calculatable<Integer> mult(Calculatable<Integer> other) {
        return new CalculatableInteger(this.get() * other.get());
    }

    @Override
    public Calculatable<Integer> div(Calculatable<Integer> other) {
        return new CalculatableInteger(this.get() / other.get());
    }
}
