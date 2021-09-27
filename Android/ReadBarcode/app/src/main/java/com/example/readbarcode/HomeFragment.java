package com.example.readbarcode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class HomeFragment extends Fragment {
    private ViewGroup viewGroup;
    private ViewPager2 viewPager2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.home_fragment_layout, container, false);

        InitViewPager(); // 뷰페이저 실행

        return viewGroup;
    }

    private void InitViewPager(){
        viewPager2 = viewGroup.findViewById(R.id.viewpager);


        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getActivity());
        viewPager2.setAdapter(myFragmentPagerAdapter);

        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

    }


}
