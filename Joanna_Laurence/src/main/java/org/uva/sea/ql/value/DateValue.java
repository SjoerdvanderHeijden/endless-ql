package org.uva.sea.ql.value;


import org.uva.sea.ql.QLValueEvaluator;
import org.uva.sea.ql.parser.NodeType;

import java.util.Calendar;

public class DateValue extends Value {

    private Calendar dateValue;

    //TODO: add string constructor

    public DateValue(Calendar dateValue) {
        this.dateValue = dateValue;
    }

    public Calendar getDateValue() {
        return dateValue;
    }

    @Override
    public <T> T accept(QLValueEvaluator<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public NodeType getType() {
        return NodeType.DATE;
    }
}
