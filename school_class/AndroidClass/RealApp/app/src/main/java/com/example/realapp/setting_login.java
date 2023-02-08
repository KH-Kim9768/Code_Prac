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

public class setting_login extends Fragment {
    ViewGroup viewGroup;
    Button button1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.setting_login, container, false);
        button1 = (Button) viewGroup.findViewById(R.id.LoginActivity);
        Button button2 = (Button) viewGroup.findViewById(R.id.app_setting);
        Button button3 = (Button) viewGroup.findViewById(R.id.mypoint);
        Button button4 = (Button) viewGroup.findViewById(R.id.favorite);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail1();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail1();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail1();
            }
        });
        return viewGroup;

    }
    public void updateDetail1() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if(resultCode == 10){
                button1.setText("로그아웃");
            }
        }
    }
}