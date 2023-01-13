package com.example.userwarranty.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userwarranty.MainActivity;
import com.example.userwarranty.R;
import com.example.userwarranty.adapter.book_card_service;
import com.example.userwarranty.models.Api.ApiClient;
import com.example.userwarranty.models.Api.ApiService;
import com.example.userwarranty.models.modelRequest.maintenance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_book_card_service  extends AppCompatActivity {
    private RecyclerView recyclerBooked;
    private com.example.userwarranty.adapter.book_card_service book_card_service;
    private List<maintenance> mlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_book_card_service);

        recyclerBooked = findViewById(R.id.recyclerBooked);
        book_card_service = new book_card_service(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerBooked.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerBooked.addItemDecoration(itemDecoration);

       mlist = new ArrayList<>();
//       callApi();

//
    }

//    private void callApi(){
//       ApiClient.getUserService().getList("63ba76107634e164eeb9af29").enqueue(new Callback<maintenance>() {
//           @Override
//           public void onResponse(Call<maintenance> call, Response<maintenance> response) {
//                mlist  = response.body();
//                book_card_service book_card_service = new book_card_service(mlist);
//                recyclerBooked.setAdapter(book_card_service);
//           }
//
//           @Override
//           public void onFailure(Call<maintenance> call, Throwable t) {
//               Toast.makeText(fragment_book_card_service.this,"on Fail",Toast.LENGTH_LONG).show();
//
//           }
//       });
//    }


}

