package com.example.userwarranty.Model.Request;

public class maintenance {
    private String date;
    private String user;
    private String employee;
    private String description;
    private String startHour;
    private String service;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public maintenance() {
    }

    public maintenance(String date, String user, String employee, String description, String startHour,String service) {
        this.date = date;
        this.user = user;
        this.employee = employee;
        this.description = description;
        this.startHour = startHour;
        this.service = service;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
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
        return "maintenance{" +
                "date='" + date + '\'' +
                ", user='" + user + '\'' +
                ", employee='" + employee + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
