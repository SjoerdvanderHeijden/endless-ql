package nl.khonraad.qls.ast;

import javax.inject.Inject;

import org.slf4j.Logger;

import nl.khonraad.ql.algebra.values.Type;
import nl.khonraad.ql.algebra.values.Value;
import nl.khonraad.qls.QLSBaseVisitor;
import nl.khonraad.qls.QLSParser;
import nl.khonraad.qls.ast.data.StyleElement;
import nl.khonraad.qls.ast.data.Styling;

public final class ExtendedQLSBaseVisitor extends QLSBaseVisitor<Value> {

    @Inject
    Logger  logger;

    @Inject
    Styling questionLangugaeStyle;

    @Override
    public Value visitType( QLSParser.TypeContext ctx ) {
        return visitChildren( ctx );
    }

    @Override
    public Value visitStylesheet( QLSParser.StylesheetContext ctx ) {
        return visitChildren( ctx );
    }

    @Override
    public Value visitPage( QLSParser.PageContext ctx ) {
        return visitChildren( ctx );
    }

    @Override
    public Value visitSection( QLSParser.SectionContext ctx ) {
        return visitChildren( ctx );
    }

    @Override
    public Value visitQuestion( QLSParser.QuestionContext ctx ) {
        return visitChildren( ctx );
    }

    @Override
    public Value visitStatement( QLSParser.StatementContext ctx ) {
        return visitChildren( ctx );
    }

    @Override
    public Value visitDefaultstyle( QLSParser.DefaultstyleContext ctx ) {

        logger.info( ctx.type().getText() );

        if ( "boolean".equals( ctx.type().getText() ) ) {

            String t = ctx.widget().QuotedString( 0 ).getText();
            String f = ctx.widget().QuotedString( 1 ).getText();

            questionLangugaeStyle.storeElementDefault( new StyleElement( Type.Boolean, t, f ) );
        }
        return visitChildren( ctx );
    }

    @Override
    public Value visitAttribute( QLSParser.AttributeContext ctx ) {
        return visitChildren( ctx );
    }

    @Override
    public Value visitWidget( QLSParser.WidgetContext ctx ) {
        return visitChildren( ctx );
    }
}