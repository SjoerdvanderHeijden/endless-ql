package com.chariotit.uva.sc.qdsl.ast.ql.node;

import com.chariotit.uva.sc.qdsl.ast.common.SourceFilePosition;
import com.chariotit.uva.sc.qdsl.ast.ql.visitor.NodeVisitor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IfBlock extends BlockElement {

    private Expression expression;
    private List<FormElement> ifElements;
    private List<FormElement> elseElements;

    public IfBlock(Expression expression, List<FormElement> formElements, SourceFilePosition filePosition) {
        super(filePosition);
        this.expression = expression;
        this.ifElements = formElements;
    }

    public IfBlock(Expression expression, List<FormElement> ifElements, List<FormElement>
            elseElements, SourceFilePosition filePosition) {
        super(filePosition);
        this.expression = expression;
        this.ifElements = ifElements;
        this.elseElements = elseElements;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public List<FormElement> getIfElements() {
        return ifElements;
    }

    public List<FormElement> getElseElements() {
        return elseElements;
    }

    @Override
    public Set<String> getPrerequisites() {
        return expression.getPrerequisites();
    }

    @Override
    public Set<String> getProducedLabels() {
        Set<String> producedLabels = new HashSet<>();

        for (FormElement formElement : ifElements) {
            producedLabels.addAll(formElement.getProducedLabels());
        }

        if (elseElements != null) {
            for (FormElement formElement : elseElements) {
                producedLabels.addAll(formElement.getProducedLabels());
            }
        }

        return producedLabels;
    }

    @Override
    public void acceptVisitor(NodeVisitor visitor) {
        expression.acceptVisitor(visitor);

        for (FormElement formElement : ifElements) {
            formElement.acceptVisitor(visitor);
        }

        if (elseElements != null) {
            for (FormElement formElement : elseElements) {
                formElement.acceptVisitor(visitor);
            }
        }

        visitor.visitIfBlock(this);
    }
}
