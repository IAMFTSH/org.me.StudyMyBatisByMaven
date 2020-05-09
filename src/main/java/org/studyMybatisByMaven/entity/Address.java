package org.studyMybatisByMaven.entity;

public class Address {
    private int addressId;
    private String homeAddress;
    private String family;

    public Address(String homeAddress, String family, int addressId) {
        this.homeAddress = homeAddress;
        this.family = family;
        this.addressId = addressId;
    }

    public Address() {
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "homeAddress='" + homeAddress + '\'' +
                ", family='" + family + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
