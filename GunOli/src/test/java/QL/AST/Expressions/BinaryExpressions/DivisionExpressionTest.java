package QL.AST.Expressions.BinaryExpressions;

import QL.AST.Expressions.ExpressionConstants.DecimalConstant;
import QL.AST.Expressions.ExpressionConstants.IntegerConstant;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitQuickcheck.class)
public class DivisionExpressionTest {

    private DivisionExpression expressionTest;
    @Property
    public void evaluate(int autoA, int autoB) {
        IntegerConstant b = new IntegerConstant( autoA,0);
        IntegerConstant c = new IntegerConstant( autoB,0);

        expressionTest  = new DivisionExpression(b,c,0);
        assertEquals((autoA / autoB), expressionTest.evaluate().getValue());

    }
    @Property
    public void evaluate(double autoA, double autoB) {
        DecimalConstant b = new DecimalConstant( autoA,0);
        DecimalConstant c = new DecimalConstant( autoB,0);

        expressionTest  = new DivisionExpression(b,c,0);
        assertEquals((autoA / autoB), expressionTest.evaluate().getValue());

    }

}