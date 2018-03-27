package org.uva.sc.cr.ql.validation

import org.eclipse.xtext.validation.Check
import org.uva.sc.cr.ql.qL.Block
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
import org.uva.sc.cr.ql.qL.QLPackage
import org.uva.sc.cr.ql.qL.Question
import org.uva.sc.cr.ql.qL.QuestionType
import org.uva.sc.cr.ql.util.MissingCaseException
import org.uva.sc.cr.ql.util.Operation
import org.uva.sc.cr.ql.util.OperationQuestionTypeMapping

class QLExpressionValidator extends AbstractQLValidator {

	public static val TYPE_NOT_ALLOWED = 'typeNotAllowed'
	public static val TYPE_NOT_ALLOWED_MESSAGE = "this type is not allowed for the specified operation"

	public static val TYPE_NOT_SAME = 'typeNotSame'
	public static val TYPE_NOT_SAME_MESSAGE = "The provided types for this operation have to be the same"

	public static val BLOCK_INVALID_EXPRESSION = 'blockInvalidExpression'
	public static val BLOCK_INVALID_EXPRESSION_MESSAGE = "Not a boolean expression"

	public static val TYPE_NOT_EXPECTED = 'typeNotExpected'
	public static val TYPE_NOT_EXPECTED_MESSAGE = "The resulting type does not match the expected type"

	def QuestionType computeType(Expression expression) {
		switch expression {
			ExpressionOr:
				return QuestionType.TYPE_BOOLEAN
			ExpressionAnd:
				return QuestionType.TYPE_BOOLEAN
			ExpressionEquality:
				return QuestionType.TYPE_BOOLEAN
			ExpressionComparison:
				return QuestionType.TYPE_BOOLEAN
			ExpressionPlusOrMinus: {
				return computeType(expression.left)
			}
			ExpressionMultiplicationOrDivision: {
				return computeType(expression.left)
			}
			ExpressionNot:
				return QuestionType.TYPE_BOOLEAN
			ExpressionLiteralString:
				return QuestionType.TYPE_STRING
			ExpressionLiteralInteger:
				return QuestionType.TYPE_INTEGER
			ExpressionLiteralBoolean:
				return QuestionType.TYPE_BOOLEAN
			ExpressionQuestionReference:
				return expression.question.type
			default:
				throw new MissingCaseException()
		}
	}

	@Check
	def checkExpressionOr(ExpressionOr expressionOr) {

		var leftType = computeType(expressionOr.left)
		var rightType = computeType(expressionOr.right)

		var allowedTypes = OperationQuestionTypeMapping.getAllowedTypesForOperation(expressionOr.op)
		if (!allowedTypes.contains(leftType))
			error(TYPE_NOT_ALLOWED_MESSAGE, QLPackage.Literals.EXPRESSION_OR__LEFT, TYPE_NOT_ALLOWED)

		if (!allowedTypes.contains(rightType))
			error(TYPE_NOT_ALLOWED_MESSAGE, QLPackage.Literals.EXPRESSION_OR__RIGHT, TYPE_NOT_ALLOWED)

		if (leftType != rightType)
			error(TYPE_NOT_SAME_MESSAGE, QLPackage.Literals.EXPRESSION_OR__RIGHT, TYPE_NOT_SAME)

	}

	@Check
	def checkExpressionAnd(ExpressionAnd expressionAnd) {

		var leftType = computeType(expressionAnd.left)
		var rightType = computeType(expressionAnd.right)

		var allowedTypes = OperationQuestionTypeMapping.getAllowedTypesForOperation(expressionAnd.op)
		if (!allowedTypes.contains(leftType))
			error(TYPE_NOT_ALLOWED_MESSAGE, QLPackage.Literals.EXPRESSION_AND__LEFT, TYPE_NOT_ALLOWED)

		if (!allowedTypes.contains(rightType))
			error(TYPE_NOT_ALLOWED_MESSAGE, QLPackage.Literals.EXPRESSION_AND__RIGHT, TYPE_NOT_ALLOWED)

		if (leftType != rightType)
			error(TYPE_NOT_SAME_MESSAGE, QLPackage.Literals.EXPRESSION_AND__RIGHT, TYPE_NOT_SAME)

	}

	@Check
	def checkExpressionEquality(ExpressionEquality expressionEquality) {

		var leftType = computeType(expressionEquality.left)
		var rightType = computeType(expressionEquality.right)

		var allowedTypes = OperationQuestionTypeMapping.getAllowedTypesForOperation(expressionEquality.op)
		if (!allowedTypes.contains(leftType))
			error(TYPE_NOT_ALLOWED_MESSAGE, QLPackage.Literals.EXPRESSION_EQUALITY__LEFT, TYPE_NOT_ALLOWED)

		if (!allowedTypes.contains(rightType))
			error(TYPE_NOT_ALLOWED_MESSAGE, QLPackage.Literals.EXPRESSION_EQUALITY__RIGHT, TYPE_NOT_ALLOWED)

		if (leftType != rightType)
			error(TYPE_NOT_SAME_MESSAGE, QLPackage.Literals.EXPRESSION_EQUALITY__RIGHT, TYPE_NOT_SAME)

	}

