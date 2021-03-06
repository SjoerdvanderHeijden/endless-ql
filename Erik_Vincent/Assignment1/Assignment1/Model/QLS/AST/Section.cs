﻿using System.Collections.Generic;
using System.Linq;

namespace Assignment1.Model.QLS.AST
{
    public class Section : Statement
    {
        public string Label { get; }
        public IReadOnlyCollection<Statement> Contents => _contents.AsReadOnly();

        private readonly List<Statement> _contents;

        public Section(int lineNumber, string label, IEnumerable<Statement> contents)
        {
            _lineNumber = lineNumber;
            Label = label;
            _contents = contents.ToList();
        }

        public override void Accept(IQLSASTVisitor visitor) => visitor.Visit(this);
    }
}
