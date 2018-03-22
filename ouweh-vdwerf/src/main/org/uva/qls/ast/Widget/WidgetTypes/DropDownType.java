package org.uva.qls.ast.Widget.WidgetTypes;

import org.uva.ql.ast.type.BooleanType;
import org.uva.ql.ast.type.Type;
import org.uva.qls.visitor.WidgetTypeVisitor;

import java.util.Arrays;
import java.util.List;

public class DropDownType extends WidgetType {

    private String trueLabel;
    private String falseLabel;

    public DropDownType(String trueLabel, String falseLabel) {
        this.trueLabel = trueLabel;
        this.falseLabel = falseLabel;
    }

    public String getTrueLabel() {
        return trueLabel;
    }

    public String getFalseLabel() {
        return falseLabel;
    }

    @Override
    public List<Class<? extends Type>> getCompatibleTypes() {
        return Arrays.asList(BooleanType.class);
    }

    @Override
    public <T, Q, V, B> T accept(WidgetTypeVisitor<T, Q, V, B> visitor, Q question, V value, B readOnly) {
        return visitor.visit(this, question, value, readOnly);
    }

}
