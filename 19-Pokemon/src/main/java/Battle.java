import java.text.DecimalFormat;

public class Battle {
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private String formattedDamage;
    public double playerAttack(int atkPower, int pAtk, int pDef, String attackName, String name, double healthPoints){
        double damage;
        damage = atkPower * (pAtk / pDef) * (1.0/25.0);
        healthPoints -= damage;
        formattedDamage = decimalFormat.format(damage);
        System.out.println("You used " + attackName + " and hit " + name + " for " + formattedDamage);
        if (healthPoints > 0.00){
            System.out.println(name + " is now at " + decimalFormat.format(healthPoints) + "HP");
        }else {
            System.out.println("You won.");
        }
        return healthPoints;
    }

    public double computerAttack(int atkPower, int pAtk, int pDef, String attackName, String name, double healthPoints){
        double damage;
        damage = atkPower * (pAtk / pDef) * (1.0/25.0);
        healthPoints -= damage;
        formattedDamage = decimalFormat.format(damage);
        System.out.println(name + " used " + attackName + " and hit you for " + formattedDamage);
        if (healthPoints > 0.00){
            System.out.println("You are now at " + decimalFormat.format(healthPoints) + "HP");
        }else {
            System.out.println(name + " won.");
        }
        return healthPoints;
    }


}
