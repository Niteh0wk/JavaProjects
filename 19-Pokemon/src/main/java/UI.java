import java.io.IOException;
import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        String chooser;

        do {
            System.out.println("How would you like to choose your Pokemon?");
            System.out.println("1. Id");
            System.out.println("2. Name");
            System.out.println("'X' to quit");
            chooser = sc.next();

            if (!chooser.equals("X")){
                try {
                    game.setUp();
                }catch (IOException e){
                    e.getCause();
                }

                switch (chooser){
                    case "1":
                        System.out.print("Type in the id: ");
                        game.choosePokemonWithId(sc.nextInt());
                        break;
                    case "2":
                        System.out.print("Type in the name: ");
                        game.choosePokemonWithName(sc.next());
                        break;
                }
                game.startBattle(sc);
            }
        }while (!chooser.equals("X"));
    }
}
