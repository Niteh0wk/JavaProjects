import java.util.Scanner;

public class SimpleCalculations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double firstNumber;
        double secondNumber;
        String line = "-";

        System.out.println("Type in the first Number:");

        while (!sc.hasNextDouble()) {
            System.out.println("Type in the first Number:");
            sc.nextLine();
        }
        firstNumber = sc.nextDouble();
        sc.nextLine();

        System.out.println("Type in the second Number");

        while (!sc.hasNextDouble()) {
            System.out.println("Type in the second Number:");
            sc.nextLine();
        }
        secondNumber = sc.nextDouble();

        System.out.println(line.repeat(30));

        System.out.printf(String.format("%.2f + %-7.2f = %8.2f \n", firstNumber, secondNumber, (firstNumber + secondNumber)));
        System.out.printf(String.format("%.2f - %-7.2f = %8.2f \n", firstNumber, secondNumber, (firstNumber - secondNumber)));
        System.out.printf(String.format("%.2f * %-7.2f = %8.2f \n", firstNumber, secondNumber, (firstNumber * secondNumber)));
        System.out.printf(String.format("%.2f / %-7.2f = %8.2f \n", firstNumber, secondNumber, (firstNumber / secondNumber)));

        System.out.println(line.repeat(30));
    }
}
