package com.example.userwarranty.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.userwarranty.R;
import com.example.userwarranty.fragment.trangchuFragment;

public class Activity_dien extends AppCompatActivity {
    ImageView image_back_dien ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_dien);


        image_back_dien = findViewById(R.id.image_back_dien);
        image_back_dien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_dien.this,trangchuFragment.class);
                startActivity(intent);
            }
        });

    }

}
