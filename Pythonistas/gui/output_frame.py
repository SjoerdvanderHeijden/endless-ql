from PyQt5 import QtWidgets


class OutputFrame(QtWidgets.QFrame):
    def __init__(self, questionIDs=[], questions={}):
        super(OutputFrame, self).__init__()
        self.frame_layout = QtWidgets.QVBoxLayout()
        self.setLayout(self.frame_layout)
        self.row = 0

        self.questionIDs = questionIDs  # Ordered list of question IDs.
        self.questions = questions  # Ordered list of question objects
        self.output_path = 'QL_output.txt'
        self.add_questions()

    def get_question_object(self,questionID):
        index = self.questionIDs.index(questionID)
        return self.questions[index]

    def get_output_path(self):
        return self.output_path

    def set_output_path(self, outputPath):
        self.output_path = outputPath

    def add_submit_button(self):
        self.submit_button = QtWidgets.QPushButton('Submit', self)
        self.submit_button.clicked.connect(self.submit)
        self.frame_layout.addWidget(self.submit_button)

    def submit(self):
        # Writes answers to txt file
        file = open(self.output_path, 'w')
        # for i in range(len(self.questions)):
        for i in self.questionIDs:
            file.write(self.questions[i].question+str(self.questions[i].answer)+'\n')
        file.close()

    def add_question(self,frame):
        self.frame_layout.addWidget(frame)

    def add_questions(self):
        for ID in self.questionIDs:
            question = self.questions[ID]
            frame = question.create_frame()
            self.add_question(frame)

    def check_duplicate_questions(self):
        question_list = []
        for ID in self.questionIDs:
            question = self.questions[ID]
            question_list.append(question.question)
        duplicates = set([duplicate for duplicate in question_list if question_list.count(duplicate) > 1])
        if len(duplicates) > 0:
            warning_string = "Warning: duplicate questions:{}".format(str(duplicates)[1:-1])
            self.frame_layout.addWidget(QtWidgets.QLabel(warning_string))
            # return "Warning: duplicate questions:{}".format(str(duplicates)[1:-1])

    def check_cyclic_ifs(self):
        pass  # todo: check cyclic ifs
        # Note: there can be no cyclic ifs due to the linear (one-way) nature of the listener

        # for question in self.questions:
        #     oldlists = [question.questionID]
        #     newlists = []
        #     for list in oldlists:
        #         ifquestion = self.get_question_object(list[-1])
        #         if_questions = ifquestion.getifquestions
        #         for ifquestion in if_questions:
        #             list.append(ifquestion)
        #             newlists.append(list)
        #             duplicates = set([duplicate for duplicate in list if list.count(duplicate) > 1])
        #             print(duplicates)
        #             if len(duplicates) > 0:
        #                 return "Error: cyclic dependency in if statements"




