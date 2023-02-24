package com.example.userwarranty.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.userwarranty.activity.Activity_cntt;
import com.example.userwarranty.activity.Activity_dien;
import com.example.userwarranty.R;
import com.example.userwarranty.activity.Activity_more;
import com.example.userwarranty.activity.Activity_phone;
import com.example.userwarranty.adapter.adapterSlide;

/**
 * A simple {@link Fragment} subclass.
 */
public class trangchuFragment extends Fragment {

//    private ImageView img_dien, img_dienlanh, img_ongnc, img_it, img_phone,img_NL,img_fixnha,img_vesinh,img_khac;

    private LinearLayout layout_dien;
    private LinearLayout layout_CNTT;
    private LinearLayout layout_phone;
    private LinearLayout layout_more;
    private ViewPager viewPager;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trangchu, container, false);
        layout_dien = view.findViewById(R.id.layout_dien);
        layout_CNTT = view.findViewById(R.id.layout_CNTT);
        layout_phone = view.findViewById(R.id.layout_phone);
        layout_more = view.findViewById(R.id.layout_more);

        viewPager = view.findViewById(R.id.id_viewpage);
        adapterSlide  adapterSlides = new adapterSlide(getParentFragmentManager(),FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapterSlides);
        adapterSlides.notifyDataSetChanged();


        layout_dien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity_dien.class);
                startActivity(intent);
            }
        });

        layout_CNTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Activity_cntt.class);
                    startActivity(intent);
            }
        });

        layout_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity_phone.class);
                startActivity(intent);
            }
        });

        layout_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity_more.class);
                startActivity(intent);
            }
        });
        return view;

    }


}