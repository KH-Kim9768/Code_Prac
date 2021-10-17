package com.example.cardtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;


import java.util.ArrayList;

public class Card00 extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private int current;

    ArrayList<Card00_sliderItem> imageItems;
    Button btnPre, btnNext, btnSelect;
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_00);


        // 뷰 연결
        viewPager2 = findViewById(R.id.viewPagerImageSlider);
        btnNext = findViewById(R.id.btn_next);
        btnPre = findViewById(R.id.btn_pre);
        btnSelect = findViewById(R.id.btn_select);

        // 아이템 리스트
        imageItems = new ArrayList<>();
        imageItems.add(new Card00_sliderItem(R.drawable.card0));
        imageItems.add(new Card00_sliderItem(R.drawable.card1));
//        imageItems.add(new Card00_sliderItem(R.drawable.card2));
        imageItems.add(new Card00_sliderItem(R.drawable.card3));
        imageItems.add(new Card00_sliderItem(R.drawable.card3));
        imageItems.add(new Card00_sliderItem(R.drawable.card4));
        imageItems.add(new Card00_sliderItem(R.drawable.card5));
        imageItems.add(new Card00_sliderItem(R.drawable.card6));
        imageItems.add(new Card00_sliderItem(R.drawable.card7));
        imageItems.add(new Card00_sliderItem(R.drawable.card8));
        imageItems.add(new Card00_sliderItem(R.drawable.card9));

        viewPager2.setAdapter(new Card00_sliderAdapter(imageItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setCurrentItem(Integer.MAX_VALUE / 2, false); // 무한 페이지
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

//
//        //viewpager 좌우 프리뷰
//        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
//        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
//        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
//                float r = 1 - Math.abs(position);
//                page.setScaleY(0.85f + r * 0.15f);
//            }
//        });
//
//        viewPager2.setPageTransformer(compositePageTransformer);

        // 다음 이미지 보기 버튼
        btnNext.setOnClickListener(new View.OnClickListener() {
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
        btnPre.setOnClickListener(new View.OnClickListener() {
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

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Card01.class);
                intent.putExtra("bg", imageItems.get(viewPager2.getCurrentItem() % 10).getImage());
                startActivity(intent);

            }
        });


    }
}
