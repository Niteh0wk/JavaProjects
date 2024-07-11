public class Person {
    private String name;
    private int id;
    private int householdId;

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

    public int getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(int householdId) {
        this.householdId = householdId;
    }

    public Person(int id, String name, int household_id) {
        this.name = name;
        this.id = id;
        this.householdId = household_id;
    }
}

