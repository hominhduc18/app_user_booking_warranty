package com.example.userwarranty.Model.Response;

public class Admin {
    private String email;
    private String password;
    private String admin;
    private String _id;

    public Admin() {
    }

    public Admin(String email, String password, String admin, String _id) {
        this.email = email;
        this.password = password;
        this.admin = admin;
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", admin='" + admin + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }
}
