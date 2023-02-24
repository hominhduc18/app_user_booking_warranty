package com.example.userwarranty.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.userwarranty.fragment.photo1Fragment;
import com.example.userwarranty.fragment.photo2Fragment;

public class adapterSlide extends FragmentStatePagerAdapter {


    public adapterSlide(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            default:
                return new photo1Fragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
