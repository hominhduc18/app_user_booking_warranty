package com.example.userwarranty.Model.Request;

import java.sql.Time;
import java.util.Date;
import org.bson.types.ObjectId;
public class maintenance {
    private String username;
    private String phone;
    private String _id;
    private String date;
    private String user;
    private String employee;
    private String description;
    private Date startHour;
    private String service;
    private String noted;
    private Number status;
    private String address;

    public maintenance() {
    }

    public maintenance(String _id,String username, String phone, String date, String user, String employee, String description, Date startHour, String service, String noted, Number status, String address) {
        this.username = username;
        this.phone = phone;
        this._id =  _id;
        this.date = date;
        this.user = user;
        this.employee = employee;
        this.description = description;
        this.startHour = startHour;
        this.service = service;
        this.noted = noted;
        this.status = status;
        this.address = address;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String get_id() {
        return _id;
    }

    public String set_id(String id) {
        this._id = id;
        return id;
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

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Time startHour) {
        this.startHour = startHour;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getNoted() {
        return noted;
    }

    public void setNoted(String noted) {
        this.noted = noted;
    }

    public Number getStatus() {
        return status;
    }

    public void setStatus(Number status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "maintenance{" +
                "username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", id='" + _id + '\'' +
                ", date=" + date +
                ", user='" + user + '\'' +
                ", employee='" + employee + '\'' +
                ", description='" + description + '\'' +
                ", startHour='" + startHour + '\'' +
                ", service='" + service + '\'' +
                ", noted='" + noted + '\'' +
                ", status=" + status +
                ", address='" + address + '\'' +
                '}';
    }



    public void setStartHour(String toString) {
        return;
    }
}
