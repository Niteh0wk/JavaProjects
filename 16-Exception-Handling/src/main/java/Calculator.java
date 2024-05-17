public class Calculator {

    public void add(double a, double b) {
        double result;
        result = a + b;
        System.out.println("Result: " + result + "\n");
    }

    public void subtract(double a, double b) {

        double result;
        result = a - b;
        System.out.println("Result: " + result + "\n");

    }

    public void multiply(double a, double b) {

        double result;
        result = a * b;
        System.out.println("Result: " + result + "\n");

    }

    public void divide(double a, double b) {
        double result;
        result = a / b;
        System.out.println("Result: " + result + "\n");

    }

    public void squareRoot(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Invalid Number");
        } else {
            double result;
            result = Math.sqrt(a);
            System.out.println("Result: " + result + "\n");
        }
    }

    public void power(double a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Invalid Number");
        } else {
            double result = Math.pow(a, b);
            System.out.println("Result: " + result + "\n");
        }
    }
}
