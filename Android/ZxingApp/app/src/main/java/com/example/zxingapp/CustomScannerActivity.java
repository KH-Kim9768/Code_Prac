package com.example.zxingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

public class CustomScannerActivity extends AppCompatActivity implements DecoratedBarcodeView.TorchListener{
    private CaptureManager capture;
    private DecoratedBarcodeView barcodeScannerView;
    private ImageButton setting_btn, switchFlashlightButton;
    private Boolean switchFlashlightButtonCheck;
    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_custom_scanner);

        switchFlashlightButtonCheck = true;
        backPressCloseHandler = new BackPressCloseHandler(this);

        setting_btn = (ImageButton) findViewById(R.id.setting_btn);
        switchFlashlightButton = (ImageButton) findViewById(R.id.switch_flashlight);

        if (!hasFlash()){
            switchFlashlightButton.setVisibility(View.GONE);
        }

        // 커스텀한 xml을 적용하고 라이트 제어를 위한 Torch리스너를 연결
        barcodeScannerView = (DecoratedBarcodeView) findViewById(R.id.zxing_barcode_scanner);
        barcodeScannerView.setTorchListener(this);

        // CaptureManager에 DecorateBarcodeView를 연결시켜준 뒤 decode를 함
        capture = new CaptureManager(this, barcodeScannerView);
        capture.initializeFromIntent(getIntent(), savedInstanceState);
        capture.decode();

    }
    
    
    // --- 아직 이해 못함
    @Override
    protected void onResume() {
        super.onResume();
        capture.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        capture.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        capture.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        capture.onSaveInstanceState(outState);
    }
    // --------

    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }
    
    @Override
    public void onTorchOn() {
        switchFlashlightButton.setImageResource(R.drawable.ic_flash_on_white_36dp);
        switchFlashlightButtonCheck = false;
    }

    @Override
    public void onTorchOff() {
        switchFlashlightButton.setImageResource(R.drawable.ic_flash_off_white_36dp);
        switchFlashlightButtonCheck = true;
    }

    public void switchFlashlight(View view){
        if (switchFlashlightButtonCheck){
            barcodeScannerView.setTorchOn();
        } else {
            barcodeScannerView.setTorchOff();
        }
    }
    
    private boolean hasFlash(){
        return getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

}