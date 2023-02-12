package com.example.userwarranty.fragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.userwarranty.Controller.dien;
import com.example.userwarranty.Model.photo;
import com.example.userwarranty.R;
import com.example.userwarranty.adapter.photoAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class trangchuFragment extends Fragment {

    private ImageView img_dien, img_dienlanh, img_ongnc, img_it, img_phone,img_NL,img_fixnha,img_vesinh,img_khac;
    private dien dienActivity;
    private View view;

    public void init(){
        img_dien = view.findViewById(R.id.img_dien);
        img_dienlanh = view.findViewById(R.id.img_dienlanh);
        img_ongnc = view.findViewById(R.id.img_ongnc);
        img_it = view.findViewById(R.id.img_IT);
        img_phone = view.findViewById(R.id.img_phone);
        img_NL = view.findViewById(R.id.img_nangluong);
        img_fixnha = view.findViewById(R.id.img_suanha);
        img_vesinh = view.findViewById(R.id.img_vesinh);
        img_khac = view.findViewById(R.id.img_khac);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_trangchu, container, false);
        init();
        img_dien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dienActivity = new dien();
//                FragmentTransaction transaction =  dienActivity.getSupportFragmentManager().beginTransaction();
//                transaction.addToBackStack(null);
//                transaction.commit();

                Intent intent = new Intent(getActivity(),dien.class);
                startActivity(intent);
            }
        });

        return view;


    }



}