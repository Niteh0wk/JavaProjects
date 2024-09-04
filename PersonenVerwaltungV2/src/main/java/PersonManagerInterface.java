import java.util.List;

public interface PersonManagerInterface {

    void insertPersonIntoDB(Person person);

    Person readPerson(int person_id);

    void updatePerson(Person person);

    Person deletePerson(int person_id);
}
