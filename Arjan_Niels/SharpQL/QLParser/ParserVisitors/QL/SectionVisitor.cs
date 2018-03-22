﻿using Antlr4.Runtime.Misc;
using QLParser.AST.QL;
using System;
using static QLGrammar.QLGrammarParser;

namespace QLParser.ParserVisitors.QL
{
    public class SectionVisitor : QLGrammar.QLGrammarBaseVisitor<QLNode>
    {
        public override QLNode VisitSection([NotNull] SectionContext context)
        {
            // If the Section is a Question, process it.
            var questionContext = context.question();
            if (questionContext != null)
            {
                var questionVisitor = new QuestionVisitor();
                return questionVisitor.VisitQuestion(questionContext);
            }

            // If it isn't a Question it is most likely to be a ConditionalBlock.
            var conditionalContext = context.conditionalBlock();
            if (conditionalContext != null)
            {
                var conditionalBlockVisitor = new ConditionalBlockVisitor();
                return conditionalBlockVisitor.VisitConditionalBlock(conditionalContext);
            }

            var computedVariableContext = context.computedVariable();
            if (computedVariableContext != null)
            {
                var computedVisitor = new ComputedVariableVisitor();
                return computedVisitor.VisitComputedVariable(computedVariableContext);
            }

            //If it manages to reach this line; throw an exception, because it should not be possible.
            throw new InvalidOperationException("We don't know how to process this section.");
        }
    }
}