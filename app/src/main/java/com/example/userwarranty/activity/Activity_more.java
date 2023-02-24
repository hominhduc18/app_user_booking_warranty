package com.example.userwarranty.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.userwarranty.R;

public class Activity_more extends AppCompatActivity {
    private LinearLayout id_dienlanh;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        id_dienlanh = findViewById(R.id.id_dienlanh);

        id_dienlanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_more.this, Activity_dienlanh.class);
                startActivity(intent);
            }
        });


    }
}
