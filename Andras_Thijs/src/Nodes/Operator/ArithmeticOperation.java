package Nodes.Operator;

import Nodes.Term.QLFloat;
import Nodes.Term.Term;
import QLExceptions.*;

public class ArithmeticOperation extends Operator {
    /**
     * Constructor that just calls the default constructor.
     * @param value the arithmetic operator.
     */
    public ArithmeticOperation(String value) {
        super(value);
    }

    /**
     * Implements a arithmetic operator (+, -, /, * and ^).
     * @param left left hand side of the operator.
     * @param right right hand side of the operator.
     * @return A new intermediary QLFloat Term with the result of the calculation.
     * @throws TypeException when left and right aren't Floats.
     * @throws SyntaxException when the value of this Operator is not +, -, /, * or ^.
     */
    @Override
    public QLFloat calculate(Term left, Term right) throws TypeException, SyntaxException {
        // Apply the correct implementation. Throw a SyntaxException for invalid operators.
        // When either left or right is not a QLFloat, a TypeException will be thrown.
        switch(this.getValue()) {
            case "+": return new QLFloat(left.getFloat() + right.getFloat());
            case "-": return new QLFloat(left.getFloat() - right.getFloat());
            case "/": return new QLFloat(left.getFloat() / right.getFloat());
            case "*": return new QLFloat(left.getFloat() * right.getFloat());
            case "^": return new QLFloat((float) Math.pow(left.getFloat(),right.getFloat()));
            default: throw new SyntaxException("Invalid arithmetic operator", this);
        }
    }
}
