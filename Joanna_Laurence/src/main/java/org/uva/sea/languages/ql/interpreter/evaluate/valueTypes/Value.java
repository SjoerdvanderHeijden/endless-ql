package org.uva.sea.languages.ql.interpreter.evaluate.valueTypes;

import org.uva.sea.languages.ql.interpreter.exceptions.EvaluationException;
import org.uva.sea.languages.ql.parser.NodeType;
import org.uva.sea.languages.ql.parser.visitor.BaseValueVisitor;

public abstract class Value implements Cloneable {

    public abstract <T> T accept(BaseValueVisitor<T> visitor);

    public abstract NodeType getType();

    //add
    public Value add(Value value) throws EvaluationException {
        throw new EvaluationException("Add operator cannot be applied here");
    }

    Value add(MoneyValue value) throws EvaluationException {
        throw new EvaluationException("Add operator cannot be applied here");
    }

    Value add(DecimalValue value) throws EvaluationException {
        throw new EvaluationException("Add operator cannot be applied here");
    }

    Value add(IntValue value) throws EvaluationException {
        throw new EvaluationException("Add operator cannot be applied here");
    }

    public Value add(DateValue value) throws EvaluationException {
        throw new EvaluationException("Add operator cannot be applied here");
    }

    public Value add(StringValue value) throws EvaluationException {
        throw new EvaluationException("Add operator cannot be applied here");
    }

    public Value add(BooleanValue value) throws EvaluationException {
        throw new EvaluationException("Add operator cannot be applied here");
    }

    public Value add(UndefinedValue undefinedValue) {
        return undefinedValue;
    }

    //and
    public Value and(Value value) throws EvaluationException {
        throw new EvaluationException("And operator cannot be applied here");
    }

    Value and(BooleanValue value) throws EvaluationException {
        throw new EvaluationException("And operator cannot be applied here");
    }

    public Value and(DateValue value) throws EvaluationException {
        throw new EvaluationException("And operator cannot be applied here");
    }

    public Value and(DecimalValue value) throws EvaluationException {
        throw new EvaluationException("And operator cannot be applied here");
    }

    public Value and(IntValue value) throws EvaluationException {
        throw new EvaluationException("And operator cannot be applied here");
    }

    public Value and(MoneyValue value) throws EvaluationException {
        throw new EvaluationException("And operator cannot be applied here");
    }

    public Value and(StringValue value) throws EvaluationException {
        throw new EvaluationException("And operator cannot be applied here");
    }

    public Value and(UndefinedValue undefinedValue) {
        return undefinedValue;
    }

    //divide
    public Value divide(Value value) throws EvaluationException {
        throw new EvaluationException("Divide operator cannot be applied here");
    }

    public Value divide(BooleanValue value) throws EvaluationException {
        throw new EvaluationException("Divide operator cannot be applied here");
    }

    public Value divide(DateValue value) throws EvaluationException {
        throw new EvaluationException("Divide operator cannot be applied here");
    }

    Value divide(DecimalValue value) throws EvaluationException {
        throw new EvaluationException("Divide operator cannot be applied here");
    }

    Value divide(IntValue value) throws EvaluationException {
        throw new EvaluationException("Divide operator cannot be applied here");
    }

    Value divide(MoneyValue value) throws EvaluationException {
        throw new EvaluationException("Divide operator cannot be applied here");
    }

    public Value divide(StringValue value) throws EvaluationException {
        throw new EvaluationException("Divide operator cannot be applied here");
    }

    public Value divide(UndefinedValue undefinedValue) {
        return undefinedValue;
    }

    //isEqual
    public Value isEqual(Value value) throws EvaluationException {
        throw new EvaluationException("isEqual operator cannot be applied here");
    }

    Value isEqual(BooleanValue value) throws EvaluationException {
        throw new EvaluationException("isEqual operator cannot be applied here");
    }

    Value isEqual(DateValue value) throws EvaluationException {
        throw new EvaluationException("isEqual operator cannot be applied here");
    }

    Value isEqual(DecimalValue value) throws EvaluationException {
        throw new EvaluationException("isEqual operator cannot be applied here");
    }

    Value isEqual(IntValue value) throws EvaluationException {
        throw new EvaluationException("isEqual operator cannot be applied here");
    }

    Value isEqual(MoneyValue value) throws EvaluationException {
        throw new EvaluationException("isEqual operator cannot be applied here");
    }

    Value isEqual(StringValue value) throws EvaluationException {
        throw new EvaluationException("isEqual operator cannot be applied here");
    }

    public Value isEqual(UndefinedValue undefinedValue) {
        return undefinedValue;
    }

