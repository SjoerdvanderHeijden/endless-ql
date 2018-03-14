﻿using System;
using System.Collections.Generic;
using System.Linq;
using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using Assignment1.Model;
using Assignment1.Parser;

namespace Assignment1
{
    internal class QLListener : QLBaseListener
    {
        private QuestionForm _form;
        private readonly Dictionary<string, Question> _questions = new Dictionary<string, Question>();
        private readonly Dictionary<string,string> _warnings = new Dictionary<string, string>();
        private QLParseErrorHandler _errorHandler = new QLParseErrorHandler();

        private bool QuestionIdExists(string questionId)
        {
            return _questions.ContainsKey(questionId);
        }

        private bool QuestionLabelExists(string questionLabel)
        {
            List<Question> questionList = _questions.Values.ToList();
            foreach (Question questionItem in questionList)
            {
                if (questionItem.Label.Equals(questionLabel))
                    return true;
            }
            return false;
        }

        private void AddWarning(ParserRuleContext context, string questionId, string message)
        {
            _warnings.Add(questionId, "Line " + context.Start.Line + ": " + message);
        }

        public override void ExitForm(QL.FormContext context)
        {
            foreach (string warning in _warnings.Values)
            {
                Console.WriteLine(warning);
            }
            _form = context.result;
            _form.Warnings = _warnings;
        }

        /* Check for each question if the label is already used and add a warning if this is the case.
         */
        public override void EnterQuestion(QL.QuestionContext context)
        {
            string questionLabel = context.result.Label;
            string questionId = context.result.Id;

            if (QuestionLabelExists(questionLabel))
            {
                AddWarning(context, questionId, "The question label '" + questionLabel + "' has already been used.");
            }
        }

        /* Check for each question if the id already exists and add an error if this is the case.
         */
        public override void ExitQuestion(QL.QuestionContext context)
        {
            string questionId = context.result.Id;

            if (QuestionIdExists(questionId))
            {
                _errorHandler.AddError(context.Start.Line, "The question id '" + questionId + "' already exists in the current context.");
            }
            else
            {
                _questions.Add(context.result.Id, context.result);
            }
        }

        /* Check for each if statement if the expression in the condition is of type boolean.
         */
        public override void ExitIfstatement(QL.IfstatementContext context)
        {
            object conditionType = context._expression.result.Evaluate();
            if (!(conditionType is bool))
            {
                _errorHandler.AddError(context.Start.Line, "The expression '" + context._expression.GetText() + "' is not of type boolean.");
            }
        }

        /* Check for each expression if the left and right operands are of the correct type.
         * For example, for an arithmetic expression the left and right operands should be numeric.
         */
        public override void ExitExpression(QL.ExpressionContext context)
        {
            Expression expression = context.result;
            try
            {
                var expressionType = expression.Evaluate();
            }
            catch (Exception exception)
            {
                _errorHandler.AddError(context.Start.Line, exception.Message);
            }
        }

        /* Check for each expressionId if the referenced questionId exists. Adds an error message
         * if this is not the case.
         */
        public override void ExitExpressionId(QL.ExpressionIdContext context)
        {
            try
            {
                context.result.Question = _questions[context.result.Id];
            }
            catch (KeyNotFoundException)
            {
                _errorHandler.AddError(context.Start.Line, "The question id '" + context.result.Id + "' does not exist in the current context.");
            }
        }

        public override void VisitErrorNode(IErrorNode node)
        {
            Console.WriteLine("Error node: " + node.GetText());
        }

        internal static QuestionForm ParseString(string input)
        {
            QLListener listener = new QLListener();
            QLErrorListener errorListener = new QLErrorListener(listener._errorHandler);

            ICharStream stream = CharStreams.fromstring(input);
            ITokenSource lexer = new QLLexer(stream);
            ((QLLexer)lexer).RemoveErrorListeners();
            ((QLLexer)lexer).AddErrorListener(errorListener);
            ITokenStream tokens = new CommonTokenStream(lexer);
            QL parser = new QL(tokens);
            parser.RemoveErrorListeners();
            parser.AddErrorListener(errorListener);
            QL.FormContext context = parser.form();
            
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.Walk(listener, context);

            if (listener._errorHandler.FormHasErrors)
                listener._errorHandler.ThrowQLParseException();
            return listener._form;
        }
    }
}
