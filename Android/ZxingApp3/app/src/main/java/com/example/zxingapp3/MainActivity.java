package com.example.zxingapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/*
========================================================

공통
AndroidManifest.xml 추가
    -> 각 Acitivity별 속성 추가  android:exported="true"

build.gradle 수정
    -> defaultConfig --> minSdkVersion 24로 변경

========================================================

Zxing
build.gradle에 추가
    -> implementation 'com.journeyapps:zxing-android-embedded:4.1.0' // ZXING Library



========================================================

Viewpager2
MainActivity
    -> homeFragmentInit() 메소드 생성
    -> Viewpager 객체 생성 후 어댑터 연결

MyViewPagerAdapter
    -> createFragment() Override
    ->

HomeFragment
    -> ViewGroup 생성 후 연결
    -> setInit() 생성
    ->

CaptureFragment
    -> ViewGroup 생성 후 연결
    -> onResume() Override
    -> Layout에 FrameLayout 생성 (ID : capture_frame_layout)

LogFragment
    -> ViewGroup 생성 후 연결

========================================================
 */


public class MainActivity extends AppCompatActivity {

    // 변수 선언부
    HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragmentInit();

    }

    private void homeFragmentInit(){
        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout, homeFragment).commit();

    }

}

