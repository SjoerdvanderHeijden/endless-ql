package com.chariotit.uva.sc.qdsl.ast.ql.node;

import com.chariotit.uva.sc.qdsl.ast.common.SourceFilePosition;
import com.chariotit.uva.sc.qdsl.ast.ql.visitor.NodeVisitor;

import java.util.List;

public class Form extends AstNode {

    private String label;
    private List<FormElement> formElements;

    public Form(String label, List<FormElement> formElements, SourceFilePosition filePosition) {
        super(filePosition);

        this.label = label;
        this.formElements = formElements;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<FormElement> getFormElements() {
        return formElements;
    }

    public void setFormElements(List<FormElement> formElements) {
        this.formElements = formElements;
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {
        for (FormElement formElement : formElements) {
            formElement.acceptVisitor(visitor);
        }

        visitor.visitForm(this);
    }
}
