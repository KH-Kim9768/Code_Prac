package com.example.readbarcode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.zxing.integration.android.IntentIntegrator;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

public class CaptureFragment extends Fragment {
    private ViewGroup viewGroup;
    private IntentIntegrator integrator;

    CaptureManager captureManager;
    DecoratedBarcodeView decoratedBarcodeView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.scanner_view, container, false);

        decoratedBarcodeView = viewGroup.findViewById(R.id.zxing_barcode_scanner);

        captureManager = new CaptureManager(getActivity(), decoratedBarcodeView);
        captureManager.initializeFromIntent(getActivity().getIntent(), savedInstanceState);
        captureManager.decode();

        return viewGroup;
    }

    @Override
    public void onResume() {
        super.onResume();
        captureManager.onResume();

//        IntentIntegrator integrator = new IntentIntegrator(getActivity());
//        integrator.setPrompt("Scan a barcode or QRCode");
//        integrator.setCaptureActivity(ZxingActivity.class);
//        integrator.setOrientationLocked(false);
//        integrator.initiateScan();
    }

    @Override
    public void onPause() {
        super.onPause();
        captureManager.onPause();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        captureManager.onDestroy();

    }
}
