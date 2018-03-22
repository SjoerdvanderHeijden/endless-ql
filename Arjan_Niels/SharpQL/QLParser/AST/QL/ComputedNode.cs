﻿using QLParser.AST;

namespace QLParser.AST.QL
{
    public class ComputedNode : QLNode
    {
        public string ID { get; private set; }
        public string Text { get; private set; }
        public QValueType ValueType { get; private set; }
        public IExpressionNode Expression { get; private set; }

        public ComputedNode(Location location, string id, string text, QValueType valueType, IExpressionNode expression) : base(location, NodeType.COMPUTED)
        {
            this.ID = id;
            this.Text = text;
            this.ValueType = valueType;
            this.Expression = expression;
        }

        public override string ToString()
        {
            return string.Format("{0}\tID: {1}\t\t{2}\t\t{3}", base.ToString(), ID, Text, Expression);
        }
    }
}
