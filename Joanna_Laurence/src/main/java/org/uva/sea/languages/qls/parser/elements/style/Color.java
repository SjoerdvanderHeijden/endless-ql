package org.uva.sea.languages.qls.parser.elements.style;

import org.antlr.v4.runtime.Token;
import org.uva.sea.languages.qls.parser.visitor.IStyleASTVisitor;

public class Color extends StyleSpecification {

    private final String colorCode;

    public Color(Token token, String colorCode) {
        super(token);
        this.colorCode = colorCode;
    }

    public String getColorCode() {
        return colorCode;
    }

    @Override
    public <T> T accept(IStyleASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
