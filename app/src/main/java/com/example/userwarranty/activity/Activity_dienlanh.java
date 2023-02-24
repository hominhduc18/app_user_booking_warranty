package com.example.userwarranty.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.userwarranty.R;

public class Activity_dienlanh extends AppCompatActivity {
    private ImageView img_back_dienlanh;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_dienlanh);

        img_back_dienlanh = findViewById(R.id.img_back_dienlanh);

        img_back_dienlanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_dienlanh.this, Activity_more.class);
                startActivity(intent);
            }
        });

    }
}
