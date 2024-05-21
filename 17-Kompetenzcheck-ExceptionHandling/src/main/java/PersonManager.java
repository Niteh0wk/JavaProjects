import java.util.*;

public class PersonManager {
    private List<Person> persons = new ArrayList<>();

    /* Creating a person with all variables */
    public void createFullPerson(String firstName, String lastName, String birthday, Gender gender, int plz, String city, String street, int houseNumber) {
        Person temp = new Person();
        temp.fullPerson(firstName, lastName, birthday, gender, plz, city, street, houseNumber);
        persons.add(temp);
    }

    /* Creating a person with a little less info */
    public void createAdvancedPerson(String firstName, String lastName, String birthday, Gender gender) {
        Person temp = new Person();
        temp.advancedPerson(firstName, lastName, birthday, gender);
        persons.add(temp);
    }

    /* Creating a person only with their name */
    public void createSimplePerson(String firstName, String lastName) {
        Person temp = new Person();
        temp.simplePerson(firstName, lastName);
        persons.add(temp);
    }

    /* Person Finder */
    public Person findPerson(String firstName) {
        for (Person person : persons) {
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                return person;
            }
        }
        throw new NullPointerException("This person does not exist!");
    }

    /* Listing All Persons*/
    public void listPersons() {
        for (Person person : persons) {
            if (person.getFirstName() == null){
                break;
            }else {
                System.out.println("[" + person.getFirstName() + ", " + person.getLastName() + "]");
            }

        }
    }

    /* Removing Person */
    public void removePerson(String firstName, String lastname) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getFirstName().equalsIgnoreCase(firstName) && persons.get(i).getLastName().equalsIgnoreCase(lastname)){
                persons.remove(i);
            }else {
                throw new NullPointerException("This person does not exist");
            }
        }
    }
}
