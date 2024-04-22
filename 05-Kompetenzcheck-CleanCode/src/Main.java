import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input;

        System.out.println("Type in a word/sentence in CAPS:");
        input = sc.nextLine();

        for (int x = 0; x < input.length(); x++) {
            switch (input.charAt(x)) {
                case 'A' -> System.out.print("@");
                case 'B' -> System.out.print("8");
                case 'C' -> System.out.print("(");
                case 'E' -> System.out.print("3");
                case 'G' -> System.out.print("6");
                case 'H' -> System.out.print("#");
                case 'I' -> System.out.print("!");
                case 'L' -> System.out.print("1");
                case 'O' -> System.out.print("0");
                case 'S' -> System.out.print("$");
                case 'T' -> System.out.print("7");
                case 'Z' -> System.out.print("2");
                default -> System.out.print(input.charAt(x));
            }
        }
    }

}