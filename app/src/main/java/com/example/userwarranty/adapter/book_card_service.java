package com.example.userwarranty.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userwarranty.MainActivity;
import com.example.userwarranty.R;
import com.example.userwarranty.models.Api.ApiClient;
import com.example.userwarranty.models.modelRequest.maintenance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class book_card_service extends RecyclerView.Adapter<book_card_service.book_card_service_ViewHolder> {
    private Context context;
    private List<maintenance> maintenanceList;

    public book_card_service(Context context) {
        this.context = context;
    }

    public void setData(List<maintenance> list){
        this.maintenanceList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public book_card_service_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_book_card_service,parent,false);

        return new book_card_service_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull book_card_service_ViewHolder holder, int position) {
        maintenance maintenances = maintenanceList.get(position);
        if(maintenances == null){
            return;
        }
        holder.editTextStyleBooked.setText(maintenances.getDescription());
        holder.edittextBookedDate.setText(maintenances.getDate());
        holder.edittextViewHourBooked.setText(maintenances.getStartHour());
        holder.buttonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(book_card_service.this, "Testing", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if(maintenanceList != null){
            return maintenanceList.size();
        }
        return 0;
    }

    public class book_card_service_ViewHolder extends RecyclerView.ViewHolder{
        private EditText editTextStyleBooked;
        private EditText edittextBookedDate;
        private EditText edittextViewHourBooked;
        private Button buttonBook;

        public book_card_service_ViewHolder(@NonNull View itemView) {
            super(itemView);

            editTextStyleBooked = itemView.findViewById(R.id.editTextStyleBooked);
            edittextBookedDate = itemView.findViewById(R.id.edittextBookedDate);
            edittextViewHourBooked = itemView.findViewById(R.id.edittextViewHourBooked);
            buttonBook = itemView.findViewById(R.id.buttonBook);

        }
    }


}

