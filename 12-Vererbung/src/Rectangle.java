public class Rectangle extends Shape {
    private int width;
    private int length;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        if (width <= 0 || length <= 0) {
            throw new IllegalArgumentException();
        } else {
            double area;
            area = width * length;
            return area;
        }
    }

    @Override
    public double getPerimeter() {
        if (width <= 0 || length <= 0) {
            throw new IllegalArgumentException();
        } else {
            double perimeter;
            perimeter = (2 * width) + (2 * length);
            return perimeter;
        }
    }
}
