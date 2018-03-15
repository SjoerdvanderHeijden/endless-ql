package gui.widgets;

import javafx.scene.control.ComboBox;
import ql.model.expression.Expression;

import java.util.List;

public class DropdownWidget extends ComboBox<String> implements WidgetInterface {

    private final List<String> options;
    private final String name;

    public DropdownWidget(String name, List<String> options) {
        this.name = name;
        this.managedProperty().bind(this.visibleProperty());
        this.options = options;
    }

    @Override
    public void setExpression(String value) {

    }

    @Override
    public Expression getExpression() {
        return null;
    }
}
