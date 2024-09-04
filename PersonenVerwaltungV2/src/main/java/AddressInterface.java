public interface AddressInterface {
    void insertAddressIntoDB(Address address);

    Address readAddress(int address_id);

    void updateAddress(Address address);

    Address deleteAddress(int address_id);
}
