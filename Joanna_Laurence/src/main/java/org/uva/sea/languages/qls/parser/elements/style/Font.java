package org.uva.sea.languages.qls.parser.elements.style;

import org.antlr.v4.runtime.Token;
import org.uva.sea.languages.qls.parser.visitor.IStyleASTVisitor;

public class Font extends StyleSpecification {

    private final String name;

    public Font(Token token, String name) {
        super(token);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public <T> T accept(IStyleASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
