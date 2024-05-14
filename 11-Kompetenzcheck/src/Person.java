import java.lang.annotation.Native;

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

    public void fullPerson(String firstName, String lastName, String birthday, Gender gender, int plz, String city, String street, int houseNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
        setGender(gender);
        Address temp = new Address();
        temp.setPlz(plz);
        temp.setCity(city);
        temp.setStreet(street);
        temp.setHouseNumber(houseNumber);
        setAddress(temp);
        printValidator = PRINT_FULL;
    }

    public void advancedPerson(String firstName, String lastName, String birthday, Gender gender) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
        setGender(gender);
        printValidator = PRINT_ADVANCED;
    }

    public void simplePerson(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        printValidator = PRINT_SIMPLE;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    @Override
    public String toString(){
        String s;
        if (this.printValidator == PRINT_FULL) {
            s = (
                    this.getFirstName() + ", " +
                            this.getLastName() + ", " +
                            this.getBirthday() + ", " +
                            this.getGender() + ", " +
                            this.getAddress().getPlz() + ", " +
                            this.getAddress().getCity() + ", " +
                            this.getAddress().getStreet() + " " +
                            this.getAddress().getHouseNumber()
            );
        } else if (this.printValidator == PRINT_ADVANCED) {
            s = (
                    this.getFirstName() + ", " +
                            this.getLastName() + ", " +
                            this.getBirthday() + ", " +
                            this.getGender()
            );
        } else if (this.printValidator == PRINT_SIMPLE){
            s = (
                    this.getFirstName() + ", " +
                            this.getLastName()
            );
        } else {
            s = "The person is not initialized";
        }
       return s;
    }
}
