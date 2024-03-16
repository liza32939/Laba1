package Task3;

class TestClass {
    // Перевантажений метод myMethod
    public double myMethod(double a) {
        return Math.exp(-Math.abs(a)) * Math.sin(a);
    }

    public double myMethod(double a, int x) {
        return Math.exp(-Math.abs(a) * x) * Math.sin(x);
    }
}
