import java.util.ArrayList;
import java.util.List;

public class Personenverwaltung {
    public List<Person> persons = new ArrayList<>();

    public List<Person> getPersons(){
        if (!persons.isEmpty()){
            return persons;
        }
        System.out.println("No Persons in list");
        return null;
    }

    public void addPerson(Person person){
        persons.add(person);
    }

    public void removePerson(Person person) {
        persons.remove(person);
    }
}
