package com.example.readbarcode;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class ZxingActivity extends AppCompatActivity {
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxing_activity_layout);

        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_zxing, homeFragment).commit();

    }




}
