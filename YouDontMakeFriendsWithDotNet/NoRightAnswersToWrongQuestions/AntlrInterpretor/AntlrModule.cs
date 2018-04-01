﻿using AntlrInterpretor.AstBuilder;
using Microsoft.Extensions.DependencyInjection;
using QuestionnaireDomain.Entities.Ast.Tools.Interfaces;
using QuestionnaireInfrastructure.API;

namespace AntlrInterpretor
{
    public class AntlrModule : IHasRegistrations
    {
        public void RegisterDependencies(IServiceCollection appRegistration)
        {
            appRegistration.AddSingleton(typeof(IAstBuilder), typeof(AstBuilder.AstBuilder));
        }
    }
}
