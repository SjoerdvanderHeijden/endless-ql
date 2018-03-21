package nl.uva.se.sc.niro.parser

import java.util

import nl.uva.se.sc.niro.errors.Errors.Error
import nl.uva.se.sc.niro.model.qls._
import org.antlr.v4.runtime.{ CharStream, CommonTokenStream }
import org.apache.logging.log4j.scala.Logging
import qls.{ QLSBaseVisitor, QLSLexer, QLSParser }

import scala.collection.JavaConverters
import scala.collection.mutable.ListBuffer

object QLStylesheetParser extends Logging {
  private val errorListener = new ErrorListener

  def getParseErrors: ListBuffer[Error] = errorListener.parseErrors

  def parse(formSource: CharStream): QLStylesheet = {
    logger.traceEntry()
    errorListener.parseErrors.clear()
    val parser = new QLSParser(new CommonTokenStream(new QLSLexer(formSource)))
    parser.removeErrorListeners()
    parser.addErrorListener(errorListener)
    logger.traceExit(StylesheetVisitor.visit(parser.stylesheet()))
  }

  object StylesheetVisitor extends QLSBaseVisitor[QLStylesheet] {
    override def visitStylesheet(ctx: QLSParser.StylesheetContext): QLStylesheet = {
      val pages = JavaConverters.asScalaBuffer(ctx.page).map(PageVisitor.visit)
      val defaultStyles = collectDefaultStyles(ctx.defaultStyle())
      QLStylesheet(ctx.name.getText, pages, defaultStyles)
    }
  }

  private def collectDefaultStyles(defaultStyleContexts: util.List[QLSParser.DefaultStyleContext]) = {
    JavaConverters.asScalaBuffer(defaultStyleContexts).map(DefaultStyleVisitor.visit).fold(Map.empty)(_ ++ _)
  }

  object DefaultStyleVisitor extends QLSBaseVisitor[Map[String, WidgetType]] {
    override def visitDefaultStyle(ctx: QLSParser.DefaultStyleContext): Map[String, WidgetType] =
      WidgetTypeVisitor
        .visit(ctx.style())
        .map(widgetType => Map(ctx.questionType().getText -> widgetType))
        .getOrElse(Map.empty)
  }

  object PageVisitor extends QLSBaseVisitor[Page] {
    override def visitPage(ctx: QLSParser.PageContext): Page = {
      val sections = JavaConverters.asScalaBuffer(ctx.section()).map(SectionVisitor.visit)
      val defaultStyles = collectDefaultStyles(ctx.defaultStyle())
      Page(ctx.name.getText, sections, defaultStyles)
    }
  }

  object SectionVisitor extends QLSBaseVisitor[Section] {
    override def visitSection(ctx: QLSParser.SectionContext): Section = {
      val questions = JavaConverters.asScalaBuffer(ctx.questionBlock().questions).map(QuestionVisitor.visit)
      val defaultStyles = collectDefaultStyles(ctx.questionBlock().defaultStyle())
      Section(ctx.name.getText, questions, defaultStyles)
    }
  }

  object QuestionVisitor extends QLSBaseVisitor[Question] {
    override def visitQuestion(ctx: QLSParser.QuestionContext): Question = {
      if (ctx.style() == null || ctx.style().widgetType() == null) Question(ctx.name.getText, None)
      else Question(ctx.name.getText, WidgetTypeVisitor.visit(ctx.style().widgetType()))
    }
  }

  object WidgetTypeVisitor extends QLSBaseVisitor[Option[WidgetType]] {
    override def visitWidgetType(ctx: QLSParser.WidgetTypeContext): Option[WidgetType] = {
      if (ctx.CHECKBOX() != null) return Some(CheckBox())
      if (ctx.SPINGBOX() != null) return Some(SpinBox())
      if (ctx.RADIO() != null) return Some(Radio(ctx.trueValue.getText, ctx.falseValue.getText))
      if (ctx.COMBO() != null) return Some(ComboBox(ctx.trueValue.getText, ctx.falseValue.getText))
      None
    }
  }
}
