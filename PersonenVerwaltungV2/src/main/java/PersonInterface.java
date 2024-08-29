import java.util.List;

public interface PersonInterface <T> {

    void createPerson(T ObjectName, int managerID);

    void read(int personID);

    void updatePerson(int personID, String values);

    void deletePerson(int personID);

    List<T> getAllPersons();
}
