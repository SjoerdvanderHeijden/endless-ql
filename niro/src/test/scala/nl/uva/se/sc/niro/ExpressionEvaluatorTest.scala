package nl.uva.se.sc.niro

import java.time.LocalDate

import nl.uva.se.sc.niro.ExpressionEvaluator._
import nl.uva.se.sc.niro.model.ql._
import nl.uva.se.sc.niro.model.ql.expressions.answers._
import nl.uva.se.sc.niro.model.ql.expressions.{ BinaryOperation, Reference }
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.{ Matchers, WordSpec }

class ExpressionEvaluatorTest extends WordSpec with Matchers with TableDrivenPropertyChecks {

  "The Expression evaluator" can {
    "do basic arithmetic operations" should {
      "on integers" in {
        // TODO deal with div by zero error
        val table = Table(
          ("Operator", "Left", "Right", "Expected Answer"),
          (Add, IntegerAnswer(5), IntegerAnswer(3), IntegerAnswer(8)),
          (Sub, IntegerAnswer(5), IntegerAnswer(3), IntegerAnswer(2)),
          (Mul, IntegerAnswer(5), IntegerAnswer(3), IntegerAnswer(15)),
          (Div, IntegerAnswer(10), IntegerAnswer(5), IntegerAnswer(2))
        )

        forAll(table) { (operator, left, right, expectedAnswer) =>
          val expression = BinaryOperation(operator, left, right)
          expression.evaluate(Map.empty, Map.empty) should be(expectedAnswer)
        }
      }

      "on decimals" in {
        // TODO deal with div by zero error
        val table = Table(
          ("Operator", "Left", "Right", "Expected Answer"),
          (Add, DecimalAnswer(5), DecimalAnswer(3), DecimalAnswer(8)),
          (Sub, DecimalAnswer(5), DecimalAnswer(3), DecimalAnswer(2)),
          (Mul, DecimalAnswer(5), DecimalAnswer(3), DecimalAnswer(15)),
          (Div, DecimalAnswer(10), DecimalAnswer(5), DecimalAnswer(2))
        )

        forAll(table) { (operator, left, right, expectedAnswer) =>
          val expression = BinaryOperation(operator, left, right)
          expression.evaluate(Map.empty, Map.empty) should be(expectedAnswer)
        }
      }

      "on money" in {
        val table = Table(
          ("Operator", "Left", "Right", "Expected Answer"),
          (Add, MoneyAnswer(5), MoneyAnswer(3), MoneyAnswer(8)),
          (Sub, MoneyAnswer(5), MoneyAnswer(3), MoneyAnswer(2)),
          (Div, MoneyAnswer(10), MoneyAnswer(5), DecimalAnswer(2))
        )

        forAll(table) { (operator, left, right, expectedAnswer) =>
          val expression = BinaryOperation(operator, left, right)
          expression.evaluate(Map.empty, Map.empty) should be(expectedAnswer)
        }
      }

      // TODO implement type widening for left hand side of the expression
      "on different types" in {
        val table = Table(
          ("Operator", "Left", "Right", "Expected Answer"),
          (Mul, MoneyAnswer(5), IntegerAnswer(3), MoneyAnswer(15)),
          (Mul, MoneyAnswer(5), DecimalAnswer(3), MoneyAnswer(15)),
          (Div, MoneyAnswer(10), IntegerAnswer(5), MoneyAnswer(2)),
          (Div, MoneyAnswer(10), DecimalAnswer(5), MoneyAnswer(2)),
          (Add, IntegerAnswer(10), DecimalAnswer(5), DecimalAnswer(15)),
          (Add, DecimalAnswer(10), IntegerAnswer(5), DecimalAnswer(15)),
          (Sub, IntegerAnswer(10), DecimalAnswer(6), DecimalAnswer(4)),
          (Sub, DecimalAnswer(10), IntegerAnswer(6), DecimalAnswer(4)),
          (Mul, IntegerAnswer(10), DecimalAnswer(5), DecimalAnswer(50)),
          (Mul, DecimalAnswer(10), IntegerAnswer(5), DecimalAnswer(50)),
          (Div, IntegerAnswer(10), DecimalAnswer(5), DecimalAnswer(2)),
          (Div, DecimalAnswer(10), IntegerAnswer(5), DecimalAnswer(2))
        )

        forAll(table) { (operator, left, right, expectedAnswer) =>
          val expression = BinaryOperation(operator, left, right)
          expression.evaluate(Map.empty, Map.empty) should be(expectedAnswer)
        }
      }
    }

    "do comparison operations" should {
      "on strings" in {
        val table = Table(
          ("Operator", "Left", "Right", "Expected Answer"),
          (Lt, StringAnswer("A"), StringAnswer("B"), BooleanAnswer(true)),
          (Lt, StringAnswer("B"), StringAnswer("A"), BooleanAnswer(false)),
          (Lte, StringAnswer("A"), StringAnswer("B"), BooleanAnswer(true)),
          (Lte, StringAnswer("A"), StringAnswer("A"), BooleanAnswer(true)),
          (Lte, StringAnswer("B"), StringAnswer("A"), BooleanAnswer(false)),
          (Gte, StringAnswer("B"), StringAnswer("A"), BooleanAnswer(true)),
          (Gte, StringAnswer("A"), StringAnswer("A"), BooleanAnswer(true)),
          (Gte, StringAnswer("A"), StringAnswer("B"), BooleanAnswer(false)),
          (Gt, StringAnswer("B"), StringAnswer("A"), BooleanAnswer(true)),
          (Gt, StringAnswer("A"), StringAnswer("B"), BooleanAnswer(false)),
          (Ne, StringAnswer("A"), StringAnswer("B"), BooleanAnswer(true)),
          (Ne, StringAnswer("A"), StringAnswer("A"), BooleanAnswer(false)),
          (Eq, StringAnswer("A"), StringAnswer("A"), BooleanAnswer(true)),
          (Eq, StringAnswer("A"), StringAnswer("B"), BooleanAnswer(false))
        )

        forAll(table) { (operator, left, right, expectedAnswer) =>
          val expression = BinaryOperation(operator, left, right)
          expression.evaluate(Map.empty, Map.empty) should be(expectedAnswer)
        }
      }

      "on integers" in {
        val table = Table(
          ("Operator", "Left", "Right", "Expected Answer"),
          (Lt, IntegerAnswer(1), IntegerAnswer(2), BooleanAnswer(true)),
          (Lt, IntegerAnswer(2), IntegerAnswer(1), BooleanAnswer(false)),
          (Lte, IntegerAnswer(1), IntegerAnswer(2), BooleanAnswer(true)),
          (Lte, IntegerAnswer(1), IntegerAnswer(1), BooleanAnswer(true)),
          (Lte, IntegerAnswer(2), IntegerAnswer(1), BooleanAnswer(false)),
          (Gte, IntegerAnswer(5), IntegerAnswer(3), BooleanAnswer(true)),
          (Gte, IntegerAnswer(5), IntegerAnswer(5), BooleanAnswer(true)),
          (Gte, IntegerAnswer(3), IntegerAnswer(5), BooleanAnswer(false)),
          (Gt, IntegerAnswer(5), IntegerAnswer(3), BooleanAnswer(true)),
          (Gt, IntegerAnswer(3), IntegerAnswer(5), BooleanAnswer(false)),
          (Ne, IntegerAnswer(5), IntegerAnswer(3), BooleanAnswer(true)),
          (Ne, IntegerAnswer(5), IntegerAnswer(5), BooleanAnswer(false)),
          (Eq, IntegerAnswer(5), IntegerAnswer(5), BooleanAnswer(true)),
          (Eq, IntegerAnswer(5), IntegerAnswer(3), BooleanAnswer(false))
        )

        forAll(table) { (operator, left, right, expectedAnswer) =>
          val expression = BinaryOperation(operator, left, right)
          expression.evaluate(Map.empty, Map.empty) should be(expectedAnswer)
        }
      }

      "on booleans" in {
        val table = Table(
          ("Operator", "Left", "Right", "Expected Answer"),
          (Lt, BooleanAnswer(false), BooleanAnswer(true), BooleanAnswer(true)),
          (Lt, BooleanAnswer(true), BooleanAnswer(false), BooleanAnswer(false)),
          (Lte, BooleanAnswer(false), BooleanAnswer(true), BooleanAnswer(true)),
          (Lte, BooleanAnswer(true), BooleanAnswer(true), BooleanAnswer(true)),
          (Lte, BooleanAnswer(true), BooleanAnswer(false), BooleanAnswer(false)),
          (Gte, BooleanAnswer(true), BooleanAnswer(false), BooleanAnswer(true)),
          (Gte, BooleanAnswer(true), BooleanAnswer(true), BooleanAnswer(true)),
          (Gte, BooleanAnswer(false), BooleanAnswer(true), BooleanAnswer(false)),
          (Gt, BooleanAnswer(true), BooleanAnswer(false), BooleanAnswer(true)),
          (Gt, BooleanAnswer(true), BooleanAnswer(true), BooleanAnswer(false)),
          (Ne, BooleanAnswer(true), BooleanAnswer(false), BooleanAnswer(true)),
          (Ne, BooleanAnswer(true), BooleanAnswer(true), BooleanAnswer(false)),
          (Eq, BooleanAnswer(true), BooleanAnswer(true), BooleanAnswer(true)),
          (Eq, BooleanAnswer(true), BooleanAnswer(false), BooleanAnswer(false))
        )

        forAll(table) { (operator, left, right, expectedAnswer) =>
          val expression = BinaryOperation(operator, left, right)
          expression.evaluate(Map.empty, Map.empty) should be(expectedAnswer)
        }
      }

      "on dates" in {
        val table = Table(
          ("Operator", "Left", "Right", "Expected Answer"),
          // format: off
          (Lt, DateAnswer(LocalDate.parse("2018-03-08")), DateAnswer(LocalDate.parse("2018-03-09")), BooleanAnswer(true)),
          (Lt, DateAnswer(LocalDate.parse("2018-03-09")), DateAnswer(LocalDate.parse("2018-03-08")), BooleanAnswer(false)),
          (Lte, DateAnswer(LocalDate.parse("2018-03-08")), DateAnswer(LocalDate.parse("2018-03-09")), BooleanAnswer(true)),
          (Lte, DateAnswer(LocalDate.parse("2018-03-08")), DateAnswer(LocalDate.parse("2018-03-08")), BooleanAnswer(true)),
          (Lte, DateAnswer(LocalDate.parse("2018-03-09")), DateAnswer(LocalDate.parse("2018-03-08")), BooleanAnswer(false)),
          (Gte, DateAnswer(LocalDate.parse("2018-03-09")), DateAnswer(LocalDate.parse("2018-03-08")), BooleanAnswer(true)),
          (Gte, DateAnswer(LocalDate.parse("2018-03-08")), DateAnswer(LocalDate.parse("2018-03-08")), BooleanAnswer(true)),
          (Gte, DateAnswer(LocalDate.parse("2018-03-08")), DateAnswer(LocalDate.parse("2018-03-09")), BooleanAnswer(false)),
          (Gt, DateAnswer(LocalDate.parse("2018-03-09")), DateAnswer(LocalDate.parse("2018-03-08")), BooleanAnswer(true)),
          (Gt, DateAnswer(LocalDate.parse("2018-03-08")), DateAnswer(LocalDate.parse("2018-03-09")), BooleanAnswer(false)),
          (Ne, DateAnswer(LocalDate.parse("2018-03-08")), DateAnswer(LocalDate.parse("2018-03-09")), BooleanAnswer(true)),
          (Ne, DateAnswer(LocalDate.parse("2018-03-08")), DateAnswer(LocalDate.parse("2018-03-08")), BooleanAnswer(false)),
          (Eq, DateAnswer(LocalDate.parse("2018-03-08")), DateAnswer(LocalDate.parse("2018-03-08")), BooleanAnswer(true)),
          (Eq, DateAnswer(LocalDate.parse("2018-03-08")), DateAnswer(LocalDate.parse("2018-03-09")), BooleanAnswer(false))
          // format: on
        )

        forAll(table) { (operator, left, right, expectedAnswer) =>
          val expression = BinaryOperation(operator, left, right)
          expression.evaluate(Map.empty, Map.empty) should be(expectedAnswer)
        }
      }

      "on money" in {
        val table = Table(
          ("Operator", "Left", "Right", "Expected Answer"),
          (Lt, MoneyAnswer(1), MoneyAnswer(2), BooleanAnswer(true)),
          (Lt, MoneyAnswer(2), MoneyAnswer(1), BooleanAnswer(false)),
          (Lte, MoneyAnswer(1), MoneyAnswer(2), BooleanAnswer(true)),
          (Lte, MoneyAnswer(1), MoneyAnswer(1), BooleanAnswer(true)),
          (Lte, MoneyAnswer(2), MoneyAnswer(1), BooleanAnswer(false)),
          (Gte, MoneyAnswer(5), MoneyAnswer(3), BooleanAnswer(true)),
          (Gte, MoneyAnswer(5), MoneyAnswer(5), BooleanAnswer(true)),
          (Gte, MoneyAnswer(3), MoneyAnswer(5), BooleanAnswer(false)),
          (Gt, MoneyAnswer(5), MoneyAnswer(3), BooleanAnswer(true)),
          (Gt, MoneyAnswer(3), MoneyAnswer(5), BooleanAnswer(false)),
          (Ne, MoneyAnswer(5), MoneyAnswer(3), BooleanAnswer(true)),
          (Ne, MoneyAnswer(5), MoneyAnswer(5), BooleanAnswer(false)),
          (Eq, MoneyAnswer(5), MoneyAnswer(5), BooleanAnswer(true)),
          (Eq, MoneyAnswer(5), MoneyAnswer(3), BooleanAnswer(false))
        )

        forAll(table) { (operator, left, right, expectedAnswer) =>
          val expression = BinaryOperation(operator, left, right)
          expression.evaluate(Map.empty, Map.empty) should be(expectedAnswer)
        }
      }
    }

    "do logical operations" should {
      "on booleans" in {
        val table = Table(
          ("Operator", "Left", "Right", "Expected Answer"),
          (Or, BooleanAnswer(true), BooleanAnswer(false), BooleanAnswer(true)),
          (Or, BooleanAnswer(false), BooleanAnswer(false), BooleanAnswer(false)),
          (And, BooleanAnswer(true), BooleanAnswer(true), BooleanAnswer(true)),
          (And, BooleanAnswer(true), BooleanAnswer(false), BooleanAnswer(false))
        )

        forAll(table) { (operator, left, right, expectedAnswer) =>
          val expression = BinaryOperation(operator, left, right)
          expression.evaluate(Map.empty, Map.empty) should be(expectedAnswer)
        }
      }
    }

    "do nested operations" in {
      val table = Table(
        ("Operator", "Left", "Right", "Expected Answer"),
        (Mul, IntegerAnswer(5), BinaryOperation(Mul, IntegerAnswer(10), IntegerAnswer(15)), IntegerAnswer(750)),
        (And, BooleanAnswer(true), BinaryOperation(And, BooleanAnswer(true), BooleanAnswer(true)), BooleanAnswer(true)),
        (And, BooleanAnswer(true), BinaryOperation(Eq, StringAnswer("Foo"), StringAnswer("Foo")), BooleanAnswer(true))
      )

      forAll(table) { (operator, left, right, expectedAnswer) =>
        val expression = BinaryOperation(operator, left, right)
        expression.evaluate(Map.empty, Map.empty) should be(expectedAnswer)
      }
    }

    "correctly find references" in {
      val qlForm = QLForm(
        formName = "Revenue",
        statements = List(
          Question("revenue", "How much did you earn", IntegerType, Some(IntegerAnswer(1000))),
          Question("expenses", "How much did you spend", IntegerType, Some(IntegerAnswer(200))),
          Question(
            "profit",
            "You still have",
            IntegerType,
            Some(BinaryOperation(Sub, Reference("revenue"), Reference("expenses"))))
        )
      )

      val questions: Seq[Question] = qlForm.statements.collect { case q: Question => q }
      val result = questions.flatMap(question => question.expression.map(_.evaluate(qlForm.symbolTable, Map.empty)))
      assert(result == Seq(IntegerAnswer(1000), IntegerAnswer(200), IntegerAnswer(800)))
    }

    "do error handling" should {
      "throw an error for arithmetic operations on unsupported types" in {
        val expression = BinaryOperation(Div, BooleanAnswer(true), BooleanAnswer(true))

        assertThrows[UnsupportedOperationException](expression.evaluate(Map.empty, Map.empty))
      }
      "throw an error for logical operations on unsupported types" in {
        val expression = BinaryOperation(And, StringAnswer("Foo"), StringAnswer("Bar"))

        assertThrows[UnsupportedOperationException](expression.evaluate(Map.empty, Map.empty))
      }
      "throw an error when evaluating mixed answertypes" in {
        val expression = BinaryOperation(Eq, BooleanAnswer(true), IntegerAnswer(5))

        assertThrows[IllegalArgumentException](expression.evaluate(Map.empty, Map.empty))
      }
    }
  }
}