    //isGreaterOrEqual
    public Value isGreaterOrEqual(Value value) throws EvaluationException {
        throw new EvaluationException("isGreaterOrEqual operator cannot be applied here");
    }

    public Value isGreaterOrEqual(BooleanValue value) throws EvaluationException {
        throw new EvaluationException("isGreaterOrEqual operator cannot be applied here");
    }

    Value isGreaterOrEqual(DateValue value) throws EvaluationException {
        throw new EvaluationException("isGreaterOrEqual operator cannot be applied here");
    }

    Value isGreaterOrEqual(DecimalValue value) throws EvaluationException {
        throw new EvaluationException("isGreaterOrEqual operator cannot be applied here");
    }

    Value isGreaterOrEqual(IntValue value) throws EvaluationException {
        throw new EvaluationException("isGreaterOrEqual operator cannot be applied here");
    }

    Value isGreaterOrEqual(MoneyValue value) throws EvaluationException {
        throw new EvaluationException("isGreaterOrEqual operator cannot be applied here");
    }

    public Value isGreaterOrEqual(StringValue value) throws EvaluationException {
        throw new EvaluationException("isGreaterOrEqual operator cannot be applied here");
    }

    public Value isGreaterOrEqual(UndefinedValue undefinedValue) {
        return undefinedValue;
    }

    //isGreaterThan
    public Value isGreaterThan(Value value) throws EvaluationException {
        throw new EvaluationException("isGreaterThan operator cannot be applied here");
    }

    public Value isGreaterThan(BooleanValue value) throws EvaluationException {
        throw new EvaluationException("isGreaterThan operator cannot be applied here");
    }

    Value isGreaterThan(DateValue value) throws EvaluationException {
        throw new EvaluationException("isGreaterThan operator cannot be applied here");
    }

    Value isGreaterThan(DecimalValue value) throws EvaluationException {
        throw new EvaluationException("isGreaterThan operator cannot be applied here");
    }

    Value isGreaterThan(IntValue value) throws EvaluationException {
        throw new EvaluationException("isGreaterThan operator cannot be applied here");
    }

    Value isGreaterThan(MoneyValue value) throws EvaluationException {
        throw new EvaluationException("isGreaterThan operator cannot be applied here");
    }

    public Value isGreaterThan(StringValue value) throws EvaluationException {
        throw new EvaluationException("isGreaterThan operator cannot be applied here");
    }

    public Value isGreaterThan(UndefinedValue undefinedValue) {
        return undefinedValue;
    }

    //isLessOrEqual
    public Value isLessOrEqual(Value value) throws EvaluationException {
        throw new EvaluationException("isLessOrEqual operator cannot be applied here");
    }

    public Value isLessOrEqual(BooleanValue value) throws EvaluationException {
        throw new EvaluationException("isLessOrEqual operator cannot be applied here");
    }

    Value isLessOrEqual(DateValue value) throws EvaluationException {
        throw new EvaluationException("isLessOrEqual operator cannot be applied here");
    }

    Value isLessOrEqual(DecimalValue value) throws EvaluationException {
        throw new EvaluationException("isLessOrEqual operator cannot be applied here");
    }

    Value isLessOrEqual(IntValue value) throws EvaluationException {
        throw new EvaluationException("isLessOrEqual operator cannot be applied here");
    }

    Value isLessOrEqual(MoneyValue value) throws EvaluationException {
        throw new EvaluationException("isLessOrEqual operator cannot be applied here");
    }

    public Value isLessOrEqual(StringValue value) throws EvaluationException {
        throw new EvaluationException("isLessOrEqual operator cannot be applied here");
    }

    public Value isLessOrEqual(UndefinedValue undefinedValue) {
        return undefinedValue;
    }

    //isLessThan
    public Value isLessThan(Value value) throws EvaluationException {
        throw new EvaluationException("isLessThan operator cannot be applied here");
    }

    public Value isLessThan(BooleanValue value) throws EvaluationException {
        throw new EvaluationException("isLessThan operator cannot be applied here");
    }

    Value isLessThan(DateValue value) throws EvaluationException {
        throw new EvaluationException("isLessThan operator cannot be applied here");
    }

    Value isLessThan(DecimalValue value) throws EvaluationException {
        throw new EvaluationException("isLessThan operator cannot be applied here");
    }

    Value isLessThan(IntValue value) throws EvaluationException {
        throw new EvaluationException("isLessThan operator cannot be applied here");
    }

    Value isLessThan(MoneyValue value) throws EvaluationException {
        throw new EvaluationException("isLessThan operator cannot be applied here");
    }

    public Value isLessThan(StringValue value) throws EvaluationException {
        throw new EvaluationException("isLessThan operator cannot be applied here");
    }

    public Value isLessThan(UndefinedValue undefinedValue) {
        return undefinedValue;
    }

