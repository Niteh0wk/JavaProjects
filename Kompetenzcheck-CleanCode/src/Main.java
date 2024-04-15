import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input;

        System.out.println("Type in a word/sentence in CAPS:");
        input = sc.nextLine();

        for (int x = 0; x < input.length(); x++) {
            switch (input.charAt(x)) {
                case 'A':
                    System.out.print("@");
                    break;
                case 'B':
                    System.out.print("8");
                    break;
                case 'C':
                    System.out.print("(");
                    break;
                case 'E':
                    System.out.print("3");
                    break;
                case 'G':
                    System.out.print("6");
                    break;
                case 'H':
                    System.out.print("#");
                    break;
                case 'I':
                    System.out.print("!");
                    break;
                case 'L':
                    System.out.print("1");
                    break;
                case 'O':
                    System.out.print("0");
                    break;
                case 'S':
                    System.out.print("$");
                    break;
                case 'T':
                    System.out.print("7");
                    break;
                case 'Z':
                    System.out.print("2");
                    break;
                default:
                    System.out.print(input.charAt(x));
            }
        }
    }

}