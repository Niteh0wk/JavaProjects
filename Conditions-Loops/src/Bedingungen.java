import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Bedingungen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;

        System.out.println("Gib deine Schulnote in numerischer Form(1-5) ein: ");
        input = sc.nextInt();

        switch (input) {
            case 1 -> System.out.println("Sehr gut");
            case 2 -> System.out.println("Gut");
            case 3 -> System.out.println("Befriedigend");
            case 4 -> System.out.println("Genügend");
            case 5 -> System.out.println("Nicht Genügend");
            default -> System.out.println("Ungültige Note!");
        }
    }
}
