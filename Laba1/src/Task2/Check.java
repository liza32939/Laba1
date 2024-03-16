package Task2;

import java.util.Random;

public class Check {
    private double x;
    private double y;

    public Check(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double Dist() {
        return Math.sqrt(x * x + y * y);
    }

    public void setRandomData() {
        Random random = new Random();
        x = random.nextDouble() * 100;
        y = random.nextDouble() * 100;
    }

    public void setData(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }
}
