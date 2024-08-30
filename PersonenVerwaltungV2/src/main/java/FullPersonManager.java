import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FullPersonManager implements  PersonInterface <FullPerson>{

    public void createPerson(FullPerson fullPerson, int managerID) {
        String createFullString = "insert into fullperson (first_name, last_name, birthday, gender, adressid, id, managerid)  values (?,?,?,?,?,?)";
        String createAddress = "insert into address (plz, city, street, housenumber, id) values(?,?,?,?,?)";

        //TODO -> Find a solution for the adressid problem
        //TODO -> And find a solution to also insert the address into the database

        try (PreparedStatement createFullStmt = DBConnector.getInstance().prepareStatement(createFullString)){
            createFullStmt.setString(1, fullPerson.getFirstName());
            createFullStmt.setString(2, fullPerson.getLastName());
            createFullStmt.setString(3, fullPerson.getBirthday());
            createFullStmt.setString(4, fullPerson.getGender().toString());
            createFullStmt.setInt(6, fullPerson.getId());
            createFullStmt.setInt(7, fullPerson.getManagerId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void read(int personID) {
        String readFullString = "select first_name, last_name from fullperson where id = ?";
        try (PreparedStatement readFullStmt = DBConnector.getInstance().prepareStatement(readFullString)) {
            readFullStmt.setInt(1, personID);

            try (ResultSet resultSet = readFullStmt.executeQuery()) {
                if (resultSet.next()) {
                    String firstname = resultSet.getString("first_name");
                    String lastname = resultSet.getString("last_name");
                    System.out.println("Full Name: " + firstname + " " + lastname);
                } else {
                    System.out.println("No entry found with ID: " + personID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePerson(int personID, String values) {

    }

    public void deletePerson(int personID) {
        String deleteString = "delete from fullperson where id = ?";
        try (PreparedStatement deleteFull = DBConnector.getInstance().prepareStatement(deleteString)){
            deleteFull.setInt(1, personID);

            int rowsAffected = deleteFull.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deleted " + rowsAffected + " row(s) from the database.");
            } else {
                System.out.println("No rows found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<FullPerson> getAllPersons() {
        List<FullPerson> fullPeople = new ArrayList<>();
        String selectFull;
        return null;
    }
}
