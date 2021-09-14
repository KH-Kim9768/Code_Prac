package com.example.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class Fragment1 extends Fragment {

    // 뷰그룹 객체 선언
    private ViewGroup viewGroup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        // 뷰그룹 인플레이션 한 뒤 viewGroup에 리턴
        // 인플레이션 --> xml에 있는 여러 코드들이 메모리에 올라가고, 그 올라간 메모리에서 UI들이 출력되는 과정
        // 여기서 Fragment를 FrameLayout(container)에 출력해주는 과정이라고 할 수 있다
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment1_layout, container, false);


        setInit(); // 뷰페이저2 실행 메서드
        return viewGroup;
    }

    private void setInit(){ // 뷰페이저2 실행 메서드
        // 뷰페이저 참조
        ViewPager2 viewpageSetup = viewGroup.findViewById(R.id.viewpager);
        
        // 생성자 매개변수 --> Fragment에서는 getActivity()를, Activity에서는 this를 사용
        MyFragmentPagerAdapter SetupPagerAdapter = new MyFragmentPagerAdapter(getActivity());
        viewpageSetup.setAdapter(SetupPagerAdapter); // 어댑터 연결

        viewpageSetup.setOrientation(ViewPager2.ORIENTATION_VERTICAL); // 방향 설정




    }
}
