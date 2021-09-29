package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private ImageView btn_next, btn_pre;
    private int current;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPagerImageSlider);
        btn_next = findViewById(R.id.btn_next);
        btn_pre = findViewById(R.id.btn_pre);
        mTabLayout = findViewById(R.id.mTabLayout);

        // 상단 슬라이드 이미지
        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.image1));
        sliderItems.add(new SliderItem(R.drawable.image2));
        sliderItems.add(new SliderItem(R.drawable.image3));
        sliderItems.add(new SliderItem(R.drawable.image4));
        sliderItems.add(new SliderItem(R.drawable.image5));

        // 하단 미리보기 이미지
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.image1));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.image2));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.image3));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.image4));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.image5));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.card0));
//        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.image1));
//        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.image1));
//        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.image1));
//        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.image1));

        //미리보기 페이지 포함 총 3개의 화면을 보여줌
        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setCurrentItem(Integer.MAX_VALUE / 2, false); //무한페이지 처럼 보이거 하기 위해서 시작을 처음이 아닌 중간에서 시작
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


        //viewpager 좌우 프리뷰
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        // 다음 이미지 보기 버튼
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = viewPager2.getCurrentItem();
                if (current == 0) {
                    viewPager2.setCurrentItem(1, true);
                } else {
                    viewPager2.setCurrentItem(current + 1, true);
                }
            }
        });

        // 이전 이미지 보기 버튼
        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current = viewPager2.getCurrentItem();
                if (current == 0) {
                    viewPager2.setCurrentItem(current, true);
                } else {
                    viewPager2.setCurrentItem(current - 1, true);
                }
            }
        });


        /*
           tabLayout 클릭시 뷰페이저 설정

         */

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // tab이 선택되었을 때
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}