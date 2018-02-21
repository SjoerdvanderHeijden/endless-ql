from antlr_files_2.QLVisitor import QLVisitor
from antlr4 import *
from QLast import *

# This class defines a complete generic visitor for a parse tree produced by QLParser.

class QLVisitorHelper(QLVisitor):

    # Visit a parse tree produced by QLParser#form.
    def visitForm(self, ctx):
        form_id = ctx.form_id().getText()
        form = FormNode(form_id)
        block = ctx.block()
        statements = block.statement()

        for statement in statements:
            node = self.visit(statement)
            if (node != None):
                form.statements.append(node)

        print(form)

        return


    # Visit a parse tree produced by QLParser#assignment.
    def visitAssignment(self, ctx):
        name = ctx.STR().getText()
        var = ctx.var().getText()
        vartype = ctx.vartype().getText()
        expression = ctx.expression
        node = AssignmentNode(name, var, vartype, expression)
        # print(node)
        return node
        # return self.visitChildren(ctx)

    # Visit a parse tree produced by QLParser#question.
    def visitQuestion(self, ctx):
        question = ctx.STR().getText()
        var = ctx.var().getText()
        vartype = ctx.vartype().getText()
        node = QuestionNode(question, var, vartype)
        # print(node)
        return node
        # return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#conditional.
    def visitConditional(self, ctx):
        if_condition_node = self.visit(ctx.if_cond())
        if (ctx.else_cond()):
            else_condition_node = self.visit(ctx.else_cond())
            return if_condition_node, else_condition_node
        # self.visit(if_condition)
        # else_condition = ctx.else_cond()
        # if (else_condition != None):

        return if_condition_node

    # Visit a parse tree produced by QLParser#expression.
    def visitExpression(self, ctx):
        # Todo: Make distinction between expressions
        # expression = ctx.getText()
        # print(expression)
        # if (expression.find("+") != -1 || expression.find("-") != -1):

        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#form_id.
    def visitForm_id(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#var.
    def visitVar(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#vartype.
    def visitVartype(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#if_cond.
    def visitIf_cond(self, ctx):
        expression = ctx.expression().getText()
        if_node = IfNode(expression)
        block = ctx.block()
        statements = block.statement()
        for statement in statements:
            node = self.visit(statement)
            if (node != None):
                # print(node)
                if_node.statements.append(node)
        # print(node)
        return if_node

    # Visit a parse tree produced by QLParser#elif_cond.
    def visitElif_cond(self, ctx):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by QLParser#else_cond.
    def visitElse_cond(self, ctx):
        else_node = ElseNode()
        block = ctx.block()
        statements = block.statement()
        for statement in statements:
            node = self.visit(statement)
            if (node != None):
                # print(node)
                else_node.statements.append(node)
        # print(node)
        return else_node