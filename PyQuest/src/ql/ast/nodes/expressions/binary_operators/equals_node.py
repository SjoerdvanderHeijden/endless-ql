from ql.ast.nodes.expressions.binary_operators.binary_operator_node import BinaryOperatorNode
from ql.types.boolean import QLBoolean


class EqualsOperatorNode(BinaryOperatorNode):
    def __init__(self, metadata, expression_type, left_expression, right_expression, value):
        super(EqualsOperatorNode, self).__init__(metadata, expression_type, left_expression, right_expression, value)

    def get_result_type(self, unused1, unused2):
        return QLBoolean

    def evaluate(self):
        self.value = self.expression_type(self.left_expression.value == self.right_expression.value)