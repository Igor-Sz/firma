package com.firma.pracownicy.domain;

public class Position {
    private int ID;
    private String name;
    private int people;

    public Position(){};

    public Position(int id, String nam, int peo){
        this.ID = id;
        this.name = nam;
        this.people = peo;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }
}
