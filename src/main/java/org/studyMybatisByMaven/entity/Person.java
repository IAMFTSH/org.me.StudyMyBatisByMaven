package org.studyMybatisByMaven.entity;

public class Person {
    private int id;
    private String name;
    private int age;
    private boolean sex;
    private int addressId;
    private Address address;
    private int peopleId;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", addressId=" + addressId +
                ", address=" + address +
                '}';
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Person(int id, String name, int age, boolean sex, int addressId, Address address, int peopleId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.addressId = addressId;
        this.address = address;
        this.peopleId = peopleId;
    }

    public Person() {
    }

    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
