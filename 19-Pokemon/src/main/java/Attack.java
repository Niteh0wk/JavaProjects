public class Attack {
    private int id;
    private String name;
    private String effect;
    private int Power;

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

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getPower() {
        return Power;
    }

    public void setPower(int power) {
        Power = power;
    }

    public Attack(int id, String name, String effect, int power) {
        this.id = id;
        this.name = name;
        this.effect = effect;
        Power = power;
    }

    @Override
    public String toString() {
        return id + ": " + name +
                " | " + effect;
    }
}
