# Lars Lokhoff, Timo Dobber
# This class defines a complete generic visitor for a parse tree produced by QLSParser.

from QLS.QLSVisitor import QLSVisitor
from antlr4 import *
from QLSast import *

class QLSVisitorHelper(QLSVisitor):

    # Visit a parse tree produced by QLSParser#stylesheet.
    def visitStylesheet(self, ctx):
        stylesheet_id = ctx.stylesheet_id().getText()
        stylesheet = StylesheetNode(stylesheet_id)

        for page in ctx.page():
            page_node = self.visit(page)
            stylesheet.pages.append(page_node)

        return stylesheet


    # Visit a parse tree produced by QLSParser#page.
    def visitPage(self, ctx):
        page_node = PageNode(ctx.page_id().getText().strip('"'))

        for section in ctx.section():
            section_node = self.visit(section)
            page_node.sections.append(section_node)

        default_style_nodes = self.checkDefaultStyle(ctx)
        page_node.default_style_widgets.extend(default_style_nodes)

        return page_node

    # Visit a parse tree produced by QLSParser#section.
    def visitSection(self, ctx):
        section_node = SectionNode(ctx.section_id().getText().strip('"'))

        if ctx.section():
            for section in ctx.section():
                child_section_node = self.visit(section)
                section_node.sections.append(child_section_node)

        if ctx.question():
            for question in ctx.question():
                question_node = self.visit(question)
                section_node.questions.append(question_node)

        
        default_style_nodes = self.checkDefaultStyle(ctx)
        section_node.default_style_widgets.extend(default_style_nodes)

        return section_node
        

    # Visit a parse tree produced by QLSParser#question.
    def visitQuestion(self, ctx):
        variable = ctx.variable().getText().strip('"')

        question_node = QuestionNode(variable)

        if ctx.widget():
            widget_node = self.visit(ctx.widget())
            question_node.widget = widget_node

        return question_node


    # Visit a parse tree produced by QLSParser#default_style.
    def visitDefault_style(self, ctx):
        variable_type = ctx.variable_type().getText()
        widget_node = self.visit(ctx.widget())
        options = {}

        if ctx.default_options():
            for option in ctx.default_options():
                if option.width():
                    name, value = option.getText().split(":")

                elif option.font():
                    name, value = option.getText().split(":")

                elif option.fontsize():
                    name, value = option.getText().split(":")

                elif option.color():
                    name, value = option.getText().split(":")

                options[name] = value

        style_options_node = StyleOptionsNode(variable_type)
        style_options_node.options = options
        widget_node.options = style_options_node


        return widget_node


    # Visit a parse tree produced by QLSParser#widget.
    def visitWidget(self, ctx):
        widget = ctx.widget_type().getText().split('(')[0]

        widget_node = WidgetNode(widget)

        if widget == "slider" or widget == "spinbox":
            widget_node.min_value = ctx.widget_type().NUMBER()[0]
            widget_node.max_value = ctx.widget_type().NUMBER()[1]

        return widget_node


    def checkDefaultStyle(self, ctx):
        default_style_widgets = []

        if ctx.default_style():
            for style in ctx.default_style():
                default_style_widget = self.visit(style)
                default_style_widgets.append(default_style_widget)

        return default_style_widgets