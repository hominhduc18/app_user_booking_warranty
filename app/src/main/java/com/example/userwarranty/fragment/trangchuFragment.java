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
        view= inflater.inflate(R.layout.fragment_trangchu, container, false);

        viewPager = view.findViewById(R.id.view_pager);
        circleIndicator = view.findViewById(R.id.circle_indicate);

        mListPhoto =getListPhoto();

        PhotoAdapter = new photoAdapter(this, mListPhoto);

        viewPager.setAdapter(PhotoAdapter);
        circleIndicator.setViewPager(viewPager);

        PhotoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        autoSlideImage();
        return view;

    }
    private List<photo> getListPhoto() {
        List<photo> list = new ArrayList<>();
        return list;
    }
    private void autoSlideImage(){
        if(mListPhoto == null || mListPhoto.isEmpty() || viewPager == null){
            return;
        }
        //khowir taoj timer
        if(mtimer == null){
            mtimer = new Timer();
        }
        mtimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = mListPhoto.size()-1;
                        if(currentItem <totalItem){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }else{
                            viewPager.setCurrentItem(0);
                        }
                    }
                });

            }
        },500,3000);//(delay,thowi gian sau moi lan xu ly)
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mtimer != null){
            mtimer.cancel();
            mtimer = null;
        }
    }
}