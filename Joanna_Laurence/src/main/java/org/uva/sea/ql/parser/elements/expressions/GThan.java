package org.uva.sea.ql.parser.elements.expressions;

import org.uva.sea.ql.parser.elements.ASTNode;
import org.uva.sea.ql.parser.elements.TraverseType;
import org.uva.sea.ql.parser.elements.types.Type;
import org.uva.sea.ql.parser.nodeTypes.DualNode;
import org.uva.sea.ql.traverse.Traverse;

public class GThan extends DualNode {
    public GThan(ASTNode lhs, ASTNode rhs) {
        super(lhs, rhs);
    }

    public void traverseNode(Traverse traverse, TraverseType traverseType) {
        super.traverseNode(traverse, traverseType);
        traverse.doLogical(this);
        traverse.doGThan(this);
    }

    /**
     * @return True or false is returned
     */
    public Type getType() {
        return new Type("boolean");
    }
}