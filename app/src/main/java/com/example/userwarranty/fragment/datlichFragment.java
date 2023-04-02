package com.example.userwarranty.fragment;

import android.app.Application;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.userwarranty.Model.Api.ApiClient;
import com.example.userwarranty.Model.Request.User;
import com.example.userwarranty.Model.Request.maintenance;
import com.example.userwarranty.Notifications.Applicationss;
import com.example.userwarranty.R;
import com.example.userwarranty.activity.Activity_listView_history;
import com.example.userwarranty.activity.MainActivity;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**

 * create an instance of this fragment.
 */
public class datlichFragment extends Fragment  {
    private  View view;
    private EditText editText_ten, editText_SĐT, editText_Đc, editText_cv, editText_GC;
    private Button btn_dat_lich;
    private TextView editText_TG,editText_ngay;
    private maintenance userMaintenance = new maintenance();
    private String date;

    public void init(){
        editText_ten = view.findViewById(R.id.editText_ten);
        editText_SĐT = view.findViewById(R.id.editText_SĐT);
        editText_Đc =  view.findViewById(R.id.editText_Đc);

        editText_cv =  view.findViewById(R.id.editText_cv);
        editText_GC =  view.findViewById(R.id.editText_GC);
        editText_ngay =  view.findViewById(R.id.editText_ngay);
        btn_dat_lich = view.findViewById(R.id.btn_dat_lich);

        editText_TG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_TimePickerDialog();
            }
        });
        editText_ngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_DatePickerDialog();
            }
        });

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_datlich, container, false);
        init();

        btn_dat_lich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editText_ten.getText().toString())){
                    Toast.makeText(getActivity(),"\"Name not verified, Please verify your Name.\"",Toast.LENGTH_LONG).show();
                }
                else  if(TextUtils.isEmpty(editText_SĐT.getText().toString())){
                    Toast.makeText(getActivity(),"\"Phone not verified, Please verify your Phone.\"",Toast.LENGTH_LONG).show();
                }
                else  if(TextUtils.isEmpty(editText_Đc.getText().toString())){
                    Toast.makeText(getActivity(),"\"Address not verified, Please verify your Address.\"",Toast.LENGTH_LONG).show();
                }
                else  if(TextUtils.isEmpty(editText_ngay.getText().toString())){
                    Toast.makeText(getActivity(),"\"Day not verified, Please verify your Day.\"",Toast.LENGTH_LONG).show();
                }
                else  if(TextUtils.isEmpty(editText_cv.getText().toString())){
                    Toast.makeText(getActivity(),"\"CV not verified, Please verify your CV.\"",Toast.LENGTH_LONG).show();
                }else  if(TextUtils.isEmpty(editText_GC.getText().toString())){
                    Toast.makeText(getActivity(),"\"Noted not verified, Please verify your Noted.\"",Toast.LENGTH_LONG).show();
                }else {

                    open_dialog(Gravity.CENTER);
//                    userBooking();
                }
            }
        });
        return view;
    }
    private void open_dialog(int gravity){
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_booking);

        Window window = dialog.getWindow();
        if(window == null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        // khai bao clock bên ngoài vẫn tắt
        if(Gravity.BOTTOM == gravity){
            dialog.setCancelable(true);
        }else{
            dialog.setCancelable(false);
        }

        Button btn_cancel_bookings = dialog.findViewById(R.id.btn_cancel_booking);
        Button btn_okay_bookings = dialog.findViewById(R.id.btn_okay_booking);

        btn_okay_bookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Successful appointment",Toast.LENGTH_LONG).show();
//                Send_Notification();
                userBooking();

            }
        });

        btn_cancel_bookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
    private void userBooking() {

        String _id = User.getInstance().getUserId();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        userMaintenance.setUsername(editText_ten.getText().toString());
        userMaintenance.setPhone(editText_SĐT.getText().toString());
        userMaintenance.setAddress(editText_Đc.getText().toString());
        userMaintenance.setDate(date);

        userMaintenance.setDescription(editText_cv.getText().toString());
        userMaintenance.setNoted(editText_GC.getText().toString());

        userMaintenance.setUser(_id);

        Call<maintenance> maintenanceCall = ApiClient.getUserService().app_booking(userMaintenance);
        maintenanceCall.enqueue(new Callback<maintenance>() {
            @Override
            public void onResponse(Call<maintenance> call, Response<maintenance> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getActivity(),"booking oke", Toast.LENGTH_LONG).show();
                    maintenance maintenanceResponse = response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(getActivity(), MainActivity.class).putExtra("date", maintenanceResponse.getUsername()));
                        }
                    }, 700);

                } else {
                    Toast.makeText(getActivity(), "booking Errr", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<maintenance> call, Throwable t) {
                Toast.makeText(getActivity(), "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    public void show_DatePickerDialog(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) +1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

//                String date = String.format("%04d-%02d-%02dT00:00:00Z", year, month, dayOfMonth);
                date = String.format("%04d-%02d-%02d", year, month, dayOfMonth);
                editText_ngay.setText(date);
                Toast.makeText(getActivity(),String.format("Selected Date: %d%d%d",year,month,dayOfMonth),
                        Toast.LENGTH_LONG).show();


            }
        }, year, month, day);
        datePickerDialog.show();


    }
    public void show_TimePickerDialog(){
        Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                String time = + hourOfDay + ":" + minute;
                editText_TG.setText(time);
                Toast.makeText(getActivity(),String.format("Selected Time: %d:%d",hourOfDay,minute),
                        Toast.LENGTH_LONG).show();
            }
        }, hour, minute, true);

        timePickerDialog.show();

    }

//    private void Send_Notification(){
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        Intent result = new Intent(getActivity(), Activity_listView_history.class);
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getActivity());
//        stackBuilder.addNextIntentWithParentStack(result);
//        PendingIntent resultPending =
//                stackBuilder.getPendingIntent(getNotificationId(),PendingIntent.FLAG_UPDATE_CURRENT);
//
//        Notification notification = new NotificationCompat.Builder(getActivity(),Applicationss.CHANNEL_ID)
//                .setContentTitle("Title Push Notification")
//                .setContentText("Message push Notification")
//                .setSmallIcon(R.drawable.thongbao)
//                .setSound(uri)// set nhạc
//                .setAutoCancel(true)// khi click vaof chuyen trang vaf xoa thong bao di
//                .setContentIntent(resultPending)//nhows addd vaof ddeer chuyen
//                .setLargeIcon(bitmap)
////                .setColor()
//                .build();
//        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getActivity());
//        notificationManagerCompat.notify(getNotificationId(), notification);
//    }
//    private int getNotificationId() {
//        return (int) new Date().getTime();
//    }

}