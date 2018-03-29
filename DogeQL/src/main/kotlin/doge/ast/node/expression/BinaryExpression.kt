package doge.ast.node.expression

import doge.ast.location.SourceLocation
import doge.ast.node.expression.operation.BinaryOperation
import doge.ast.node.expression.visitor.evaluation.EvaluationVisitor
import doge.ast.node.expression.visitor.evaluation.TypeVisitor
import doge.ast.node.expression.visitor.reference.ReferenceCollector
import doge.ast.node.expression.visitor.reference.ReferenceVisitor
import doge.data.question.SymbolType
import doge.data.value.BaseSymbolValue
import doge.visitor.QuestionnaireASTBaseVisitor

class BinaryExpression(
        val left: Expression,
        val right: Expression,
        val operation: BinaryOperation,
        sourceLocation: SourceLocation)
    : Expression(sourceLocation) {

    override fun <T> accept(visitor: QuestionnaireASTBaseVisitor<T>): T {
        return visitor.visit(this)
    }

    override fun accept(visitor: EvaluationVisitor): BaseSymbolValue {
        return visitor.visit(this)
    }

    override fun accept(visitor: TypeVisitor): SymbolType {
        return visitor.visit(this)
    }

    override fun accept(visitor: ReferenceVisitor): Boolean {
        return visitor.visit(this)
    }

    override fun accept(visitor: ReferenceCollector) {
        return visitor.visit(this)
    }

}