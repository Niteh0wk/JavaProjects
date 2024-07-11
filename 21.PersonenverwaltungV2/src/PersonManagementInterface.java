import java.util.List;

public interface PersonManagementInterface {
    void createPersonManagement(Manager manager);
    void createFullPerson(FullPerson fullperson, int managerId);
    void createAdvancedPerson(AdvancedPerson advancedPerson, int managerId);
    void createSimplePerson(SimplePerson simplePerson, int managerId);

    Manager readManagement(int managerId);
    FullPerson readFullPerson(int personId);
    AdvancedPerson readAdvancedPerson(int personId);
    SimplePerson readSimplePerson(int personId);

    void deleteManagement(int managerId);
    void deleteFullPerson(int personId);
    void deleteAdvancedPerson(int personId);
    void deleteSimplePerson(int personId);

    List<Manager> getAllManagements();
    List<FullPerson> getAllFullPersons();
    List<AdvancedPerson> getAllAdvancedPersons();
    List<SimplePerson> getAllSimplePersons();
}
