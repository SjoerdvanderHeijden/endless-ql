package org.uva.sc.cr.ql.interpreter.evaluator

import java.util.Map
import javax.inject.Singleton
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import org.uva.sc.cr.ql.qL.Expression
import org.uva.sc.cr.ql.qL.ExpressionAnd
import org.uva.sc.cr.ql.qL.ExpressionComparison
import org.uva.sc.cr.ql.qL.ExpressionEquality
import org.uva.sc.cr.ql.qL.ExpressionLiteralBoolean
import org.uva.sc.cr.ql.qL.ExpressionLiteralInteger
import org.uva.sc.cr.ql.qL.ExpressionLiteralString
import org.uva.sc.cr.ql.qL.ExpressionMultiplicationOrDivision
import org.uva.sc.cr.ql.qL.ExpressionNot
import org.uva.sc.cr.ql.qL.ExpressionOr
import org.uva.sc.cr.ql.qL.ExpressionPlusOrMinus
import org.uva.sc.cr.ql.qL.ExpressionQuestionReference
import org.uva.sc.cr.ql.util.MissingCaseException
import org.uva.sc.cr.ql.util.Operation
import org.uva.sc.cr.ql.qL.ExpressionParanthesis

@Singleton
class ExpressionEvaluator {

	val ScriptEngine engine;

	new() {
		val manager = new ScriptEngineManager()
		engine = manager.getEngineByName("js")
	}

	private def String buildExpression(Expression expression) {
		switch expression {
			ExpressionOr:
				return '''«buildExpression(expression.left)» «expression.op» «buildExpression(expression.right)»'''
			ExpressionAnd:
				return '''«buildExpression(expression.left)» «expression.op» «buildExpression(expression.right)»'''
			ExpressionEquality:
				return '''«buildExpression(expression.left)» «expression.op» «buildExpression(expression.right)»'''
			ExpressionComparison:
				return '''«buildExpression(expression.left)» «expression.op» «buildExpression(expression.right)»'''
			ExpressionPlusOrMinus:
				return '''«buildExpression(expression.left)» «expression.op» «buildExpression(expression.right)»'''
			ExpressionMultiplicationOrDivision:
				return '''«buildExpression(expression.left)» «expression.op» «buildExpression(expression.right)»'''
			ExpressionParanthesis:
				return ''' ( «buildExpression(expression.expression)» ) '''
			ExpressionNot:
				return Operation.NOT.literal + buildExpression(expression.expression)
			ExpressionLiteralString:
				return " '" + expression.expression + "' "
			ExpressionLiteralInteger:
				return " " + expression.expression + " "
			ExpressionLiteralBoolean:
				return " " + expression.expression + " "
			ExpressionQuestionReference:
				return expression.question.name
			default: {
				throw new MissingCaseException()
			}
		}
	}

	def <T> evaluateExpression(Expression expression, Map<String, Object> arguments, Class<T> clazz) {
		val expressionAsString = buildExpression(expression)
		arguments.forEach [ variableName, valueValue |
			engine.put(variableName, valueValue)
		]
		var result = engine.eval(expressionAsString)
		return result as T
	}

}
