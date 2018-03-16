﻿using System;
using System.Collections.Generic;

namespace QuestionaireOrchestration.Models
{
    public class QuestionnaireModel
    {
        public QuestionnaireModel(
            Guid questionnaireId, 
            string questionnaireDisplayName)
        {
            QuestionnaireId = questionnaireId;
            QuestionnaireDisplayName = questionnaireDisplayName;
        }

        public Guid QuestionnaireId { get; }
        public string QuestionnaireDisplayName { get; }
        public IList<QuestionModel> Questions { get; }
            = new List<QuestionModel>();
    }
}