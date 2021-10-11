package com.example.gesture_viewpager;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CustomViewPagerAdapter extends FragmentStateAdapter {

    private final int ITEM_COUNT = 2;

    public CustomViewPagerAdapter(FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position) {
            case 0:
                Log.d("NowPosition", getItemId(position)+"");
                return new CaptureFragment();
            case 1:
                Log.d("NowPosition", getItemId(position)+"");
                return new LogFragment();

            default:
                return new CaptureFragment();
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return ITEM_COUNT;
    }
}
