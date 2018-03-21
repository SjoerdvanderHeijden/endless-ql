package qlviz.interpreter;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import qlviz.QLBaseVisitor;
import qlviz.QLParser;
import qlviz.model.booleanExpressions.BooleanExpression;
import qlviz.model.ConditionalBlock;
import qlviz.model.QuestionBlock;

import java.util.stream.Collectors;

public class ConditionalBlockVisitor extends QLBaseVisitor<ConditionalBlock> {

    private final QLBaseVisitor<BooleanExpression> booleanExpressionVisitor;
    private final QLBaseVisitor<QuestionBlock> questionBlockVisitor;

    @Inject
    public ConditionalBlockVisitor(
            QLBaseVisitor<BooleanExpression> booleanExpressionVisitor,
            @Assisted QLBaseVisitor<QuestionBlock> questionBlockVisitor) {
        this.booleanExpressionVisitor = booleanExpressionVisitor;
        this.questionBlockVisitor = questionBlockVisitor;
    }

    @Override
    public ConditionalBlock visitConditionalBlock(QLParser.ConditionalBlockContext ctx) {
        return new ConditionalBlock(
                booleanExpressionVisitor.visitBooleanExpression(ctx.booleanExpression()),
                ctx.questionBlock().stream().map(questionBlockVisitor::visitQuestionBlock).collect(Collectors.toList()),
                ctx);
    }
}
