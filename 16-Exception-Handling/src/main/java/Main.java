import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        UI ui = new UI();
        Scanner sc = new Scanner(System.in);
        String chooseMenuPoint;
        double a = 0;
        double b = 0;
        int c = 0;


        do {
            ui.menu();
            chooseMenuPoint = sc.next();

            switch (chooseMenuPoint) {
                case "1":
                    ui.addition(a, b, sc, calc);
                    break;

                case "2":
                    ui.subtraction(a, b, sc, calc);
                    break;

                case "3":
                    ui.multiplication(a, b, sc, calc);
                    break;

                case "4":
                    ui.division(a, b, sc, calc);
                    break;

                case "5":
                    ui.squareRoot(a, sc, calc);
                    break;

                case "6":
                    ui.power(a, c, sc, calc);
                    break;
            }
        } while (!chooseMenuPoint.equals(":q!"));


    }
}

