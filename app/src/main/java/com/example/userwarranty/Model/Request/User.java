package com.example.userwarranty.Model.Request;

public class User {
    private static User instance;
    private String _id;

    /// Singleton
    public User() {
        // private constructor to prevent instantiation
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    public void setUserId(String userId) {// để logout và xóa
        this._id = userId;
    }

    public String getUserId() {// để lưu id
        return _id;
    }

    ///////////////////////
    private String  username;
    private String  email;
    private String  password;
    private String   phone;
    private String  accessToken;
    private String address;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



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



    public User(String username, String email, String password, String phone, String accessToken, String _id, String address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.accessToken = accessToken;
        this._id = _id;
        this.address = address;

    }



    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", token=" + accessToken +
                ", address=" + address +
                '}';
    }
}
