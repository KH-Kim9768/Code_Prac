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

public class setting_logout extends Fragment {
    ViewGroup viewGroup;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.setting_logout, container, false);
        Button button1 = (Button) viewGroup.findViewById(R.id.LoginActivity);
        Button button2 = (Button) viewGroup.findViewById(R.id.app_setting);
        Button button3 = (Button) viewGroup.findViewById(R.id.mypoint);
        Button button4 = (Button) viewGroup.findViewById(R.id.favorite);
        Button button5 = (Button) viewGroup.findViewById(R.id.Profile);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail1();
            }
        });
        return viewGroup;

    }
    public void updateDetail1() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

}