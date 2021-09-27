package com.example.zxingapp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class HomeFragment extends Fragment {
    // 변수 선언부
    ViewGroup viewGroup;
    ViewPager2 viewPager2;
    MyViewPagerAdapter myViewPagerAdapter;
    IntentIntegrator intentIntegrator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.home_fragment_layout, container, false);

        setInit();

        return viewGroup;

    }

    private void setInit(){
        // Viewpager 연결
        viewPager2 = (ViewPager2) viewGroup.findViewById(R.id.home_viewpager);

        // MyViewPagerAdapter 객체 생성 후 Viewpager에 연결
        myViewPagerAdapter = new MyViewPagerAdapter(getActivity());
        viewPager2.setAdapter(myViewPagerAdapter);

        // Viewpager 세로모드로 변경
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);


    }


}
