package com.chariotit.uva.sc.qdsl.grammar;

import com.chariotit.uva.sc.qdsl.ast.ql.node.*;
import com.chariotit.uva.sc.qdsl.ast.ql.node.constant.BooleanConstant;
import com.chariotit.uva.sc.qdsl.ast.ql.node.constant.IntegerConstant;
import com.chariotit.uva.sc.qdsl.ast.ql.node.constant.MoneyConstant;
import com.chariotit.uva.sc.qdsl.ast.ql.node.constant.StringConstant;
import com.chariotit.uva.sc.qdsl.ast.ql.node.operator.*;
import com.chariotit.uva.sc.qdsl.ast.ql.node.type.*;
import com.chariotit.uva.sc.qdsl.ast.ql.node.type.IntegerTypeNode;
import com.chariotit.uva.sc.qdsl.ast.ql.node.type.MoneyTypeNode;
import com.chariotit.uva.sc.qdsl.ast.ql.symboltable.SymbolTable;
import com.chariotit.uva.sc.qdsl.ast.ql.type.*;
import com.chariotit.uva.sc.qdsl.ast.ql.visitor.SymbolTableBuilderVisitor;
import com.chariotit.uva.sc.qdsl.parser.QLVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

public class QLGrammarTest {

    private QLParser getParser(String inputFile) {
        try {
            String testDataDir = "src/test/data/grammar/";
            QLLexer lexer = new QLLexer(CharStreams.fromFileName(testDataDir + inputFile));
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            return new QLParser(tokens);
        } catch (IOException e) {
            throw new RuntimeException("Could not find input file");
        }
    }

    private QLAstRoot getAst(String inputFile) {
        QLParser parser = getParser(inputFile);
        ParseTree tree = parser.forms();
        QLVisitor visitor = new QLVisitor();

        return (QLAstRoot) visitor.visit(tree);
    }

    @Test
    public void testForms() {
        QLAstRoot astRoot = getAst("forms.ql");

        assertEquals(astRoot.getForms().size(), 2);

        Form firstForm = astRoot.getForms().get(0);
        LineElement firstElement = (LineElement) firstForm.getFormElements().get(0);

        assertEquals(firstElement.getLabel().getLabel(), "hasSoldHouse");

        IfBlock ifBlock = (IfBlock) firstForm.getFormElements().get(3);
        assertEquals(ifBlock.getIfElements().size(), 3);
        assertEquals(((LabelExpression) (ifBlock.getExpression())).getLabel(),
                "hasSoldHouse");

        LineElement valueResidue = (LineElement) (ifBlock.getIfElements().get(2));
        assertTrue(valueResidue.getTypeExpression().getTypeNode() instanceof MoneyTypeNode);
        assertFalse(valueResidue.getTypeExpression().getTypeNode() instanceof BooleanTypeNode);
        assertEquals(valueResidue.getQuestion().getQuestion(), "Value residue:");

        assertTrue(valueResidue.getTypeExpression().getExpression() instanceof
                LabelBinOpExpression);
        assertTrue(((LabelBinOpExpression) (valueResidue.getTypeExpression().getExpression()))
                .getExpression() instanceof LabelExpression);
    }

    @Test
    public void testTypes() {
        QLAstRoot astRoot = getAst("types.ql");
        List<FormElement> elements = astRoot.getForms().get(0).getFormElements();

        assertTrue(((LineElement) elements.get(0)).getTypeExpression().getTypeNode() instanceof
                BooleanTypeNode);
        assertTrue(((LineElement) elements.get(1)).getTypeExpression().getTypeNode() instanceof
                IntegerTypeNode);
        assertTrue(((LineElement) elements.get(2)).getTypeExpression().getTypeNode() instanceof
                MoneyTypeNode);
        assertTrue(((LineElement) elements.get(3)).getTypeExpression().getTypeNode() instanceof
                StringTypeNode);
    }

    @Test
    public void testUnops() {
        QLAstRoot astRoot = getAst("unops.ql");
        List<FormElement> elements = astRoot.getForms().get(0).getFormElements();

        assertTrue(((UnOpExpression) ((LineElement) elements.get(0)).getTypeExpression()
                .getExpression()).getOperator() instanceof MinusOp);
        assertTrue(((UnOpExpression) ((LineElement) elements.get(1)).getTypeExpression()
                .getExpression()).getOperator() instanceof PlusOp);
        assertTrue(((UnOpExpression) ((LineElement) elements.get(2)).getTypeExpression()
                .getExpression()).getOperator() instanceof NotOp);
    }

