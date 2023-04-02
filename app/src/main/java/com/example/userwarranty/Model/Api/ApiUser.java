package com.example.userwarranty.Model.Api;

import com.example.userwarranty.Model.Request.User;
import com.example.userwarranty.Model.Request.maintenance;
import com.example.userwarranty.Model.Request.otp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiUser {
    @POST("v1/user/loginUser")
    Call<User> loginUser(@Body User user);

    @POST("v1/user/register")
    Call<User> registerUserCall(@Body User user);

    @PUT("v1/user/updateUser/{id}")
    Call<User> updateUser(@Path("id") String id);

    @GET("/v1/user/logoutUser")
    Call<User> getLogout(@Header("token") String authToken);



    @POST("/v1/user/changepassword")
    Call<otp> changePass(@Body otp user);

    @GET("/v1/user/get/An/User/{id}")
    Call<User> getInfor(@Path("id") String id);

    @PUT("/v1/user/updateUser/{id}")
    Call<User>updateUser(@Path("id") String id,
                         @Body User user);

    @GET("/v1/maintenance/getUserAMaintenance/{id}")
    Call<maintenance> get_booking_ById(@Path("id") String id);


    @POST("v1/user/useremailsend")
    Call<otp> otpUserCall(@Body otp otP);

    @POST("/v1/maintenance/useraddBooking")
    Call<maintenance> app_booking(@Body maintenance maintenances);
}

