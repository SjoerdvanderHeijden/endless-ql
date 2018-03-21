package org.uva.forcepushql.ast;

import javax.swing.*;
import java.util.LinkedList;

public class FormNode extends Node{
    private LinkedList<Node> questions;
    private String name;

    public FormNode(){
        questions = new LinkedList<Node>();
    }

    public LinkedList<Node> getQuestions() {
        return questions;
    }

    public void setQuestions(LinkedList<Node> questions) {
        this.questions = questions;
    }

    public void setOneQuestion(Node question){
        if (question != null)
            questions.add(question);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public LinkedList<JPanel> accept(ASTVisitor visitor) {
        return visitor.visit(this);
    }
}
