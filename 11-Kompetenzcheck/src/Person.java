public class Person {
    private String firstName;
    private String lastName;
    private String birthday;
    enum Gender{
        male, female, diverse
    }

    public Person(String firstName, String lastName, String birthday, Gender gender, int plz, String city, String street, int houseNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        Adress ad1 = new Adress();
        ad1.setPlz(plz);
        ad1.setCity(city);
        ad1.setStreet(street);
        ad1.setHouseNumber(houseNumber);
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
