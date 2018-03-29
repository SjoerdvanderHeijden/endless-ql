package ql.evaluation.value;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Date;

public class NumberValue extends Value<BigDecimal> {

    public NumberValue(BigDecimal value) {
        super(value);
    }

    public NumberValue(Integer value) {
        super(new BigDecimal(value.toString()));
    }

    public NumberValue(Double value) {
        super(new BigDecimal(value.toString()));
    }

    @Override
    public Boolean getBooleanValue() {
        throw new UnsupportedOperationException("Cannot cast number to boolean");
    }

    @Override
    public Integer getIntValue() {
        return this.value.intValue();
    }

    @Override
    public Double getDecimalValue() {
        return this.value.doubleValue();
    }

    @Override
    public BigDecimal getMoneyValue() {
        return this.value.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String getStringValue() {
        throw new UnsupportedOperationException("Cannot cast number to string");
    }

    @Override
    public LocalDate getDateValue() {
        throw new UnsupportedOperationException("Cannot cast number to date");
    }

    @Override
    public Value divide(Value right) {
        if (right.isUndefined() || right.getIntValue() == 0)
            return new UndefinedValue();

        NumberValue rightValue = (NumberValue) right;
        return new NumberValue(this.value.divide(rightValue.value, MathContext.DECIMAL128));
    }

    @Override
    public Value multiply(Value right) {
        if (right.isUndefined())
            return new UndefinedValue();

        NumberValue rightValue = (NumberValue) right;
        return new NumberValue(this.value.multiply(rightValue.value));
    }

    @Override
    public Value subtract(Value right) {
        if (right.isUndefined())
            return new UndefinedValue();

        NumberValue rightValue = (NumberValue) right;
        return new NumberValue(this.value.subtract(rightValue.value));
    }

    @Override
    public Value sum(Value right) {
        if (right.isUndefined())
            return new UndefinedValue();

        NumberValue rightValue = (NumberValue) right;
        return new NumberValue(this.value.add(rightValue.value));
    }

    @Override
    public Value eq(Value right) {
        if (right.isUndefined())
            return new UndefinedValue();

        NumberValue rightValue = (NumberValue) right;
        return new BooleanValue(this.value.compareTo(rightValue.value) == 0);
    }

    @Override
    public Value ge(Value right) {
        if (right.isUndefined())
            return new UndefinedValue();

        NumberValue rightValue = (NumberValue) right;
        return new BooleanValue(this.value.compareTo(rightValue.value) >= 0);
    }

    @Override
    public Value gt(Value right) {
        if (right.isUndefined())
            return new UndefinedValue();

        NumberValue rightValue = (NumberValue) right;
        return new BooleanValue(this.value.compareTo(rightValue.value) > 0);
    }

    @Override
    public Value le(Value right) {
        if (right.isUndefined())
            return new UndefinedValue();

        NumberValue rightValue = (NumberValue) right;
        return new BooleanValue(this.value.compareTo(rightValue.value) <= 0);
    }

    @Override
    public Value lt(Value right) {
        if (right.isUndefined())
            return new UndefinedValue();

        NumberValue rightValue = (NumberValue) right;
        return new BooleanValue(this.value.compareTo(rightValue.value) < 0);
    }

    @Override
    public Value and(Value right) {
        throw new UnsupportedOperationException("Cannot perform and on integer.");
    }

    @Override
    public Value or(Value right) {
        throw new UnsupportedOperationException("Cannot perform or on integer.");
    }

    @Override
    public Value not() {
        throw new UnsupportedOperationException("Cannot perform not on integer.");
    }

    @Override
    public Value neg() {
        return new NumberValue(this.value.multiply(new BigDecimal(-1.0)));
    }
}
