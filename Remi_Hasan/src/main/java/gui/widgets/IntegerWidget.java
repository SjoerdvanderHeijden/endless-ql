package gui.widgets;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class IntegerWidget extends Widget<TextField> {

    public IntegerWidget(String name) {
        super(name);

        TextField textField = new TextField();
        TextFormatter formatter = createTextFormatter("-?\\d*");
        textField.setTextFormatter(formatter);

        this.control = textField;
    }

    @Override
    public void setValue(String value) {
        this.control.setText(value);
    }

    @Override
    public String getValue() {
        return this.control.getText();
    }

    public void setListener(ChangeListener<String> changeListener) {
        this.control.textProperty().addListener(changeListener);
    }
}