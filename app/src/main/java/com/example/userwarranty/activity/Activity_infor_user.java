package com.example.userwarranty.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.userwarranty.Model.Api.ApiClient;
import com.example.userwarranty.Model.Request.User;
import com.example.userwarranty.Model.Request.maintenance;
import com.example.userwarranty.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_infor_user extends AppCompatActivity {
    private TextView TextView_username,TextView_phone,TextView_address,TextView_email;
    private Button button_updateInfor;


    public void init(){
        TextView_username = findViewById(R.id.TextView_username);
        TextView_address = findViewById(R.id.TextView_address);
        TextView_email = findViewById(R.id.TextView_email);
        TextView_phone = findViewById(R.id.TextView_phone);
        button_updateInfor = findViewById(R.id.button_updateInfor);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_user);

        init();
        button_updateInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_infor_user.this, Activity_update_user.class);
                startActivity(intent);
            }
        });
        getUser();
    }




    public void getUser(){


        User userRequest = new User();

        //add id to singleton
        String _id = User.getInstance().getUserId();
        Call<User> inforResponseCall = ApiClient.getUserService().getInfor(_id);
        inforResponseCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Activity_infor_user.this, " Get Infor ", Toast.LENGTH_LONG).show();


                    User  userResponse = response.body();


                    TextView_address.setText(userResponse.getAddress());
                    TextView_username.setText( userResponse.getUsername());
                    TextView_phone.setText(userResponse.getPhone());
                    TextView_email.setText(userResponse.getEmail());



                } else {
                    Toast.makeText(Activity_infor_user.this, "Please verify infor", Toast.LENGTH_LONG).show();

                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Activity_infor_user.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
