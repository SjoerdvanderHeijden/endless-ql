package ql.parsers

import grammar._
import ql.models.ast._
import ql.visitors._

import scala.io.Source

import java.net.URL

import org.antlr.v4.runtime._

object QlFormParser {
  def getParser(input: String): QlParser = {
    val charStream = new ANTLRInputStream(input)
    val lexer = new QlLexer(charStream)
    val tokens = new CommonTokenStream(lexer)
    val parser = new QlParser(tokens)
    return parser
  }

  def parseFromURL(location: URL): ASTNode = {
    val source = Source.fromURL(location)
    val sourcedLines = source.mkString
    source.close

    val visitor = new ASTVisitor()
    val parser = getParser(sourcedLines)
    val tree = parser.root()

    return visitor.visit(tree)
  }

}
