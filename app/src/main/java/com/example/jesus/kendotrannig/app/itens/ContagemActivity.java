package com.example.jesus.kendotrannig.app.itens;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jesus.kendotrannig.R;
import com.example.jesus.kendotrannig.app.ReproducaoActivity;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ContagemActivity extends YouTubeBaseActivity {

    private Chronometer crono;
    private ImageButton playPauseBtn;
    private YouTubePlayerView youTubePlayerView;
    private long time, timeStop;
    private YouTubePlayer player;
    private boolean pause;
    public static String VIDEO_ID;
    public static final String API_KEY = "AIzaSyBx7v0YOb140fDO7EbfMx4l87raxezDWFw";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contagem);
        setupViews();
        VIDEO_ID = getIntent().getStringExtra("link");
        pause = false;
        time = 0;
        timeStop = 0;
    }

    private void setupViews() {
        playPauseBtn = findViewById(R.id.play_pause_btn);
        crono = findViewById(R.id.crono);
        youTubePlayerView = findViewById(R.id.youtube_contagem_view);
        youTubePlayerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo(VIDEO_ID);
                player = youTubePlayer;
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(ContagemActivity.this, "Error ao iniciar o YouTubePlayer.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void playPause(View view) { //TODO: Realizar stop e reproduzir video em loop
        if(!pause){
            crono.setBase(SystemClock.elapsedRealtime() - time);
            crono.start();
            pause = true;
            Toast.makeText(this,"play",Toast.LENGTH_SHORT).show();
            playPauseBtn.setImageResource(R.drawable.ic_pause);
            player.play();
        }else {
            pause = false;
            time =  SystemClock.elapsedRealtime() - crono.getBase();
            crono.stop();
            Toast.makeText(this,"pause",Toast.LENGTH_SHORT).show();
            playPauseBtn.setImageResource(R.drawable.ic_play_arrow);
            player.pause();
        }
    }

    public void stop(View view) {

    }
}
