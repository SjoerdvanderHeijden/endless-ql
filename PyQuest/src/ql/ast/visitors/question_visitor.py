from ql.ast.statements.form_node import FormNode
from ql.ast.statements.if_node import IfNode
from ql.ast.statements.question_node import QuestionNode
from ql.ast.visitors.visitor_helper import on, when


class QuestionVisitor(object):

    def __init__(self):
        self.__questions = []

    @property
    def questions(self):
        return self.__questions

    # Generic method that initializes the dynamic dispatcher
    @on('node')
    def visit(self, node):
        pass

    @when(FormNode)
    def visit(self, node):
        for child in node.block:
            child.accept(self)

    @when(IfNode)
    def visit(self, node):
        for child in node.block:
            child.accept(self)

    @when(QuestionNode)
    def visit(self, node):
        self.__questions.append({"label": node.label,
                                 "identifier": node.identifier,
                                 "answer_type": node.answer_type,
                                 "position": node.position})
