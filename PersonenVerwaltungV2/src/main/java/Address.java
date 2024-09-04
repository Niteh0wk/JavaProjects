public class Address {
    private int plz;
    private String city;
    private String street;
    private int houseNumber;
    private int id;

    public Address(int id, int plz, String city, String street, int houseNumber) {
        setPlz(plz);
        setCity(city);
        setStreet(street);
        setHouseNumber(houseNumber);
        setId(id);
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "Postleitzahl='" + plz + '\'' +
                ", Ort='" + city + '\'' +
                ", StrassenName='" + street + '\'' +
                ", HausNummer=" + houseNumber +
                '}';
    }
}