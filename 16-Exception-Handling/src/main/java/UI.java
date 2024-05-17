import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    public void addition(double a, double b, Scanner sc, Calculator calc) {
        while (true) {
            try {
                System.out.print("First Number: ");
                a = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                sc.next();
            }
        }

        while (true) {
            try {
                System.out.print("Second Number: ");
                b = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                sc.next();
            }
        }

        try {
            calc.add(a, b);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void subtraction(double a, double b, Scanner sc, Calculator calc) {
        while (true) {
            try {
                System.out.print("First Number: ");
                a = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                sc.next();
            }
        }

        while (true) {
            try {
                System.out.print("Second Number: ");
                b = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                sc.next();
            }
        }

        try {
            calc.subtract(a, b);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void multiplication(double a, double b, Scanner sc, Calculator calc) {
        while (true) {
            try {
                System.out.print("First Number: ");
                a = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                sc.next();
            }
        }

        while (true) {
            try {
                System.out.print("Second Number: ");
                b = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                sc.next();
            }
        }

        try {
            calc.multiply(a, b);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void division(double a, double b, Scanner sc, Calculator calc) {
        while (true) {
            try {
                System.out.print("First Number: ");
                a = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                sc.next();
            }
        }

        while (true) {
            try {
                System.out.print("Second Number: ");
                b = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                sc.next();
            }
        }

        try {
            calc.divide(a, b);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    public void squareRoot(double a, Scanner sc, Calculator calc) {
        while (true) {
            try {
                System.out.print("Square Root of: ");
                a = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                sc.next();
            }
        }

        try {
            calc.squareRoot(a);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void power(double a, int c, Scanner sc, Calculator calc) {
        while (true) {
            try {
                System.out.print("Number: ");
                a = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                sc.next(); // Clear the invalid input
            }
        }

        while (true) {
            try {
                System.out.print("To the power of: ");
                c = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next(); // Clear the invalid input
            }
        }

        try {
            calc.power(a, c);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void menu() {
        System.out.println("What calculation do you want to make?");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Square Root");
        System.out.println("6. Power");
        System.out.println("Type ':q!' to exit");
    }
}
