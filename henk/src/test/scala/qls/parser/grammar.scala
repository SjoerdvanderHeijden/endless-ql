import grammar._

import ql.models._
import qls.listeners._
import ql.visitors._

import scala.io.Source

import org.scalatest.FunSpec
import org.scalatest.Matchers._
import org.scalatest.BeforeAndAfter

import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree._

class QlsGrammerParserSpec extends FunSpec with BeforeAndAfter {

  describe("when parsing a basic form") {
    var listener: CountNodesListener = null

    before {
      val source = Source.fromURL(getClass.getResource("qls/parser/simple.qls"))
      val sourcedLines = source.mkString
      source.close

      listener = new CountNodesListener()
      val parser = Main.getQlsParser(sourcedLines)
      val tree = parser.root()

      val paul = new ParseTreeWalker()
      paul.walk(listener, tree)
    }

    it("'root' node count should be 1") {
      assert(listener.node_count("root") == 1)
    }

    it("'page' node count should be 1") {
      assert(listener.node_count("page") == 1)
    }

    it("'section' node count should be 2") {
      assert(listener.node_count("section") == 2)
    }

    it("'question' node count should be 2") {
      assert(listener.node_count("question") == 2)
    }

    it("'identifier' node count should be 4") {
      assert(listener.node_count("identifier") == 4)
    }
  }
}

// class GrammarOneSpec extends FunSpec with BeforeAndAfter {
  // describe("when parsing a form with a conditional") {
    // var listener: CountNodesListener = null

    // before {
      // val source = Source.fromURL(getClass.getResource("ql/conditional.ql"))
      // val sourcedLines = source.mkString
      // source.close

      // listener = new CountNodesListener()
      // val parser = Main.getParser(sourcedLines)
      // val tree = parser.root()

      // val paul = new ParseTreeWalker()
      // paul.walk(listener, tree)
    // }

    // it("'question' node count should be 5") {
      // assert(listener.node_count("questions") == 4)
    // }

    // it("'root' node count should be 1") {
      // assert(listener.node_count("root") == 1)
    // }

    // it("'typeDecl' node count should be 5") {
      // assert(listener.node_count("typeDecl") == 5)
    // }

    // it("'form' node count should be 1") {
      // assert(listener.node_count("form") == 1)
    // }

    // it("'formHeader' node count should be 1") {
      // assert(listener.node_count("formHeader") == 1)
    // }

    // it("'varDecl' node count should be 5") {
      // assert(listener.node_count("varDecl") == 5)
    // }

    // it("'ifStmt' node count should be 1") {
      // assert(listener.node_count("ifStmt") == 1)
    // }

    // it("'computation' node count should be 1") {
      // assert(listener.node_count("computation") == 1)
    // }

    // it("'binOp' node count should be 1") {
      // assert(listener.node_count("binOp") == 1)
    // }
  // }
// }
