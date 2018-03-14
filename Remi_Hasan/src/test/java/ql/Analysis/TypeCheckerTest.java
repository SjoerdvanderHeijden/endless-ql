package ql.Analysis;

import org.junit.Test;
import ql.QLTestUtilities;
import ql.analysis.TypeChecker;
import ql.model.expression.Expression;

public class TypeCheckerTest {

    @Test
    public void positiveTypeCheckerTest() {
        Expression expression = QLTestUtilities.expressionFromString("1 + 1");

        TypeChecker typeChecker = new TypeChecker(null, null);
        typeChecker.visit(expression);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeTypeCheckerTest() {
        Expression expression = QLTestUtilities.expressionFromString("1 + true");

        TypeChecker typeChecker = new TypeChecker(null, null);
        typeChecker.visit(expression);
    }
}
