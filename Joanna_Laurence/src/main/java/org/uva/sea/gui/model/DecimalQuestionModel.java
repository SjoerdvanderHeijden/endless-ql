package org.uva.sea.gui.model;

import org.uva.sea.gui.render.visitor.IQuestionModelVisitor;
import org.uva.sea.languages.ql.interpreter.dataObject.questionData.QuestionData;
import org.uva.sea.languages.ql.interpreter.evaluate.valueTypes.DecimalValue;

public class DecimalQuestionModel extends BaseQuestionModel {

    private final DecimalValue value;

    public DecimalQuestionModel(QuestionData data) {
        super(data);
        //TODO: Handle situation when data.getValue() return ErrorValue
        //throw an exception and set default valu
        this.value = (DecimalValue) data.getValue();
    }

    @Override
    public <T> T accept(IQuestionModelVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String displayValue() {
        return (this.value != null) ? String.valueOf(this.value.getDecimalValue()) : "No value";
    }
}
