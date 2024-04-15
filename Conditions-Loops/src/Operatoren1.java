import java.util.Scanner;

public class Operatoren1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;
        int luckyNumber = 26;
        boolean roundNumber = false;
        boolean evenNumber = false;
        boolean sameAsLuckyNumber = false;
        boolean twoDigits = false;

        System.out.println("Input a number here:");
        input = sc.nextInt();

        if (input % 10 == 0)
            roundNumber = true;
        if (input % 2 == 0)
            evenNumber = true;
        if (input == luckyNumber)
            sameAsLuckyNumber = true;
        if (input > 9)
            twoDigits = true;

        System.out.println("Round Number: " + roundNumber);
        System.out.println("Even Number: " + evenNumber);
        System.out.println("Same as Lucky Number: " + sameAsLuckyNumber);
        System.out.println("Has over 1 digit: " + twoDigits);
    }
}
