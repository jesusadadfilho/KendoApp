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
    private boolean executando;
    private long time;
    private boolean pause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contagem);
        setupViews();
        executando = true;
        pause = false;
    }

    private void setupViews() {
        playPauseBtn = findViewById(R.id.play_pause_btn);
        crono = findViewById(R.id.crono);
    }

    public void playPause(View view) {
        if(executando){
            long base = pause ? time :  SystemClock.elapsedRealtime();
            crono.setBase(base);
            crono.start();
            executando = false;//todo:terminarcronometro
            pause = false;
            Toast.makeText(this,"play",Toast.LENGTH_SHORT).show();
        }else {
            pause = true;
            time =  Long.valueOf(crono.getBase());
            crono.stop();
            executando = true;
            Toast.makeText(this,"pause" + crono.toString(),Toast.LENGTH_SHORT).show();
        }
    }

}
