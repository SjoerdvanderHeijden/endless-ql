﻿using System;
using QuestionnaireDomain.Entities.Ast.Nodes.Calculation.Interfaces;
using QuestionnaireDomain.Entities.Ast.Nodes.Common;
using QuestionnaireDomain.Entities.Ast.Nodes.Questionnaire.Interfaces;
using QuestionnaireDomain.Entities.Domain;

namespace QuestionnaireDomain.Entities.Ast.Nodes.Questionnaire
{
    internal class CalculatedQuestionNode : 
        AstNodeBase, 
        ICalculatedQuestionNode
    {
        public string QuestionName { get; }
        public string QuestionText { get; }
        public IQuestionType QuestionType { get; }
        public DomainId<ICalculationNode> CalculatedValue { get; }

        public CalculatedQuestionNode(
            Guid id, 
            string definition,
            string questionId, 
            string questionText, 
            IQuestionType questionType,
            DomainId<ICalculationNode> calculation) 
            : base(id, definition)
        {
            QuestionName = questionId;
            QuestionText = questionText;
            QuestionType = questionType;
            CalculatedValue = calculation;
        }
    }
}