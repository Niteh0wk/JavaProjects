public class Address {
    private int plz;
    private String city;
    private String street;
    private int houseNumber;
    private int id;

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Address(int plz, String city, String street, int houseNumber, int id) {
        this.plz = plz;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.plz + ", " + this.city + ", " + this.street + ", " + this.houseNumber + ", " + this.id;
    }
}