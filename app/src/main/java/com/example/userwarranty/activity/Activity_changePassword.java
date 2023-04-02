package com.example.userwarranty.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.userwarranty.Model.Api.ApiClient;
import com.example.userwarranty.Model.Request.User;
import com.example.userwarranty.Model.Request.otp;
import com.example.userwarranty.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_changePassword extends AppCompatActivity {
    public EditText editEmail;
    public EditText edit_otp;
    public EditText new_pass;
    public Button btn_change;
    
    
   
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editEmail = findViewById(R.id.edit_email);
        edit_otp = findViewById(R.id.edit_otp);
        new_pass = findViewById(R.id.new_pass);
        btn_change = findViewById(R.id.btn_change);


        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editEmail.getText().toString())){
                    Toast.makeText(Activity_changePassword.this,"\"Email not verified, Please verify your email.\"",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(edit_otp.getText().toString())){
                    Toast.makeText(Activity_changePassword.this,"\"OTP not verified, Please verify your Password.\"",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(new_pass.getText().toString())){
                    Toast.makeText(Activity_changePassword.this,"\"New Password not verified, Please verify your Password.\"",Toast.LENGTH_LONG).show();
                }
                else{
                    //proceed to login
                    changePassword();
                }

            }
        });
    }

    private void changePassword() {
            otp userRequest = new otp();
            userRequest.setEmail(editEmail.getText().toString());
            userRequest.setCode(edit_otp.getText().toString());
            userRequest.setNewPassword(new_pass.getText().toString());

            Call<otp> changePassResponseCall = ApiClient.getUserService().changePass(userRequest);
            changePassResponseCall.enqueue(new Callback<otp>() {
                @Override
                public void onResponse(Call<otp> call, Response<otp> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(Activity_changePassword.this, " ", Toast.LENGTH_LONG).show();

                        otp changeResponse = response.body();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(Activity_changePassword.this, MainActivity.class).putExtra("data", changeResponse.getEmail()));
                            }
                        }, 700);

                    } else {
                        Toast.makeText(Activity_changePassword.this, "Please verify your Email And Password", Toast.LENGTH_LONG).show();

                    }
                }

                @Override
                public void onFailure(Call<otp> call, Throwable t) {
                    Toast.makeText(Activity_changePassword.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                }


            });
    }

}
