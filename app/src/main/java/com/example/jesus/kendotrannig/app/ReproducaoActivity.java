package com.example.jesus.kendotrannig.app;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.jesus.kendotrannig.R;

public class ReproducaoActivity extends AppCompatActivity {

    VideoView videoView;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproducao);

        videoView = findViewById(R.id.video_view);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        String path = "https://www.youtube.com/watch?v=xvaAASh1JDc";
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });

        videoView.start();


    }
}
