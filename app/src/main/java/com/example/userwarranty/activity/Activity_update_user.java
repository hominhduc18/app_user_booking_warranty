package com.example.userwarranty.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.userwarranty.Model.Api.ApiClient;
import com.example.userwarranty.Model.Request.User;
import com.example.userwarranty.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_update_user extends AppCompatActivity {
    private Button button_updateInfor_user;
    private EditText Edittext_username, EditText_address, EditText_phone, EditText_email;

    public void init() {
        Edittext_username = findViewById(R.id.Edittext_username);
        EditText_address = findViewById(R.id.EditText_address);
        EditText_email = findViewById(R.id.EditText_email);
        EditText_phone = findViewById(R.id.EditText_phone);
        button_updateInfor_user = findViewById(R.id.button_updateInfor_user);


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);

        init();

        button_updateInfor_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                open_dialog_logout(Gravity.CENTER);
            }
        });
    }




    private void open_dialog_logout(int gravity) {

        Dialog dialog = new Dialog(Activity_update_user.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_update_user);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        // khai bao clock bên ngoài vẫn tắt
        if (Gravity.BOTTOM == gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);
        }

        Button btn_cancel_logout = dialog.findViewById(R.id.btn_cancel_logout);
        Button btn_okay_logout = dialog.findViewById(R.id.btn_okay_logout);

        btn_okay_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_update_user.this, "Update Information Successful", Toast.LENGTH_LONG).show();
                updateUserAPI();

            }
        });

        btn_cancel_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
    public void updateUserAPI(){
        User userRequest = new User();
        userRequest.setUsername(Edittext_username.getText().toString());
        userRequest.setEmail(EditText_email.getText().toString());
        userRequest.setPhone(EditText_phone.getText().toString());
        userRequest.setAddress(EditText_address.getText().toString());

        String _id = User.getInstance().getUserId();

        Call<User> updateResponseCall = ApiClient.getUserService().updateUser(_id);
        updateResponseCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Activity_update_user.this, "Update Successfull", Toast.LENGTH_LONG).show();

                    User updateResponse = response.body();

                } else {
                    Toast.makeText(Activity_update_user.this, "Please verify your", Toast.LENGTH_LONG).show();

                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Activity_update_user.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

}
