from ql.ast.expressions.binary_operators.binary_operator_node import BinaryOperatorNode
from ql.types.boolean import QLBoolean
from ql.types.date import QLDate
from ql.types.decimal import QLDecimal
from ql.types.integer import QLInteger
from ql.types.money import QLMoney
from ql.types.string import QLString
from ql.types.undefined import QLUndefined


class NotEqualsOperatorNode(BinaryOperatorNode):
    def __init__(self, position, expression_type, left_expression, right_expression, value):
        super(NotEqualsOperatorNode, self).__init__(position, expression_type, left_expression, right_expression, value)
        self.__valid_types = [(QLBoolean, QLBoolean),
                              (QLDate, QLDate),
                              (QLDecimal, QLDecimal),
                              (QLDecimal, QLInteger),
                              (QLDecimal, QLMoney),
                              (QLInteger, QLInteger),
                              (QLInteger, QLMoney),
                              (QLMoney, QLMoney),
                              (QLString, QLString)]

    def get_result_type(self, type1, type2):
        if (type1, type2) or (type2, type1) in self.__valid_types:
            return QLBoolean
        return QLUndefined

    def evaluate(self):
        self.value = self.expression_type(self.left_expression.value != self.right_expression.value)
