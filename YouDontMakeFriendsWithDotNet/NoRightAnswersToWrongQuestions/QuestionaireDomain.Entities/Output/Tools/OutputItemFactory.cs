﻿using System;
using System.Collections.Generic;
using QuestionnaireDomain.Entities.Ast.Nodes.Questionnaire.Interfaces;
using QuestionnaireDomain.Entities.Domain;
using QuestionnaireDomain.Entities.Domain.Interfaces;
using QuestionnaireDomain.Entities.Output.Nodes;
using QuestionnaireDomain.Entities.Output.Nodes.Interfaces;
using QuestionnaireDomain.Entities.Output.Tools.Interfaces;
using QuestionnaireInfrastructure.API;

namespace QuestionnaireDomain.Entities.Output.Tools
{
    internal class OutputItemFactory : IOutputItemFactory
    {
        private readonly IIdMaker m_ids;
        private readonly IDomainItemRegistry m_registry;

        public OutputItemFactory(
            IIdMaker ids, 
            IDomainItemRegistry registry)
        {
            m_ids = ids;
            m_registry = registry;
        }

        public Reference<IQuestionnaireOutputItem> CreateQuestionnaireOutputItem(
            Reference<IQuestionnaireRootNode> variable,
            string displayName,
            IList<Reference<IQuestionOutputItem>> questions)
        {
            var questionnaireOutputItem= new QuestionnaireOutputItem(
                variable,
                m_ids.Next,
                displayName) {Questions = questions };

            return DomainItemRegistration<IQuestionnaireOutputItem>(
                questionnaireOutputItem);
        }

        public Reference<IQuestionOutputItem> CreateQuestionOutputItem(
            Reference<IQuestionNode> variable,
            string text, 
            string value,
            Type type,
            bool isVisible, 
            bool isReadonly)
        {
            var questionOutputItem = new QuestionOutputItem(
                m_ids.Next,
                variable,
                text,
                type,
                value,
                isVisible,
                isReadonly);

            return DomainItemRegistration<IQuestionOutputItem>(
                questionOutputItem);
        }

        private Reference<T> DomainItemRegistration<T>(T node) where T : IDomainItem
        {
            m_registry.Add(node);
            return new Reference<T>(node.Id);
        }
    }
}