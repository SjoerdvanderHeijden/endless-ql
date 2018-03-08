﻿namespace QL.Core.Errors
{
    public class BinaryOpperator : Error
    {
        public string LeftType;
        public string RightType;
        public string Opperator;
        public int ErrorLine;

        public BinaryOpperator(string leftType, string rightType, string opperator, int errorLine)
        {
            LeftType = leftType;
            RightType = rightType;
            Opperator = opperator;
            ErrorLine = errorLine;
        }

        public override string ToString()
        {
            return $"Type error in line {ErrorLine}: \'{Opperator}\' cannot be applied to " +
                $"the combination of {LeftType} and {RightType}";
        }
    }
}