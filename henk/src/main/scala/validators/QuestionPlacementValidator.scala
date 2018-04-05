package general.validators

import ql.models.ast.{Root => QLRoot}
import qls.models.ast.{Statement => QLSStatement}

import ql.collectors.{
  StatementCollector => StatementCollectorQL,
  ExpressionCollector,
  FormCollector
}

import qls.collectors.{ElementCollector => ElementCollectorQLS}

import scala.collection.JavaConversions._

case class UnplacedQuestion(label: String) extends Exception(label)

class GeneralQuestionPlacementValidator extends BaseValidator {
  def check(ql: QLRoot, qls: QLSStatement): Option[UnplacedQuestion] = {
    val QLIdentifiers = getQLIdentifiers(ql)
    val QLSIdentifiers = getQLSIdentifier(qls)

    QLIdentifiers
      .diff(QLSIdentifiers)
      .map(undecl => {
        val message = s"Question '${undecl}' is declared in QL but not placed in QLS"
        return Some(new UnplacedQuestion(message))
      })
    None
  }

  def getQLIdentifiers(ql: QLRoot): List[String] = {
    val questions = FormCollector.getStatements(ql).flatMap(StatementCollectorQL.getQuestions)
    // val questions = StatementCollectorQL.getQuestions(ql)
    val vardecls = questions.flatMap(ExpressionCollector.getIdentifiers)
    vardecls.map(_.id)
  }

  def getQLSIdentifier(qls: QLSStatement): List[String] = {
    val questions = ElementCollectorQLS.getQuestions(qls)
    questions.map(_.identifier.id)
  }
}