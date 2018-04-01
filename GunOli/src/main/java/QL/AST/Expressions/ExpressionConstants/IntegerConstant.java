package QL.AST.Expressions.ExpressionConstants;

import QL.Analysis.ExpressionVisitorInterface;
import QL.AST.Expressions.Constant;
import QL.Analysis.EvaluationType;

public class IntegerConstant extends Constant<Integer> {
    public IntegerConstant(Integer value, int line){
        super(value == null ? 0 : value, line);
    }


    public EvaluationType returnType(){
        return EvaluationType.Integer;
    }

    @Override
    public Boolean isArithmetic(){
        return true;
    }

    @Override
    public String toString(){
        return Integer.toString(this.getValue());
    }

    @Override
    public <T> T accept(ExpressionVisitorInterface<T> visitor){
        return visitor.visit(this);
    }
}