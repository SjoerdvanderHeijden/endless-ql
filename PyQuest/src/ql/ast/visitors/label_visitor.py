from ql.ast.statements.form_node import FormNode
from ql.ast.statements.if_node import IfNode
from ql.ast.statements.question_node import QuestionNode
from multimethods import multimethod


class LabelVisitor(object):

    def __init__(self):
        self.__labels = []

    @property
    def labels(self):
        return self.__labels

    @multimethod(FormNode)
    def visit(self, node):
        for child in node.block:
            child.accept(self)

    @multimethod(IfNode)
    def visit(self, node):
        for child in node.block:
            child.accept(self)

    @multimethod(QuestionNode)
    def visit(self, node):
        self.__labels.append(node.label)
