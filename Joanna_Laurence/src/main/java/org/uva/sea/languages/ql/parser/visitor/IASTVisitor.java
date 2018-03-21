package org.uva.sea.languages.ql.parser.visitor;

import org.uva.sea.languages.ql.parser.elements.*;
import org.uva.sea.languages.ql.parser.elements.expressions.*;
import org.uva.sea.languages.ql.parser.elements.expressions.types.*;
import org.uva.sea.languages.ql.parser.nodeTypes.BinaryOperator;
import org.uva.sea.languages.ql.parser.nodeTypes.SingleNode;

public interface IASTVisitor<T> {
    T visit(Addition node);

    T visit(And node);

    T visit(Division node);

    T visit(Equal node);

    T visit(GreaterOrEqual node);

    T visit(GreaterThan node);

    T visit(LessOrEqual node);

    T visit(LessThan node);

    T visit(Multiplication node);

    T visit(Negative node);

    T visit(NotEqual node);

    T visit(Not node);

    T visit(Or node);

    T visit(Positive node);

    T visit(Subtraction node);

    T visit(Bool node);

    T visit(DateExpr node);

    T visit(Decimal node);

    T visit(Money node);

    T visit(Int node);

    T visit(Str node);

    T visit(Type node);

    T visit(Variable node);

    T visit(IfStatement node);

    T visit(Form node);

    T visit(Question node);

    T visit(Statements node);

    T visit(BinaryOperator node);

    T visit(SingleNode node);
}
