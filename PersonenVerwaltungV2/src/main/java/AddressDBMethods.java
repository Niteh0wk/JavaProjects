import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressDBMethods implements AddressInterface {
    public void insertAddressIntoDB(Address address) {
        String insertAddress = "INSERT INTO ADDRESS (PLZ, CITY, STREET, HOUSENUMBER, ID) VALUES (?,?,?,?,?)";

        try (PreparedStatement ps = DBConnector.getInstance().prepareStatement(insertAddress, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, address.getPlz());
            ps.setString(2, address.getCity());
            ps.setString(3, address.getStreet());
            ps.setInt(4, address.getPlz());
            ps.setInt(5, address.getId());
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Address created successfully");
    }

    public Address readAddress(int address_id) {
        Address address;
        try (PreparedStatement ps = DBConnector.getInstance().prepareStatement("SELECT * FROM ADDRESS WHERE ID = ?")) { // Definition des Statements mit Platzhaltern: '?'
            ps.setInt(1, address_id);
            ResultSet rs = ps.executeQuery(); // Absetzen der Query
            if (rs.next()) {
                address = new Address(rs.getInt("ID"),rs.getInt("PLZ"), rs.getString("CITY"), rs.getString("STREET"), rs.getInt("HOUSENUMBER"));
            } else {
                System.err.println("No Person found with the given ID");
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Fehler bei der Datenbankabfrage: " + e.getMessage());
            return null;
        }
        return address;
    }

    public void updateAddress(Address address) {
        try (PreparedStatement ps = DBConnector.getInstance().prepareStatement("UPDATE ADDRESS SET PLZ = ?, CITY = ?, STREET = ?, HOUSENUMBER = ? WHERE ID = ?")) {
            ps.setInt(1, address.getPlz());
            ps.setString(2, address.getCity());
            ps.setString(3, address.getStreet());
            ps.setInt(4, address.getHouseNumber());
            ps.setInt(5, address.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Fehler bei der Datenbankabfrage");
            System.out.println(e.getMessage());
        }
    }

    public Address deleteAddress(int address_id) {
        Address deletedAddress = readAddress(address_id);
        try (PreparedStatement ps = DBConnector.getInstance().prepareStatement("DELETE FROM ADDRESS WHERE ID = ?")) {
            ps.setInt(1, address_id);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Fehler beim Löschen des Datenbankeintrages");
            System.out.println(e.getMessage());
        }
        return deletedAddress;
    }
}