	@Check
	def checkExpressionComparison(ExpressionComparison expressionComparison) {

		var leftType = computeType(expressionComparison.left)
		var rightType = computeType(expressionComparison.right)

		var allowedTypes = OperationQuestionTypeMapping.getAllowedTypesForOperation(expressionComparison.op)
		if (!allowedTypes.contains(leftType))
			error(TYPE_NOT_ALLOWED_MESSAGE, QLPackage.Literals.EXPRESSION_COMPARISON__LEFT, TYPE_NOT_ALLOWED)

		if (!allowedTypes.contains(rightType))
			error(TYPE_NOT_ALLOWED_MESSAGE, QLPackage.Literals.EXPRESSION_COMPARISON__RIGHT, TYPE_NOT_ALLOWED)

		if (leftType != rightType)
			error(TYPE_NOT_SAME_MESSAGE, QLPackage.Literals.EXPRESSION_COMPARISON__RIGHT, TYPE_NOT_SAME)

	}

	@Check
	def checkExpressionPlusOrMinus(ExpressionPlusOrMinus expressionPlusOrMinus) {

		var leftType = computeType(expressionPlusOrMinus.left)
		var rightType = computeType(expressionPlusOrMinus.right)

		var allowedTypes = OperationQuestionTypeMapping.getAllowedTypesForOperation(expressionPlusOrMinus.op)
		if (!allowedTypes.contains(leftType))
			error(TYPE_NOT_ALLOWED_MESSAGE, QLPackage.Literals.EXPRESSION_PLUS_OR_MINUS__LEFT, TYPE_NOT_ALLOWED)

		if (!allowedTypes.contains(rightType))
			error(TYPE_NOT_ALLOWED_MESSAGE, QLPackage.Literals.EXPRESSION_PLUS_OR_MINUS__RIGHT, TYPE_NOT_ALLOWED)

		if (leftType != rightType)
			error(TYPE_NOT_SAME_MESSAGE, QLPackage.Literals.EXPRESSION_PLUS_OR_MINUS__RIGHT, TYPE_NOT_SAME)

	}

	@Check
	def checkExpressionMulOrDiv(ExpressionMultiplicationOrDivision expressionMultiplicationOrDivision) {

		var leftType = computeType(expressionMultiplicationOrDivision.left)
		var rightType = computeType(expressionMultiplicationOrDivision.right)

		var allowedTypes = OperationQuestionTypeMapping.getAllowedTypesForOperation(expressionMultiplicationOrDivision.op)
		if (!allowedTypes.contains(leftType))
			error(TYPE_NOT_ALLOWED_MESSAGE, QLPackage.Literals.EXPRESSION_MULTIPLICATION_OR_DIVISION__LEFT, TYPE_NOT_ALLOWED)

		if (!allowedTypes.contains(rightType))
			error(TYPE_NOT_ALLOWED_MESSAGE, QLPackage.Literals.EXPRESSION_MULTIPLICATION_OR_DIVISION__RIGHT, TYPE_NOT_ALLOWED)

		if (leftType != rightType)
			error(TYPE_NOT_SAME_MESSAGE, QLPackage.Literals.EXPRESSION_MULTIPLICATION_OR_DIVISION__RIGHT, TYPE_NOT_SAME)

	}

	@Check
	def checkExpressionNot(ExpressionNot expressionNot) {

		var type = computeType(expressionNot.expression)

		var allowedTypes = OperationQuestionTypeMapping.getAllowedTypesForOperation(Operation.NOT.literal)
		if (!allowedTypes.contains(type))
			error(TYPE_NOT_ALLOWED_MESSAGE, QLPackage.Literals.EXPRESSION_NOT__EXPRESSION, TYPE_NOT_ALLOWED)

	}

	@Check
	def checkBlockExpression(Block block) {

		if (computeType(block.expression) != QuestionType.TYPE_BOOLEAN) {
			error(BLOCK_INVALID_EXPRESSION_MESSAGE, QLPackage.Literals.BLOCK__EXPRESSION, BLOCK_INVALID_EXPRESSION)
		}

	}

	@Check
	def checkComputedQuestion(Question question) {

		if (question.expression !== null) {
			var expectedType = question.type
			var computedType = computeType(question.expression)
			if (expectedType != computedType)
				error(TYPE_NOT_EXPECTED_MESSAGE, QLPackage.Literals.QUESTION__EXPRESSION, TYPE_NOT_EXPECTED)
		}

	}

}
