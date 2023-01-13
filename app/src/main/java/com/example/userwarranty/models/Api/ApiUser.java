package com.example.userwarranty.models.Api;

import com.example.userwarranty.models.modelRequest.maintenance;
import com.example.userwarranty.models.modelRequest.otp;
import com.example.userwarranty.models.modelRequest.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface  ApiUser {


    @POST("v1/user/loginUser")
     Call<User> loginUser(@Body User user);

    @POST("v1/user/register")
    Call<User> registerUserCall(@Body User user) ;

    @POST("v1/user/email_send")
    Call<otp> otpUserCall(@Body otp otP) ;

    @POST("v1/maintenance/addBooking")
    Call<maintenance> bookAppointment(@Body maintenance maintenances);

    @GET("v1/maintenance/addBooking")
    Call<maintenance> getList(@Query("_id") maintenance maintenances);

//    @POST("v1/user/logoutUser")
//    Call<User> logoutUserCall(User logoutUser) {
//        return null;
//    }
//    @POST("v1/user/email_send")
//    Call<User> otpUserCall(User otpUser) {
//        return null;
//    }
//
//
//    @PUT("v1/auth/updateUser/{id}")
//    Call<User> updateUserCall(@Path("id") String id) {
//        return null;
//    }
//    @DELETE("v1/user/deleteUser/{id}")
//    Call<User> deleteUserCall(@Path("id") String id) {return null;}
}


