package ql.evaluator;

import ql.ast.Form;
import ql.ast.expressions.GroupExpression;
import ql.ast.expressions.IdentifierSet;
import ql.ast.expressions.binary.*;
import ql.ast.expressions.Identifier;
import ql.ast.expressions.literals.BooleanLiteral;
import ql.ast.expressions.literals.IntegerLiteral;
import ql.ast.expressions.literals.StringLiteral;
import ql.ast.statements.*;
import ql.values.*;
import ql.visitors.ExpressionVisitor;
import ql.visitors.FormVisitor;
import ql.visitors.StatementVisitor;

import java.util.ArrayList;
import java.util.List;

public class Evaluator implements FormVisitor, StatementVisitor<Void>, ExpressionVisitor<Value> {
    private final ValueTable valueTable;
    private final IdentifierSet identifierSet;
    private List<Question> questions = new ArrayList<>();

    public Evaluator() {
        this.valueTable = new ValueTable();
        this.identifierSet = new IdentifierSet();
    }

    public void storeValues(Identifier identifier, Value value) {
        identifierSet.add(identifier);
        valueTable.add(identifier, value);
    }

    //<editor-fold desc="FormVisitor">
    @Override
    public void visit(Form form) {
        for (Statement statement : form.getStatements()) {
            statement.accept(this);
        }
    }
    //</editor-fold>

    //<editor-fold desc="StatementVisitor">
    @Override
    public Void visit(CalculableQuestion calculableQuestion) {
        if (!identifierSet.exists(calculableQuestion.getIdentifier())) {
            Value value = calculableQuestion.getCalculableValue().accept(this);
            valueTable.add(calculableQuestion.getIdentifier(), value);
        }

        if (!questions.contains(calculableQuestion)) {
            questions.add(calculableQuestion);
        }
        return null;
    }

    @Override
    public Void visit(IfThen ifThen) {
        if (ifThen.getCondition().accept(this).toBoolean()) {
            for (Statement statement : ifThen.getThenStatements()) {
                statement.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(IfThenElse ifThenElse) {
        if (ifThenElse.getCondition().accept(this).toBoolean()) {
            for (Statement statement : ifThenElse.getThenStatements()) {
                statement.accept(this);
            }
        } else {
            for (Statement statement : ifThenElse.getElseStatements()) {
                statement.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(Question question) {
        if (!identifierSet.exists(question.getIdentifier())) {
            valueTable.add(question.getIdentifier(), new Undefined());
        }

        if (!questions.contains(question)) {
            questions.add(question);
        }
        return null;
    }
    //</editor-fold>

    //<editor-fold desc="ExpressionVisitor">
    public Value visit(Addition addition) {
        Value leftOperand = addition.getLeftExpression().accept(this);
        Value rightOperand = addition.getRightExpression().accept(this);

        return leftOperand.add(rightOperand);
    }

    public Value visit(Division division) {
        Value leftOperand = division.getLeftExpression().accept(this);
        Value rightOperand = division.getRightExpression().accept(this);

        return leftOperand.divide(rightOperand);
    }

    public Value visit(Equal equal) {
        Value leftOperand = equal.getLeftExpression().accept(this);
        Value rightOperand = equal.getRightExpression().accept(this);
        return leftOperand.equal(rightOperand);
    }

    public Value visit(GreaterThan greaterThan) {
        Value leftOperand = greaterThan.getLeftExpression().accept(this);
        Value rightOperand = greaterThan.getRightExpression().accept(this);
        return leftOperand.greaterThan(rightOperand);
    }

    public Value visit(GreaterThanOrEqual greaterThanOrEqual) {
        Value leftOperand = greaterThanOrEqual.getLeftExpression().accept(this);
        Value rightOperand = greaterThanOrEqual.getRightExpression().accept(this);
        return leftOperand.greaterThanOrEqual(rightOperand);
    }

    public Value visit(LessThan lessThan) {
        Value leftOperand = lessThan.getLeftExpression().accept(this);
        Value rightOperand = lessThan.getRightExpression().accept(this);
        return leftOperand.lessThan(rightOperand);
    }

    public Value visit(LessThanOrEqual lessThanOrEqual) {
        Value leftOperand = lessThanOrEqual.getLeftExpression().accept(this);
        Value rightOperand = lessThanOrEqual.getRightExpression().accept(this);
        return leftOperand.lessThanOrEqual(rightOperand);
    }

    public Value visit(LogicalAnd logicalAnd) {
        Value leftOperand = logicalAnd.getLeftExpression().accept(this);
        Value rightOperand = logicalAnd.getRightExpression().accept(this);
        return leftOperand.and(rightOperand);
    }

    public Value visit(LogicalOr logicalOr) {
        Value leftOperand = logicalOr.getLeftExpression().accept(this);
        Value rightOperand = logicalOr.getRightExpression().accept(this);
        return leftOperand.or(rightOperand);
    }

    public Value visit(Multiplication multiplication) {
        Value leftOperand = multiplication.getLeftExpression().accept(this);
        Value rightOperand = multiplication.getRightExpression().accept(this);
        return leftOperand.multiply(rightOperand);
    }

    public Value visit(NotEqual notEqual) {
        Value leftOperand = notEqual.getLeftExpression().accept(this);
        Value rightOperand = notEqual.getRightExpression().accept(this);
        return leftOperand.notEqual(rightOperand);
    }

    public Value visit(Subtraction subtraction) {
        Value leftOperand = subtraction.getLeftExpression().accept(this);
        Value rightOperand = subtraction.getRightExpression().accept(this);
        return leftOperand.subtract(rightOperand);
    }

    public Value visit(Identifier identifier) {
        return valueTable.find(identifier);
    }

    @Override
    public Value visit(BooleanLiteral booleanLiteral) {
        return new BooleanValue(booleanLiteral.getValue());
    }

    @Override
    public Value visit(IntegerLiteral integerLiteral) {
        return new IntegerValue(integerLiteral.getValue());
    }

    public Value visit(StringLiteral stringLiteral) {
        return new StringValue(stringLiteral.getValue());
    }

    @Override
    public Value visit(GroupExpression groupExpression) {
        return groupExpression.getExpression().accept(this);
    }
    //</editor-fold>

    public List<Question> questions() {
        return questions;
    }
    public ValueTable valueTable() {
        return valueTable;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void clear() {
        questions.clear();
    }
}
