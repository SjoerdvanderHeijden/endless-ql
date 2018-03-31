package org.uva.sc.cr.ql.interpreter.evaluator

import java.math.BigDecimal
import java.math.RoundingMode
import java.util.Map
import javax.inject.Singleton
import org.joda.money.CurrencyUnit
import org.joda.money.Money
import org.uva.sc.cr.ql.qL.ExpressionMultiplicationOrDivision
import org.uva.sc.cr.ql.qL.ExpressionPlusOrMinus
import org.uva.sc.cr.ql.qL.ExpressionQuestionReference
import org.uva.sc.cr.ql.util.Operation
import org.uva.sc.cr.ql.qL.ExpressionParanthesis

@Singleton
class ExpressionEvaluatorMoney {

	private static val CURRENCY_UNIT = CurrencyUnit.EUR
	private static val ROUNDING_MODE = RoundingMode.DOWN

	dispatch def Money evaluateExpression(ExpressionParanthesis expression, Map<String, Object> arguments) {
		return evaluateExpression(expression.expression, arguments)
	}

	dispatch def Money evaluateExpression(ExpressionPlusOrMinus expression, Map<String, Object> arguments) {
		var leftMoney = evaluateExpression(expression.left, arguments)
		var rightMoney = evaluateExpression(expression.right, arguments)
		if (expression.op == Operation.PLUS.literal) {
			return leftMoney.plus(rightMoney)
		} else {
			return leftMoney.minus(rightMoney)
		}
	}

	dispatch def Money evaluateExpression(ExpressionMultiplicationOrDivision expression, Map<String, Object> arguments) {
		var leftMoney = evaluateExpression(expression.left, arguments)
		var rightMoney = evaluateExpression(expression.right, arguments)
		if (expression.op == Operation.MULTIPLICATION.literal)
			return leftMoney.multipliedBy(rightMoney.amount, ROUNDING_MODE)
		else
			return leftMoney.dividedBy(rightMoney.amount, ROUNDING_MODE)
	}

	dispatch def Money evaluateExpression(ExpressionQuestionReference expression, Map<String, Object> arguments) {
		val value = arguments.get(expression.question.name)
		var BigDecimal bigDecimalValue;
		try {
			bigDecimalValue = new BigDecimal(value.toString())
		} catch (NumberFormatException e) {
			bigDecimalValue = new BigDecimal(0)
		}
		return Money.of(CURRENCY_UNIT, bigDecimalValue, ROUNDING_MODE)
	}

}
