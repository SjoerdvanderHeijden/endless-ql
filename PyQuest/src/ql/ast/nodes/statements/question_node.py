from ql.ast.nodes.base_node import BaseNode
from gui.model.question import QuestionModel


class QuestionNode(BaseNode):
    def __init__(self, line_number, label, identifier, answer_type, answer, computed):
        super(QuestionNode, self).__init__(line_number)
        self.__label = label
        self.__identifier = identifier
        self.__answer_type = answer_type
        self.__answer = answer
        self.__computed = computed

    @property
    def label(self):
        return self.__label

    @property
    def identifier(self):
        return self.__identifier

    @property
    def answer_type(self):
        return self.__answer_type

    @property
    def answer(self):
        return self.__answer

    @property
    def computed(self):
        return self.__computed

    def __eq__(self, other):
        return self.__label == other.__label and \
               self.__identifier == other.__identifier and \
               self.__answer_type == other.__answer_type and \
               self.__answer == other.answer

    def to_question(self, show):
        return QuestionModel(self.label, self.identifier, self.answer_type, self.answer, self.computed, show)
