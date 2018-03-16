package ql.ast.expression;

import ql.ast.expression.literal.Literal;
import ql.ast.expression.literal.UndefinedLiteral;
import ql.ast.type.Type;
import ql.ast.type.Undefined;
import ql.helpers.Observable;
import ql.helpers.Observer;
import ql.visitors.interfaces.ExpressionVisitor;

public class Identifier extends Expression implements Observable {
    
    private String name;
    private Type type;
    private Literal<?> value;
    
    public Identifier(String name) {
        this.name       = name;
        this.type       = new Undefined();
        this.value      = new UndefinedLiteral();
    }
    
    public Identifier(String name, Type type) {
        this.name       = name;
        this.type       = type;
        this.value      = new UndefinedLiteral();
    }
    
    public String getName() {
        return name;
    }
    
    public Literal<?> getValue() {
        return value;
    }
    
    public Type getType() {
        return type;
    }
    
    public void setValue(Literal<?> value) {
        
        if(!this.value.toString().equals(value.toString()))
        {
            this.value = type.parse(value);
            
            notifyObservers();
        }
    }
    
    public Identifier setType(Type type) {
        
        this.type = type;
        
        return this;
    }
    
    @Override
    public String toString() {
        return name;
    }

    @Override
    public <E> E accept(ExpressionVisitor<E> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public boolean isIdentifier() {
        return true;
    }
    
    public boolean equals(Identifier id) {
        return name.equals(id.getName());
    }

    @Override
    public Literal<?> evaluate() {
        return getValue();
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) o.update();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
}