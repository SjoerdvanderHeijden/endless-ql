from pyql.ast.expression import expressions
from pyql.ast.form import block
from pyql.ast.form import statement


class Question(statement.Statement):

    def __init__(self, location, identifier, text, question_type):
        super().__init__(location)
        self._identifier = identifier
        self._text = text
        self._question_type = question_type

    @property
    def identifier(self):
        return self._identifier

    @property
    def text(self):
        return self._text

    @property
    def question_type(self):
        return self._question_type

    def __repr__(self):
        output = {
            "identifier": str(self.identifier),
            "text": str(self.text),
            "question_type": str(self.question_type),
        }
        return str({"AST QuestionStatement " + str(self.location): str(output)})


class ComputedQuestion(Question):

    def __init__(self, location, identifier, text, question_type, expression):
        super().__init__(location, identifier, text, question_type)
        self._expression = expression

    @property
    def expression(self):
        return self._expression

    def __repr__(self):
        return "AST ComputedQuestion Statement at: " + str(self.location)


class If(statement.Statement):

    def __init__(self, location, expression: expressions.Expression, block: block.Block):
        super().__init__(location)
        self._expression = expression
        self._block = block

    @property
    def expression(self):
        return self._expression

    @property
    def block(self):
        return self._block

    def __repr__(self):
        return "AST If Statement at: " + str(self.location)


class IfElse(If):

    def __init__(self, location, expression, if_block, else_block):
        super().__init__(location, expression, if_block)
        self._else_block = else_block

    @property
    def if_block(self):
        return super().block

    @property
    def else_block(self):
        return self._else_block

    def __repr__(self):
        return "AST IfElse Statement at: " + str(self.location)
