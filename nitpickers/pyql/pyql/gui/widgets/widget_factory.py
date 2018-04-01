from pyql.gui.widgets.widgets import *
from util.types import *
from util.multimethods import multimethod


class WidgetFactory:

    def __init__(self):
        pass

    def widget(self, root, type, value):
        w = self.create_widget(type)
        return w(root, value)

    @multimethod(String)
    def create_widget(self, type):
        return StringWidget

    @multimethod(Integer)
    def create_widget(self, type):
        return IntegerWidget

    @multimethod(Decimal)
    def create_widget(self, type):
        return DecimalWidget

    @multimethod(Money)
    def create_widget(self, type):
        return MoneyWidget

    @multimethod(Boolean)
    def create_widget(self, type):
        return BooleanWidget

