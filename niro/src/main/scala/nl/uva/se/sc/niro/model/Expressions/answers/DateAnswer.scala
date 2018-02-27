package nl.uva.se.sc.niro.model.Expressions.answers

import nl.uva.se.sc.niro.model.Expressions.Answer
import nl.uva.se.sc.niro.model.{ BinaryOperator, UnaryOperator }

final case class DateAnswer(possibleValue: Option[String]) extends Answer {

  def applyUnaryOperator(unaryOperator: UnaryOperator): Answer = ???
  def applyBinaryOperator(binaryOperator: BinaryOperator, other: Answer): Answer = ???
}

object DateAnswer {
  def apply() = new DateAnswer(None)
  def apply(value: String) = new DateAnswer(Some(value))
}
