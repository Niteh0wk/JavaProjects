public class Person {
    private String firstName;
    private String lastName;
    private String birthday;
    enum Gender{
        male, female, diverse
    }

    public void fullPerson(String firstName, String lastName, String birthday, Gender gender, int plz, String city, String street, int houseNumber){
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
        Adress ad1 = new Adress();
        ad1.setPlz(plz);
        ad1.setCity(city);
        ad1.setStreet(street);
        ad1.setHouseNumber(houseNumber);
    }

    public void simplePerson(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }

    public void advancedPerson(String firstName, String lastName, String birthday, Gender gender){
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
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

}