    @Test
    public void testBinops() {
        QLAstRoot astRoot = getAst("binops.ql");
        List<FormElement> elements = astRoot.getForms().get(0).getFormElements();

        assertTrue(((LabelBinOpExpression) ((LineElement) elements.get(0)).getTypeExpression()
                .getExpression()).getOperator() instanceof MinusOp);
        assertTrue(((LabelBinOpExpression) ((LineElement) elements.get(1)).getTypeExpression()
                .getExpression()).getOperator() instanceof PlusOp);
        assertTrue(((LabelBinOpExpression) ((LineElement) elements.get(2)).getTypeExpression()
                .getExpression()).getOperator() instanceof DivideOp);
        assertTrue(((LabelBinOpExpression) ((LineElement) elements.get(3)).getTypeExpression()
                .getExpression()).getOperator() instanceof MultiplyOp);
        assertTrue(((LabelBinOpExpression) ((LineElement) elements.get(4)).getTypeExpression()
                .getExpression()).getOperator() instanceof EqOp);
        assertTrue(((LabelBinOpExpression) ((LineElement) elements.get(5)).getTypeExpression()
                .getExpression()).getOperator() instanceof NeqOp);
        assertTrue(((LabelBinOpExpression) ((LineElement) elements.get(6)).getTypeExpression()
                .getExpression()).getOperator() instanceof GteOp);
        assertTrue(((LabelBinOpExpression) ((LineElement) elements.get(7)).getTypeExpression()
                .getExpression()).getOperator() instanceof GtOp);
        assertTrue(((LabelBinOpExpression) ((LineElement) elements.get(8)).getTypeExpression()
                .getExpression()).getOperator() instanceof LtOp);
        assertTrue(((LabelBinOpExpression) ((LineElement) elements.get(9)).getTypeExpression()
                .getExpression()).getOperator() instanceof LteOp);
        assertTrue(((LabelBinOpExpression) ((LineElement) elements.get(10)).getTypeExpression()
                .getExpression()).getOperator() instanceof AndOp);
        assertTrue(((LabelBinOpExpression) ((LineElement) elements.get(11)).getTypeExpression()
                .getExpression()).getOperator() instanceof OrOp);
    }

    @Test
    public void testConstants() {
        QLAstRoot astRoot = getAst("constants.ql");
        List<FormElement> elements = astRoot.getForms().get(0).getFormElements();

        assertTrue(((LineElement) elements.get(0)).getTypeExpression().getExpression() instanceof
                BooleanConstant);

        assertTrue(((LineElement) elements.get(1)).getTypeExpression().getExpression() instanceof
                IntegerConstant);

        assertTrue(((LineElement) elements.get(2)).getTypeExpression().getExpression() instanceof
                MoneyConstant);

        assertTrue(((LineElement) elements.get(3)).getTypeExpression().getExpression() instanceof
                StringConstant);
    }

    @Test
    public void testConstantsDefaults() {
        QLAstRoot astRoot = getAst("constants_defaults.ql");

        SymbolTableBuilderVisitor visitor = new SymbolTableBuilderVisitor();
        astRoot.acceptVisitor(visitor);

        List<FormElement> elements = astRoot.getForms().get(0).getFormElements();

        String symbolBoolean = ((LineElement) (elements.get(0))).getLabel().getLabel();
        String symbolInteger = ((LineElement) (elements.get(1))).getLabel().getLabel();
        String symbolMoney = ((LineElement) (elements.get(2))).getLabel().getLabel();
        String symbolString = ((LineElement) (elements.get(3))).getLabel().getLabel();

        SymbolTable symbolTable = astRoot.getSymbolTable();

        assertTrue(((BooleanExpressionValue) symbolTable.getEntry(symbolBoolean)
                .getExpressionValue()).getValue().equals(false));
        assertTrue(((IntegerExpressionValue) symbolTable.getEntry(symbolInteger)
                .getExpressionValue()).getValue().equals(0));
        assertTrue(((MoneyExpressionValue) symbolTable.getEntry(symbolMoney)
                .getExpressionValue()).getValue().equals((float)0.0));
        assertTrue(((StringExpressionValue) symbolTable.getEntry(symbolString)
                .getExpressionValue()).getValue().equals(""));
    }
}
