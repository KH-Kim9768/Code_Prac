package com.example.realapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class home extends Fragment {

    ViewGroup viewGroup;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.home,container,false);
        Button button1 = (Button) viewGroup.findViewById(R.id.interest);
        Button button2 = (Button) viewGroup.findViewById(R.id.distance);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail1();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail2();
            }
        });
        return viewGroup;
    }
    public void updateDetail1() {
        Intent intent = new Intent(getActivity(), interest.class);
        startActivity(intent);
}
    public void updateDetail2() {
        Intent intent = new Intent(getActivity(), distance.class);
        startActivity(intent);
    }

}

