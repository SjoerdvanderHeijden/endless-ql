package QLS.QLSVisitor;

import QLS.ParseObjectQLS.Default;
import QLS.ParseObjectQLS.QLSQuestion;
import QLS.ParseObjectQLS.Section;
import QLS.QLSAntlrGen.QLSBaseVisitor;
import QLS.QLSAntlrGen.QLSParser;

import java.util.ArrayList;

public class SectionVisitor extends QLSBaseVisitor {

    @Override
    public Section visitSection(QLSParser.SectionContext ctx){

        int line = ctx.getStart().getLine();
        ArrayList<Section> sections = new ArrayList<Section>();
        ArrayList<Default> defaultSections = new ArrayList<Default>();
        ArrayList<QLSQuestion> questions = new ArrayList<QLSQuestion>();
        SectionVisitor sectionVisitor = new SectionVisitor();
        DefaultVisitor defaultVisitor = new DefaultVisitor();
        QLSQuestionVisitor questionVisitor = new QLSQuestionVisitor();

        for(QLSParser.SectionContext secCtx: ctx.section()){
            Section section = sectionVisitor.visitSection(secCtx);
            sections.add(section);
        }

        for(QLSParser.DefaultSecContext defSecCtx: ctx.defaultSec()){
            Default defaultSection = defaultVisitor.visitDefaultSec(defSecCtx);
            defaultSections.add(defaultSection);
        }

        for(QLSParser.QuestionContext questionCtx : ctx.question() ){
            QLSQuestion question = questionVisitor.visitQuestion(questionCtx);
            questions.add(question);
        }
        return new Section(ctx.STRING().getText(), questions, sections, defaultSections, line);

    }
}
