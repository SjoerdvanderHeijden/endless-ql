import tkinter

from multimethods import multimethod
from pyql.ast.form.form import Form
from pyql.ast.form.block import Block
from pyql.ast.form.ql_statements import Question
from pyql.ast.form.ql_statements import ComputedQuestion
from pyql.ast.form.ql_statements import If
from pyql.ast.form.ql_statements import IfElse
from pyql.ast.ast import ASTNode
from pyql.ast.expression.expressions import Identifier
from pyql.util.types import Type
from pyql.static_analysis.expression_evaluator import ExpressionEvaluator
from pyql.gui.window import Window

from pyql.gui.widgets.widget_factory import WidgetFactory


class GUIVisitor:
    def __init__(self, ast, symbol_table, messages):
        self._expression_visitor = ExpressionEvaluator(symbol_table)
        self._ast = ast
        self._symbol_table = symbol_table

        root = tkinter.Tk()
        self._window = Window(root, self, self._symbol_table)

        print(messages, not messages)
        if not messages:
            self.build()
        else:
            self.build_messages(messages)
        root.mainloop()

    def build(self):
        self._window.clear()
        self._ast.accept(self)

    def build_messages(self, messages):
        self._window.show_messages(messages)

    @multimethod(Identifier)
    def visit(self, identifier):
        return identifier.identifier

    @multimethod(Form)
    def visit(self, form):
        form.block.accept(self)

    @multimethod(Block)
    def visit(self, block):
        questions = block.statements
        for q in questions:
            visit_accepted = q.accept(self)
            if visit_accepted is not None:
                break

    @multimethod(ComputedQuestion)
    def visit(self, computed_question):
        try:
            expression_evaluated_value = computed_question.expression.accept(self._expression_visitor)
        except KeyError:
            return False

        if expression_evaluated_value:
            identifier = computed_question.identifier.accept(self)
            type = computed_question.question_type.accept(self)

            self._window.add_computed_question(identifier, computed_question.text, WidgetFactory.widget(type),
                                               expression_evaluated_value)

    @multimethod(Question)
    def visit(self, question):
        identifier = question.identifier.accept(self)
        type = question.question_type.accept(self)

        try:
            value = self._symbol_table.get(identifier)
        except KeyError:
            value = ""

        self._window.add_question(identifier, question.text, WidgetFactory.widget(type), value)

    @multimethod(IfElse)
    def visit(self, if_else_statement):
        try:
            expression_evaluates_true = if_else_statement.expression.accept(self._expression_visitor)
        except KeyError:
            return False

        if expression_evaluates_true:
            if_else_statement.if_block.accept(self)
        else:
            if_else_statement.else_block.accept(self)

    @multimethod(If)
    def visit(self, if_statement):
        try:
            expression_evaluates_true = if_statement.expression.accept(self._expression_visitor)
        except KeyError:
            return False

        if expression_evaluates_true:
            if_statement.block.accept(self)

    @multimethod(Type)
    def visit(self, type):
        return type

    @multimethod(ASTNode)
    def visit(self, node):
        pass
