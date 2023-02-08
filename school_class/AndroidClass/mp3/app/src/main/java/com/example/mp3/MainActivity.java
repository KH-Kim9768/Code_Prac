package com.example.mp3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button pl, st;
    View.OnClickListener cl;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pl = (Button) findViewById(R.id.play);
        st = (Button) findViewById(R.id.stop);

        mp = MediaPlayer.create(this, R.raw.lovestory);
        mp.setLooping(true); // mp3 무한반복
        
        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.play:
                        if(mp.isPlaying() == false){
                            mp = MediaPlayer.create(getApplicationContext(), R.raw.lovestory);
                            mp.start();
                        }
                        break;

                    case R.id.stop:
                        if(mp.isPlaying() == true){
                            mp.stop();
                        }
                        break;
                }
            }
        };

        pl.setOnClickListener(cl);
        st.setOnClickListener(cl);
    }
}