package com.example.userwarranty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.userwarranty.Model.photo;
import com.example.userwarranty.adapter.AdapterViewpage;
import com.example.userwarranty.adapter.photoAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    AdapterViewpage adapterViewpage;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView =  findViewById(R.id.bottom_nav);
        viewPager = findViewById(R.id.viewpage);


        adapterViewpage = new AdapterViewpage(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapterViewpage);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.trang_chu:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.dat_lich:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.lien_he:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.ca_nhan:
                        viewPager.setCurrentItem(3);
                        break;
                }

            }

        });
    }
}