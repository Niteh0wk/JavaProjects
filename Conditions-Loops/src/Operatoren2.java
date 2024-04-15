import java.time.LocalTime;
import java.util.Scanner;

public class Operatoren2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalTime input;
        LocalTime dayStart = LocalTime.of(8, 30);
        LocalTime dayEnd = LocalTime.of(15, 30);

        System.out.println("Type in a number(hour) to know if its work/freetime:");
        input = LocalTime.parse(sc.next());

        if (input.isAfter(dayStart) && input.isBefore(dayEnd)){
            System.out.println("Work Time");
        }else {
            System.out.println("Free Time");
        }

    }
}
