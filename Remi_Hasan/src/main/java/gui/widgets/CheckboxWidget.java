package gui.widgets;

import javafx.scene.control.CheckBox;
import ql.model.expression.Expression;
import ql.model.expression.variable.ExpressionVariableBoolean;

public class CheckboxWidget extends CheckBox implements WidgetInterface {

    private final String name;

    public CheckboxWidget(String name) {
        this.name = name;
        this.managedProperty().bind(this.visibleProperty());
    }

    @Override
    public void setExpression(String value) {
        this.setSelected(Boolean.valueOf(value));
    }

    @Override
    public Expression getExpression() {
        return new ExpressionVariableBoolean(null, this.isSelected());
    }
}
