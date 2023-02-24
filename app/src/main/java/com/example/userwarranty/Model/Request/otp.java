package com.example.userwarranty.Model.Request;

public class otp {
    private String email;
    private String code;
    private String expiresIn;

    public otp() {
    }

    public otp(String email, String code,String expiresIn) {
        this.email = email;
        this.code = code;
        this.expiresIn = expiresIn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return "otp{" +
                "email='" + email + '\'' +
                ", code=" + code +
                ", expiresIn=" + expiresIn +
                '}';
    }
}
