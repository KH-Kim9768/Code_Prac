package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyFragmentPagerAdapter extends FragmentStateAdapter {

    private final int mSetItemCount = 2;

    // 생성자
    public MyFragmentPagerAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
//        int iViewIdx = getRealPosition(position);
        switch (position){  // Fragment 순서에 맞게 투입
            case 0: return new Fragment2();
            case 1: return new Fragment3();

            default: return new Fragment2(); // 기본 Fragment

        }
    }

//    public int getRealPosition(int position){
//        return position % mSetItemCount;
//    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return mSetItemCount;
    }


}
