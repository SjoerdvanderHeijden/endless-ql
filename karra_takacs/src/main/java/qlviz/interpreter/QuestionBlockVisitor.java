package qlviz.interpreter;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import qlviz.QLBaseVisitor;
import qlviz.QLParser;
import qlviz.model.ConditionalBlock;
import qlviz.model.question.Question;
import qlviz.model.QuestionBlock;

import java.util.stream.Collectors;

public class QuestionBlockVisitor extends QLBaseVisitor<QuestionBlock> {

    private final QLBaseVisitor<Question> questionVisitor;
    private final QLBaseVisitor<ConditionalBlock> conditionalBlockVisitor;

    @Inject
    public QuestionBlockVisitor(
            QuestionVisitor questionVisitor,
            ConditionalBlockVisitorFactory conditionalBlockVisitorFactory) {
        this.questionVisitor = questionVisitor;
        this.conditionalBlockVisitor = conditionalBlockVisitorFactory.create(this);
    }

    @Override
    public QuestionBlock visitQuestionBlock(QLParser.QuestionBlockContext ctx) {
        return new QuestionBlock(
               ctx.question().stream().map(questionVisitor::visitQuestion).collect(Collectors.toList()),
               ctx.conditionalBlock().stream().map(conditionalBlockVisitor::visitConditionalBlock).collect(Collectors.toList()),
               ctx
        );
    }
}
