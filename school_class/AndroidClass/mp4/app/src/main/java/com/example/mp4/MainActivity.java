package com.example.mp4;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button pl, st;
    View.OnClickListener cl;

    VideoView vv;
    Uri fname;
    MediaController mc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pl = (Button) findViewById(R.id.play);
        st = (Button) findViewById(R.id.stop);

        vv = (VideoView) findViewById(R.id.video);
        fname = Uri.parse("android.resource://com.example.mp4/" + R.raw.son);

        vv.setVideoURI(fname);
        mc = new MediaController(this);
        vv.setMediaController(mc);


        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.play:
                        if(vv.isPlaying() == false){
                            vv.setVideoURI(fname);
                            vv.start();
                        }
                        break;

                    case R.id.stop:
                        if(vv.isPlaying() == true){
                            vv.stopPlayback();
                        }
                        break;
                }
            }
        };

        pl.setOnClickListener(cl);
        st.setOnClickListener(cl);
    }
}