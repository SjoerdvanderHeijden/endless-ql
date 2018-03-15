package org.uva.sea.languages.qls.parser.elements.style;

import org.antlr.v4.runtime.Token;
import org.uva.sea.languages.ql.interpreter.dataObject.WidgetType;
import org.uva.sea.languages.qls.parser.elements.Parameter;
import org.uva.sea.languages.qls.parser.visitor.IStyleASTVisitor;

import java.util.ArrayList;
import java.util.List;

public class Widget extends StyleSpecification {

    private final WidgetType widgetType;
    private final List<Parameter> parameters;

    public Widget(Token token, String widgetType, List<Parameter> parameters) {
        super(token);
        this.parameters = parameters;
        this.widgetType = WidgetType.valueOf(widgetType.toUpperCase());
    }

    public WidgetType getWidgetType() {
        return this.widgetType;
    }

    public Iterable<Parameter> getParameters() {
        return this.parameters;
    }

    @Override
    public <T> T accept(IStyleASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    /**
     * Get parameters from widget
     *
     * @return List of parameters
     */
    public List<String> getStringParameters() {
        List<String> parameters = new ArrayList<>();
        for (Parameter parameter : this.getParameters())
            parameters.add(parameter.getParameter());
        return parameters;
    }
}
