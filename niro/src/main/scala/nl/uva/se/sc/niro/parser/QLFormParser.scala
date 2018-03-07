package nl.uva.se.sc.niro.parser

import _root_.ql.{ QLBaseVisitor, QLLexer, QLParser }
import nl.uva.se.sc.niro.model.Expressions._
import nl.uva.se.sc.niro.model.Expressions.answers._
import nl.uva.se.sc.niro.model._
import nl.uva.se.sc.niro.parser.errors.ParseErrorInfo
import org.antlr.v4.runtime.tree.RuleNode
import org.antlr.v4.runtime.{ CharStream, CommonTokenStream }
import org.apache.logging.log4j.scala.Logging

import scala.collection.JavaConverters
import scala.collection.mutable.ListBuffer

object QLFormParser extends Logging {
  private val errorListener = new ErrorListener

  def getParseErrors: ListBuffer[ParseErrorInfo] = errorListener.parseErrors

  def parse(formSource: CharStream): QLForm = {
    logger.traceEntry()
    errorListener.parseErrors.clear()
    val parser = new QLParser(new CommonTokenStream(new QLLexer(formSource)))
    parser.removeErrorListeners()
    parser.addErrorListener(errorListener)
    logger.traceExit(FormVisitor.visit(parser.form))
  }

  object FormVisitor extends QLBaseVisitor[QLForm] {
    override def defaultResult(): QLForm = QLForm("Unparseable form definition!", Seq.empty)

    override def shouldVisitNextChild(node: RuleNode, currentResult: QLForm): Boolean = {
      errorListener.parseErrors.isEmpty
    }

    override def visitForm(ctx: QLParser.FormContext): QLForm = {
      val formName = ctx.Identifier().getText
      val statements: Seq[Statement] = JavaConverters.asScalaBuffer(ctx.statement).toList.flatMap(StatementVisitor.visit)

      QLForm(formName, statements)
    }
  }

  object StatementVisitor extends QLBaseVisitor[Seq[Statement]] {
    override def defaultResult(): Seq[Statement] =
      Seq(
        Question("error", "There is a serious error in a question or if-else statement!", BooleanType, BooleanAnswer()))

    override def shouldVisitNextChild(node: RuleNode, currentResult: Seq[Statement]): Boolean = {
      errorListener.parseErrors.isEmpty
    }

    override def visitBlock(ctx: QLParser.BlockContext): Seq[Statement] = {
      JavaConverters.asScalaBuffer(ctx.statement()).toList.flatMap(StatementVisitor.visit)
    }

    override def visitQuestion(ctx: QLParser.QuestionContext): Seq[Statement] = {
      val questionId = ctx.Identifier().getText
      val questionLabel = ctx.label.getText
      val answerType = AnswerType(ctx.answerType().getText)
      val expression = Option(ctx.expression)
        .map(ExpressionVisitor.visit)
        .getOrElse(Answer(ctx.answerType.getText))
      Seq(Question(questionId, questionLabel, answerType, expression))
    }

    override def visitConditional(ctx: QLParser.ConditionalContext): Seq[Statement] = {
      val predicate: Expression = ExpressionVisitor.visit(ctx.condition)
      val negatedPredicate: Expression = UnaryOperation(Neg, predicate)

      val thenStatements: Seq[Statement] =
        JavaConverters.asScalaBuffer(ctx.thenBlock).toList.flatMap(StatementVisitor.visit)
      val elseStatements: Seq[Statement] =
        JavaConverters.asScalaBuffer(ctx.elseBlock).toList.flatMap(StatementVisitor.visit)

      val ifConditional = Conditional(predicate, thenStatements)
      val elseConditional = Conditional(negatedPredicate, elseStatements)

      Seq(ifConditional, elseConditional).filter(_.thenStatements.nonEmpty)
    }
  }

  object ExpressionVisitor extends QLBaseVisitor[Expression] {
    override def defaultResult(): Expression = BooleanAnswer(false)

    override def shouldVisitNextChild(node: RuleNode, currentResult: Expression): Boolean = {
      errorListener.parseErrors.isEmpty
    }

    override def visitGroupExpr(ctx: QLParser.GroupExprContext): Expression = {
      visit(ctx.expression())
    }
    override def visitUnaryExpr(ctx: QLParser.UnaryExprContext): Expression = {
      UnaryOperation(UnaryOperator(ctx.op.getText), visit(ctx.expression))
    }
    override def visitMultiplicativeExpr(ctx: QLParser.MultiplicativeExprContext): Expression = {
      BinaryOperation(BinaryOperator(ctx.op.getText), visit(ctx.lhs), visit(ctx.rhs))
    }
    override def visitAdditiveExpr(ctx: QLParser.AdditiveExprContext): Expression = {
      BinaryOperation(BinaryOperator(ctx.op.getText), visit(ctx.lhs), visit(ctx.rhs))
    }
    override def visitRelationalExp(ctx: QLParser.RelationalExpContext): Expression = {
      BinaryOperation(BinaryOperator(ctx.op.getText), visit(ctx.lhs), visit(ctx.rhs))
    }
    override def visitEqualityExpr(ctx: QLParser.EqualityExprContext): Expression = {
      BinaryOperation(BinaryOperator(ctx.op.getText), visit(ctx.lhs), visit(ctx.rhs))
    }
    override def visitLogicalAndExpr(ctx: QLParser.LogicalAndExprContext): Expression = {
      BinaryOperation(BinaryOperator(ctx.op.getText), visit(ctx.lhs), visit(ctx.rhs))
    }
    override def visitLogicalOrExpr(ctx: QLParser.LogicalOrExprContext): Expression = {
      BinaryOperation(BinaryOperator(ctx.op.getText), visit(ctx.lhs), visit(ctx.rhs))
    }
    override def visitIntConst(ctx: QLParser.IntConstContext): Expression = {
      IntAnswer(ctx.IntValue().getText.toInt)
    }
    override def visitDecConst(ctx: QLParser.DecConstContext): Expression = {
      DecAnswer(BigDecimal(ctx.DecValue().getText))
    }
    override def visitDateConst(ctx: QLParser.DateConstContext): Expression = {
      DateAnswer(ctx.DateValue().getText)
    }
    override def visitStringConst(ctx: QLParser.StringConstContext): Expression = {
      StringAnswer(ctx.TEXT().getText)
    }
    override def visitBool(ctx: QLParser.BoolContext): Expression = {
      BooleanAnswer(ctx.getText.toBoolean)
    }
    override def visitVar(ctx: QLParser.VarContext): Expression = {
      Reference(ctx.Identifier().getText)
    }
  }

}
