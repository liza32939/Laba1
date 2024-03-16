package Task5;

class Function1 implements Evaluatable {
    @Override
    public double eval(double x) {
        return Math.exp(-Math.abs(2.5 * x)) * Math.sin(x);
    }
}
