from Gui import Gui
from QLast import *
import operator as op
from Tkinter import *

class GuiBuilder():
    def __init__(self, ast):
        self.gui = Gui()
        self.ast = ast
        self.form_name = ast.name

        self.values = []
        self.trueExpressions = {}
        self.frameOrder = []
        self.frameCounter = 0

        self.labels = {}
        self.textBoxes = {}
        self.yesNoButtons = {}
        self.yesNoButtonsValues = {}
        self.parseStatements(ast)

    def updateForm(self, name='', index='', mode=''):
        self.frameCounter = 0
        self.parseStatements(self.ast)

    def parseStatements(self, form):  
        print self.frameOrder
        print self.frameCounter                          
        for statement in form.statements:
            print statement
            if type(statement) is QuestionNode:
                self.parseQuestion(statement)

            elif type(statement) is AssignmentNode:
                self.parseAssignment(statement)

            elif type(statement) is IfNode:
                condionalShown = self.parseConditional(statement, 'if')

            elif type(statement) is ElifNode and not condionalShown:
                condionalShown = self.parseConditional(statement, 'elif')

            elif type(statement) is ElseNode and not condionalShown:
                condionalShown = self.parseConditional(statement, 'else')

            elif type(statement) is ElseNode and not condionalShown:
                if len(statement.statements) > 0 and statement.statements[0].var in self.trueExpressions:
                    self.removeFrame(statement.statements[0].var, statement.statements)

    def parseQuestion(self, statement):
        if statement.vartype == "boolean" and statement.var not in self.values:
            self.gui.addBooleanQuestion(statement.var, statement.question, "No", "Yes", self.updateForm)
            self.values.append(statement.var)
        elif statement.vartype == "int" and statement.var not in self.values:
            self.gui.addIntQuestion(statement.var, statement.question, self.updateForm)
            self.values.append(statement.var)

    def parseAssignment(self, statement):
        if type(statement.expression) is BinOpNode:
            left = self.parseBinOpAssignment(statement.expression.left)
            right = self.parseBinOpAssignment(statement.expression.right)
            result = self.get_operator(statement.expression.op)(left, right)

        if(type(statement.expression) is UnOpNode):
            result = self.gui.getValue(statement.var, "int")

        if statement.var in self.values:
            self.gui.updateText(statement.var, result)
        else:
            self.values.append(statement.var)
            self.gui.addAssignment(statement.var, statement.name, result)

    def parseBinOpAssignment(self, statement):
        if type(statement) is BinOpNode:
            left = self.parseBinOpAssignment(statement.left)
            right = self.parseBinOpAssignment(statement.right)
            return self.get_operator(statement.op)(left, right)

        if type(statement) is UnOpNode:
            return self.gui.getValue(statement.var, "int")

    def parseConditional(self, statement, type):
        if type == 'else' and len(statement.statements) > 0:
            expression = statement.statements[0].var
            statements = statement.statements
            elseNode = True

        else:
            expression = statement.expression
            statements = statement.statements
            elseNode = False

        if (self.checkExpressionValues(expression) and expression not in self.trueExpressions) or elseNode: 
            print "yes"
            if len(self.frameOrder) > 0 and self.frameCounter <= len(self.frameOrder):
                self.removeFrames(self.frameOrder[self.frameCounter:])
                self.frameOrder = self.frameOrder[:self.frameCounter]
                self.frameCounter = len(self.frameOrder)

            self.trueExpressions[expression] = self.gui.setCurrentStatementFrame()
            self.frameOrder.append((expression, statements))
            self.frameCounter += 1
            self.parseStatements(statement)

            return True
        
        elif self.checkExpressionValues(expression) and expression in self.trueExpressions and not elseNode:
            self.frameCounter += 1
            return True
        elif not self.checkExpressionValues(expression) and expression in self.trueExpressions and not elseNode:
            self.removeFrame(expression, statements)
        elif expression in self.trueExpressions and not (len(self.frameOrder) > 0 and self.frameCounter <= len(self.frameOrder)) and not elseNode:
            self.frameCounter += 1

        return False

    def removeFrame(self, expression, statements):
        if expression in self.trueExpressions:
            self.trueExpressions[expression].destroy()
            del self.trueExpressions[expression]

        for stmnt in statements:
            if stmnt.var in self.values:
                self.values.remove(stmnt.var)

    def removeFrames(self, frameList):
        print "removing frames: ", frameList
        for frame in frameList:
            self.removeFrame(frame[0], frame[1])

    # Function that checks if the expression variables match the needed values to show the block
    def checkExpressionValues(self, expression):
        if type(expression) is BinOpNode:
            if expression.op == "&&":
                if self.checkExpressionValues(expression.left) and self.checkExpressionValues(expression.right):
                    return True

            if expression.op == "||":
                if self.checkExpressionValues(expression.left) or self.checkExpressionValues(expression.right):
                    return True

            else:
                left = self.parseBinOpAssignment(expression.left)
                right = self.parseBinOpAssignment(expression.right)
                result = self.get_operator(expression.op)(left, right)

        if type(expression) is UnOpNode:
            if not expression.negate and self.gui.values[expression.var].get() == 1:
                return True
            elif expression.negate and self.gui.values[expression.var].get() == 0:
                return True

        return False

    def get_operator(self, operator):
        return {
            '+' : op.add,
            '-' : op.sub,
            '*' : op.mul,
            '/' : op.div,
            '%' : op.mod,
            '^' : op.xor,
            '<' : op.lt,
            '>' : op.gt,
            '<=': op.le,
            '>=': op.ge
            }[operator]
