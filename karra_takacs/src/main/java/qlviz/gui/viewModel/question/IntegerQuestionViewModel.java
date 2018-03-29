package qlviz.gui.viewModel.question;

import qlviz.gui.viewModel.booleanExpressions.BooleanExpressionViewModel;
import qlviz.gui.viewModel.numericExpressions.NumericExpressionViewModelFactory;
import qlviz.model.question.IntegerQuestion;

import java.util.List;

public class IntegerQuestionViewModel extends NumericQuestionViewModel {
    public IntegerQuestionViewModel(
            IntegerQuestion question,
            NumericExpressionViewModelFactory factory,
            List<BooleanExpressionViewModel> conditions) {
        super(question, factory, conditions);
    }


    @Override
    public void accept(QuestionViewModelVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public <T> T accept(TypedQuestionViewModelVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
