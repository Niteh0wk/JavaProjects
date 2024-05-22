public class Pokemon {
    private int id;
    private String name;
    private int healthPoints;
    private int atk;
    private int def;
    private int speed;

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

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
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

    public Pokemon(int id, String name, int healthPoints, int atk, int def, int speed) {
        this.id = id;
        this.name = name;
        this.healthPoints = healthPoints;
        this.atk = atk;
        this.def = def;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return  id + ": " + name;
    }
}
