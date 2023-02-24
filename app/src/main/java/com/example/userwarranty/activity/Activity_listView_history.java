package com.example.userwarranty.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userwarranty.Model.Api.ApiClient;
import com.example.userwarranty.Model.Api.ApiUser;
import com.example.userwarranty.Model.Request.User;
import com.example.userwarranty.Model.Request.maintenance;
import com.example.userwarranty.R;
import com.example.userwarranty.adapter.RecleViewAdapter;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_listView_history extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecleViewAdapter userAdapter;
    private List<maintenance> userList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_history);


        recyclerView = findViewById(R.id.RecyclerView);

        userAdapter = new RecleViewAdapter(userList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Activity_listView_history.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(userAdapter);


        get_Maintenaces();


    }
    public void get_Maintenaces() {
        Call<maintenance> maintenanceCallss = ApiClient.getUserService().get_booking_ById("63fb1c888923a2134f8f7ddf");

        maintenanceCallss.enqueue(new Callback<maintenance>() {
            @Override
            public void onResponse(Call<maintenance> maintenance, Response<maintenance> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Activity_listView_history.this, "list view", Toast.LENGTH_LONG).show();

                    maintenance maintenanceRespond = response.body();
                    // neu ko goi ben Recle setData
                userList.add(maintenanceRespond);
//                userAdapter.notifyDataSetChanged();
                    userAdapter.setData(userList);
                    recyclerView.setAdapter(userAdapter);



                } else {
                    Toast.makeText(Activity_listView_history.this, "Please list view", Toast.LENGTH_LONG).show();

                }


            }

            @Override
            public void onFailure(Call<maintenance> call, Throwable t) {
                Toast.makeText(Activity_listView_history.this, "Failed to fetch data!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
