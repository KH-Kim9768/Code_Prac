package com.example.zxingapp3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/*

createFragment() Override

getItemId() Override

getItemCount() Override

 */

public class MyViewPagerAdapter extends FragmentStateAdapter {
    // 변수 선언부
    private final int itemCount = 2;

    // 생성자
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0: return new CaptureFragment();
            case 1: return new LogFragment();

            default: return new CaptureFragment(); // default
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

}
