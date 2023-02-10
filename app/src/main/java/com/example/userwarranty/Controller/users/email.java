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
import com.example.userwarranty.Model.Request.otp;
import com.example.userwarranty.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class email extends AppCompatActivity {
    private EditText edit_send_email;
    private Button btnSendEmail;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);


        edit_send_email = findViewById(R.id.edit_send_email);

        btnSendEmail = findViewById(R.id.btnSend_email);

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edit_send_email.getText().toString())) {
                    Toast.makeText(email.this, "Email Required", Toast.LENGTH_LONG).show();

                } else {
                    //proceed to login
                    sendOTP_Email();
                }

            }
        });
    }
    private void sendOTP_Email() {
        otp otpRequest = new otp();
        otpRequest.setEmail(edit_send_email.getText().toString());

        Call<otp> EmailResponseCall = ApiClient.getUserService().otpUserCall(otpRequest);
        EmailResponseCall.enqueue(new Callback<otp>() {
            @Override
            public void onResponse(Call<otp> call, Response<otp> response) {
                if(response.isSuccessful()){
                    Toast.makeText(email.this,"Email Successful", Toast.LENGTH_LONG).show();
                    otp otpResponse = response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(email.this, MainActivity.class).putExtra("data",otpResponse.getEmail()));
                        }
                    },700);

                }else{
                    Toast.makeText(email.this,"email Failed", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<otp> call, Throwable t) {
                Toast.makeText(email.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
