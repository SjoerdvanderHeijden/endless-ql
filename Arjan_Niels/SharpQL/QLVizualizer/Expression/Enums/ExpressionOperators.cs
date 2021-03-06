﻿namespace QLVisualizer.Expression.Enums
{
    /// <summary>
    /// Static class containing default ExpressionOperator collections
    /// </summary>
    public static class ExpressionOperators
    {
        /// <summary>
        /// All ExpressionOperators that can be executed on logical statements
        /// </summary>
        public readonly static ExpressionOperator[] Logical = new ExpressionOperator[]
        {
            ExpressionOperator.And,
            ExpressionOperator.Or,
            ExpressionOperator.Equals
        };


        /// <summary>
        /// All ExpressionOperators that can be used for comparison
        /// </summary>
        public readonly static ExpressionOperator[] Comparison = new ExpressionOperator[]
        {
            ExpressionOperator.Equals,
            ExpressionOperator.GreaterEquals,
            ExpressionOperator.LessEquals,
            ExpressionOperator.GreaterThan,
            ExpressionOperator.LessThan
        };

        /// <summary>
        /// All ExpressionOperators that can be used for numeric statements
        /// </summary>
        public readonly static ExpressionOperator[] Numeric = new ExpressionOperator[]
        {
            ExpressionOperator.Equals,
            ExpressionOperator.GreaterEquals,
            ExpressionOperator.LessEquals,
            ExpressionOperator.GreaterThan,
            ExpressionOperator.LessThan,
            ExpressionOperator.Plus,
            ExpressionOperator.Minus,
            ExpressionOperator.Multiply,
            ExpressionOperator.Divide
        };

    }
}
