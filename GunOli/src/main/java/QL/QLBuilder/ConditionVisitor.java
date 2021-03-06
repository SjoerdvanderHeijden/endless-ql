package QL.QLBuilder;

import QL.AST.Expressions.BinaryExpressions.AndExpression;
import QL.AST.Expressions.Expression;
import QL.AST.Expressions.UnaryExpressions.NotExpression;
import QL.AST.Question;
import QL.QLAntlrGen.QLBaseVisitor;
import QL.QLAntlrGen.QLParser;

import java.util.ArrayList;

public class ConditionVisitor extends QLBaseVisitor{
    private Expression condition;

    public ConditionVisitor(Expression condition){
        this.condition = condition;
    }

    @Override
    public ArrayList<Question> visitCondition(QLParser.ConditionContext ctx){
        int line = ctx.getStart().getLine();
        ArrayList<Question> questions = new ArrayList<>();
        ExpressionVisitor expressionVisitor = new ExpressionVisitor();

        QLParser.ExpressionContext expressionCtx = ctx.expression();
        Expression condition = expressionVisitor.visit(expressionCtx);

        QLParser.BlockContext blockCtx = ctx.trueBlock;

        if(ctx.falseBlock != null){
            QLParser.BlockContext falseBlockCtx = ctx.falseBlock;
            Expression negatedCondition = new NotExpression(condition, line);
            Expression conditionChain = new AndExpression(negatedCondition, this.condition, line);
            BlockVisitor falseBlockVisitor = new BlockVisitor(conditionChain);
            ArrayList<Question> falseBlockQuestions = falseBlockVisitor.visitBlock(falseBlockCtx);
            questions.addAll(falseBlockQuestions);
        }

        Expression conditionChain = new AndExpression(condition, this.condition, line);
        BlockVisitor trueBlockVisitor = new BlockVisitor(conditionChain);
        ArrayList<Question> blockQuestions = trueBlockVisitor.visitBlock(blockCtx);
        questions.addAll(blockQuestions);
        return questions;
    }
}

