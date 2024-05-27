import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String firstName;
    private String lastName;
    private String birthday;
    private Address address;
    private Gender gender;
    private int printValidator;
    final private int PRINT_FULL = 1;
    final private int PRINT_ADVANCED = 2;
    final private int PRINT_SIMPLE = 3;

    /* Person Creation*/

    public void fullPerson(String firstName, String lastName, String birthday, Gender gender, int plz, String city, String street, int houseNumber) {
        try {
            setFirstName(firstName);
        } catch (InvalidPersonName e) {
            System.out.println(e.getMessage());
        }

        try {
            setLastName(lastName);
        } catch (InvalidPersonName e) {
            System.out.println(e.getMessage());
        }

        try {
            setBirthday(birthday);
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }

        setGender(gender);
        Address temp = new Address();
        temp.setPlz(plz);

        try {
            temp.setCity(city);
        }catch (InvalidName e){
            System.out.println(e.getMessage());
        }

        try {
            temp.setStreet(street);
        }catch (InvalidName e){
            System.out.println(e.getMessage());
        }

        temp.setHouseNumber(houseNumber);
        setAddress(temp);

        printValidator = PRINT_FULL;
    }

    public void advancedPerson(String firstName, String lastName, String birthday, Gender gender) {
        try {
            setFirstName(firstName);
        } catch (InvalidPersonName e) {
            System.out.println(e.getMessage());
        }

        try {
            setLastName(lastName);
        } catch (InvalidPersonName e) {
            System.out.println(e.getMessage());
        }

        try {
            setBirthday(birthday);
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }
        setGender(gender);

        printValidator = PRINT_ADVANCED;
    }

    public void simplePerson(String firstName, String lastName) {
        try {
            setFirstName(firstName);
        } catch (InvalidPersonName e) {
            System.out.println(e.getMessage());
        }

        try {
            setLastName(lastName);
        } catch (InvalidPersonName e) {
            System.out.println(e.getMessage());
        }

        printValidator = PRINT_SIMPLE;
    }

    /* Getter and Setter */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws InvalidPersonName {
        if (!isNumeric(firstName)) {
            this.firstName = firstName;
        } else {
            throw new InvalidPersonName("Invalid Input: " + firstName);
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws InvalidPersonName {
        if (!isNumeric(lastName)) {
            this.lastName = lastName;
        } else {
            throw new InvalidPersonName("Invalid Input: " + lastName);
        }

    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) throws DateTimeParseException {
        if (birthday.matches("\\d{2}.\\d{2}.\\d{4}")) {
            this.birthday = birthday;
        } else {
            throw new DateTimeParseException("Your date does not match the right date format.", birthday, 0);
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isNumeric(String Name) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(Name);
        return matcher.find();
    }

    /* toString Override for printing */

    @Override
    public String toString() {
        String s;
        if (this.printValidator == PRINT_FULL) {
            s = ("[" + this.getFirstName() + ", " +
                    this.getLastName() + ", " +
                    this.getBirthday() + ", " +
                    this.getGender() + ", " +
                    this.getAddress().getPlz() + ", " +
                    this.getAddress().getCity() + ", " +
                    this.getAddress().getStreet() + " " +
                    this.getAddress().getHouseNumber() + "]"
            );
        } else if (this.printValidator == PRINT_ADVANCED) {
            s = ("[" + this.getFirstName() + ", " +
                    this.getLastName() + ", " +
                    this.getBirthday() + ", " +
                    this.getGender() + "]"
            );
        } else if (this.printValidator == PRINT_SIMPLE) {
            s = ("[" + this.getFirstName() + ", " +
                    this.getLastName() + "]"
            );
        } else {
            s = "The person is not initialized";
        }
        return s;
    }
}
