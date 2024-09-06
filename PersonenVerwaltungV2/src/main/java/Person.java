import java.time.format.DateTimeParseException;

public class Person {
    private String firstName;
    private String lastName;
    private String birthday;
    private Gender gender;
    private int address_id;
    private int id;
    private int managerid;

    public Person(String firstName, String lastName, int id, int managerid) {
        setFirstName(firstName);
        setLastName(lastName);
        setId(id);
        setManagerid(managerid);
    }

    public Person(String firstName, String lastName, String birthday, Gender gender, int id, int managerid) {
        this(firstName,lastName, id, managerid);
        setGender(gender);
        setBirthday(birthday);
    }

    public Person(String firstName, String lastName, String birthday, Gender gender, int address_id, int id, int managerid) {
        this(firstName, lastName, birthday, gender, id, managerid);
        setAddress_id(address_id);
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

    public void setBirthday(String birthday) throws DateTimeParseException {
        if (birthday != null) {
            if (birthday.matches("\\d{4}.\\d{2}.\\d{2}")){
                this.birthday = birthday;
            }else {
                throw new DateTimeParseException("Your date does not match the right date format.", birthday, 0);
            }
        } else {
            this.birthday = null;
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManagerid() {
        return managerid;
    }

    public void setManagerid(int managerid) {
        this.managerid = managerid;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Vorname='" + firstName + '\'' +
                ", Nachname='" + lastName + '\'' +
                ", Geburtstag='" + birthday + '\'' +
                ", Geschlecht=" + gender +
                ", AdressenID=" + address_id;
    }
}
