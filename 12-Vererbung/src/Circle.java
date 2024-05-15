public class Circle extends Shape {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        } else {
            double area;
            area = (radius * radius) * Math.PI;
            return area;
        }
    }

    @Override
    public double getPerimeter() {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        } else {
            double perimeter;
            perimeter = 2 * radius * Math.PI;
            return perimeter;
        }

    }
}
