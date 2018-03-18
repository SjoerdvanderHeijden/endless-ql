﻿using System;
using QuestionnaireDomain.Entities.Output.Nodes.Interfaces;

namespace QuestionnaireOrchestration.Models
{
    public class ModelReference<T> where T : IOutputItem
    {
        public ModelReference(Guid id, string displayValue)
        {
            Id = id;
            DisplayValue = displayValue;
        }
        public Guid Id { get; }
        public string DisplayValue { get; }
    }
}