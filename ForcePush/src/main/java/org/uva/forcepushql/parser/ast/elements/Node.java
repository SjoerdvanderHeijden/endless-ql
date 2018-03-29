package org.uva.forcepushql.parser.ast.elements;

import org.antlr.v4.runtime.Token;
import org.uva.forcepushql.parser.ast.visitors.ASTVisitor;

public abstract class Node {

    private Token token = null;

    protected Node(){    }

    protected Node(Token token){ this.token = token;}

    public int getLine(){
        return this.token.getLine();
    }

    public int getColumn(){
        return this.token.getCharPositionInLine();
    }

    abstract public <T> T accept(ASTVisitor visitor);

}
