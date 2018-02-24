package ql.value;

import ql.ast.type.Type;

public class Bool extends Value<Boolean> {

    private boolean value;
    
    public Bool() { 
        this.value = false;
    }
    
    public Bool(String value) { 
        this.value = Boolean.parseBoolean(value);
    }

    public Bool(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Boolean getValue() {
        return value;
    }
    
    @Override
    public void setValue(Boolean value) {
        this.value = value;
    }

    @Override
    public Type getType() {
        return new ql.ast.type.Bool();
    }
}