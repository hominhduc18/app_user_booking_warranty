package com.example.userwarranty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userwarranty.Model.Request.maintenance;
import com.example.userwarranty.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecleViewAdapter extends RecyclerView.Adapter<RecleViewAdapter.ViewHolder> {


    private List<maintenance> maintenanceList;
    private Context context;

    public void setData(List<maintenance> maintenanceResponseList) {
        this.maintenanceList = maintenanceResponseList;
        notifyDataSetChanged();
    }
    public RecleViewAdapter (List<maintenance> maintenanceList){
        this.maintenanceList = maintenanceList;
    }

    @NonNull
    @Override
    public RecleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyleview_list_booking,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecleViewAdapter.ViewHolder holder, int position) {
        maintenance maintenanceRespond = maintenanceList.get(position);

        String username =maintenanceRespond.getUsername();
        String des = maintenanceRespond.getDescription();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy/MM/dddd");

        String day = maintenanceRespond.getDate();

        holder.textView_name.setText(username);
        holder.textView_BH.setText(des);
        holder.textView_day.setText(day);



    }

    @Override
    public int getItemCount() {
        return maintenanceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView_name;
        private TextView textView_BH;
        private TextView textView_day;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_name = itemView.findViewById(R.id.textview_name);
            textView_BH = itemView.findViewById(R.id.textview_BH);
            textView_day = itemView.findViewById(R.id.textview_day);
        }

//        public void setDatas( String username, String decriptions, String day) {
//
//
//            textView_name .setText(username);
//            textView_BH.setText(decriptions);
//            textView_day.setText(day);
//        }
    }
}