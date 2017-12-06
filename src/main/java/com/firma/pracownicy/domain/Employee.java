package com.firma.pracownicy.domain;

public class Employee {
    private int employeeID;
    private String name;
    private String surname;
    private int position;
    private String email;

    public Employee(int id, String nam, String sur, int pos, String ema) {
        this.employeeID = id;
        this.name = nam;
        this.surname = sur;
        this.position = pos;
        this.email = ema;
    }
    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}