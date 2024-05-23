import java.io.IOException;
import java.util.Random;

public class Game {
    private Pokemon player, pc;
    PokemonReader pokemonReader;
    AttacksReader attacksReader;
    Attack playerAtk1;
    Attack playerAtk2;
    Attack computerAtk1;
    Attack computerAtk2;

    public Game() {
        pokemonReader = new PokemonReader();
        attacksReader = new AttacksReader();
    }

    public void setUp() throws IOException {
        pokemonReader.createPokemonsFromCSV();
        attacksReader.createAttacksFromCSV();
    }

    public Pokemon choosePokemonWithName(String name) {
        return pokemonReader.getPokemonWithName(name);
    }

    public Pokemon choosePokemonWithId(int id) {
        return pokemonReader.getPokemonWithId(id);
    }

    public void playerSetAttack() {
        Random r = new Random();
        playerAtk1 = attacksReader.getAttack(r.nextInt(217));
        playerAtk2 = attacksReader.getAttack(r.nextInt(217));
    }

    public void computerSetAttack() {
        Random r = new Random();
        int id = r.nextInt(217);
        computerAtk1 = attacksReader.getAttack(id);
        id = r.nextInt(217);
        computerAtk2 = attacksReader.getAttack(id);
    }

    public void startBattle() {
        //TODO
    }
}
