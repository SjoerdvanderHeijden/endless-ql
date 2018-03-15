package com.chariotit.uva.sc.qdsl.qls.ast.node;

import com.chariotit.uva.sc.qdsl.qls.ast.visitor.NodeVisitor;

import java.util.ArrayList;
import java.util.List;

public class Page extends AstNode {

    private List<DefaultProperties> defaults;
    private List<Section> sections;
    private String label;

    public Page(List<Section> sections, String label, List<DefaultProperties> defaults, Integer
            columnNumber,
                Integer lineNumber) {
        super(lineNumber, columnNumber);
        this.defaults = defaults;
        this.sections = sections;
        this.label = label;
    }

    public Page(List<Section> sections, String label, Integer columnNumber, Integer lineNumber) {
        super(lineNumber, columnNumber);
        this.defaults = new ArrayList<>();
        this.sections = sections;
        this.label = label;
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {

    }
}
