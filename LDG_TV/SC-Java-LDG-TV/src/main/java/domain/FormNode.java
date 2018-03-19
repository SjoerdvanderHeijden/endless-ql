package domain;

import domain.model.IfASTNode;
import domain.model.ASTNode;
import domain.model.QuestionASTNode;
import domain.model.value.MoneyValue;
import domain.model.variable.MoneyVariable;
import domain.model.variable.Variable;

import java.util.ArrayList;
import java.util.List;

public class FormNode {

    private String formIdentifier;
    private List<ASTNode> ASTNodes;
    private List<Variable> referencedVariables;
    private int lastIfIndex;

    public FormNode(){
        this.ASTNodes = new ArrayList<>();
        this.referencedVariables = new ArrayList<Variable>();
    }

    public List<Variable> getReferencedVariables() {
        return referencedVariables;
    }

    public void setFormIdentifier(String formIdentifier) {
        this.formIdentifier = formIdentifier;
    }
    public String getFormIdentifier() {
        return formIdentifier;
    }

    public List<ASTNode> getASTNodes() {
        return this.ASTNodes;
    }

    public void addQuestion(QuestionASTNode q){
        this.ASTNodes.add(q);
    }

    public void addIfNode(IfASTNode ifNode){
        this.ASTNodes.add(ifNode);
        this.lastIfIndex = this.ASTNodes.size() - 1;
    }

    public void addToLastIf(QuestionASTNode q){
        IfASTNode ifNode = (IfASTNode) this.ASTNodes.get(this.lastIfIndex); // TODO check for instance of and not out of bounds
        ifNode.addQuestion(q);
    }

    public Variable getVariableFromList(String label){
        Variable qv = null ;
        for (QuestionASTNode qan : getAllQuestionASTNodes()) {
               if(qan.getVariable().getIdentifier().equals(label) ){
                   qv = qan.getVariable();
               }
        }
        return qv;
    }
    public QuestionASTNode getQuestionByVariableIdentifier(String identifier){
        QuestionASTNode qv = null ;
        for (QuestionASTNode qan : getAllQuestionASTNodes()) {
            if(qan.getVariable().getIdentifier().equals(identifier) ){
                return qan;
            }
        }
        return null;
    }

    public List<QuestionASTNode> getAllQuestionASTNodes(){
        List<QuestionASTNode> temp = new ArrayList<>();
        for (ASTNode an : getASTNodes()) {
            if(an instanceof QuestionASTNode){
                temp.add((QuestionASTNode) an);
            }
            if(an instanceof IfASTNode){
                temp.addAll(((IfASTNode) an).getQuestionNodes());
            }
        }
        return temp;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        for (ASTNode n : ASTNodes) {
            str.append(n)
                    .append('\n');
        }

        return str.toString();
    }

    public void evaluateIfs() {
        for (ASTNode an : getASTNodes()) {
            if(an instanceof IfASTNode){
                IfASTNode ifNode = (IfASTNode) an;
                ifNode.checkConditions();
            }
        }
    }

    public void evaluateArithmetic() {
        for (ASTNode an : getAllQuestionASTNodes())) {

        }
    }
}
