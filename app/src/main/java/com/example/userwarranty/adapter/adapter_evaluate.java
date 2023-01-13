package com.example.userwarranty.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.example.userwarranty.R;
import com.example.userwarranty.fragment.fragment_thank_you;

public class adapter_evaluate extends Dialog {
    private float userRating =0 ;
    public adapter_evaluate(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_evaluate);

        final AppCompatButton ratenowbtn = findViewById(R.id.btnRatenow);
        final AppCompatButton laterbtn = findViewById(R.id.btnmaybe);
        final RatingBar ratingbar = findViewById(R.id.ratingbar);
        final ImageView ratingImage = findViewById(R.id.ratingImage);
        ratenowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        laterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
            }
        });
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (rating <= 1) {
                    ratingImage.setImageResource(R.drawable.motsao);
                } else if (rating <= 2) {
                    ratingImage.setImageResource(R.drawable.twosao);
                } else if (rating <= 3) {
                    ratingImage.setImageResource(R.drawable.basao);
                } else if (rating <= 4) {
                    ratingImage.setImageResource(R.drawable.bonsao);
                } else {
                    ratingImage.setImageResource(R.drawable.fivesao);
                }
                animateImage(ratingImage);
                userRating= rating;
            }
        });
    }

    private void startActivity(Intent i) {

    }

    private void animateImage(ImageView ratingImage){
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1f,1f,
                0, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(3000);
        ratingImage.startAnimation(scaleAnimation);
    }
}
