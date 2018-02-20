package nl.uva.js.qlparser.logic;

import nl.uva.js.qlparser.models.Form;
import nl.uva.js.qlparser.models.dataexpressions.Combinator;
import nl.uva.js.qlparser.models.dataexpressions.Value;
import nl.uva.js.qlparser.models.enums.ArithOp;
import nl.uva.js.qlparser.models.enums.CompOp;
import nl.uva.js.qlparser.models.enums.DataType;
import nl.uva.js.qlparser.models.formexpressions.FormExpression;
import nl.uva.js.qlparser.models.formexpressions.IfBlock;
import nl.uva.js.qlparser.models.formexpressions.Question;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class IngesterTest {

    private Ingester ingester;

    @Before
    public void setup() {
        ingester = new Ingester();
    }

    @Test
    public void testToParsedForm() throws IOException {
        // Questions
        Question hasSoldHouse = Question.builder()
                .name("hasSoldHouse")
                .question("Did you sell a house in 2010?")
                .dataType(DataType.BOOLEAN)
                .build();

        Question hasBoughtHouse = Question.builder()
                .name("hasBoughtHouse")
                .question("Did you buy a house in 2010?")
                .dataType(DataType.BOOLEAN)
                .build();

        Question hasMaintLoan = Question.builder()
                .name("hasMaintLoan")
                .question("Did you enter a loan for maintenance/reconstruction?")
                .dataType(DataType.BOOLEAN)
                .build();

        // Conditional questions
        Question sellingPrice = Question.builder()
                .name("sellingPrice")
                .question("Price the house was sold for:")
                .dataType(DataType.MONEY)
                .build();

        Question privateDebt = Question.builder()
                .name("privateDebt")
                .question("Private debts for the sold house:")
                .dataType(DataType.MONEY)
                .build();

        Question valueResidue = Question.builder()
                .name("valueResidue")
                .question("Value residue:")
                .dataType(DataType.MONEY)
                .value(Combinator.builder()
                        .left(sellingPrice.getValue())
                        .operator(ArithOp.MIN)
                        .right(privateDebt.getValue())
                        .build())
                .build();

        IfBlock ifBlock = IfBlock.builder()
                .condition(Combinator.builder()
                        .left(hasSoldHouse.getValue())
                        .operator(CompOp.EQ)
                        .right(Value.builder().dataType(DataType.BOOLEAN).value("TRUE").build())
                        .build())
                .expressions(new LinkedList<>(Arrays.asList(
                        sellingPrice,
                        privateDebt,
                        valueResidue)))
                .build();

        LinkedList<FormExpression> expectedExpressions =
                new LinkedList<>(Arrays.asList(
                                hasSoldHouse,
                                hasBoughtHouse,
                                hasMaintLoan,
                                ifBlock
                ));

        Form expectedForm = Form.builder()
                .name("Box1HouseOwning")
                .formExpressions(expectedExpressions)
                .build();

        Form actualForm = ingester.toParsedForm("src/test/java/nl/uva/js/qlparser/logic/testdata/ql_input.jsql");

        assertEquals(expectedForm, actualForm);
    }
}