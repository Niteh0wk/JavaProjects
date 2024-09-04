import java.util.List;

public interface ManagementInterface {

    void createManagement(Management manager);

    void readManager(int managerID);

    void updateManager(int managerID, String values);

    void deleteManager(int managerID);

    List<Management> getAllManagements();
}
