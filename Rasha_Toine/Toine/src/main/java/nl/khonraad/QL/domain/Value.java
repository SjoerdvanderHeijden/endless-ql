package nl.khonraad.QL.domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public final class Value {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT    = new SimpleDateFormat( "dd/MM/yyyy" );
    private static final long             MILLISECONDS_IN_A_DAY = 24 * 60 * 60 * 1000L;

    public static final Value             FALSE                 = new Value( Type.Boolean, "False" );
    public static final Value             TRUE                  = new Value( Type.Boolean, "True" );
    public static final Value             EPOCH                 = new Value( Type.Date, "01/01/1970" );

    public static final Value             INITIAL_BOOLEAN       = FALSE;
    public static final Value             INITIAL_DATE          = EPOCH;
    public static final Value             INITIAL_INTEGER       = new Value( Type.Integer, "0" );
    public static final Value             INITIAL_MONEY         = new Value( Type.Money, "0.00" );
    public static final Value             INITIAL_STRING        = new Value( Type.String, "" );

    private Type                          type;
    private String                        text;

    public Value(Type type, String string) {

        this.type = type;
        this.text = string;
    }

    private Value(boolean condition) {

        this( Type.Boolean, condition ? TRUE.getText() : FALSE.getText() );
    }

    public Value apply( String operator ) {

        switch ( operator ) {

            case "+":
                return this;

            case "-":
                return apply( "*", new Value( Type.Integer, "-1" ) );

            case "!":
                return not( this );
        }
        throw new RuntimeException(
                "Check Antlr grammar. Unknow unary operator defined there, not implemented here: " + operator );
    }

    public Value apply( String operator, Value rightOperand ) {

        switch ( operator ) {

            case "*":
                return this.multiplied_by( rightOperand );

            case "/":
                return this.divided_by( rightOperand );

            case "+":
                return this.added_with( rightOperand );

            case "-":
                return this.subtracted_with( rightOperand );

            case "&&":
                return this.conjuncted_with( rightOperand );

            case "||":
                return this.disjuncted_with( rightOperand );

            case "==":
                return this.compared_with( rightOperand );

            case "<=":
                return this.isLowerThenOrEqualTo( rightOperand );

            case ">=":
                return this.isGreaterThenOrEqualTo( rightOperand );

            case "<":
                return this.isLowerThen( rightOperand );

            case ">":
                return this.isGreaterThen( rightOperand );
        }
        throw new RuntimeException( "Check Antlr grammar. Operator defined there, not implemented here: " + operator );
    }

    public Type getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    private Value not( Value value ) {
        return new Value( !TRUE.equals( value ) );
    }

    private Value conjuncted_with( Value rightOperand ) {

        Type type_right = rightOperand.getType();
        Type type_left = this.getType();

        switch ( type_left + " && " + type_right ) {

            case "Boolean && Boolean":
                return booleanAndboolean( this, rightOperand );
        }
        throw new RuntimeException( "Check Antlr grammar. Operation impossible" );
    }

    private Value disjuncted_with( Value rightOperand ) {

        Type type_right = rightOperand.getType();
        Type type_left = this.getType();

        switch ( type_left + " || " + type_right ) {

            case "Boolean || Boolean":

                // use the Morgan's Theorem
                return not( booleanAndboolean( not( this ), not( rightOperand ) ) );
        }
        throw new RuntimeException( "Check Antlr grammar. Operation impossible" );
    }

    private Value isLowerThen( Value rightOperand ) {

        Type type_right = rightOperand.getType();
        Type type_left = this.getType();

        String text_left = this.getText();
        String text_right = rightOperand.getText();

        switch ( type_left + " < " + type_right ) {

            case "Date < Date":
                return new Value( toDate( text_left ).before( toDate( text_right ) ) );

            case "Integer < Integer":
                return new Value( Integer.parseInt( text_left ) < Integer.parseInt( text_right ) );

            case "Money < Money":
                return new Value( new BigDecimal( text_left ).compareTo( new BigDecimal( text_right ) ) == -1 );

            case "String < String":
                return new Value( text_left.compareTo( text_right ) == -1 );

        }
        throw new RuntimeException( "Check Antlr grammar. Operation impossible" );
    }

    private Value isLowerThenOrEqualTo( Value rightOperand ) {

        Type type_right = rightOperand.getType();
        Type type_left = this.getType();

        String text_left = this.getText();
        String text_right = rightOperand.getText();

        switch ( type_left + " <= " + type_right ) {

            case "Date <= Date":
                return new Value( (toDate( text_left ).before( toDate( text_right ) )
                        || (toDate( text_left ).equals( toDate( text_right ) ))) );

            case "Integer <= Integer":
                return new Value( (Integer.parseInt( text_left ) <= Integer.parseInt( text_right )) );

            case "Money <= Money":
                return new Value( new BigDecimal( text_left ).compareTo( new BigDecimal( text_right ) ) != -1 );

            case "String <= String":
                return new Value( text_left.compareTo( text_right ) != 1 );

        }
        throw new RuntimeException( "Check Antlr grammar. Operation impossible" );
    }

    private Value compared_with( Value rightOperand ) {

        Type type_right = rightOperand.getType();
        Type type_left = this.getType();

        String text_left = this.getText();
        String text_right = rightOperand.getText();

        switch ( type_left + " == " + type_right ) {

            case "Boolean == Boolean":
            case "Date == Date":
            case "Integer == Integer":
            case "Money == Money":
            case "String == String":
                return new Value( this.equals( rightOperand ) );

        }
        throw new RuntimeException( "Check Antlr grammar. Operation impossible " + type_right + " " + type_left + " "
                + text_left + " " + text_right + " " );
    }

    private Value isGreaterThen( Value rightOperand ) {

        Type type_right = rightOperand.getType();
        Type type_left = this.getType();

        String text_left = this.getText();
        String text_right = rightOperand.getText();

        switch ( type_left + " > " + type_right ) {

            case "Date > Date":
                return new Value( toDate( text_left ).after( toDate( text_right ) ) );

            case "Integer > Integer":
                return new Value( (Integer.parseInt( text_left ) > Integer.parseInt( text_right )) );

            case "Money > Money":
                return new Value( new BigDecimal( text_left ).compareTo( new BigDecimal( text_right ) ) == 1 );

            case "String > String":
                return new Value( text_left.compareTo( text_right ) == 1 );

        }
        throw new RuntimeException( "Check Antlr grammar. Operation impossible" );
    }

    private Value isGreaterThenOrEqualTo( Value rightOperand ) {

        Type type_right = rightOperand.getType();
        Type type_left = this.getType();

        String text_left = this.getText();
        String text_right = rightOperand.getText();

        switch ( type_left + " >= " + type_right ) {

            case "Date >= Date":
                return new Value( (toDate( text_left ).after( toDate( text_right ) )
                        || (toDate( text_left ).equals( toDate( text_right ) ))) );

            case "Integer >= Integer":
                return new Value( (Integer.parseInt( text_left ) >= Integer.parseInt( text_right )) );

            case "Money >= Money":
                return new Value( new BigDecimal( text_left ).compareTo( new BigDecimal( text_right ) ) != -1 );

            case "String >= String":
                return new Value( text_left.compareTo( text_right ) != -1 );

        }
        throw new RuntimeException( "Check Antlr grammar. Operation impossible" );
    }

    private Value multiplied_by( Value rightOperand ) {

        Type type_right = rightOperand.getType();
        Type type_left = this.getType();
        String text_left = this.getText();
        String text_right = rightOperand.getText();

        switch ( type_left + " * " + type_right ) {

            case "Integer * Integer":
                return new Value( Type.Integer,
                        Integer.toString( Integer.parseInt( text_left ) * Integer.parseInt( text_right ) ) );

            case "Integer * Money":
                return new Value( Type.Money,
                        new BigDecimal( text_right ).multiply( new BigDecimal( text_left ) ).toString() );

            case "Money * Integer":
                return new Value( Type.Money,
                        new BigDecimal( text_left ).multiply( new BigDecimal( text_right ) ).toString() );

        }
        throw new RuntimeException( "Check Antlr grammar. Operation impossible" );
    }

    private Value divided_by( Value rightOperand ) {

        Type type_right = rightOperand.getType();
        Type type_left = this.getType();
        String text_left = this.getText();
        String text_right = rightOperand.getText();

        switch ( type_left + " / " + type_right ) {

            case "Integer / Integer":
                return new Value( Type.Integer,
                        Integer.toString( (Integer.parseInt( text_left ) / Integer.parseInt( text_right )) ) );

            case "Money / Integer":
                return new Value( Type.Money,
                        Double.toString(
                                (new BigDecimal( text_left ).divide( new BigDecimal( Integer.parseInt( text_right ) ) ))
                                        .doubleValue() ) );

        }
        throw new RuntimeException( "Check Antlr grammar. Operation impossible" );
    }

    private Value added_with( Value rightOperand ) {

        Type type_right = rightOperand.getType();
        Type type_left = this.getType();

        String text_left = this.getText();
        String text_right = rightOperand.getText();

        switch ( type_left + " + " + type_right ) {

            case "Date + Integer":
                return new Value( Type.Date, dateToString(
                        new Date( dateStringToLong( text_left ) + MILLISECONDS_IN_A_DAY * new Long( text_right ) ) ) );

            case "Integer + Integer":
                return new Value( Type.Integer,
                        Integer.toString( (Integer.parseInt( text_left ) + Integer.parseInt( text_right )) ) );

            case "Money + Money":
                return new Value( Type.Money, "" + new BigDecimal( text_left ).add( new BigDecimal( text_right ) ) );

            case "String + Integer":
            case "String + Money":
            case "String + String":
                return new Value( Type.String, text_left + text_right );

        }
        throw new RuntimeException( "Check Antlr grammar. Operation impossible" );

    }

    private Value subtracted_with( Value rightOperand ) {

        Type type_right = rightOperand.getType();
        Type type_left = this.getType();

        String text_left = this.getText();
        String text_right = rightOperand.getText();

        switch ( type_left + " - " + type_right ) {

            case "Date - Integer":
                return new Value( Type.Date, dateToString(
                        new Date( dateStringToLong( text_left ) - 24 * 60 * 60 * 1000 * new Long( text_right ) ) ) );

            case "Integer - Integer":
                return new Value( Type.Integer,
                        Integer.toString( (Integer.parseInt( text_left ) - Integer.parseInt( text_right )) ) );

            case "Money - Money":
                return new Value( Type.Money, Double.toString(
                        new BigDecimal( text_left ).subtract( new BigDecimal( text_right ) ).doubleValue() ) );
        }
        throw new RuntimeException( "Check Antlr grammar. Operation impossible" );
    }

    private Value booleanAndboolean( Value left, Value right ) {

        return new Value( TRUE.equals( left ) && TRUE.equals( right ) );
    }

    private Date toDate( String text ) {

        return new Date( dateStringToLong( text ) );
    }

    private long dateStringToLong( String text_left ) {

        try {
            return SIMPLE_DATE_FORMAT.parse( text_left ).getTime();
        } catch (ParseException e) {
            throw new RuntimeException( e );
        }
    }

    private String dateToString( Date d ) {

        return SIMPLE_DATE_FORMAT.format( d );
    }

    @Override
    public String toString() {

        return new ToStringBuilder( this, ToStringStyle.MULTI_LINE_STYLE ).append( "type", type ).append( "text", text )
                .toString();
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Value other = (Value) obj;
        if ( text == null ) {
            if ( other.text != null )
                return false;
        } else if ( !text.equals( other.text ) )
            return false;
        if ( type != other.type )
            return false;
        return true;
    }

}