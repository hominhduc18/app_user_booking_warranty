package com.example.userwarranty.Model.Api;

import com.example.userwarranty.Model.Request.User;
import com.example.userwarranty.Model.Request.maintenance;
import com.example.userwarranty.Model.Request.otp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiUser {
    @POST("v1/user/loginUser")
    Call<User> loginUser(@Body User user);

    @POST("v1/user/register")
    Call<User> registerUserCall(@Body User user) ;

    @POST("v1/user/email_send")
    Call<otp> otpUserCall(@Body otp otP) ;

    @POST("v1/maintenance/useraddBooking")
    Call<maintenance> bookAppointment(@Body maintenance maintenances);

    @GET("v1/maintenance/addBooking")
    Call<maintenance> getList(@Query("_id") maintenance maintenances);

    @GET("/v1/user/logoutUser")
    Call<User> getLogout(@Header("token") String authToken);

}
