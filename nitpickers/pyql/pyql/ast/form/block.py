from pyql.ast import ast


class Block(ast.ASTNode):

    def __init__(self, location, statements: []):
        super().__init__(location)
        self._statements = statements

    @property
    def statements(self):
        return self._statements

    def __repr__(self):
        return "AST Block at: " + str(self.location)

