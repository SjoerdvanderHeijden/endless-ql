package ast.model.declarations;

import ast.model.ASTNode;

public abstract class TypeDeclaration extends ASTNode implements TypeDeclarationInterface {

    private String identifier;

    TypeDeclaration(String identifier, MetaInformation metaInformation) {
        super(metaInformation);
        this.identifier = identifier;
    }

    TypeDeclaration(String identifier) {
        super();
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

}
