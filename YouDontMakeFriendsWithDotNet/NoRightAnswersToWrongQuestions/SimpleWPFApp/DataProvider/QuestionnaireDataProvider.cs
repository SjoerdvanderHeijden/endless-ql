﻿using System;
using System.Linq;
using QuestionaireOrchestration.Commands;
using QuestionaireOrchestration.Models;
using QuestionaireOrchestration.QueryServices;
using QuestionnaireInfrastructure.API;
using QuestionnaireUI.Models;

namespace SimpleWPFApp.DataProvider
{
    internal class QuestionnaireDataProvider: IQuestionnaireDataProvider
    {
        private readonly ICommandBus m_commandBus;
        private readonly IQuestionnaireOutputModelQueryService m_queryService;

        public QuestionnaireDataProvider(
            ICommandBus commandBus,
            IQuestionnaireOutputModelQueryService queryService)
        {
            m_commandBus = commandBus;
            m_queryService = queryService;
        }

        public QuestionnaireWrapper GetSingleQuestionnaire()
        {
            var firstItem = m_queryService.GetAll().FirstOrDefault();
            var model = m_queryService
                .GetModel(firstItem.Id);
            return new QuestionnaireWrapper(model);
        }

        public void LoadDefaultQuestionnaire()
        {
            var command = new CreateDefinitionFromTextCommand
            {
                DefinitionText = Properties.Resources.ExampleForm
            };
            m_commandBus.Send(command);
        }

        public void Reload(QuestionnaireModel questionnaireModel)
        {
            var command = new UpdateValuesCommand
            {
                Questionnaire = questionnaireModel
            };
            m_commandBus.Send(command);
        }
    }
}