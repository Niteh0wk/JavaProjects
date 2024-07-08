public class Person {
    private String name;
    private int id;
    private int household_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHousehold_id() {
        return household_id;
    }

    public void setHousehold_id(int household_id) {
        this.household_id = household_id;
    }

    public Person(String name, int id, int household_id) {
        this.name = name;
        this.id = id;
        this.household_id = household_id;
    }
}

