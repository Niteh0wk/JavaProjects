import java.util.ArrayList;
import java.util.List;

public class PersonManager {
    private List<Person> persons = new ArrayList<>();
    private ArrayList<Integer> printValidator = new ArrayList<>();

    public void createFullPerson(String firstName, String lastName, String birthday, Gender gender, int plz, String city, String street, int houseNumber) {
        Person temp = new Person();
        temp.fullPerson(firstName, lastName, birthday, gender, plz, city, street, houseNumber);
        persons.add(temp);
        printValidator.add(1);
    }

    public void createAdvancedPerson(String firstName, String lastName, String birthday, Gender gender) {
        Person temp = new Person();
        temp.advancedPerson(firstName, lastName, birthday, gender);
        persons.add(temp);
        printValidator.add(2);
    }

    public void createSimplePerson(String firstName, String lastName) {
        Person temp = new Person();
        temp.simplePerson(firstName, lastName);
        persons.add(temp);
        printValidator.add(3);
    }

    public void getPerson(int atPos) {
        if (atPos > persons.size()) {
            throw new IndexOutOfBoundsException("This Person does not exist!");
        } else if (printValidator.get(atPos - 1) == 1) {
            System.out.println(
                    persons.get(atPos - 1).getFirstName() + ", " +
                            persons.get(atPos - 1).getLastName() + ", " +
                            persons.get(atPos - 1).getBirthday() + ", " +
                            persons.get(atPos - 1).getGender() + ", " +
                            persons.get(atPos - 1).getAddress().getPlz() + ", " +
                            persons.get(atPos - 1).getAddress().getCity() + ", " +
                            persons.get(atPos - 1).getAddress().getStreet() + " " +
                            persons.get(atPos - 1).getAddress().getHouseNumber()
            );
        } else if (printValidator.get(atPos - 1) == 2) {
            System.out.println(
                    persons.get(atPos - 1).getFirstName() + ", " +
                            persons.get(atPos - 1).getLastName() + ", " +
                            persons.get(atPos - 1).getBirthday() + ", " +
                            persons.get(atPos - 1).getGender()
            );
        } else if (printValidator.get(atPos - 1) == 3){
            System.out.println(
                    persons.get(atPos - 1).getFirstName() + ", " +
                    persons.get(atPos - 1).getLastName()
            );
        }
    }

    public void personList() {
        for (int i = 0; i < persons.size(); i++) {
            System.out.println("[" + persons.get(i).getFirstName() + "]");
        }
    }

    public void removePerson(int atPos) {
        persons.remove(atPos - 1);
        printValidator.remove(atPos - 1);
        if (atPos < persons.size()) {
            throw new IndexOutOfBoundsException("This Person does not exist!");
        }
    }
}
