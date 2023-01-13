package com.example.userwarranty.models.modelRespond;

public class Users {
    private String _id ;
    private String email;
    private String username;
    private long phone;
    private String password;
    private String sex;
    private Object history;
    private String accessToken;

    public Users() {
    }

    public Users(String _id, String email, String username, long phone, String password, String sex, Object history, String accessToken) {
        this._id = _id;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.sex = sex;
        this.history = history;
        this.accessToken = accessToken;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Object getHistory() {
        return history;
    }

    public void setHistory(Object history) {
        this.history = history;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "Users{" +
                "_id='" + _id + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", phone=" + phone +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", history=" + history +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
