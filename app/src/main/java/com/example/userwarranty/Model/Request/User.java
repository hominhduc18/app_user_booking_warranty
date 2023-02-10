package com.example.userwarranty.Model.Request;

public class User {
    private String  username;
    private String  email;
    private String  password;
    private String   phone;
    private String  accessToken;


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public User(String username, String email, String password, String phone, String accessToken) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.accessToken = accessToken;

    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", token=" + accessToken +
                '}';
    }
}
