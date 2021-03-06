package qlviz.interpreter.style;

import com.google.inject.Inject;
import qlviz.QLSBaseVisitor;
import qlviz.QLSVisitor;
import qlviz.QLSParser;
import qlviz.model.style.DefaultWidgetDeclaration;
import qlviz.model.style.Page;
import qlviz.model.style.Section;
import qlviz.model.style.Stylesheet;

import java.util.stream.Collectors;

public class PageVisitor extends QLSBaseVisitor<Page> {

    private final QLSVisitor<Section> sectionVisitor;
    private final QLSVisitor<DefaultWidgetDeclaration> defaultWidgetVisitor;

    @Inject
    public PageVisitor(QLSVisitor<Section> sectionVisitor, QLSVisitor<DefaultWidgetDeclaration> defaultWidgetVisitor) {
        this.sectionVisitor = sectionVisitor;
        this.defaultWidgetVisitor = defaultWidgetVisitor;
    }

    @Override
    public Page visitPage(QLSParser.PageContext ctx) {
        Page page = new Page(
                ctx.IDENTIFIER().getText(),
                ctx.section()
                        .stream()
                        .map(sectionVisitor::visitSection)
                        .collect(Collectors.toList()),
                ctx.defaultWidgetDeclaration()
                        .stream()
                        .map(defaultWidgetVisitor::visitDefaultWidgetDeclaration)
                        .collect(Collectors.toList()),
                ctx
        );
        for (Section section : page.getSections()) {
            section.setParent(page);
        }
        return page;
    }
}
