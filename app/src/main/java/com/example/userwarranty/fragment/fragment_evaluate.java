package com.example.userwarranty.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.userwarranty.R;
import com.example.userwarranty.adapter.adapter_evaluate;

public class fragment_evaluate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);/// bỏ qua phải về home

        adapter_evaluate rateuseDialog = new adapter_evaluate(fragment_evaluate.this);
        rateuseDialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        rateuseDialog.setCancelable(false);
        rateuseDialog.show();
    }
}
