﻿using System;
using QuestionnaireDomain.Entities.Ast.Nodes.Common;

namespace QlsTransformer.Domain.Ast.Nodes
{
    internal class StyleNode : AstNodeBase, IStyleNode
    {
        public StyleNode(
            Guid id,
            string definition,
            IWidget widget,
            int? width,
            string font,
            decimal? fontSize,
            string color) : base(id, definition)
        {
            Widget = widget;
            Width = width;
            Font = font;
            FontSize = fontSize;
            Color = color;
        }

        public IWidget Widget { get; }
        public int? Width { get; }
        public string Font { get; }
        public decimal? FontSize { get; }
        public string Color { get; }
    }
}