    //multiply
    public Value multiply(Value value) throws EvaluationException {
        throw new EvaluationException("Multiply operator cannot be applied here");
    }

    public Value multiply(BooleanValue value) throws EvaluationException {
        throw new EvaluationException("Multiply operator cannot be applied here");
    }

    public Value multiply(DateValue value) throws EvaluationException {
        throw new EvaluationException("Multiply operator cannot be applied here");
    }

    Value multiply(DecimalValue value) throws EvaluationException {
        throw new EvaluationException("Multiply operator cannot be applied here");
    }

    Value multiply(IntValue value) throws EvaluationException {
        throw new EvaluationException("Multiply operator cannot be applied here");
    }

    Value multiply(MoneyValue value) throws EvaluationException {
        throw new EvaluationException("Multiply operator cannot be applied here");
    }

    public Value multiply(StringValue value) throws EvaluationException {
        throw new EvaluationException("Multiply operator cannot be applied here");
    }

    public Value multiply(UndefinedValue undefinedValue) {
        return undefinedValue;
    }

    //negate
    public Value negate() throws EvaluationException {
        throw new EvaluationException("Negate operator cannot be applied here");
    }

    //isNotEqual
    public Value isNotEqual(Value value) throws EvaluationException {
        throw new EvaluationException("isNotEqual operator cannot be applied here");
    }

    Value isNotEqual(BooleanValue value) throws EvaluationException {
        throw new EvaluationException("isNotEqual operator cannot be applied here");
    }

    Value isNotEqual(DateValue value) throws EvaluationException {
        throw new EvaluationException("isNotEqual operator cannot be applied here");
    }

    Value isNotEqual(DecimalValue value) throws EvaluationException {
        throw new EvaluationException("isNotEqual operator cannot be applied here");
    }

    Value isNotEqual(IntValue value) throws EvaluationException {
        throw new EvaluationException("isNotEqual operator cannot be applied here");
    }

    Value isNotEqual(MoneyValue value) throws EvaluationException {
        throw new EvaluationException("isNotEqual operator cannot be applied here");
    }

    Value isNotEqual(StringValue value) throws EvaluationException {
        throw new EvaluationException("isNotEqual operator cannot be applied here");
    }

    public Value isNotEqual(UndefinedValue undefinedValue) {
        return undefinedValue;
    }

    //not
    public Value not() throws EvaluationException {
        throw new EvaluationException("Not operator cannot be applied on here");
    }

    //or
    public Value or(Value value) throws EvaluationException {
        throw new EvaluationException("Or operator cannot be applied here");
    }

    Value or(BooleanValue value) throws EvaluationException {
        throw new EvaluationException("Or operator cannot be applied here");
    }

    public Value or(DateValue value) throws EvaluationException {
        throw new EvaluationException("Or operator cannot be applied here");
    }

    public Value or(DecimalValue value) throws EvaluationException {
        throw new EvaluationException("Or operator cannot be applied here");
    }

    public Value or(IntValue value) throws EvaluationException {
        throw new EvaluationException("Or operator cannot be applied here");
    }

    public Value or(MoneyValue value) throws EvaluationException {
        throw new EvaluationException("Or operator cannot be applied here");
    }

    public Value or(StringValue value) throws EvaluationException {
        throw new EvaluationException("Or operator cannot be applied here");
    }

    public Value or(UndefinedValue undefinedValue) {
        return undefinedValue;
    }

    //positive
    public Value positive() throws EvaluationException {
        throw new EvaluationException("Positive operator cannot be applied here");
    }

    //subtract
    public Value subtract(Value value) throws EvaluationException {
        throw new EvaluationException("Subtract operator cannot be applied here");
    }

    public Value subtract(BooleanValue value) throws EvaluationException {
        throw new EvaluationException("Subtract operator cannot be applied here");
    }

    public Value subtract(DateValue value) throws EvaluationException {
        throw new EvaluationException("Subtract operator cannot be applied here");
    }

    Value subtract(DecimalValue value) throws EvaluationException {
        throw new EvaluationException("Subtract operator cannot be applied here");
    }

    public Value subtract(IntValue value) throws EvaluationException {
        throw new EvaluationException("Subtract operator cannot be applied here");
    }

    public Value subtract(MoneyValue value) throws EvaluationException {
        throw new EvaluationException("Subtract operator cannot be applied here");
    }

    public Value subtract(StringValue value) throws EvaluationException {
        throw new EvaluationException("Subtract operator cannot be applied here");
    }

    public Value subtract(UndefinedValue undefinedValue) {
        return undefinedValue;
    }

    public Value clone() throws CloneNotSupportedException {
        return (Value) super.clone();
    }
}
