package com.example.userwarranty.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.userwarranty.Model.Api.ApiClient;
import com.example.userwarranty.Model.Request.User;
import com.example.userwarranty.R;
import com.example.userwarranty.activity.Activity_listView_history;
import com.example.userwarranty.activity.Activity_infor_user;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.

 */
public class canhanFragment extends Fragment {
        ImageView image_info_account,image_history,image_thongbao,image_logout;
        View view;
        public void init(){
            image_info_account = view.findViewById(R.id.image_info_account);
            image_history = view.findViewById(R.id.image_history);
            image_thongbao = view.findViewById(R.id.image_thongbao);
            image_logout = view.findViewById(R.id.image_logout);

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_canhan, container, false);
        init();

        image_info_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               check_infor();
            }
        });
        image_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_lichsu();
            }
        });
        image_thongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_thongbao();

            }
        });
        image_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                open_dialog_logout( Gravity.CENTER);
            }
        });
        return view;



    }

    private void check_gout() {
        String token;
        Response<User>response = null;

        token = response.body().getAccessToken();
        Call<User> call = ApiClient.getUserService().getLogout(token);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User.getInstance().setUserId(null); // xóa id
                    Toast.makeText(getActivity(), response.body().toString(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "logout Fail", Toast.LENGTH_LONG).show();
                }

            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getActivity(),"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private void check_thongbao() {
            Intent intent = new Intent(getActivity(), Activity_infor_user.class);
            startActivity(intent);
    }

    private void check_lichsu() {
            Intent intent = new Intent(getActivity(), Activity_listView_history.class);
            startActivity(intent);
    }

    private void check_infor() {
        Intent intent = new Intent(getActivity(), Activity_infor_user.class);
        startActivity(intent);
    }

    private void open_dialog_logout(int gravity){
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_logout);

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

        Button btn_cancel_logout = dialog.findViewById(R.id.btn_cancel_logout);
        Button btn_okay_logout = dialog.findViewById(R.id.btn_okay_logout);

        btn_okay_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Logout Successful",Toast.LENGTH_LONG).show();
                check_gout();

            }
        });

        btn_cancel_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}