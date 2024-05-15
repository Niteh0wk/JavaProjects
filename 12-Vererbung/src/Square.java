public class Square extends Shape {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        if (side <= 0) {
            throw new IllegalArgumentException();
        } else {
            double area;
            area = side * side;
            return area;
        }

    }

    @Override
    public double getPerimeter() {
        if (side <= 0) {
            throw new IllegalArgumentException();
        } else {
            double perimeter;
            perimeter = side * 4;
            return perimeter;
        }
    }
}
