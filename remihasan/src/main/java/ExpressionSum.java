public class ExpressionSum extends Expression<Double> {

    private final Expression left;
    private final Expression right;

    ExpressionSum(Expression left, Expression right){
        System.out.println("DEBUGSET: " + left + " " + right);
        this.left = left;
        this.right = right;
    }

    @Override
    public Double evaluate() {
        if(isEvaluable()){
            return (double)left.evaluate() + (double)right.evaluate();
        }
        return null;
    }

    @Override
    public boolean isEvaluable() {
        return left.isEvaluable() && right.isEvaluable();
    }

    @Override
    public String toString() {
        System.out.println("DEBUGSUM: " + left + " " + right);
        return this.left.toString() + " + " + this.right.toString();
    }

}