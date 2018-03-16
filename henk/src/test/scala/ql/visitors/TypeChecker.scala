import ql.models.ast._
import ql.validators._
import ql.spec.helpers._

import scala.io.Source
import scala.util.{Try, Success, Failure}

import org.scalatest.FunSpec
import org.scalatest.Matchers._
import org.scalatest.BeforeAndAfter

import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree._

class TypeCheckerSpec extends FunSpec with BeforeAndAfter {
  val resourceDir = "ql/typechecking"

  describe("when TypeChecker validates a valid form") {
    val filename = s"${resourceDir}/simple.ql"
    val form = FormHelper.getForm(getClass.getResource(filename))
    val tc = new TypeChecker()

    it("should return true") {
      assert(tc.validate(form))
    }

    it("error message should be empty") {
      assert(tc.error == null)
    }
  }

  describe("when TypeChecker validates a form containing an undeclared var") {
    val filename = s"${resourceDir}/single_undeclared_identifier.ql"
    val form = FormHelper.getForm(getClass.getResource(filename))
    val tc = new TypeChecker()

    it("should return false") {
      assert(!tc.validate(form))
    }

    it("typechecker should contain the exception") {
      tc.error match {
        case IdentifierNotDeclared(_) => succeed
        case other => fail("no correct error was set")
      }
    }
  }

  describe("when TypeChecker validates a form containing invalid conditional") {
    val filename = s"${resourceDir}/conditions/binop/money_bool_binop.ql"
    val form = FormHelper.getForm(getClass.getResource(filename))
    val tc = new TypeChecker()

    it("should return false") {
      assert(!tc.validate(form))
    }

    it("typechecker should contain the exception") {
      tc.error match {
        case ConditionalNotBoolean(_) => succeed
        case other => fail("no correct error was set")
      }
    }
  }

  // describe("when ConditionalValidator contains a conditional with Money type") {
    // val filename = s"${resourceDir}/money_type_conditional.ql"
    // val form = FormHelper.getForm(getClass.getResource(filename))

    // it("check should return an option exception") {
      // ConditionalValidator.check(form) match {
        // case None => fail()
        // case Some(ConditionalNotBoolean(e)) => succeed
        // case other => fail("wrong error thrown")
      // }
    // }
  // }

  // describe("when ConditionalValidator contains a valid binOp") {
    // val filename = s"${resourceDir}/binop/simple_binop.ql"
    // val form = FormHelper.getForm(getClass.getResource(filename))

    // it("check should not return an option exception") {
      // ConditionalValidator.check(form) match {
        // case None => succeed
        // case Some(ConditionalNotBoolean(e)) => fail(e)
        // case other => fail("ConditionalValidator should not have thrown an error")
      // }
    // }
  // }

  // describe("when ConditionalValidator contains a binop consisting of money and boolean") {
    // val filename = s"${resourceDir}/binop/money_bool_binop.ql"
    // val form = FormHelper.getForm(getClass.getResource(filename))

    // it("check should return an option exception") {
      // ConditionalValidator.check(form) match {
        // case None => fail()
        // case Some(ConditionalNotBoolean(e)) => succeed
        // case other => fail("wrong error thrown")
      // }
    // }
  // }
}
