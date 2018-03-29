package com.chariotit.uva.sc.qdsl.ast.ql.visitor;

import com.chariotit.uva.sc.qdsl.ast.ql.node.*;
import com.chariotit.uva.sc.qdsl.ast.ql.node.constant.BooleanConstant;
import com.chariotit.uva.sc.qdsl.ast.ql.node.constant.IntegerConstant;
import com.chariotit.uva.sc.qdsl.ast.ql.node.constant.MoneyConstant;
import com.chariotit.uva.sc.qdsl.ast.ql.node.constant.StringConstant;
import com.chariotit.uva.sc.qdsl.ast.ql.node.operator.*;
import com.chariotit.uva.sc.qdsl.ast.ql.node.type.BooleanTypeNode;
import com.chariotit.uva.sc.qdsl.ast.ql.node.type.IntegerTypeNode;
import com.chariotit.uva.sc.qdsl.ast.ql.node.type.MoneyTypeNode;
import com.chariotit.uva.sc.qdsl.ast.ql.node.type.StringTypeNode;
import com.chariotit.uva.sc.qdsl.ast.ql.symboltable.SymbolTable;

public class EvaluateVisitor extends NodeVisitor {

    private SymbolTable symbolTable;

    public EvaluateVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public void visitBooleanConstant(BooleanConstant booleanConstant) {
        booleanConstant.evaluate(symbolTable);
    }

    @Override
    public void visitIntegerConstant(IntegerConstant integerConstant) {
        integerConstant.evaluate(symbolTable);
    }

    @Override
    public void visitMoneyConstant(MoneyConstant moneyConstant) {
        moneyConstant.evaluate(symbolTable);

    }

    @Override
    public void visitStringConstant(StringConstant stringConstant) {
        stringConstant.evaluate(symbolTable);
    }

    @Override
    public void visitDivideOp(DivideOp divideOp) {

    }

    @Override
    public void visitEqOp(EqOp eqOp) {

    }

    @Override
    public void visitGteOp(GteOp gteOp) {

    }

    @Override
    public void visitGtOp(GtOp gtOp) {

    }

    @Override
    public void visitLteOp(LteOp lteOp) {

    }

    @Override
    public void visitLtOp(LtOp ltOp) {

    }

    @Override
    public void visitMinusOp(MinusOp minusOp) {

    }

    @Override
    public void visitMultiplyOp(MultiplyOp multiplyOp) {

    }

    @Override
    public void visitNeqOp(NeqOp neqOp) {

    }

    @Override
    public void visitNotOp(NotOp notOp) {

    }

    @Override
    public void visitPlusOp(PlusOp plusOp) {

    }

    @Override
    public void visitOrOp(OrOp orOp) {

    }

    @Override
    public void visitAndOp(AndOp andOp) {

    }

    @Override
    public void visitBooleanType(BooleanTypeNode booleanType) {

    }

    @Override
    public void visitIntegerType(IntegerTypeNode integerType) {

    }

    @Override
    public void visitMoneyType(MoneyTypeNode moneyType) {

    }

    @Override
    public void visitStringType(StringTypeNode stringType) {

    }

    @Override
    public void visitAstRoot(QLAstRoot astRoot) {

    }

    @Override
    public void visitForm(Form form) {

    }

    @Override
    public void visitConstBinOpExpression(ConstBinOpExpression constBinOpExpression) {
        constBinOpExpression.evaluate(symbolTable);
    }

    @Override
    public void visitIfBlock(IfBlock ifBlock) {

    }

    @Override
    public void visitLabel(Label label) {

    }

    @Override
    public void visitLabelBinOpExpression(LabelBinOpExpression labelBinOpExpression) {
        labelBinOpExpression.evaluate(symbolTable);
    }

    @Override
    public void visitLabelExpression(LabelExpression labelExpression) {
        labelExpression.evaluate(symbolTable);
    }

    @Override
    public void visitLineElement(LineElement lineElement) {

    }

    @Override
    public void visitQuestion(Question question) {

    }

    @Override
    public void visitTypeExpression(TypeExpression typeExpression) {

    }

    @Override
    public void visitUnOpExpression(UnOpExpression unOpExpression) {
        unOpExpression.evaluate(symbolTable);
    }
}
