package com.example.readbarcode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.zxing.integration.android.IntentIntegrator;

public class CaptureFragment extends Fragment {
    private ViewGroup viewGroup;
    private IntentIntegrator integrator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.capture_fragment_layout, container, false);



        return viewGroup;
    }

    @Override
    public void onResume() {
        super.onResume();
        IntentIntegrator integrator = new IntentIntegrator(getActivity());
        integrator.setPrompt("Scan a barcode or QRCode");
        integrator.setCaptureActivity(ZxingActivity.class);
        integrator.setOrientationLocked(false);
        integrator.initiateScan();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
