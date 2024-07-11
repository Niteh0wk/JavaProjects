import java.time.format.DateTimeParseException;

public class AdvancedPerson {
    private String firstName;
    private String lastName;
    private String birthday;
    private Gender gender;
    private int id;
    private int managerId;

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
        if (birthday.matches("\\d{2}.\\d{2}.\\d{4}")){
            this.birthday = birthday;
        }else {
            throw new DateTimeParseException("Your date does not match the right date format.", birthday, 0);
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public AdvancedPerson(int id, String firstName, String lastName, String birthday, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.firstName + ", " + this.lastName + ", " + this.birthday + ", " + this.gender;
    }
}
