﻿using System.Collections.Generic;
using System.Linq;
using QuestionnaireDomain.Entities.Ast.Nodes.Boolean.Interfaces;
using QuestionnaireDomain.Entities.Ast.Nodes.Questionnaire.Interfaces;
using QuestionnaireDomain.Entities.Domain;
using QuestionnaireDomain.Entities.Domain.Interfaces;
using QuestionnaireDomain.Entities.Output.Nodes.Interfaces;
using QuestionnaireDomain.Entities.Output.Tools.Interfaces;

namespace QuestionnaireDomain.Entities.Output.Tools
{
    internal class BuildOutputVisitor :
        IBuildOutputVisitor
    {
        private readonly IBooleanEvaluatorVisitor m_booleanEvaluator;
        private readonly IDomainItemLocator m_domainItemLocator;
        private readonly ISymbolTable m_lookup;
        private readonly IOutputItemFactory m_outputItemFactory;

        private readonly IList<DomainId<IQuestionOutputItem>> m_questions =
            new List<DomainId<IQuestionOutputItem>>();

        private readonly Stack<bool> m_questionsCurrentlyVisible = new Stack<bool>();

        public BuildOutputVisitor(
            IDomainItemLocator domainItemLocator,
            IOutputItemFactory outputItemFactory,
            ISymbolTable lookup,
            IBooleanEvaluatorVisitor booleanEvaluator)
        {
            m_domainItemLocator = domainItemLocator;
            m_outputItemFactory = outputItemFactory;
            m_lookup = lookup;
            m_booleanEvaluator = booleanEvaluator;
            m_questionsCurrentlyVisible.Push(true);
        }

        public DomainId<IQuestionnaireOutputItem> Build(
            DomainId<IQuestionnaireRootNode> node)
        {
            dynamic d = node;
            this.Visit(d);
            return m_domainItemLocator
                .GetAllRefs<IQuestionnaireOutputItem>()
                .FirstOrDefault();
        }

        public void Visit(DomainId<IQuestionnaireRootNode> questionnaireNode)
        {
            var astNode = questionnaireNode
                .ToDomainItem(m_domainItemLocator);

            HandleStatements(astNode.Statements);

            var existingOutput = m_domainItemLocator
                .GetAll<IQuestionnaireOutputItem>()
                .FirstOrDefault(x => x.Variable.Id == astNode.Id);

            if (existingOutput == null)
                m_outputItemFactory.CreateQuestionnaireOutputItem(
                    questionnaireNode,
                    astNode.QuestionnaireName,
                    m_questions);
        }

        private void HandleStatements(IEnumerable<DomainId<IStatementNode>> statements)
        {
            foreach (var statement in statements)
                if (m_domainItemLocator.Exists<IUserInputQuestionNode>(statement.Id))
                    Visit(new DomainId<IUserInputQuestionNode>(statement.Id));
                else if (m_domainItemLocator.Exists<ICalculatedQuestionNode>(statement.Id))
                    Visit(new DomainId<ICalculatedQuestionNode>(statement.Id));
                else if (m_domainItemLocator.Exists<IConditionalStatementNode>(statement.Id))
                    Visit(new DomainId<IConditionalStatementNode>(statement.Id));
        }

        private void Visit(DomainId<IUserInputQuestionNode> questionNode)
        {
            var astNode = questionNode.ToDomainItem(m_domainItemLocator);

            var existingOutput = m_domainItemLocator
                .GetAll<IQuestionOutputItem>()
                .FirstOrDefault(x => x.Variable.Id == astNode.Id);

            if (existingOutput == null)
            {
                var question = m_outputItemFactory.CreateQuestionOutputItem(
                    new DomainId<IQuestionNode>(questionNode.Id),
                    GetValue(astNode),
                    m_questionsCurrentlyVisible.Peek(),
                    false);

                m_questions.Add(question);
            }
            else
            {
                existingOutput.Visible = m_questionsCurrentlyVisible.Peek();
            }
        }

        private void Visit(DomainId<ICalculatedQuestionNode> questionNode)
        {
            var astNode = questionNode.ToDomainItem(m_domainItemLocator);

            var existingOutput = m_domainItemLocator
                .GetAll<IQuestionOutputItem>()
                .FirstOrDefault(x => x.Variable.Id == astNode.Id);

            if (existingOutput == null)
            {
                var question = m_outputItemFactory.CreateQuestionOutputItem(
                    new DomainId<IQuestionNode>(questionNode.Id),
                    GetValue(astNode),
                    m_questionsCurrentlyVisible.Peek(),
                    true);

                m_questions.Add(question);
            }
            else
            {
                existingOutput.Value = GetValue(astNode);
                existingOutput.Visible = m_questionsCurrentlyVisible.Peek();
            }
        }

        private void Visit(DomainId<IConditionalStatementNode> ifElseNode)
        {
            var node = ifElseNode.ToDomainItem(m_domainItemLocator);
            var predicateResult = Evaluate(node.Predicate);
            m_questionsCurrentlyVisible.Push(predicateResult);
            HandleStatements(node.Consequent);
            m_questionsCurrentlyVisible.Pop();
            m_questionsCurrentlyVisible.Push(!predicateResult);
            HandleStatements(node.Alternative);
            m_questionsCurrentlyVisible.Pop();
        }

        private bool Evaluate(DomainId<IBooleanLogicNode> predicate)
        {
            return m_booleanEvaluator.Evaluate(predicate);
        }

        private string GetValue(IQuestionNode question)
        {
            return question.QuestionType.GetValue(m_lookup, question);
        }
    }
}