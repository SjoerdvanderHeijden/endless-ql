package org.uva.sea.languages.qls.parser.elements.specification;

import org.antlr.v4.runtime.Token;
import org.uva.sea.languages.qls.parser.elements.QLSNode;

public abstract class Specification extends QLSNode {
    Specification(final Token token) {
        super(token);
    }
}
