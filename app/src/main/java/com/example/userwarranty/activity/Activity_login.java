package com.example.userwarranty.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.userwarranty.Model.Api.ApiClient;
import com.example.userwarranty.Model.Request.User;
import com.example.userwarranty.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_login extends AppCompatActivity {
    EditText emailEditText,passwordEditText;
    Button loginBtn;
    ProgressBar progressBar;
    TextView registerAccountBtnTextView;
    TextView text_view_forgot_pass;
    public void init(){
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginBtn = findViewById(R.id.login_btn);
        progressBar = findViewById(R.id.progress_bar);
        registerAccountBtnTextView = findViewById(R.id.create_account_text_view_btn);
        text_view_forgot_pass = findViewById(R.id.text_view_forgot_pass);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       init();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(emailEditText.getText().toString())){
                    Toast.makeText(Activity_login.this,"\"Email not verified, Please verify your email.\"",Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(passwordEditText.getText().toString())){
                    Toast.makeText(Activity_login.this,"\"Password not verified, Please verify your Password.\"",Toast.LENGTH_LONG).show();
                }
                else{
                    //proceed to login
                    loginAPI();
                }

            }
        });

        registerAccountBtnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_login.this, Activity_register.class);
                startActivity(intent);
            }
        });

        text_view_forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_login.this, Activity_sendEmail.class);
                startActivity(intent);
            }
        });
    }



    private static String token;
    private void loginAPI() {
        User userRequest = new User();
        userRequest.setEmail(emailEditText.getText().toString());
        userRequest.setPassword(passwordEditText.getText().toString());

        Call<User> loginResponseCall = ApiClient.getUserService().loginUser(userRequest);
        loginResponseCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Activity_login.this, response.body().getAccessToken(), Toast.LENGTH_LONG).show();
                    token = response.body().getAccessToken();
                    // lưua sigle ton
                    String _id = response.body().getUserId();
                    User.getInstance().setUserId(_id);


                    // SINGLE TON KHI LẤY VÀ XÓA


                    /*
                    Bây giờ bạn có thể truy cập ID của người dùng từ bất kỳ đâu trong ứng
                     dụng của bạn bằng cách sử dụng phương thức getUserId() của Singleton class:



                    String _id = User.getInstance().getUserId();


                    xóa khi logout
                      User.getInstance().setId(null);


                    */

//                    // get user id when needed
//                    String userId = UserSingleton.getInstance().getUserId();
//
////                    clear user id when user logs out
//                    UserSingleton.getInstance().setUserId(null);



                    User loginResponse = response.body();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(Activity_login.this, MainActivity.class).putExtra("data", loginResponse.getUsername()));
                        }
                    }, 700);

                } else {
                    Toast.makeText(Activity_login.this, "Please verify your Email And Password", Toast.LENGTH_LONG).show();

                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Activity_login.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
