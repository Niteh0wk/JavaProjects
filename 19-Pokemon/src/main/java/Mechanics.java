import java.util.List;

public class Mechanics {
    Attacks attack = new Attacks();
    Player player = new Player();
    Computer computer = new Computer();


    public void atk(int chosenAttack){
        int playerHealth;
        int computerHealth;
    }

    public void searchWithName(String name){
        Pokemons pokemons = new Pokemons();
        int temp = pokemons.getIndex(name);

        String pokemonName = pokemons.getName(temp);
        int atk = pokemons.getAtk(temp);
        int def = pokemons.getDef(temp);
        int speed = pokemons.getSpeed(temp);
        String type1 = pokemons.getType1(temp);
        String type2 = pokemons.getType2(temp);
        int healthPoints = pokemons.getHealthPoints(temp);

        player.setAtk(atk);
        player.setDef(def);
        player.setSpeed(speed);
        player.setHealthPoints(healthPoints);
    }

    public void searchWithIndex(int index){
        Pokemons pokemons = new Pokemons();

        String pokemonName = pokemons.getName(index);
        int atk = pokemons.getAtk(index);
        int def = pokemons.getDef(index);
        int speed = pokemons.getSpeed(index);
        String type1 = pokemons.getType1(index);
        String type2 = pokemons.getType2(index);
        int healthPoints = pokemons.getHealthPoints(index);

        player.setAtk(atk);
        player.setDef(def);
        player.setSpeed(speed);
        player.setHealthPoints(healthPoints);
    }
}
