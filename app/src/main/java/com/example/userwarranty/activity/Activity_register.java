package com.example.userwarranty.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.userwarranty.Model.Api.ApiClient;
import com.example.userwarranty.Model.Request.User;
import com.example.userwarranty.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_register extends AppCompatActivity {
    private EditText username,email,password,phone;
    private TextView login_text_view_btn;
    private Button register;
    public void init(){
        username = findViewById(R.id.username_edit_text);
        email = findViewById(R.id.email_edit_text);
        password = findViewById(R.id.password_edit_text);
        phone = findViewById(R.id.phone_edit_text);
        register = findViewById(R.id.register_btn);
        login_text_view_btn = findViewById(R.id.login_text_view_btn);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(username.getText().toString())){
                    Toast.makeText(Activity_register.this,"\"Username not verified, Please verify your Username.\"",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(email.getText().toString())){
                    Toast.makeText(Activity_register.this,"\"Email not verified, Please verify your Email.\"",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(phone.getText().toString())){
                    Toast.makeText(Activity_register.this,"\"Phone not verified, Please verify your Phone.\"",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(Activity_register.this,"\"Password not verified, Please verify your Password .\"",Toast.LENGTH_LONG).show();
                }
                else{
                    //proceed to login
                    User registerRequest = new User();
                    registerRequest.setEmail(email.getText().toString());
                    registerRequest.setPassword(password.getText().toString());
                    registerRequest.setUsername(username.getText().toString());
                    registerRequest.setPhone(phone.getText().toString());
                    registerAPI(registerRequest);
                }
            }
        });

        login_text_view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }



    private void registerAPI(User registerRequest) {


        Call<User> registerResponseCall = ApiClient.getUserService().registerUserCall(registerRequest);
        registerResponseCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    String message = "Successful ..";
                    Toast.makeText(Activity_register.this,message,Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Activity_register.this, Activity_login.class));
                    finish();
                }else{
                    String message = "An error occurred please try again later ...";
                    Toast.makeText(Activity_register.this,message,Toast.LENGTH_LONG).show();
                }

            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(Activity_register.this,message,Toast.LENGTH_LONG).show();

            }
        });


    }
}