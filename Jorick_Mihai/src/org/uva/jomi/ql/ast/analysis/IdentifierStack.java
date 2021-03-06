package org.uva.jomi.ql.ast.analysis;

import java.util.HashMap;
import java.util.Stack;
import org.uva.jomi.ql.ast.expressions.IdentifierExpression;

public class IdentifierStack {

	private final Stack<HashMap<String, IdentifierExpression>> identifierStack;

	// Create a new stack
	public IdentifierStack() {
		this.identifierStack = new Stack<HashMap<String, IdentifierExpression>>();
	}

	// Create a new scope
	public void enterScope() {
		identifierStack.push(new HashMap<String, IdentifierExpression>());
	}

	// Destroy the top scope
	public void leaveScope() {
		identifierStack.pop();
	}

	// Add a new element to the inner most scope
	public void add(IdentifierExpression identifier) {
		identifierStack.peek().put(identifier.getName(), identifier);
	}

	// Try to add a new element to the top most scope
	public boolean tryAdd(String name, IdentifierExpression identifier) {
		if (identifierStack.isEmpty()) {
			System.err.println("Empty Stack - Could not add the element");
			return false;
		}
		identifierStack.peek().put(name, identifier);
		return true;
	}

	// Check if a particular identifier is present in the inner most scope
	public boolean isInCurrentScope(String identifierName) {
		if (identifierStack.peek().containsKey(identifierName)) {
			return true;
		} else {
			return false;
		}
	}

	// Search from the inner to the outer most scope for a particular identifier name
	public IdentifierExpression getIdentifier(String name) {
		for (HashMap<String, IdentifierExpression> map : identifierStack) {
			if (map.containsKey(name)) {
				return map.get(name);
			}
		}

		return null;
	}
}
