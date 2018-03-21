package qlviz.interpreter.style;

import com.google.inject.Inject;
import qlviz.QLSBaseVisitor;
import qlviz.QLSParser;
import qlviz.model.style.Page;
import qlviz.model.style.Stylesheet;

import java.util.stream.Collectors;

public class StylesheetVisitor extends QLSBaseVisitor<Stylesheet> {

    private final QLSBaseVisitor<Page> pageVisitor;

    @Inject
    public StylesheetVisitor(QLSBaseVisitor<Page> pageVisitor) {
        this.pageVisitor = pageVisitor;
    }

    @Override
    public Stylesheet visitStylesheet(QLSParser.StylesheetContext ctx) {
        Stylesheet stylesheet = new Stylesheet(
                ctx.page()
                        .stream()
                        .map(pageVisitor::visitPage)
                        .collect(Collectors.toList()),
                ctx.IDENTIFIER().getText(),
                ctx);
        for (Page page : stylesheet.getPages()) {
            page.setParent(stylesheet);
        }
        return stylesheet;
    }
}
