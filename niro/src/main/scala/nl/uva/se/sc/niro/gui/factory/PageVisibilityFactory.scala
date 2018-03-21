package nl.uva.se.sc.niro.gui.factory

import nl.uva.se.sc.niro.model.ql.Question
import nl.uva.se.sc.niro.model.ql.expressions._
import nl.uva.se.sc.niro.model.ql.expressions.answers.{ BooleanAnswer, StringAnswer }
import nl.uva.se.sc.niro.model.qls.QLStylesheet

object PageVisibilityFactory {
  val ACTIVE_PAGE_NAME = "__active_page_name__"

  def createPageVisibility(question: Question, stylesheet: Option[QLStylesheet], visible: Expression): Expression = {
    val pageNames = getPageNamesContainingQuestion(question, stylesheet)
    val pageNameChecks = createPageCheckExpressions(pageNames)
    createCumulativePageNameCheck(pageNameChecks).map(And(_, visible)).getOrElse(visible)
  }

  private def getPageNamesContainingQuestion(question: Question, stylesheet: Option[QLStylesheet]): Seq[String] = {
    stylesheet.map(_.collectPageNamesWithQuestion(question.id)).getOrElse(Seq.empty)
  }

  private def createPageCheckExpressions(pageNames: Seq[String]): Seq[Expression] = {
    pageNames.map(pageName => Equal(Reference(ACTIVE_PAGE_NAME), StringAnswer(pageName)))
  }

  private def createCumulativePageNameCheck(pageNameChecks: Seq[Expression]): Option[Expression] = {
    if (pageNameChecks.isEmpty) None
    else Some(pageNameChecks.fold(BooleanAnswer(false))((l: Expression, r: Expression) => Or(l, r)))
  }

}
