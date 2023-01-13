package com.example.userwarranty.models.modelRespond;

public class Maintenance {
    private Object User;
    private Object employee;
    private String description;

    public Maintenance() {
    }

    public Maintenance(Object user, Object employee, String description) {
        User = user;
        this.employee = employee;
        this.description = description;
    }

    public Object getUser() {
        return User;
    }

    public void setUser(Object user) {
        User = user;
    }

    public Object getEmployee() {
        return employee;
    }

    public void setEmployee(Object employee) {
        this.employee = employee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "User=" + User +
                ", employee=" + employee +
                ", description='" + description + '\'' +
                '}';
    }
}
