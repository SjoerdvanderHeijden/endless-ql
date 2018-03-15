package org.uva.sea.languages.qls.parser.elements.specification;

import org.antlr.v4.runtime.Token;
import org.uva.sea.languages.qls.parser.elements.style.StyleSpecification;
import org.uva.sea.languages.qls.parser.visitor.IStyleASTVisitor;

import java.util.List;

public class DefaultStyle extends Specification {

    private final String typeName;
    private final List<StyleSpecification> styleSpecificationList;

    public DefaultStyle(Token token, String typeName, List<StyleSpecification> styleSpecificationList) {
        super(token);
        this.styleSpecificationList = styleSpecificationList;
        this.typeName = typeName;
    }

    public Iterable<StyleSpecification> getStyleSpecificationList() {
        return styleSpecificationList;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public <T> T accept(IStyleASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
