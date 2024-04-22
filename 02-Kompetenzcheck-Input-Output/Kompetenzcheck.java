import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String text = " Hello World ";
        double number;

        System.out.println(text + " " + text.length());

        System.out.println(text.toUpperCase());
        System.out.println(text.toLowerCase());
        System.out.println(text.replace("World", "CODERS.BAY"));
        System.out.println(text.trim());

        number = sc.nextDouble();

        int value = (int)Math.round(number);
        System.out.println(value);

        System.out.printf(String.format("%.2f",number));


        System.out.printf(String.format("\n%13.2f",number));
    }
}