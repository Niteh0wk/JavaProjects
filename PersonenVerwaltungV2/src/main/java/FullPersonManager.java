import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FullPersonManager implements PersonInterface<FullPerson> {

    public void createPerson(FullPerson fullPerson, int managerID) {
        String createFullString = "insert into fullperson (first_name, last_name, birthday, gender, addressid, id, managerid)  values (?,?,?,?,?,?,?)";
        String createAddress = "insert into address (plz, city, street, housenumber, id) values(?,?,?,?,?)";

        try (PreparedStatement createAddressStmt = DBConnector.getInstance().prepareStatement(createAddress)) {
            createAddressStmt.setInt(1, fullPerson.getAddress().getPlz());
            createAddressStmt.setString(2, fullPerson.getAddress().getCity());
            createAddressStmt.setString(3, fullPerson.getAddress().getStreet());
            createAddressStmt.setInt(4, fullPerson.getAddress().getHouseNumber());
            createAddressStmt.setInt(5, fullPerson.getAddress().getId());

            createAddressStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement createFullStmt = DBConnector.getInstance().prepareStatement(createFullString)) {

            createFullStmt.setString(1, fullPerson.getFirstName());
            createFullStmt.setString(2, fullPerson.getLastName());
            createFullStmt.setString(3, fullPerson.getBirthday());
            createFullStmt.setString(4, fullPerson.getGender().toString());
            createFullStmt.setInt(5, fullPerson.getAddress().getId());
            createFullStmt.setInt(6, fullPerson.getId());
            createFullStmt.setInt(7, managerID);

            createFullStmt.executeUpdate();

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

    public void updateFirstName(int personID, String values) {
        String updateFirstNameString = "update fullperson set first_name = ? where id = ?";
        updateName(personID, values, updateFirstNameString);
    }

    public void updateLastName(int personID, String values) {
        String updateLastNameString = "update fullperson set last_name = ? where id = ?";
        updateName(personID, values, updateLastNameString);
    }

    private void updateName(int personID, String values, String name) {
       String updateNameString = name;
        try (PreparedStatement updateNameStmt = DBConnector.getInstance().prepareStatement(updateNameString)) {
            updateNameStmt.setString(1, values);
            updateNameStmt.setInt(2, personID);

            updateNameStmt.executeUpdate();
            System.out.println("Full Person was Updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateManagerID(int personID, int values) {
        String updateFirstNameString = "update fullperson set managerid = ? where id = ?";
        try (PreparedStatement updateFirstNameStmt = DBConnector.getInstance().prepareStatement(updateFirstNameString)) {
            updateFirstNameStmt.setInt(1, values);
            updateFirstNameStmt.setInt(2, personID);

            updateFirstNameStmt.executeUpdate();
            System.out.println("Full Person was Updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAddress(int personID, int plz, String city, String street, int houseNumber) {
        String updateAddressString = "update address set plz = ?, city = ?, street = ?, housenumber = ? where id = (select addressid from fullperson where id = ?)";
        try (PreparedStatement updateAddressStmt = DBConnector.getInstance().prepareStatement(updateAddressString)) {
            updateAddressStmt.setInt(1, plz);
            updateAddressStmt.setString(2, city);
            updateAddressStmt.setString(3, street);
            updateAddressStmt.setInt(4, houseNumber);
            updateAddressStmt.setInt(5, personID);

            updateAddressStmt.executeUpdate();
            System.out.println("Full Person was Updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePerson(int personID) {
        String deleteString = "delete from fullperson where id = ?";
        try (PreparedStatement deleteFull = DBConnector.getInstance().prepareStatement(deleteString)) {
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
        String selectFullPersons = "select first_name, last_name, birthday, gender, addressid, fullperson.id, plz, city, street, housenumber from fullperson join address on FullPerson.addressid = address.id";
        try (PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(selectFullPersons)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String birthday = resultSet.getString("birthday");
                Gender gender = Gender.valueOf(resultSet.getString("gender"));
                int plz = resultSet.getInt("plz");
                String city = resultSet.getString("city");
                String street = resultSet.getString("street");
                int housenumber = resultSet.getInt("housenumber");
                int fullpersonid = resultSet.getInt("fullperson.id");
                int addressid = resultSet.getInt("id");

                FullPerson fullPerson = new FullPerson(fullpersonid, first_name, last_name, birthday, gender, new Address(plz, city, street, housenumber, addressid));
                fullPeople.add(fullPerson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fullPeople;
    }
}
