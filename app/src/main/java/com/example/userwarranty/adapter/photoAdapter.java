package com.example.userwarranty.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.bumptech.glide.Glide;
import com.example.userwarranty.Model.photo;
import com.example.userwarranty.R;
import com.example.userwarranty.fragment.trangchuFragment;

import java.io.Serializable;
import java.util.List;

public class photoAdapter extends  PagerAdapter {
    private Context context;
    private List<photo> mlistphoto;


    public photoAdapter(Context context, List<photo> mlistphoto) {
//context
        this.context =context;
        this.mlistphoto = mlistphoto;
    }

    public photoAdapter(trangchuFragment trangchuFragment, List<photo> mListPhoto) {
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.adapter_iteam_photo,container, false);

        ImageView imgPhoto = view.findViewById(R.id.img_photo);
        photo photos = mlistphoto.get(position);
        if(photos != null){
            Glide.with(context).load(photos.getResourceID()).into(imgPhoto);
        }
        container.addView(view);
        return  view;
    }

    @Override
    public int getCount() {
        if(mlistphoto != null){
            return mlistphoto.size();
        }
        return 0;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //de rermove riew
        container.removeView((View) object);
    }
}