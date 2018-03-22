package org.uva.qls.collector;

import org.uva.ql.ast.Question;
import org.uva.qls.ast.DefaultStatement.DefaultWidgetStatement;
import org.uva.qls.ast.Segment.*;
import org.uva.qls.visitor.SegmentVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class StylesheetContext implements SegmentVisitor<Segment> {

    private final HashMap<String, Section> sections = new LinkedHashMap<>();
    private final HashMap<String, QuestionReference> questions = new LinkedHashMap<>();
    private final HashMap<String, Page> pages = new LinkedHashMap<>();
    private final HashMap<String, Segment> parents = new LinkedHashMap<>();

    private final Stylesheet stylesheet;

    public StylesheetContext(Stylesheet stylesheet) {
        this.stylesheet = stylesheet;

        stylesheet.accept(this, null);
    }

    public List<QuestionReference> getQuestions() {
        return new ArrayList<>(questions.values());
    }

    public List<Page> getPages() {
        return new ArrayList<>(pages.values());
    }

    public Segment getPage(Question question) {
        for (Segment parent : getAllParents("Question." + question.getId())) {
            if (pages.containsKey(parent.getId())) {
                return pages.get(parent.getId());
            }
        }
        return null;
    }

    public List<Section> getSections() {
        return new ArrayList<>(sections.values());
    }

    public Segment getParent(String segmentId) {
        if (parents.containsKey(segmentId)) {
            return parents.get(segmentId);
        }
        return null;
    }

    public List<Segment> getAllParents(String segmentId) {
        List<Segment> segments = new ArrayList<>();
        if (parents.containsKey(segmentId)) {
            Segment parent = parents.get(segmentId);
            segments.add(parent);
            segments.addAll(getAllParents(parent.getId()));
            return segments;
        }
        return segments;
    }

    public List<DefaultWidgetStatement> getAllDefaultWidgetStatements(){
        List<DefaultWidgetStatement> defaults = new ArrayList<>();
        for(Segment section: sections.values()){
            defaults.addAll(section.getDefaultWidgetStatements());
        }
        for(Segment page: pages.values()){
            defaults.addAll(page.getDefaultWidgetStatements());
        }
        return defaults;
    }

    public QuestionReference getQuestion(String questionId) {
        if (questions.containsKey(questionId)) {
            return questions.get(questionId);
        }
        return null;
    }

    public QuestionReference getQuestionReference(Question question) {
        return getQuestion("Question." + question.getId());
    }


    @Override
    public Segment visit(Section section, Segment parent) {
        sections.put(section.getId(), section);
        parents.put(section.getId(), parent);

        for (Segment segment : section.getSegments()) {
            segment.accept(this, section);
        }
        return section;
    }

    @Override
    public Segment visit(QuestionReference questionReference, Segment parent) {
        questions.put(questionReference.getId(), questionReference);
        parents.put(questionReference.getId(), parent);
        return questionReference;
    }

    @Override
    public Segment visit(Page page, Segment parent) {
        pages.put(page.getId(), page);

        for (Segment segment : page.getSegments()) {
            segment.accept(this, page);
        }

        return page;
    }

    @Override
    public Segment visit(Stylesheet stylesheet) {
        for (Page page : stylesheet.getPages()) {
            page.accept(this, stylesheet);
        }
        return stylesheet;
    }


}
