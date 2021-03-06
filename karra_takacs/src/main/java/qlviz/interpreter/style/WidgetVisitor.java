package qlviz.interpreter.style;

import com.google.inject.Inject;
import qlviz.QLSBaseVisitor;
import qlviz.QLSVisitor;
import qlviz.QLSParser;
import qlviz.model.style.Parameter;
import qlviz.model.style.Widget;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class WidgetVisitor extends QLSBaseVisitor<Widget> {

   private final WidgetTypeTranslator widgetTypeTranslator;
   private final QLSVisitor<Parameter> parameterVisitor;

   @Inject
    public WidgetVisitor(WidgetTypeTranslator widgetTypeTranslator, QLSVisitor<Parameter> parameterVisitor) {
        this.widgetTypeTranslator = widgetTypeTranslator;
        this.parameterVisitor = parameterVisitor;
    }

    @Override
    public Widget visitWidget(QLSParser.WidgetContext ctx) {
        if (ctx.simpleWidget() != null) {
            return
                    new Widget(ctx.simpleWidget(),
                               widgetTypeTranslator.translate(ctx.simpleWidget().WIDGET_TYPE()),
                               new ArrayList<>());
        }
        else
        {
            return new Widget(ctx.parametrizedWidget(),
                              widgetTypeTranslator.translate(ctx.parametrizedWidget().WIDGET_TYPE()),
                              ctx.parametrizedWidget().parameter()
                                                      .stream()
                                                      .map(parameterVisitor::visitParameter)
                                                      .collect(Collectors.toList()));
        }
    }
}
