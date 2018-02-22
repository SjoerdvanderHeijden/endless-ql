package org.uva.sea.ql.parser.elements.types;

import org.antlr.v4.runtime.Token;
import org.uva.sea.ql.parser.NodeType;
import org.uva.sea.ql.parser.elements.ASTNode;
import org.uva.sea.ql.traverse.Visitor;

import java.util.Calendar;

public class DateExpr extends ASTNode  {
    private Calendar date = Calendar.getInstance();

    public DateExpr(Token token, String day, String month, String year) {
        super(token);
        this.date.set(Calendar.YEAR, Integer.parseInt(year));
        this.date.set(Calendar.MONTH, Integer.parseInt(month));
        this.date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
    }

    public Calendar getDate() {
        return date;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type getType() {
        return new Type(NodeType.DATE);
    }
}
