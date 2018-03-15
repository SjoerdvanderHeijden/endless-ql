package org.uva.sea.gui.widget;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Control;
import javafx.scene.control.RadioButton;
import org.uva.sea.gui.FormController;
import org.uva.sea.gui.model.BaseQuestionModel;
import org.uva.sea.languages.ql.interpreter.evaluate.valueTypes.BooleanValue;

public class RadioButtonWidget implements Widget {

    @Override
    public Control draw(BaseQuestionModel questionModel, FormController controller) {
        //TODO: check implementation
        RadioButton radioButton = new RadioButton();

        radioButton.selectedProperty().addListener(
                (observable, oldValue, newValue) -> controller.updateGuiModel(questionModel.getVariableName(), new BooleanValue(newValue))
        );

        return radioButton;

    }
}
