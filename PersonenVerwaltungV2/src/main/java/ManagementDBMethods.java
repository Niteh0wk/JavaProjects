import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagementDBMethods implements ManagementInterface {

    public void createManagement(Management manager) {
        String createManagementString = "insert into manager (id, name) values (?,?)";
        try (PreparedStatement createManagementStmt = DBConnector.getInstance().prepareStatement(createManagementString)) {
            createManagementStmt.setInt(1, manager.getId());
            createManagementStmt.setString(2, manager.getName());

            createManagementStmt.executeUpdate();

            System.out.println("Manager created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readManager(int managerID) {
        String readManagerString = "select name from manager where id = ?";
        try (PreparedStatement readManagerStmt = DBConnector.getInstance().prepareStatement(readManagerString)) {
            readManagerStmt.setInt(1, managerID);

            try (ResultSet resultSet = readManagerStmt.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    System.out.println("Management Name: " + name);
                } else {
                    System.out.println("No entry found with ID: " + managerID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateManager(int managerID, String values) {
        String updateString = "update manager set name = ? where id = ?";
        try (PreparedStatement updateManager = DBConnector.getInstance().prepareStatement(updateString)) {
            updateManager.setString(1, values);
            updateManager.setInt(2, managerID);

            updateManager.executeUpdate();

            System.out.println("Manager updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteManager(int managerID) {
        String deleteString = "delete from manager where id = ?";
        try (PreparedStatement deleteManager = DBConnector.getInstance().prepareStatement(deleteString)) {
            deleteManager.setInt(1, managerID);

            int rowsAffected = deleteManager.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deleted: " + rowsAffected + " row(s) from the database.");
            } else {
                System.out.println("No rows found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Management> getAllManagements() {
        List<Management> managers = new ArrayList<>();
        String selectManager = "select id, name from manager";
        try (PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(selectManager)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int managerid = resultSet.getInt("id");
                String name = resultSet.getString("name");

                Management manager = new Management(managerid, name);
                managers.add(manager);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managers;
    }
}
