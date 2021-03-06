package nl.khonraad.ql.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import nl.khonraad.ql.QLBaseVisitor;
import nl.khonraad.ql.QLParser;
import nl.khonraad.ql.algebra.values.Operator;
import nl.khonraad.ql.algebra.values.Type;
import nl.khonraad.ql.algebra.values.Value;
import nl.khonraad.ql.language.Identifier;
import nl.khonraad.ql.language.Label;
import nl.khonraad.ql.language.Question;
import nl.khonraad.ql.language.QuestionsInterpretor;

public final class QuestionsVisitor extends QLBaseVisitor<Value> {

    @Inject
    private QuestionsInterpretor questionsInterpretor;

    private List<Identifier>     forwardReferences             = new ArrayList<>();

    private static final String  REFERENCES_UNDEFINED_QUESTION = "Reference to undefined question: ";

    @Override
    public Value visitForm( QLParser.FormContext ctx ) {

        Value value = visitChildren( ctx );

        if ( !forwardReferences.isEmpty() ) {
            throw new RuntimeException( REFERENCES_UNDEFINED_QUESTION + forwardReferences.get( 0 ) );
        }
        return value;
    }

    @Override
    public Value visitIdentifier( QLParser.IdentifierContext ctx ) {

        Identifier identifier = new Identifier( ctx.Identifier().getText() );

        Optional<Question> question = questionsInterpretor.queryAnswerableQuestion( identifier );

        if ( question.isPresent() ) {
            forwardReferences.remove( identifier );
            return question.get().value();
        }
        throw new RuntimeException( REFERENCES_UNDEFINED_QUESTION + identifier.string() );
    }

    @Override
    public Value visitPartAnswerableQuestion( QLParser.PartAnswerableQuestionContext ctx ) {

        Identifier identifier = new Identifier( ctx.Identifier().getText() );
        Label label = new Label( ctx.QuotedString().getText() );

        Type type = Type.type( ctx.type().getText() );

        Optional<Question> question = questionsInterpretor.queryAnswerableQuestion( identifier );

        if ( question.isPresent() ) {

            throw reportError( ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Duplicate declaration "
                    + ctx.Identifier().getText() );
        }
        questionsInterpretor.declareAsAnswerableQuestion( identifier, label, type );

        return Value.Unit;
    }

    private IllegalStateException reportError( int l, int c, String message ) {
        return new IllegalStateException( "Line " + l + ":" + c + " " + message );
    }

    @Override
    public Value visitPartComputedQuestion( QLParser.PartComputedQuestionContext ctx ) {

        Identifier identifier = new Identifier( ctx.Identifier().getText() );
        Label label = new Label( ctx.QuotedString().getText() );

        Type type = Type.type( ctx.type().getText() );

        forwardReferences.remove( identifier );

        Value value = visit( ctx.expression() );

        if ( !type.equals( value.type() ) ) {
            throw reportError( ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Type error " + ctx.Identifier().getText() );
        }
        return questionsInterpretor.declareAsComputedQuestion( identifier, label, value );
    }

    @Override
    public Value visitUnaryOperator_Expression( QLParser.UnaryOperator_ExpressionContext ctx ) {

        Value expression = visit( ctx.expression() );
        String operator = ctx.unaryOperator().getText();

        try {
            return expression.apply( Operator.parse( operator ) );
        } catch (Exception e) {
            throw reportError( ctx.start.getLine(), ctx.start.getCharPositionInLine(), "Exception " + ctx.expression().getText() );
        }
    }

    @Override
    public Value visitExpressionQuotedString( QLParser.ExpressionQuotedStringContext ctx ) {
        return Value.of( Type.String, ctx.QuotedString().getText() );
    }

    @Override
    public Value visitExpression_MultiplicationOperator_Expression(
            QLParser.Expression_MultiplicationOperator_ExpressionContext ctx ) {

        Value left = visit( ctx.expression( 0 ) );
        Value right = visit( ctx.expression( 1 ) );
        String operator = ctx.multiplicationOperator().getText();

        return left.apply( Operator.parse( operator ), right );

    }

    @Override
    public Value visitExpression_AdditionOperator_Expression( QLParser.Expression_AdditionOperator_ExpressionContext ctx ) {

        Value left = visit( ctx.expression( 0 ) );
        Value right = visit( ctx.expression( 1 ) );
        String operator = ctx.additionOperator().getText();

        return left.apply( Operator.parse( operator ), right );
    }

    @Override
    public Value visitExpression_EqualityOperator_Expression( QLParser.Expression_EqualityOperator_ExpressionContext ctx ) {

        Value left = visit( ctx.expression( 0 ) );
        Value right = visit( ctx.expression( 1 ) );
        String operator = ctx.equalityOperator().getText();

        return left.apply( Operator.parse( operator ), right );
    }

    @Override
    public Value visitExpression_LogicalOperator_Expression( QLParser.Expression_LogicalOperator_ExpressionContext ctx ) {

        Value left = visit( ctx.expression( 0 ) );
        Value right = visit( ctx.expression( 1 ) );
        String operator = ctx.logicalOperator().getText();

        return left.apply( Operator.parse( operator ), right );
    }

    @Override
    public Value visitExpression_OrderingOperator_Expression( QLParser.Expression_OrderingOperator_ExpressionContext ctx ) {

        Value left = visit( ctx.expression( 0 ) );
        Value right = visit( ctx.expression( 1 ) );
        String operator = ctx.orderingOperator().getText();

        return left.apply( Operator.parse( operator ), right );
    }

    @Override
    public Value visitExpressionMoneyConstant( QLParser.ExpressionMoneyConstantContext ctx ) {

        return Value.of( Type.Money, ctx.MoneyConstant().getText() );
    }

    @Override
    public Value visitExpressionDateConstant( QLParser.ExpressionDateConstantContext ctx ) {

        return Value.of( Type.Date, ctx.DateConstant().getText() );
    }

    @Override
    public Value visitExpressionIntegerConstant( QLParser.ExpressionIntegerConstantContext ctx ) {

        return Value.of( Type.Integer, ctx.IntegerConstant().getText() );
    }

    @Override
    public Value visitExpressionBooleanConstant( QLParser.ExpressionBooleanConstantContext ctx ) {

        return Value.of( Type.Boolean, ctx.BooleanConstant().getText() );
    }

    @Override
    public Value visitExpressionParenthesized( QLParser.ExpressionParenthesizedContext ctx ) {

        return visit( ctx.expression() );
    }

    @Override
    public Value visitPartConditionalBlock( QLParser.PartConditionalBlockContext ctx ) {

        Value value = visit( ctx.expression() );

        if ( value.equals( Value.True ) ) {
            visitChildren( ctx.block() );
        }
        return value;
    }
}
