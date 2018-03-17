package org.uva.qls.ast.Segment;

import org.uva.qls.ast.Style.Style;
import org.uva.qls.ast.Widget.Widget;
import org.uva.qls.visitor.SegmentVisitor;

import java.util.List;
import java.util.Arrays;

public class QuestionReference extends Segment {

    private String id;
    private Style style;
    private Widget widget;

    public QuestionReference(String id, Style style, Widget widget) {
        this.id = id;
        this.style = style;
        this.widget = widget;
    }

    public String getId() {
        return id;
    }

    public Widget getWidget() {
        return widget;
    }


    @Override
    public List<QuestionReference> getQuestions() {
        return Arrays.asList(this);
    }

    @Override
    public <S> S accept(SegmentVisitor<S> visitor) {
        return visitor.visit(this);
    }
}
