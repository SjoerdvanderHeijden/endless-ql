package domain.model.visitor;

import domain.model.expression.Expression;
import domain.model.variable.BooleanVariable;
import domain.model.variable.MoneyVariable;
import domain.model.variable.StringVariable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class UIVisitor implements Visitor {
    @Override
    public Node visit(BooleanVariable bv) {
        return (Node) new CheckBox();
    }

    @Override
    public Node visit(StringVariable sv) {
        return (Node) new TextField();
    }

    @Override
    public Node visit(Expression ev) {
        return (Node) new Label("Value");
    }

    @Override
    public Node visit(MoneyVariable mv) {
        return (Node) new TextField();
    }
}
