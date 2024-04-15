import java.util.ArrayList;
import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        String input;

        System.out.println("Type in a number('q' for stop):");
        do {
            input = sc.next();
            if (!input.equals("q")) {
                numbers.add(Integer.parseInt(input));
                System.out.println("Type in another number('q' for stop):");
            }
        } while (!input.equals("q"));

        int temp = 0;
        for (int x = 0; x < numbers.size(); x++){
            if (temp < numbers.get(x)){
                temp = numbers.get(x);
            }
        }

        System.out.println();
        System.out.println("The largest number was: " + temp);
    }
}
