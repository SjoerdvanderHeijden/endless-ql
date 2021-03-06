using Assignment1.Model.QL.AST;

namespace Assignment1.Model.QLS.AST.Style
{
    public class FontSize : ASTNode, IStyle
    {
        public int Value { get; }

        public FontSize(int lineNumber, int value)
        {
            _lineNumber = lineNumber;
            Value = value;
        }

        public void Accept(IStyleVisitor visitor) => visitor.Visit(this);
    }
}
