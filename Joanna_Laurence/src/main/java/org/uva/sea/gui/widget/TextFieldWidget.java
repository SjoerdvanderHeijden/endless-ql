package org.uva.sea.gui.widget;


import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import org.uva.sea.gui.FormController;
import org.uva.sea.gui.model.BaseQuestionModel;
import org.uva.sea.gui.render.visitor.QuestionModelVisitor;
import org.uva.sea.gui.render.visitor.TextToValueVisitor;
import org.uva.sea.languages.ql.interpreter.evaluate.valueTypes.Value;

public class TextFieldWidget implements Widget {

    private static final double TEXT_WIDTH = 100.0;

    @Override
    public Control draw(BaseQuestionModel questionModel, FormController controller) {
        TextField textField = this.createTextField(questionModel);

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            controller.setLastFocused(questionModel.getVariableName());
            System.out.println("TextField Text Changed (newValue: " + newValue + ")");
            QuestionModelVisitor<Value> textToValueVisitor = new TextToValueVisitor(newValue);
            Value value = questionModel.accept(textToValueVisitor);
            controller.updateGuiModel(questionModel.getVariableName(), value);
        });
        textField.positionCaret(textField.getText().length());
        return textField;
    }

    private TextField createTextField(BaseQuestionModel question) {
        TextField textField = new TextField();
        if (question.getValue() != null) {
            textField.setText(question.displayValue());
        }
        textField.setEditable(true);
        textField.setMinWidth(TextFieldWidget.TEXT_WIDTH);

        if (question.isComputed()) {
            textField.setEditable(false);
        }

        return textField;
    }
}
