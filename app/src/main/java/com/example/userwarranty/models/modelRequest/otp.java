package com.example.userwarranty.models.modelRequest;

public class otp {
    private String email;
    private long code;

    public otp() {
    }

    public otp(String email, long code) {
        this.email = email;
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "OTP{" +
                "email='" + email + '\'' +
                ", code=" + code +
                '}';
    }
}
