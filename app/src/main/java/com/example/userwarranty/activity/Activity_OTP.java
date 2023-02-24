package com.example.userwarranty.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.userwarranty.Model.Api.ApiClient;
import com.example.userwarranty.Model.Request.User;
import com.example.userwarranty.Model.Request.otp;
import com.example.userwarranty.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_OTP extends AppCompatActivity {
    private EditText otp1,otp2, otp3, otp4;
    private Button btn_send_otp;

    public void init(){
        otp1 =  findViewById(R.id.otp1);
        otp2 =  findViewById(R.id.otp2);
        otp3 =  findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);
        btn_send_otp = findViewById(R.id.btn_Send_email);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        init();

        btn_send_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(otp1.getText().toString()) ||  TextUtils.isEmpty(otp1.getText().toString()) ||
                TextUtils.isEmpty(otp1.getText().toString()) || TextUtils.isEmpty(otp1.getText().toString())){
                    Toast.makeText(Activity_OTP.this,"\" Please verify your OTP.\"",Toast.LENGTH_LONG).show();
                }
                else
                {
                    putOTP();
                }
            }
        });


    }
    public void putOTP(){
        otp otpRequest = new otp();
        otpRequest.setCode(otp1.getText().toString());
        otpRequest.setCode(otp2.getText().toString());
        otpRequest.setCode(otp3.getText().toString());
        otpRequest.setCode(otp4.getText().toString());

        Call<otp> otpResponseCall = ApiClient.getUserService().otpUserCall(otpRequest);
        otpResponseCall.enqueue(new Callback<otp>() {
            @Override
            public void onResponse(Call<otp> call, Response<otp> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Activity_OTP.this,"OTP Right", Toast.LENGTH_LONG).show();

                    otp otpResponse = response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(Activity_OTP.this, MainActivity.class).putExtra("data", otpResponse.getCode()));
                        }
                    }, 700);

                } else {
                    Toast.makeText(Activity_OTP.this, "Please verify your Email And Password", Toast.LENGTH_LONG).show();

                }

                }
            @Override
            public void onFailure(Call<otp> call, Throwable t) {
            Toast.makeText(Activity_OTP.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });



    }
}
