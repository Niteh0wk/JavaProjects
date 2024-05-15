import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Circle c1 = new Circle();
        Rectangle r1 = new Rectangle();
        Square s1 = new Square();

        System.out.println("Type in a radius to make calculations of a Circle:");
        System.out.print("Radius: "); c1.setRadius(sc.nextInt());
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());

        System.out.println("Type in the width and length to make calculations of a Rectangle:");
        System.out.print("Width: "); r1.setWidth(sc.nextInt());
        System.out.print("Length: "); r1.setLength(sc.nextInt());
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());

        System.out.println("Type in a side-length to make calculations of a Square: ");
        System.out.print("Side: "); s1.setSide(sc.nextInt());
        System.out.println("Area: " + s1.getArea());
        System.out.println("Perimeter: " + s1.getPerimeter());
    }
}
