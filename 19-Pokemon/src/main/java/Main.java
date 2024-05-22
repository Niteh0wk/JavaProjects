import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();

        game.setUp(); // initialize Pokedex
        game.choosePokemon(); // choosePokemon
        game.startBattle(); // fight
    }
}
