import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimplePersonManager implements PersonInterface <SimplePerson>{

    public void createPerson(SimplePerson simplePerson, int managerID){
        String createSimpleString = "insert into simpleperson (first_name, last_name, id, managerid) values (?,?,?,?)";
        try (PreparedStatement createSimpleStmt = DBConnector.getInstance().prepareStatement(createSimpleString)) {
            createSimpleStmt.setString(1, simplePerson.getFirstName());
            createSimpleStmt.setString(2, simplePerson.getLastName());
            createSimpleStmt.setInt(3, simplePerson.getId());
            createSimpleStmt.setInt(4, managerID);

            createSimpleStmt.executeUpdate();

            System.out.println("Simple Person was created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void read(int personID) {
        String readSimpleString = "select first_name, last_name from simpleperson where id = ?";
        try (PreparedStatement readSimpleStmt = DBConnector.getInstance().prepareStatement(readSimpleString)) {
            readSimpleStmt.setInt(1, personID);

            try (ResultSet resultSet = readSimpleStmt.executeQuery()) {
                String firstname = resultSet.getString("first_name");
                String lastname = resultSet.getString("last_name");
                System.out.println("Simple Name: " + firstname + " " + lastname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePerson(int personID, String values) {

    }

    public void deletePerson(int personID) {
        String deleteString = "delete from simpleperson where id = ?";
        try (PreparedStatement deleteSimple = DBConnector.getInstance().prepareStatement(deleteString)) {
            deleteSimple.setInt(1, personID);

            int rowsAffected = deleteSimple.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deleted " + rowsAffected + " row(s) from the database.");
            } else {
                System.out.println("No rows found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SimplePerson> getAllPersons() {
        List<SimplePerson> simplePeople = new ArrayList<>();
        String selectSimplePersons = "Select first_name, last_name from simpleperson";

        try (PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(selectSimplePersons)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String firstname = resultSet.getString("first_name");
                String lastname = resultSet.getString("last_name");
                int id = resultSet.getInt("id");

                SimplePerson simplePerson = new SimplePerson(id, firstname, lastname);
                simplePeople.add(simplePerson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return simplePeople;
    }
}
