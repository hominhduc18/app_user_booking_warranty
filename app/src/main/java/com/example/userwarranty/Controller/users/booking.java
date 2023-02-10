package com.example.userwarranty.Controller.users;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.userwarranty.R;

public class booking extends AppCompatActivity {
    private Button btn_dat_lich;
    private EditText editText_ten;
    private EditText editText_SĐT;
    private EditText editText_CV;
    private EditText editText_TG;
    private EditText editText_GC;
    private EditText editText_ĐC;

    public void init(){
        btn_dat_lich = findViewById(R.id.btn_dat_lich);
        editText_ten = findViewById(R.id.editText_ten);
        editText_SĐT = findViewById(R.id.editText_SĐT);
        editText_ĐC = findViewById(R.id.editText_Đc);
        editText_CV = findViewById(R.id.editText_cv);
        editText_TG = findViewById(R.id.editText_TG);
        editText_GC = findViewById(R.id.editText_GC);

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_datlich);
        init();
        btn_dat_lich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editText_ten.getText().toString())){
                    Toast.makeText(booking.this,"Vui lòng nhập tên", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(editText_SĐT.getText().toString())){
                    Toast.makeText(booking.this,"Vui lòng nhập SĐT", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(editText_CV.getText().toString())){
                    Toast.makeText(booking.this,"Vui lòng nhập công việc", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(editText_GC.getText().toString())){
                    Toast.makeText(booking.this,"Vui lòng nhập ghi chú", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(editText_SĐT.getText().toString())){
                    Toast.makeText(booking.this,"Vui lòng nhập SĐT", Toast.LENGTH_LONG).show();
                }
            }
        });
    }





}
