package Nodes;

public abstract class ASTNode {
    private ASTNode parent;

    public ASTNode getParent() {
        return parent;
    }

    public void setParent(ASTNode parent) {
        this.parent = parent;
    }


}
