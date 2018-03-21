from ql.ast.expressions.binary_operators.binary_operator_node import BinaryOperatorNode
from ql.types.decimal import QLDecimal
from ql.types.integer import QLInteger
from ql.types.money import QLMoney
from ql.types.string import QLString
from ql.types.undefined import QLUndefined


class AdditionOperatorNode(BinaryOperatorNode):
    def __init__(self, position, expression_type, left_expression, right_expression, value):
        super(AdditionOperatorNode, self).__init__(position, expression_type, left_expression, right_expression, value)
        self.__valid_types = {(QLDecimal, QLDecimal): QLDecimal,
                              (QLDecimal, QLInteger): QLDecimal,
                              (QLDecimal, QLMoney):   QLMoney,
                              (QLInteger, QLInteger): QLInteger,
                              (QLInteger, QLDecimal): QLDecimal,
                              (QLInteger, QLMoney):   QLMoney,
                              (QLMoney, QLMoney):   QLMoney,
                              (QLMoney, QLDecimal): QLMoney,
                              (QLMoney, QLInteger): QLMoney,
                              (QLString, QLString):  QLString}

    def get_result_type(self, type1, type2):
        if self.__valid_types.get((type1, type2)):
            return self.__valid_types.get((type1, type2))
        return QLUndefined

    def evaluate(self):
        self.value = self.expression_type(self.left_expression.value + self.right_expression.value)
