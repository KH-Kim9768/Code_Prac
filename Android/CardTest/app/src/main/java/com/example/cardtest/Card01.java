package com.example.cardtest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.viewpager2.widget.ViewPager2;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Card01 extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private ImageView imageView;
    private Card01_ViewPagerAdapter viewPagerAdapter;
    private RelativeLayout editLayout;

    Button btnSave;

    String storagePath;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_01);



        imageView = findViewById(R.id.imageView);
        viewPager2 = findViewById(R.id.decoItemViewPager);
        editLayout = findViewById(R.id.editLayout);

        btnSave = findViewById(R.id.card01_btn_save);

        // 저장 버튼
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharingImage();
            }
        });

        // Card00 에서 선택한 이미지 배경으로 설정
        Intent intent = getIntent();
        int getBg = intent.getExtras().getInt("bg", R.drawable.ic_launcher_foreground);
        Drawable drawable = getResources().getDrawable(getBg);
        editLayout.setBackground(drawable);

        ArrayList<Integer> items = new ArrayList<>();


        // items 추가
        for (int i = 0; i< 32; i++){
//            items.add(android.R.drawable.ic_menu_camera);
//            items.add(android.R.drawable.ic_popup_reminder);
//            items.add(android.R.drawable.ic_media_pause);
//            items.add(android.R.drawable.ic_menu_save);
//            items.add(R.drawable.card_next);
//            items.add(R.drawable.card_previous);
//            items.add(R.drawable.inssatest_answer_icon_refresh);
//            items.add(R.drawable.inssatest_answer_icon_screenrotation);
            items.add(R.drawable.card_deco_01);
            items.add(R.drawable.card_deco_02);
            items.add(R.drawable.card_deco_03);
            items.add(R.drawable.card_deco_04);
            items.add(R.drawable.card_deco_05);
        }

        viewPagerAdapter = new Card01_ViewPagerAdapter(items);
        viewPagerAdapter.setOnItemClickListener(index -> {

            int rid = items.get(index);
            ImageView deco = new ImageView(this);
            deco.setImageResource(rid);

            // 이미지 뷰 이동 및 확대 축소 관련
            MyTouchListener myTouchListener = new MyTouchListener();
            deco.setOnTouchListener(myTouchListener);




            editLayout.addView(deco);
        });

        viewPager2.setAdapter(viewPagerAdapter);

    }

    public void sharingImage(){
        Context context = getApplicationContext();



    }
}
