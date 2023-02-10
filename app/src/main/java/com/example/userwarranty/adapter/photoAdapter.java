package com.example.userwarranty.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.userwarranty.Model.photo;
import com.example.userwarranty.fragment.trangchuFragment;

import java.util.List;

public class photoAdapter extends FragmentStateAdapter {
    private List<photo> mlistPhoto;

    public photoAdapter(@NonNull trangchuFragment fragmentActivity, List<photo>list) {
        super(fragmentActivity);
        this.mlistPhoto =  list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        photo photos = mlistPhoto.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_photo", photos);
        return null;
    }

    @Override
    public int getItemCount() {
        if(mlistPhoto != null){
            return mlistPhoto.size();
        }
        return 0;
    }
}