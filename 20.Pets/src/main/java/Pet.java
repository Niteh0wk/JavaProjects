public class Pet {
    private String name;
    private int id;
    private int personId;

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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Pet(String name, int id, int person_id) {
        this.name = name;
        this.id = id;
        this.personId = person_id;
    }
}
