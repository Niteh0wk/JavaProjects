public class Pet {
    private String name;
    private int id;
    private int person_id;

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

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public Pet(String name, int id, int person_id) {
        this.name = name;
        this.id = id;
        this.person_id = person_id;
    }
}
