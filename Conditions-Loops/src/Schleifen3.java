import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.Random;
import java.util.Scanner;

public class Schleifen3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int offset;

        String input;
        String result = "";

        System.out.println("Gib ein wort/satz ein der verschlüsselt werden soll:");
        input = sc.nextLine();

        offset = r.nextInt(1,26);

        for (int y = 0; y < input.length(); y++) {
            char c = input.charAt(y);
            if (c >= 'A' && c <= 'Z') {
                c = (char) ((input.charAt(y) + offset));
                if (c > 'Z') {
                    c -= 26;
                }
            }else if (c >= 'a' && c <= 'z'){
                c = (char) ((input.charAt(y) + offset));
                if (c > 'z'){
                    c -= 26;
                }
            }
            result += c;
        }

        System.out.println(result);
    }
}
