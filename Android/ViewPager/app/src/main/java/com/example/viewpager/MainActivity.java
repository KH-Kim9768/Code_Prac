package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = new Fragment1();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

    }


}