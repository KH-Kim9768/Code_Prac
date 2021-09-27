package com.example.zxingapp3;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Locale;

import static android.speech.tts.TextToSpeech.ERROR;

/*

viewGroup 객체 선언

onResume() Override

TextToSpeech 객체 tts 선언 후 onCreate에서 초기화
 */
public class CaptureFragment extends Fragment {

    // 변수 선언부
    private ViewGroup viewGroup;
    private IntentIntegrator intentIntegrator;
    private Button initScan;
    private TextView resultTextView;
    private TextToSpeech tts;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // scnner
        intentIntegrator = new IntentIntegrator(this.getActivity()).forSupportFragment(this);
        intentIntegrator.setPrompt("Scan a barcode or QRCode");
        intentIntegrator.setCaptureActivity(ZxingActivity.class);
        intentIntegrator.setOrientationLocked(false);

        // tts
        tts = new TextToSpeech(getActivity().getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if ( i != ERROR){
                    tts.setLanguage(Locale.KOREA);
                }
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.capture_fragment_layout, container, false);

        initScan = viewGroup.findViewById(R.id.init_scan_btn);
        resultTextView = viewGroup.findViewById(R.id.result_text_view);

        initScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentIntegrator.initiateScan();
            }
        });

        return viewGroup;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null){
            if(result.getContents() == null){
                Toast.makeText(getActivity(), "Cancelled", Toast.LENGTH_LONG).show();
            } else {
//                Toast.makeText(getActivity(), "String = " + result.getContents(), Toast.LENGTH_LONG).show();
                String FormatName = result.getFormatName();
                String contents = result.getContents();
                resultTextView.setText("Format = " + FormatName + ", String = " + contents);

                tts.speak(contents, TextToSpeech.QUEUE_FLUSH, null);


            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
