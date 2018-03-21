package domain.model.variable;

import domain.model.stylesheet.UIElement;
import domain.model.value.*;
import domain.visitor.Visitor;
import javafx.scene.Node;


public abstract class Variable {
    private final String identifier;
    private UIElement uiElement;

    public Variable(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
    public abstract Value getValue();

    public void setValue(StringValue value){};
    public void setValue(BooleanValue value){};
    public void setValue(ArithmeticExpressionValue value){};
    public void setValue(BooleanExpressionValue value){};
    public void setValue(MoneyValue value){};
    public void setUiElement(UIElement uiElement) {
        this.uiElement = uiElement;
    }
    public UIElement getUiElement() {
        return uiElement;
    }
    public abstract Node getRelatedUIElement(Visitor v);


}
