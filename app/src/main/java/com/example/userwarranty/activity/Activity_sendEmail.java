package com.example.userwarranty.activity;

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
import com.example.userwarranty.Model.Request.otp;
import com.example.userwarranty.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_sendEmail extends AppCompatActivity {
    private EditText edit_send_email;
    private Button btn_Send_email;

    public void init(){
        edit_send_email =  findViewById( R.id.email_edit_text);
        btn_Send_email =  findViewById(R.id.btn_Send_email);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        init();

        btn_Send_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(edit_send_email.getText().toString())){
                    Toast.makeText(Activity_sendEmail.this,"\"Please verify your Email.\"",Toast.LENGTH_LONG).show();
                }
                else{
                    sendOTP();
                }
            }
        });

    }
    public void sendOTP(){
        otp otpRequest = new otp();
        otpRequest.setEmail(edit_send_email.getText().toString());

        Call<otp> EmailResponseCall = ApiClient.getUserService().otpUserCall(otpRequest);
        EmailResponseCall.enqueue(new Callback<otp>() {
            @Override
            public void onResponse(Call<otp> call, Response<otp> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Activity_sendEmail.this,"OTP Send Email Successful", Toast.LENGTH_LONG).show();
                    otp otpResponse = response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(Activity_sendEmail.this, Activity_OTP.class).putExtra("data",otpResponse.getEmail()));
                        }
                    },700);

                }else{
                    Toast.makeText(Activity_sendEmail.this,"OTP Send Email Failed", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<otp> call, Throwable t) {
                Toast.makeText(Activity_sendEmail.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
