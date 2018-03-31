from gui.widgets.money_spinbox import MoneySpinbox
from ql.ast.nodes.expressions.literals.money_node import MoneyNode
from ql.types.boolean import QLBoolean
from ql.types.type import QLType


class QLMoney(QLType):
    def __init__(self, value=0.0, currency='$'):
        super(QLMoney, self).__init__()
        self.__value = float(value)
        self.__currency = currency

    def __repr__(self):
        return '{}{:.2f}'.format(self.currency, self.value)

    def __bool__(self):
        return bool(self.value)

    def __float__(self):
        return float(self.value)

    def __int__(self):
        return int(self.value)

    def __str__(self):
        return '{}{:.2f}'.format(self.currency, self.value)

    def __neg__(self):
        return QLMoney(- self.value, self.currency)

    def __eq__(self, other):
        return QLBoolean(self.value == other.value and self.currency == other.currency)

    def __ne__(self, other):
        return QLBoolean(self.value != other.value or self.currency != other.currency)

    def __lt__(self, other):
        return QLBoolean(self.value < other.value and self.currency == other.currency)

    def __gt__(self, other):
        return QLBoolean(self.value > other.value and self.currency == other.currency)

    def __le__(self, other):
        return QLBoolean(self.value <= other.value and self.currency == other.currency)

    def __ge__(self, other):
        return QLBoolean(self.value >= other.value and self.currency == other.currency)

    def __add__(self, other):
        if self.currency == other.currency:
            return QLMoney(self.value + other.value, self.currency)
        return NotImplemented

    def __sub__(self, other):
        if self.currency == other.currency:
            return QLMoney(self.value - other.value, self.currency)
        return NotImplemented

    def get_json_value(self):
        return {'value': round(self.value, 2), 'currency': self.currency}

    @property
    def value(self):
        return self.__value

    @property
    def currency(self):
        return self.__currency

    @staticmethod
    def get_literal_node(value=0.0, currency='$'):
        return MoneyNode(None, QLMoney, QLMoney(value, currency))

    @staticmethod
    def pyqt5_default_widget():
        widget = MoneySpinbox()
        return widget
