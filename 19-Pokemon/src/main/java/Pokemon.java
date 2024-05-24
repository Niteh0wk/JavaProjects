public class Pokemon {
    private int id;
    private String name;
    private double healthPoints;
    private int atk;
    private int def;
    private int speed;
    private Attack attack1;
    private Attack attack2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Attack getAttack1() {
        return attack1;
    }

    public void setAttack1(Attack attack1) {
        this.attack1 = attack1;
    }

    public Attack getAttack2() {
        return attack2;
    }

    public void setAttack2(Attack attack2) {
        this.attack2 = attack2;
    }

    public Pokemon(int id, String name, double healthPoints, int atk, int def, int speed) {
        this.id = id;
        this.name = name;
        this.healthPoints = healthPoints;
        this.atk = atk;
        this.def = def;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Index: " + id +
                "| Name: " + name +
                "| HP: " + healthPoints +
                "| Atk: " + atk +
                "| Def: " + def +
                "| Speed: " + speed;
    }

    @Override
    public Pokemon clone(){
        return new Pokemon(this.id, this.name, this.healthPoints, this.atk, this.def, this.speed);
    }
}
