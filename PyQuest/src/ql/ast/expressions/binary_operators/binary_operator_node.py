from ql.ast.expressions.expression_node import ExpressionNode


class BinaryOperatorNode(ExpressionNode):
    def __init__(self, position, expression_type, left_expression, right_expression, value):
        super(BinaryOperatorNode, self).__init__(position, expression_type, value)
        self.__left_expression = left_expression
        self.__right_expression = right_expression

    @property
    def left_expression(self):
        return self.__left_expression

    @property
    def right_expression(self):
        return self.__right_expression

    @property
    def value(self):
        return self.__value

    @value.setter
    def value(self, value):
        self.__value = value
