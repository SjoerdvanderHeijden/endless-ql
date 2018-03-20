package com.chariotit.uva.sc.qdsl.ast.qls.node;

import com.chariotit.uva.sc.qdsl.ast.qls.visitor.NodeVisitor;

import java.util.List;

public class Question extends SectionElement {

    private String label;
    private Properties properties;

    public Question(String label, Properties properties, Integer lineNumber, Integer
            columnNumber) {
        super(lineNumber, columnNumber);
        this.label = label;
        this.properties = properties;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {
        properties.acceptVisitor(visitor);

        visitor.visitQuestion(this);
    }
}
