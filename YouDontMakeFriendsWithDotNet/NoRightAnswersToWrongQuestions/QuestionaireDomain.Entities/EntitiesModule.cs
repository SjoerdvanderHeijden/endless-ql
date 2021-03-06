﻿using Microsoft.Extensions.DependencyInjection;
using QuestionnaireDomain.Entities.Ast.Tools;
using QuestionnaireDomain.Entities.Ast.Tools.Interfaces;
using QuestionnaireDomain.Entities.Domain;
using QuestionnaireDomain.Entities.Domain.Interfaces;
using QuestionnaireDomain.Entities.Output.Tools;
using QuestionnaireDomain.Entities.Output.Tools.Interfaces;
using QuestionnaireDomain.Entities.Validators;
using QuestionnaireDomain.Entities.Validators.Interfaces;
using QuestionnaireInfrastructure.API;

namespace QuestionnaireDomain.Entities
{
    public class EntitiesModule : IHasRegistrations
    {
        public void RegisterDependencies(IServiceCollection appRegistration)
        {
            appRegistration.AddSingleton(typeof(IAstFactory), typeof(AstFactory));
            appRegistration.AddSingleton(typeof(IOutputItemFactory), typeof(OutputItemFactory));
            appRegistration.AddSingleton(typeof(IDomainItemRegistry), typeof(DomainItemRegistry));
            appRegistration.AddSingleton(typeof(ISymbolTable), typeof(SymbolTable));
            appRegistration.AddSingleton(typeof(IBooleanEvaluatorVisitor), typeof(BooleanEvaluatorVisitor));
            appRegistration.AddSingleton(typeof(ICalculationVisitor), typeof(CalculationVisitor));
            appRegistration.AddTransient(typeof(IBuildOutputVisitor), typeof(BuildOutputVisitor));
            appRegistration.AddSingleton(typeof(IDomainItemLocator), typeof(DomainItemLocator));
            appRegistration.AddSingleton(typeof(IVariableUpdater), typeof(VariableUpdater));
            appRegistration.AddSingleton(typeof(IQuestionnaireOutputCreator), typeof(QuestionnaireOutputCreator));
            appRegistration.AddSingleton(typeof(IQuestionnaireOutputUpdater), typeof(QuestionnaireOutputUpdater));
            appRegistration.AddSingleton(typeof(IQuestionnaireAstCreator), typeof(QuestionnaireAstCreator));
            appRegistration.AddSingleton(typeof(IQuestionnaireTypeChecker), typeof(QuestionnaireTypeChecker));
            appRegistration.AddSingleton(typeof(IDuplicateVariableValidator), typeof(DuplicateVariableValidator));
            appRegistration.AddSingleton(typeof(IUndefinedVariableValidator), typeof(UndefinedVariableValidator));
            appRegistration.AddSingleton(typeof(IBooleanConditionValidator), typeof(BooleanConditionValidator));
            appRegistration.AddSingleton(typeof(IDateComparisonValidator), typeof(DateComparisonValidator));
            appRegistration.AddSingleton(typeof(ITextComparisonValidator), typeof(TextComparisonValidator));
            appRegistration.AddSingleton(typeof(IMathComparisonValidator), typeof(MathComparisonValidator));
            appRegistration.AddSingleton(typeof(IMathExpressionValidator), typeof(MathExpressionValidator));
            appRegistration.AddSingleton(typeof(IUnknownTypeValidator), typeof(UnknownTypeValidator));
            appRegistration.AddSingleton(typeof(IDuplicateTextValidator), typeof(DuplicateTextValidator));
            appRegistration.AddSingleton(typeof(ICyclicDependencyValidator), typeof(CyclicDependencyValidator));
            appRegistration.AddSingleton(typeof(IVariableService), typeof(VariableService));
            appRegistration.AddSingleton(typeof(ICalculationService), typeof(CalculationService));
            appRegistration.AddSingleton(typeof(IExtractVariableVisitor), typeof(ExtractVariableVisitor));
        }
    }
}