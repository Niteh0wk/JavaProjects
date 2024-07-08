import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PersonCVSEdit {
    private final String filepath;
    HashMap<Integer, > persons;

    public PersonCVSEdit(){
        filepath = "persons.csv";
        persons = new HashMap<>();
    }

    public void createPerson(String name, int id, int household_id) throws IOException {
        FileWriter writer = new FileWriter(filepath);
        char[] content = (name + ", " + id + ", " + household_id).toCharArray();
        writer.write(content);
        writer.close();
        Person currentPerson = new Person(name, id, household_id);
        persons.put(household_id, );
    }

    public Person getPersonWithName(String name){
        for (Person person : persons.values()){
            if (person.getName().equalsIgnoreCase(name)){
                return person;
            }
        }
        return null;
    }

    public Person getPersonWithHouseholdId(int id){
        return persons.get(id);
    }
}
