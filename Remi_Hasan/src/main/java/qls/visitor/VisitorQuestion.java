package qls.visitor;

import qls.model.Question;
import qls.model.widget.Widget;
import qls.antlr.QLSBaseVisitor;
import qls.antlr.QLSParser;

public class VisitorQuestion extends QLSBaseVisitor<Question> {

    @Override
    public Question visitQuestion(QLSParser.QuestionContext ctx) {
        VisitorWidget visitorWidget = new VisitorWidget();

        Widget widget = null;
        if (ctx.widget() != null) {
            widget = visitorWidget.visit(ctx.widget());
        }

        return new Question(ctx.getStart(), ctx.IDENTIFIER().getText(), widget);
    }
}
