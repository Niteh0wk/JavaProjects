public class Battle {
    public double attack(int atkPower, int pAtk, int pDef, String attackName, String name, double healthPoints){
        double damage;
        damage = atkPower * (pAtk / pDef) * (1.0/25.0);
        healthPoints -= damage;

        return healthPoints;
    }
}
