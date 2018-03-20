﻿using QuestionnaireDomain.Entities.Ast.Nodes.Calculation.Interfaces;
using QuestionnaireDomain.Entities.Domain;
using QuestionnaireDomain.Entities.Domain.Interfaces;
using QuestionnaireDomain.Entities.Output.Tools.Interfaces;

namespace QuestionnaireDomain.Entities.Output.Tools
{
    internal class CalculationVisitor : ICalculationVisitor
    {
        private readonly IDomainItemLocator m_domainItemLocator;

        public CalculationVisitor(IDomainItemLocator domainItemLocator)
        {
            m_domainItemLocator = domainItemLocator;
        }

        public decimal Calculate(
            Reference<ICalculationNode> calculationNode)
        {
            var node = m_domainItemLocator.Get<ICalculationNode>(calculationNode.Id);
            dynamic d = node;
            return this.Evaluate(d);
        }

        private decimal Evaluate(INumberNode node)
        {
            return node.Value;
        }

        private decimal Evaluate(IMultiplyNode node)
        {
            return EvaluateLeft(node) * EvaluateRight(node);
        }

        private decimal Evaluate(IDivideNode node)
        {
            return EvaluateLeft(node) / EvaluateRight(node);
        }

        private decimal Evaluate(IAddNode node)
        {
            return EvaluateLeft(node) + EvaluateRight(node);
        }

        private decimal Evaluate(ISubtractNode node)
        {
            return EvaluateLeft(node) - EvaluateRight(node);
        }

        private dynamic EvaluateRight(IBinaryExpressionNode node)
        {
            var rightCalculation = node.RightCalculation.ToDomainItem(m_domainItemLocator);
            dynamic dr = rightCalculation;
            return Evaluate(dr);
        }

        private dynamic EvaluateLeft(IBinaryExpressionNode node)
        {
            var leftCalculation = node.LeftCalculation.ToDomainItem(m_domainItemLocator);
            dynamic dl = leftCalculation;
            return Evaluate(dl);
        }
    }
}