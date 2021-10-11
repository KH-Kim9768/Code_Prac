package com.example.gesture_viewpager;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LogFragment extends Fragment{
    View rootView;
    TextView actionView;


    public LogFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.log_fragment_layout, container, false);

        actionView = rootView.findViewById(R.id.action_view);

        MainActivity.customGestureListener.setTextView(actionView);



        return rootView;
    }


}


