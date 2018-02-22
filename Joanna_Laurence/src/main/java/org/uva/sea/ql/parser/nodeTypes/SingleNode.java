package org.uva.sea.ql.parser.nodeTypes;

import org.antlr.v4.runtime.Token;
import org.uva.sea.ql.parser.elements.ASTNode;
import org.uva.sea.ql.traverse.Visitor;

public abstract class SingleNode extends ASTNode {
    private ASTNode value;

    public SingleNode(Token token, ASTNode value) {
        super(token);
        this.value = value;
    }

    public ASTNode getValue() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
