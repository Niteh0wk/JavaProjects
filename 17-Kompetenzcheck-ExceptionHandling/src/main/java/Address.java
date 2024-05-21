import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address {
    private int plz;
    private String city;
    private String street;
    private int houseNumber;

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws InvalidPersonName {
        if (!isNumeric(street)){
            this.city = city;
        }else {
            throw new InvalidPersonName("Invalid Input: " + city);
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws InvalidPersonName {
        if (!isNumeric(street)){
            this.street = street;
        }else {
            throw new InvalidPersonName("Invalid Input: " + street);
        }

    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public boolean isNumeric(String Name) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(Name);
        return matcher.find();
    }
}