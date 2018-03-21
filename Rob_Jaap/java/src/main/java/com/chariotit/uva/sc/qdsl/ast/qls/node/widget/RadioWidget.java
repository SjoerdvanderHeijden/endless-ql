package com.chariotit.uva.sc.qdsl.ast.qls.node.widget;

import com.chariotit.uva.sc.qdsl.ast.ExpressionType;
import com.chariotit.uva.sc.qdsl.ast.qls.node.WidgetType;
import com.chariotit.uva.sc.qdsl.ast.qls.visitor.NodeVisitor;

public class RadioWidget extends WidgetType {

    private String yesLabel;
    private String noLabel;

    public RadioWidget(String yesLabel, String noLabel, Integer lineNumber, Integer columnNumber) {
        super(lineNumber, columnNumber);
        this.yesLabel = yesLabel;
        this.noLabel = noLabel;
    }

    public RadioWidget(Integer lineNumber, Integer columnNumber) {
        super(lineNumber, columnNumber);
    }

    public String getNoLabel() {
        return noLabel;
    }

    public void setNoLabel(String noLabel) {
        this.noLabel = noLabel;
    }

    public String getYesLabel() {

        return yesLabel;
    }

    public void setYesLabel(String yesLabel) {
        this.yesLabel = yesLabel;
    }

    @Override
    public boolean isValidExpressionType(ExpressionType expressionType) {
        return expressionType == ExpressionType.BOOLEAN;
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {
        visitor.visitRadioWidget(this);
    }
}
