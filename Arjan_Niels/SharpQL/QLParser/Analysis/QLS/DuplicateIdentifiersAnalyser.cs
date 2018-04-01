﻿using QLParser.AST.QLS;
using System.Collections.Generic;
using System.Linq;

namespace QLParser.Analysis.QLS
{
    public class DuplicateIdentifiersAnalyser : IQLSAnalyser, IQLSVisitor
    {
        private IList<string> VisitedIDs;
        public DuplicateIdentifiersAnalyser()
        {
            this.VisitedIDs = new List<string>();
        }

        public bool Analyse(QLSNode node)
        {
            this.VisitedIDs.Clear();
            this.Visit(node);

            var isValid = true;
            foreach (var id in this.VisitedIDs.Distinct())
            {
                var idCount = this.VisitedIDs.Count(x => x == id);
                if (idCount > 1)
                {
                    isValid = false;
                    Analyser.AddMessage(string.Format("Duplicate key in QLS: {0}", id), MessageType.WARNING);
                }
            }

            return isValid;
        }

        public void Visit(QLSQuestionNode node)
        {
            this.VisitedIDs.Add(node.ID);

            VisitChildren(node);
        }

        public void Visit(QLSStructuralNode node)
        {
            VisitChildren(node);
        }

        public void Visit(QLSNode node)
        {
            VisitChildren(node);
        }

        private void VisitChildren(QLSNode node)
        {
            foreach (var child in node.Children)
                child.Accept(this);
        }
    }
}