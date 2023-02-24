package com.example.userwarranty.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.userwarranty.R;
import com.example.userwarranty.fragment.trangchuFragment;

public class Activity_phone extends AppCompatActivity {
    ImageView img_back_phone ;
    trangchuFragment trangchuFragments;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_phone);

        img_back_phone = findViewById(R.id.img_back_phone);
        img_back_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_phone.this, trangchuFragment.class);
                startActivity(intent);
            }
        });

    }
}
