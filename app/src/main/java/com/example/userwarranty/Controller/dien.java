package com.example.userwarranty.Controller;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.userwarranty.R;
import com.example.userwarranty.fragment.trangchuFragment;

public class dien extends AppCompatActivity {
     ImageView back ;
    trangchuFragment trangchuFragments;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_dien);

        back = findViewById(R.id.img_dien);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                trangchuFragments = new trangchuFragment();
//                FragmentTransaction transaction =  trangchuFragments.beginTransaction();
//                transaction.addToBackStack(null);
//                transaction.commit();


            }
        });

    }

}
