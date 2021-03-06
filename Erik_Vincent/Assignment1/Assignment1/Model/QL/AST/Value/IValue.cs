﻿using Assignment1.Model.QL.AST.Expression;

namespace Assignment1.Model.QL.AST.Value
{
    public interface IValue : IExpression
    {
        void Accept(IValueVisitor visitor);
        bool IsUndefined();
    }
}
