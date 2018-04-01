﻿using QlsTransformer.Domain.Ast.Nodes;

namespace QlsTransformer.Domain.Output.Tools
{
    internal class StyleFactory : IStyleFactory
    {
        private Style CreateBaseStyle()
        {
            return new Style(
                new AstTextBox(),
                100,
                "Arial",
                10m,
                "#FF000000");
        }

        public Style CreateIntegerBaseStyle()
        {
            return new Style(
                CreateBaseStyle(),
                widget: new AstSpinBox());
        }

        public Style CreateDecimalBaseStyle()
        {
            return new Style(CreateBaseStyle());
        }

        public Style CreateDateBaseStyle()
        {
            return new Style(
                CreateBaseStyle(),
                widget: new AstDatePicker());
        }

        public Style CreateStringBaseStyle()
        {
            return new Style(CreateBaseStyle());
        }

        public Style CreateBoolBaseStyle()
        {
            return new Style(
                CreateBaseStyle(),
                widget: new AstCheckBox());
        }

        public Style CreateMergedStyle(Style originalStyle, IStyleNode newStyle)
        {
            if (newStyle == null)
            {
                return originalStyle;
            }

            return new Style(
                originalStyle,
                newStyle.Widget,
                newStyle.Width,
                newStyle.Font,
                newStyle.FontSize,
                newStyle.Color);
        }
    }
}