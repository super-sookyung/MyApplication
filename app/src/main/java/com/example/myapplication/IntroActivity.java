package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager SlideViewPager;
    private SliderAdapter sliderAdapter;
    private Button btn_start;
    private TextView a;
    private TextView b;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.loading_zero );


        SlideViewPager = (ViewPager) findViewById( R.id.slider );
        sliderAdapter = new SliderAdapter( this );
//        int a = sliderAdapter.getCount();

        SlideViewPager.setAdapter( sliderAdapter );

        SlideViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==2){
                    setContentView( R.layout.loading_three );
                    a =(TextView)findViewById( R.id.introtext_3 );
                    b = (TextView)findViewById( R.id.introtext_33 );
                    onClick( btn_start );
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });






    }

    @Override
    public void onClick(View v) {
        btn_start = (Button)findViewById( R.id.intro_33 ) ;
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
