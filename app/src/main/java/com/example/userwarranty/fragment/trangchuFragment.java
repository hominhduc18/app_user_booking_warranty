package com.example.userwarranty.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private photoAdapter PhotoAdapter;
    // auto
    private List<photo> mListPhoto;
    private Timer mtimer;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_trangchu, container, false);


        return view;

    }
}