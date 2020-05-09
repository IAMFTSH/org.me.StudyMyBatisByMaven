package org.studyMybatisByMaven.entity;

import java.util.List;

public class People {
    private int peopleId;
    private int id;
    private List<Person> persons;


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

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "People{" +
                "peopleId=" + peopleId +
                ", id=" + id;
    }
}
