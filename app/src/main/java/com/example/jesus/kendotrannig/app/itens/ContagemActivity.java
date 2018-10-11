package com.example.jesus.kendotrannig.app.itens;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jesus.kendotrannig.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerView;

public class ContagemActivity extends YouTubeBaseActivity {

    private Chronometer crono;
    private ImageButton playPauseBtn;
    private YouTubePlayerView youTubePlayerView;
    private long time, timeStop;
    private boolean pause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contagem);
        setupViews();
        pause = false;
        time = 0;
        timeStop = 0;
    }

    private void setupViews() {
        playPauseBtn = findViewById(R.id.play_pause_btn);
        crono = findViewById(R.id.crono);
    }

    public void playPause(View view) { //TODO: Realizar stop e reproduzir video
        if(!pause){
            crono.setBase(SystemClock.elapsedRealtime() - time);
            crono.start();
            pause = true;
            Toast.makeText(this,"play" + (time + timeStop),Toast.LENGTH_SHORT).show();
            playPauseBtn.setImageResource(R.drawable.ic_pause);
        }else {
            pause = false;
            time =  SystemClock.elapsedRealtime() - crono.getBase();
            crono.stop();
            Toast.makeText(this,"pause" + time,Toast.LENGTH_SHORT).show();
            playPauseBtn.setImageResource(R.drawable.ic_play_arrow);
        }
    }

}
