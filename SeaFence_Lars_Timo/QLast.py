class QLast(object):
    pass

class FormNode(QLast):
    def __init__(self, name):
        self.name = name
        self.statements = []

    def __repr__(self):
        return "Form: {}, statements: {}".format(self.name, self.statements)

class QuestionNode(QLast):
    def __init__(self, question, var, vartype):
        self.question = question
        self.var = var
        self.vartype = vartype

    def __repr__(self):
        return "Question({}, {}, {})".format(self.question, self.var, self.vartype)

class AssignmentNode(QLast):
    def __init__(self, name, var, vartype, expression):
        self.name = name
        self.var = var
        self.vartype = vartype
        self.expression = expression

    def __repr__(self):
        return "Assignment: {} {} {} = {}".format(self.name, self.vartype, self.var, self.expression)


class BinOpNode(QLast):
    def __init__(self, left, op, right, negate=False):
        self.left = left
        self.op = op
        self.right = right
        self.negate = negate

    def __repr__(self):
        return "binop: negate:{} {} {} {}".format(self.negate, self.left, self.op, self.right)

class UnOpNode(QLast):
    def __init__(self, var, negate=False):
        self.var = var
        self.negate = negate

    def __repr__(self):
        return "unop: negate:{} {}".format(self.negate, self.var)

class IfNode(QLast):
    def __init__(self, expression):
        self.expression = expression
        self.statements = []

    def __repr__(self):
        return "If expression: {}, statements: {}".format(self.expression, self.statements)

class ElifNode(QLast):
    def __init__(self, expression):
        self.expression = expression
        self.statements = []

    def __repr__(self):
        return "Elif expression: {}, statements: {}".format(self.expression, self.statements)

class ElseNode(QLast):
    def __init__(self):
        self.statements = []

    def __repr__(self):
        return "Else statements: {}".format(self.statements)

class LiteralNode(QLast):
    def __init__(self, literal, negate=False):
        self.literal = literal
        self.negate = negate

    def __repr__(self):
        return "Litaral negate: {} {}".format(self.negate, self.literal)