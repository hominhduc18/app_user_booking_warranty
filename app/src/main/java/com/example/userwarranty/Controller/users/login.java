package com.example.userwarranty.Controller.users;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.userwarranty.MainActivity;
import com.example.userwarranty.Model.Api.ApiClient;
import com.example.userwarranty.Model.Api.ApiUser;
import com.example.userwarranty.Model.Request.User;
import com.example.userwarranty.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {
    private EditText email,password;
    private Button sign_in, button_register;


    public void init(){
        email = findViewById(R.id.EditText_email_login);
        password = findViewById(R.id.EditText_password_login);
        sign_in = findViewById(R.id.button_sign_in);
        button_register = findViewById(R.id.button_register);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       init();

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(login.this,"email / Password Required", Toast.LENGTH_LONG).show();
                }
                else{
                    //proceed to login
                    loginAPI();
                }

            }
        });
    }

    private static String token;
    private void loginAPI() {
        User userRequest = new User();
        userRequest.setEmail(email.getText().toString());
        userRequest.setPassword(password.getText().toString());

        Call<User> loginResponseCall = ApiClient.getUserService().loginUser(userRequest);
        loginResponseCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Toast.makeText(login.this,response.body().getAccessToken(), Toast.LENGTH_LONG).show();
                    token = response.body().getAccessToken();
                    User loginResponse = response.body();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(login.this, MainActivity.class).putExtra("data",loginResponse.getUsername()));
                        }
                    },700);

                }else{
                    Toast.makeText(login.this,"Login Failed", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(login.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }
        });
    }

    private void logout(){
        Call<User> call = ApiClient.getUserService().getLogout(token);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(login.this, response.body().toString(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(login.this, "logout Fail", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(login.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }

}
