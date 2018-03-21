package ql.visitors

import grammar._
import ql.models.ast._

import scala.collection.JavaConversions._

class ASTVisitor extends QlParserBaseVisitor[ASTNode] {

  override def visitRoot(ctx: QlParser.RootContext): ASTRoot = {
    val body = visitFormBody(ctx.formBody)
    val header = visit(ctx.formHeader)
    ASTRoot(header, body)
  }

  override def visitFormHeader(
      ctx: QlParser.FormHeaderContext): ASTFormHeader = {
    ASTFormHeader(visit(ctx.identifier))
  }


  override def visitFormBody(ctx: QlParser.FormBodyContext): ASTFormBody = {
    val statements = ctx.stmt.map(visit).toList
    ASTFormBody(statements)
  }

  override def visitQuestion(ctx: QlParser.QuestionContext): ASTQuestion = {
    val varDecl = visit(ctx.varDecl)
    ASTQuestion(varDecl, ctx.label.getText.replace("\"", ""))
  }

  override def visitComputation(
      ctx: QlParser.ComputationContext): ASTComputation = {
    ASTComputation(visit(ctx.varDecl),
                   visit(ctx.valAssign),
                   ctx.label.getText.replace("\"", ""))
  }

  override def visitVarDecl(ctx: QlParser.VarDeclContext): ASTVarDecl = {
    ASTVarDecl(visit(ctx.typeDecl), visit(ctx.identifier))
  }

  override def visitTypeDecl(ctx: QlParser.TypeDeclContext): ASTNode =
    ctx.getText match {
      case "boolean" => ASTBoolean()
      case "money"   => ASTMoney()
      case "integer" => ASTInteger()
      case "string"  => ASTString()
    }

  override def visitConditional(ctx: QlParser.ConditionalContext): ASTNode = {
    visit(ctx.ifStmt)
  }

  override def visitIfStmt(ctx: QlParser.IfStmtContext): ASTIfStatement = {
    val statements = ctx.stmt.map(visit).toList
    ASTIfStatement(visit(ctx.expr), statements)
  }

  override def visitValAssign(ctx: QlParser.ValAssignContext): ASTNode = {
    ASTValAssign(visit(ctx.expr))
  }

  override def visitBinOp(ctx: QlParser.BinOpContext): ASTNode =
    ctx.getText match {
      case "+"  => ASTAdd()
      case "-"  => ASTMin()
      case "*"  => ASTMul()
      case "/"  => ASTDiv()
      case "!"  => ASTUnaryNot()
      case "&&" => ASTLogicalCon()
      case "||" => ASTLogicalDis()
      case "<"  => ASTRelationalLT()
      case ">"  => ASTRelationalGT()
      case "<=" => ASTRelationalLTE()
      case ">=" => ASTRelationalGTE()
      case "!=" => ASTNotEqualOp()
      case "==" => ASTEqualOp()
    }

  override def visitUnOp(ctx: QlParser.UnOpContext): ASTNode =
    ctx.getText match {
      case "-" => ASTUnaryMin()
      case "!" => ASTUnaryNot()
    }

  override def visitStringExpression(
      ctx: QlParser.StringExpressionContext): ASTNode = {
    visit(ctx.stringLit)
  }

  override def visitStringLit(
      ctx: QlParser.StringLitContext): ASTNode = {
    ASTStringValue(ctx.getText.replace("\"", ""))
  }

  override def visitBooleanExpression(
      ctx: QlParser.BooleanExpressionContext): ASTNode = {
    visit(ctx.booleanLit)
  }

  override def visitBooleanLit(
      ctx: QlParser.BooleanLitContext): ASTNode = {
    ASTBooleanValue(ctx.getText.toBoolean)
  }

  override def visitIntegerExpression(
      ctx: QlParser.IntegerExpressionContext): ASTNode = {
    visit(ctx.integerLit)
  }

  override def visitIntegerLit(
      ctx: QlParser.IntegerLitContext): ASTNode = {
    ASTIntegerValue(Integer.parseInt(ctx.getText))
  }

  override def visitIdentifier(
      ctx: QlParser.IdentifierContext): ASTIdentifier = {
    ASTIdentifier(ctx.getText)
  }

  override def visitIdentifierExpression(
      ctx: QlParser.IdentifierExpressionContext): ASTNode = {
    visit(ctx.identifier)
  }

  override def visitBinaryExpression(
      ctx: QlParser.BinaryExpressionContext): ASTNode = {
    ASTBinary(visit(ctx.lhs), visit(ctx.rhs), visit(ctx.binOp))
  }

  override def visitUnaryExpression(
      ctx: QlParser.UnaryExpressionContext): ASTNode = {
    ASTUnary(visit(ctx.expr), visit(ctx.op))
  }

  override def visitBracketExpression(
      ctx: QlParser.BracketExpressionContext): ASTNode = {
    visit(ctx.expr)
  }

}
