package QL.ParseObjectsQL.Expressions.BinaryExpressions;

import QL.ParseObjectsQL.Expressions.ExpressionConstants.DecimalConstant;
import QL.ParseObjectsQL.Expressions.ExpressionConstants.IntegerConstant;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
@RunWith(JUnitQuickcheck.class)
public class GreaterOrEqualExpressionTest {

    private GreaterOrEqualExpression expressionTest;
    @Property
    public void evaluate(int left, int right) {
        IntegerConstant leftToTest = new IntegerConstant(left, 0);
        IntegerConstant rightToTest = new IntegerConstant(right, 0);

        expressionTest = new GreaterOrEqualExpression(leftToTest, rightToTest, 0);

        assertEquals((left >= right), expressionTest.evaluate().getValue() );
    }
    @Property
    public void evaluate(double left, double right) {
        DecimalConstant leftToTest = new DecimalConstant(left, 0);
        DecimalConstant rightToTest = new DecimalConstant(right, 0);

        expressionTest = new GreaterOrEqualExpression(leftToTest, rightToTest, 0);

        assertEquals((left >= right), expressionTest.evaluate().getValue() );
    }
}