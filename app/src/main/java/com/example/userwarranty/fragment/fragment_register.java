package com.example.userwarranty.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_register extends AppCompatActivity {
    EditText username,email,password,phone;
    Button register;


    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);

        username = findViewById(R.id.editTextPersonName);
        email = findViewById(R.id.editTextTextEmailAddressSignin);
        password = findViewById(R.id.editTextTextPasswordSignin);
        phone = findViewById(R.id.editTextPhone);
        register = findViewById(R.id.buttonRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString()) ||
                        TextUtils.isEmpty(email.getText().toString()) ||TextUtils.isEmpty(phone.getText().toString()) ){
                    String message = "All inputs required ..";
                    Toast.makeText(fragment_register.this,message, Toast.LENGTH_LONG).show();
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
    }
    private void registerAPI(User registerRequest) {
        Call<User> registerResponseCall = ApiClient.getUserService().registerUserCall(registerRequest);
        registerResponseCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    String message = "Successful ..";
                    Toast.makeText(fragment_register.this,message,Toast.LENGTH_LONG).show();
                    startActivity(new Intent(fragment_register.this, MainActivity.class));
                    finish();
                }else{
                    String message = "An error occurred please try again later ...";
                    Toast.makeText(fragment_register.this,message,Toast.LENGTH_LONG).show();
                }

            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(fragment_register.this,message,Toast.LENGTH_LONG).show();

            }
        });


    }

}
