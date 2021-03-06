package gui.components.widgets.spinbox;

import gui.components.widgets.GUIWidget;
import javafx.beans.InvalidationListener;
import javafx.scene.Node;
import javafx.scene.control.Spinner;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class SpinBox<T> extends Spinner<T> implements GUIWidget {

    public SpinBox() {
        this.setEditable(true);
    }

    @Override
    public Node getNode() {
        return this;
    }

    @Override
    public void setChangeListener(InvalidationListener invalidationListener) {
        this.valueProperty().addListener(invalidationListener);
    }

    @Override
    public void setColor(String color) {
        this.setStyle("-fx-text-inner-color: " + color + ";");
    }

    @Override
    public void setFont(String font) {
        Font currentFont = this.getEditor().getFont();
        this.getEditor().setFont(Font.font(font, FontWeight.NORMAL, currentFont.getSize()));
    }

    @Override
    public void setFontSize(int fontSize) {
        Font currentFont = this.getEditor().getFont();
        this.getEditor().setFont(Font.font(currentFont.getFamily(), FontWeight.NORMAL, fontSize));
    }

    @Override
    public void setWidth(int width) {
        this.setPrefWidth(width);
    }
}

