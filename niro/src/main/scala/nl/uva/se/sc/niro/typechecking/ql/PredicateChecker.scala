package nl.uva.se.sc.niro.typechecking.ql

import nl.uva.se.sc.niro.errors.Errors.TypeCheckError
import nl.uva.se.sc.niro.model.ql._
import nl.uva.se.sc.niro.typechecking.ql.StaticTypeChecker._
import org.apache.logging.log4j.scala.Logging

object PredicateChecker extends Logging {
  def checkNonBooleanPredicates(qlForm: QLForm): Either[TypeCheckError, QLForm] = {
    logger.info("Phase 3 - Checking predicates that are not of the type boolean ...")

    val conditionals: Seq[Conditional] = Statement.collectAllConditionals(qlForm.statements)
    val conditionalsWithNonBooleanPredicates: Seq[Conditional] = conditionals filterNot { conditional =>
      conditional.predicate.typeOf(qlForm.symbolTable).contains(BooleanType)
    }

    if (conditionalsWithNonBooleanPredicates.nonEmpty) {
      Left(TypeCheckError(message = s"Non boolean predicate: $conditionalsWithNonBooleanPredicates"))
    } else {
      Right(qlForm)
    }
  }
}