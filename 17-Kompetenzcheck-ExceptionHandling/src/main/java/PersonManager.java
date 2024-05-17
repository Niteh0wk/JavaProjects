import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonManager {
    private List<Person> persons = new ArrayList<>();
    private ArrayList<Integer> printValidator = new ArrayList<>();
    HashMap<String, String> personList = new HashMap<>();


    /* Creating a person with all variables */
    public void createFullPerson(String firstName, String lastName, String birthday, Gender gender, int plz, String city, String street, int houseNumber) {
        Person temp = new Person();
        temp.fullPerson(firstName, lastName, birthday, gender, plz, city, street, houseNumber);
        personList.put(firstName,lastName);
        persons.add(temp);
        printValidator.add(1);
    }

    /* Creating a person with a little less info */
    public void createAdvancedPerson(String firstName, String lastName, String birthday, Gender gender) {
        Person temp = new Person();
        temp.advancedPerson(firstName, lastName, birthday, gender);
        personList.put(firstName,lastName);
        persons.add(temp);
        printValidator.add(2);
    }

    /* Creating a person only with their name */
    public void createSimplePerson(String firstName, String lastName) {
        Person temp = new Person();
        temp.simplePerson(firstName, lastName);
        personList.put(firstName,lastName);
        persons.add(temp);
        printValidator.add(3);
    }

    public void getPerson() {

    }

    public void listPersons() {
        /*for (int i = 0; i < persons.size(); i++) {
            System.out.println("[" + persons.get(i).getFirstName() + "]");
        }*/

        System.out.println(personList);
    }

    public void removePerson(String firstName, String lastname) {
        personList.remove(firstName, lastname);
    }
}
