from ql.ast.expressions.literals.literal_node import LiteralNode


class IntegerNode(LiteralNode):
    def __init__(self, metadata, expression_type, value):
        super(IntegerNode, self).__init__(metadata, expression_type, value)
