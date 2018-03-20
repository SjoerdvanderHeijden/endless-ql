from ql.ast.expressions.binary_operators.binary_operator_node import BinaryOperatorNode


class GreaterThanOperatorNode(BinaryOperatorNode):
    def __init__(self, position, expression_type, left_expression, right_expression, value):
        super(GreaterThanOperatorNode, self).__init__(position, expression_type, left_expression, right_expression, value)

    def evaluate(self):
        self.value = self.expression_type(self.left_expression.value.value > self.right_expression.value.value)
