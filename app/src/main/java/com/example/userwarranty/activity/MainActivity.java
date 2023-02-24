package com.example.userwarranty.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.userwarranty.R;
import com.example.userwarranty.adapter.AdapterViewpage;
import com.example.userwarranty.databinding.ActivityMainBinding;
import com.example.userwarranty.fragment.canhanFragment;
import com.example.userwarranty.fragment.datlichFragment;
import com.example.userwarranty.fragment.lienheFragment;
import com.example.userwarranty.fragment.trangchuFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
   
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new trangchuFragment());


        binding.bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.trang_chu:
                        replaceFragment(new trangchuFragment());
                        break;
                    case R.id.dat_lich:
                        replaceFragment(new datlichFragment());
                        break;
                    case R.id.lien_he:
                        replaceFragment(new lienheFragment());
                        break;
                    case R.id.ca_nhan:
                        replaceFragment(new canhanFragment());
                        break;
                }
                return true;
            }
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.farm_Layout,fragment);
        fragmentTransaction.commit();
    }
}