package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return slide_images.length;
    }


    public int[] slide_images = {
        R.drawable.intro_1,
            R.drawable.intro_2,
            R.drawable.intro_3,
            R.drawable.intro_1
    };

    public String[] slide_text = {
           "목표와 습관 관리",
            "디노와 함꼐",
            "다양한 디노 친구들",
            "목표와 습관 관리"


    };

    public String[] slide_subtext ={
            "이루고 싶은 목표나 습관을 등록하고\n 매일 한 발짝씩 나아가요.",
            "목표와 습관을 위해 노력할수록\n" +
                    "디노 친구들이 어른이 될 수 있어요.",
            "한 친구를 성장시켜 주면\n" +
                    "새로운 친구를 만날 수 있어요.",
            "한 친구를 성장시켜 주면\n" +
                    "새로운 친구를 만날 수 있어요."

    };

    public int[] slide_dot ={
           R.drawable.green_circle,
            R.drawable.gray_circle,
            R.drawable.gray_circle,
            R.drawable.gray_circle
    };

    public int[] slide_dott={
            R.drawable.gray_circle,
            R.drawable.green_circle,
            R.drawable.gray_circle,
            R.drawable.gray_circle

    };

    public int[] slide_dottt ={
            R.drawable.gray_circle,
            R.drawable.gray_circle,
            R.drawable.green_circle,
            R.drawable.green_circle

    };

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container,int position){

        layoutInflater = (LayoutInflater) context.getSystemService( context.LAYOUT_INFLATER_SERVICE );
        View view = layoutInflater.inflate(R.layout.loading_one,container,false);

        ImageView slideImageView = (ImageView)view.findViewById(R.id.intro_1);
        TextView slideTextView = (TextView)view.findViewById( R.id.introtext_1 );
        ImageView slidesubImageView = (ImageView)view.findViewById(R.id.intro_11);
        TextView slidesubTextView = (TextView)view.findViewById( R.id.introtext_11 );
        ImageView slidesubbImageView = (ImageView)view.findViewById( R.id.intro_111 );
        ImageView slidesubbbImageView = (ImageView)view.findViewById( R.id.intro_1111 );


        slideImageView.setImageResource( slide_images[position] );
        slideTextView.setText(slide_text[position]);
        slidesubImageView.setImageResource( slide_dot[position] );
        slidesubTextView.setText(slide_subtext[position]);
        slidesubbImageView.setImageResource( slide_dott[position] );
        slidesubbbImageView.setImageResource( slide_dottt[position] );


        container.addView( view );
        return view;
    }


    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
