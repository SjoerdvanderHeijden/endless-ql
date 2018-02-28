class Equality:
    def __eq__(self, other):
        return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

    def __ne__(self, other):
        return not self.__eq__(other)


class Statement(Equality):
    pass


class Aexp(Equality):
    pass


class Bexp(Equality):
    pass


# Statements
class FormStatement(Statement):
    def __init__(self, name, form):
        self.name = name
        self.form = form

    def __repr__(self):
        return 'FormStatement(%s, %s)' % (self.name, self.form)

    # def eval(self, env):
    #     value = self.aexp.eval(env)
    #     env[self.name] = value


class AssignStatement(Statement):
    def __init__(self, name, question, data_type):
        self.name = name
        self.question = question
        self.data_type = data_type

    def __repr__(self):
        return 'AssignStatement(%s, %s, %s)' % (self.name, self.question, self.data_type)

    # def eval(self, env):
    #     value = self.aexp.eval(env)
    #     env[self.name] = value


class CompoundStatement(Statement):
    def __init__(self, first, second):
        self.first = first
        self.second = second

    def __repr__(self):
        return '%s, %s' % (self.first, self.second)

    # def eval(self, env):
    #     self.first.eval(env)
    #     self.second.eval(env)


class IfStatement(Statement):
    def __init__(self, condition, true_stmt):
        self.condition = condition
        self.true_stmt = true_stmt

    def __repr__(self):
        return 'IfStatement(%s, %s)' % (self.condition, self.true_stmt)

    # def eval(self, env):
    #     condition_value = self.condition.eval(env)
    #     if condition_value:
    #         self.true_stmt.eval(env)
    #     else:
    #         if self.false_stmt:
    #             self.false_stmt.eval(env)


class IntAexp(Aexp):
    def __init__(self, i):
        self.i = i

    def __repr__(self):
        return 'IntAexp(%d)' % self.i

    def eval(self, env):
        return self.i


class VarAexp(Aexp):
    def __init__(self, name):
        self.name = name

    def __repr__(self):
        return 'VarAexp(%s)' % self.name

    def eval(self, env):
        if self.name in env:
            return env[self.name]
        else:
            return 0


class BinopAexp(Aexp):
    def __init__(self, op, left, right):
        self.op = op
        self.left = left
        self.right = right

    def __repr__(self):
        return 'BinopAexp(%s, %s, %s)' % (self.op, self.left, self.right)

    def eval(self, env):
        left_value = self.left.eval(env)
        right_value = self.right.eval(env)
        if self.op == '+':
            value = left_value + right_value
        elif self.op == '-':
            value = left_value - right_value
        elif self.op == '*':
            value = left_value * right_value
        elif self.op == '/':
            value = left_value / right_value
        else:
            raise RuntimeError('unknown operator: ' + self.op)
        return value


class RelopBexp(Bexp):
    def __init__(self, op, left, right):
        self.op = op
        self.left = left
        self.right = right

    def __repr__(self):
        return 'RelopBexp(%s, %s, %s)' % (self.op, self.left, self.right)

    def eval(self, env):
        left_value = self.left.eval(env)
        right_value = self.right.eval(env)
        if self.op == '<':
            value = left_value < right_value
        elif self.op == '<=':
            value = left_value <= right_value
        elif self.op == '>':
            value = left_value > right_value
        elif self.op == '>=':
            value = left_value >= right_value
        elif self.op == '=':
            value = left_value == right_value
        elif self.op == '!=':
            value = left_value != right_value
        else:
            raise RuntimeError('unknown operator: ' + self.op)
        return value


# class AndBexp(Bexp):
#     def __init__(self, left, right):
#         self.left = left
#         self.right = right
#
#     def __repr__(self):
#         return 'AndBexp(%s, %s)' % (self.left, self.right)
#
#     def eval(self, env):
#         left_value = self.left.eval(env)
#         right_value = self.right.eval(env)
#         return left_value and right_value
#
#
# class OrBexp(Bexp):
#     def __init__(self, left, right):
#         self.left = left
#         self.right = right
#
#     def __repr__(self):
#         return 'OrBexp(%s, %s)' % (self.left, self.right)
#
#     def eval(self, env):
#         left_value = self.left.eval(env)
#         right_value = self.right.eval(env)
#         return left_value or right_value
#
#
# class NotBexp(Bexp):
#     def __init__(self, exp):
#         self.exp = exp
#
#     def __repr__(self):
#         return 'NotBexp(%s)' % self.exp
#
#     def eval(self, env):
#         value = self.exp.eval(env)
#         return not value
