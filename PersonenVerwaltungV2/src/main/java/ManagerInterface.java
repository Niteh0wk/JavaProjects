import java.util.List;

public interface ManagerInterface{

    void createManagement(Manager manager);

    void readManager(int managerID);

    void updateManager(int managerID, String values);

    void deleteManager(int managerID);

    List<Manager> getAllManagements();
}
