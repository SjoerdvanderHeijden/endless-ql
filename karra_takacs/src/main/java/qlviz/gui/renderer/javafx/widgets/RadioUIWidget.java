package qlviz.gui.renderer.javafx.widgets;

import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import qlviz.gui.viewModel.question.*;
import qlviz.model.style.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RadioUIWidget implements UIWidget, QuestionViewModelVisitor, ParameterVisitor {

    private final ToggleGroup toggleGroup;
    private final VBox container;
    private final List<RadioButton> radioButtons = new ArrayList<>();

    public RadioUIWidget(List<Parameter> parameters) {
        this.toggleGroup = new ToggleGroup();
        this.container = new VBox();
        for (Parameter option : parameters) {
            option.accept(this);
        }

    }

    @Override
    public Node getNode() {
        return this.container;
    }

    @Override
    public void bindToQuestion(QuestionViewModel questionViewModel) {
        questionViewModel.accept(this);
    }

    @Override
    public void setProperty(PropertySetting setting) {
        ParameterValueReader parameterValueReader = new ParameterValueReader();
        setting.getValue().accept(parameterValueReader);
        switch (setting.getPropertyKey()) {
            case "font":
                this.radioButtons.forEach(rb ->
                        rb.setFont(new Font(parameterValueReader.getStringValue(), rb.getFont().getSize())));
                break;
            case "fontsize":
                this.radioButtons.forEach(rb ->
                        rb.setFont(new Font(rb.getFont().getName(), parameterValueReader.getNumericValue().doubleValue())));
                break;
        }
    }

    @Override
    public void visit(BooleanQuestionViewModel booleanQuestion) {
        this.toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) ->
            booleanQuestion.valueProperty().setValue(newValue == toggleGroup.getToggles().get(0)));
    }

    @Override
    public void visit(DateQuestionViewModel dateQuestion) {

    }

    @Override
    public void visit(DecimalQuestionViewModel decimalQuestion) {

    }

    @Override
    public void visit(IntegerQuestionViewModel integerQuestion) {

    }

    @Override
    public void visit(MoneyQuestionViewModel moneyQuestion) {

    }

    @Override
    public void visit(StringQuestionViewModel stringQuestion) {
        this.toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) ->
            stringQuestion.valueProperty().setValue(((StringParameter)newValue.getUserData()).getValue()));
    }

    @Override
    public void visit(StringParameter stringParameter) {
        RadioButton radioButton = new RadioButton();
        radioButton.setText(stringParameter.getValue());
        radioButton.setUserData(stringParameter);
        this.container.getChildren().add(radioButton);
        this.radioButtons.add(radioButton);
        radioButton.setToggleGroup(this.toggleGroup);
    }

    @Override
    public void visit(NumericParameter numericParameter) {
    }

    @Override
    public void visit(ColorParameter colorParameter) {

    }
}
