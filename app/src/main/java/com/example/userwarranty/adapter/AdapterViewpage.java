package com.example.userwarranty.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.userwarranty.fragment.canhanFragment;
import com.example.userwarranty.fragment.datlichFragment;
import com.example.userwarranty.fragment.lienheFragment;
import com.example.userwarranty.fragment.trangchuFragment;

public class AdapterViewpage extends FragmentStatePagerAdapter {


    public AdapterViewpage(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new trangchuFragment();
            case 1:
                return new datlichFragment();
            case 2:
                return new lienheFragment();
            case 3:
                return new canhanFragment();
            default:
                return new trangchuFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
