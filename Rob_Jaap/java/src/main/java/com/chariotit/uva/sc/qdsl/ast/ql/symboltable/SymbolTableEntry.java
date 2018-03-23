package com.chariotit.uva.sc.qdsl.ast.ql.symboltable;

import com.chariotit.uva.sc.qdsl.ast.ExpressionType;
import com.chariotit.uva.sc.qdsl.ast.ExpressionValue;
import com.chariotit.uva.sc.qdsl.ast.ql.node.AstNode;

public class SymbolTableEntry {

    private String label;
    private AstNode node;
    private ExpressionType expressionType;
    private ExpressionValue expressionValue;

    public SymbolTableEntry(String label, AstNode node) {
        this.label = label;
        this.node = node;
    }

    public SymbolTableEntry(String label, AstNode node, ExpressionType expressionType) {
        this.label = label;
        this.node = node;
        this.expressionType = expressionType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public AstNode getNode() {
        return node;
    }

    public void setNode(AstNode node) {
        this.node = node;
    }

    public ExpressionType getExpressionType() {
        return expressionType;
    }

    public void setExpressionType(ExpressionType expressionType) {
        this.expressionType = expressionType;
    }

    public ExpressionValue getExpressionValue() {
        return expressionValue;
    }

    public void setExpressionValue(ExpressionValue expressionValue) {
        this.expressionValue = expressionValue;
    }
}
