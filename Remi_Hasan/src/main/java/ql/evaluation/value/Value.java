package ql.evaluation.value;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Value<T> {
    public final T value;

    Value(T value) {
        this.value = value;
    }

    public T getValue() {
        if (isUndefined()) {
            return null;
        } else {
            return value;
        }
    }

    public abstract Boolean getBooleanValue();

    public abstract Integer getIntValue();

    public abstract Double getDecimalValue();

    public abstract BigDecimal getMoneyValue();

    public abstract String getStringValue();

    public abstract LocalDate getDateValue();

    public abstract Value divide(Value right);

    public abstract Value multiply(Value right);

    public abstract Value subtract(Value right);

    public abstract Value sum(Value right);

    public abstract Value eq(Value right);

    public abstract Value ge(Value right);

    public abstract Value gt(Value right);

    public abstract Value le(Value right);

    public abstract Value lt(Value right);

    public abstract Value and(Value right);

    public abstract Value or(Value right);

    public abstract Value not();

    public abstract Value neg();

    public boolean isUndefined() {
        return false;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}


