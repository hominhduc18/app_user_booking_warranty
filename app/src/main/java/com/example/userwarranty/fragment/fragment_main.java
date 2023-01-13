package com.example.userwarranty.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userwarranty.R;
import com.example.userwarranty.adapter.book_card_service;
import com.google.android.material.navigation.NavigationView;

public class fragment_main extends AppCompatActivity {
    private TextView textview;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);


        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        findViewById(R.id.imgmenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController(this,R.id.naviHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);
        textview = findViewById(R.id.textViewTitle);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                textview.setText(navDestination.getLabel());
            }
        });

    }


}
