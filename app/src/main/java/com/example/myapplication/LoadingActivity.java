package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LoadingActivity extends AppCompatActivity{

    private ImageView loading;
    private  static int loadingTimeout=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);
        loading = (ImageView)findViewById(R.id.loading);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LoadingActivity.this,IntroActivity.class);
                startActivity(i);
                finish();

            }
        },loadingTimeout);

        Animation dinoloading = AnimationUtils.loadAnimation(this,R.anim.loadinganimation);
        loading.startAnimation(dinoloading);




    }

}
