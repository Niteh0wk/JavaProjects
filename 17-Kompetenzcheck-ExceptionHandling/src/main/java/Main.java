import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menuChooser;
        UI ui = new UI();

        do {
            ui.menu();
            menuChooser = sc.next();

            switch (menuChooser){
                case "1":
                    ui.createSimple();
                    break;
                case "2":
                    ui.createAdvanced();
                    break;
                case "3":
                    ui.createFull();
                    break;
                case "4":
                    ui.listPersons();
                    break;
                case "5":
                    ui.getPerson();
                    break;
                case "6":
                    ui.removePerson();
                    break;
            }
        }while (!menuChooser.equals("X"));
    }
}