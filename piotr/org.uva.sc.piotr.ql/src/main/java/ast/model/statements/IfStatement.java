package ast.model.statements;

import ast.model.expressions.Expression;
import ast.visitors.ASTNodeVisitor;

import java.util.List;

public class IfStatement extends Statement {

    private final Expression condition;
    private List<Statement> statementList;
    private List<Statement> elseStatementList;

    public IfStatement(Expression condition, List<Statement> statementList, List<Statement> elseStatementList, MetaInformation metaInformation) {
        super(metaInformation);
        this.condition = condition;
        this.statementList = statementList;
        this.elseStatementList = elseStatementList;
    }

    public IfStatement(Expression condition, List<Statement> statementList, List<Statement> elseStatementList){
        super();
        this.condition = condition;
        this.statementList = statementList;
        this.elseStatementList = elseStatementList;
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getElseStatementList() {
        return elseStatementList;
    }

    public List<Statement> getStatementList() {
        return statementList;
    }

    @Override
    public <T> T accept(ASTNodeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
