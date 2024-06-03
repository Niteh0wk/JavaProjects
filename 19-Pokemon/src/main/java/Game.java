import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
/* 151 Pokemons, 217 Attacks */

public class Game {
    private Pokemon player;
    private Pokemon computer;
    private PokemonReader pokemonReader;
    private AttacksReader attackReader;
    private Random r = new Random();
    private Battle battle = new Battle();

    public Game() {
        pokemonReader = new PokemonReader();
        attackReader = new AttacksReader();
    }

    public void setUp() throws IOException {
        pokemonReader.createPokemonFromCSV();
        attackReader.createAttackFromCSV();
    }

    public void choosePokemonWithName(String name) {
        player = pokemonReader.getPokemonWithName(name).clone();
        computer = pokemonReader.getPokemonWithId(r.nextInt(151)).clone();
        player.setAttack1(attackReader.getAttack(r.nextInt(217)));
        player.setAttack2(attackReader.getAttack(r.nextInt(217)));
        computer.setAttack1(attackReader.getAttack(r.nextInt(217)));
        computer.setAttack2(attackReader.getAttack(r.nextInt(217)));
    }

    public void choosePokemonWithId(int id) {
        player = pokemonReader.getPokemonWithId(id).clone();
        computer = pokemonReader.getPokemonWithId(r.nextInt(151)).clone();
        player.setAttack1(attackReader.getAttack(r.nextInt(217)));
        player.setAttack2(attackReader.getAttack(r.nextInt(217)));
        computer.setAttack1(attackReader.getAttack(r.nextInt(217)));
        computer.setAttack2(attackReader.getAttack(r.nextInt(217)));
    }

    public void startBattle(Scanner sc) {
        System.out.println("Player chose: " + player);
        System.out.println("Computer chose: " + computer);
        do {
            if ((player.getSpeed() > computer.getSpeed()) && (player.getHealthPoints() > 0.00 && computer.getHealthPoints() > 0.00)){
                player(sc);
                computer();
            }else if ((computer.getSpeed() > player.getSpeed()) && (player.getHealthPoints() > 0.00 && computer.getHealthPoints() > 0.00)){
                computer();
                player(sc);
            } else if((computer.getSpeed() == player.getSpeed()) && (player.getHealthPoints() > 0.00 && computer.getHealthPoints() > 0.00)){
                player(sc);
                computer();
            }
        }while (player.getHealthPoints() > 0.00 && computer.getHealthPoints() > 0.00);
    }

    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    private void attack(Pokemon attacker, Pokemon defender, int chosenAttack){
        Attack attack;
        if (chosenAttack == 1){
            attack = attacker.getAttack1();
        }else {
            attack = attacker.getAttack2();
        }
        defender.setHealthPoints(battle.attack(attack.getPower(), attacker.getAtk(), attacker.getDef(), attacker.getName(), defender.getName(), defender.getHealthPoints()));
        if (defender.getHealthPoints() > 0.00){
            System.out.println(defender.getName() + "is now at " + decimalFormat.format(defender.getHealthPoints()) + "HP");
        }else {
            System.out.println(attacker.getName() + " won :D");
        }

    }

    private void player(Scanner sc){
        if (player.getHealthPoints() > 0.00){
            System.out.println("Choose your Attack:");
            System.out.println("1. " + player.getAttack1());
            System.out.println("2. " + player.getAttack2());
            int chosenAttack = sc.nextInt();
            attack(player , computer , chosenAttack);
        }
    }

    private void computer(){
        int chosenAttack;
        if (computer.getHealthPoints() > 0.00){
            chosenAttack = r.nextInt(1,3);
            attack(computer, player, chosenAttack);
        }
    }
}


