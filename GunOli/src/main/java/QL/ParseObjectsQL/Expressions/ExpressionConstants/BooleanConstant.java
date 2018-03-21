package QL.ParseObjectsQL.Expressions.ExpressionConstants;

import QL.ParseObjectsQL.Expressions.EvaluationType;

public class BooleanConstant extends Constant<Boolean> {
    public BooleanConstant(Boolean value) { super(value == null ? false : value); }

    public EvaluationType returnType(){
        return EvaluationType.Boolean;
    }


    @Override
    public Boolean isLogical(){
        return true;
    }

    @Override
    public String toString(){
        return Boolean.toString(this.getValue());
    }
}
