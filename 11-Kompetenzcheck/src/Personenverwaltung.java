import java.util.ArrayList;
import java.util.List;

public class Personenverwaltung {
    private List<Person> persons = new ArrayList<>();

    public List<Person> getPersons(){
        if (!persons.isEmpty()){
            return persons;
        }
        System.out.println("No Persons in list");
        return null;
    }

    public void createFullPerson(String firstName, String lastName, String birthday, Person.Gender gender, int plz, String city, String street, int houseNumber){
        Person temp = new Person();
        persons.add(temp);
        temp.fullPerson(firstName, lastName, birthday, gender, plz, city, street ,houseNumber);
    }

    public void createSimplePerson(String firstName, String lastName){
        Person temp = new Person();
        persons.add(temp);
        temp.simplePerson(firstName, lastName);
    }

    public void createAdvancedPerson(String firstName, String lastName, String birthday, Person.Gender gender){
        Person temp = new Person();
        persons.add(temp);
        temp.advancedPerson(firstName, lastName, birthday, gender);
    }

}
