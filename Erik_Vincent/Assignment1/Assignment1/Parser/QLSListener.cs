﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using Assignment1.Model.QLS;
using Assignment1.Model.QLS.AST;

namespace Assignment1.Parser
{
    internal class QLSListener : QLSBaseListener
    {
        private StyleSheet _styleSheet;

        public override void ExitStylesheet(QLS.StylesheetContext context)
        {
            _styleSheet = context.result;
        }

        internal static StyleSheet ParseString(string input)
        {
            QLSListener listener = new QLSListener();
            ICharStream stream = CharStreams.fromstring(input);
            ITokenSource lexer = new QLSLexer(stream);
            ITokenStream tokens = new CommonTokenStream(lexer);
            QLS parser = new QLS(tokens);
            QLS.StylesheetContext context = parser.stylesheet();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.Walk(listener, context);
            return listener._styleSheet;
        }
    }
}
