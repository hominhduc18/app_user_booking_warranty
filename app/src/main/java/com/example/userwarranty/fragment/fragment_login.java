package com.example.userwarranty.fragment;

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
import com.example.userwarranty.R;
import com.example.userwarranty.models.Api.ApiClient;
import com.example.userwarranty.models.modelRequest.User;
import com.example.userwarranty.models.modelRespond.Users;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_login extends AppCompatActivity {
    EditText email,password;
    Button sign_in, button_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        email = findViewById(R.id.EditText_email_login);
        password = findViewById(R.id.EditText_password_login);
        sign_in = findViewById(R.id.button_sign_in);
        button_register = findViewById(R.id.button_register);



        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(fragment_login.this,"email / Password Required", Toast.LENGTH_LONG).show();
                }
                else{
                    //proceed to login
                    loginAPI();
                }

            }
        });
    }
    private void loginAPI() {
        User userRequest = new User();
        userRequest.setEmail(email.getText().toString());
        userRequest.setPassword(password.getText().toString());

        Call<User> loginResponseCall = ApiClient.getUserService().loginUser(userRequest);
        loginResponseCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Toast.makeText(fragment_login.this,"Login Successful", Toast.LENGTH_LONG).show();
                    User loginResponse = response.body();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(fragment_login.this, MainActivity.class).putExtra("data",loginResponse.getUsername()));
                        }
                    },700);

                }else{
                    Toast.makeText(fragment_login.this,"Login Failed", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(fragment_login.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fragment_login.this, fragment_register.class);
                startActivity(intent);
            }
        });

    }
}
