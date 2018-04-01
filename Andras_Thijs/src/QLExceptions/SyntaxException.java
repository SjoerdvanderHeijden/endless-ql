package QLExceptions;

import Nodes.ASTNode;

/**
 * A basic SyntaxException which can hold a message and the ASTNode in which the error is found.
 */
public class SyntaxException extends Exception {
    private final String message;
    private ASTNode node;

    public SyntaxException(String message) {
        this.message = message;
    }

    public SyntaxException(String message, ASTNode node) {
        this.message = message;
        this.node = node;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ASTNode getNode() {
        return node;
    }
}
