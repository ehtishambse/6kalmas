package com.developer.arsltech.a6kalma;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;

public class first_kalma extends Activity {

    MediaPlayer player;
    Button backBtn,Btnplay,Btnstop,Btnpause;
    int pause;
    SeekBar seekBar;
    AudioManager audioManager;

    Button nextKalma,previous1Kalma;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_kalma);

        Btnplay=(Button)findViewById(R.id.btn_play);
        Btnpause=(Button)findViewById(R.id.btn_pause);
        Btnstop=(Button)findViewById(R.id.btn_stop);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        VolumeSB();

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Window window=getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorAction));
        }
        seekBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.main), PorterDuff.Mode.MULTIPLY);
        seekBar.getThumb().setColorFilter(getResources().getColor(R.color.main), PorterDuff.Mode.SRC_IN);

        nextKalma= (Button) findViewById(R.id.firstnext);
        previous1Kalma= (Button) findViewById(R.id.previous);

        nextKalma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent next=new Intent(first_kalma.this,second_kalma.class);
                startActivity(next);
                first_kalma.this.finish();
            }
        });

        previous1Kalma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent previous2=new Intent(first_kalma.this,six_kalmas.class);
                startActivity(previous2);
                first_kalma.this.finish();
            }
        });


        Btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player==null) {
                    player = MediaPlayer.create(first_kalma.this, R.raw.one_kalma);
                    player.start();
                }

                else if(!player.isPlaying()){
                    player.seekTo(pause);
                    player.start();

                }
            }
        });

        Btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player!=null) {
                    player.stop();
                    player = null;
                }
            }
        });

        Btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player!=null){
                    player.pause();
                    pause = player.getCurrentPosition();
                }

            }
        });


    }

    private void VolumeSB() {
        try {
            seekBar = (SeekBar) findViewById(R.id.Volumesb);


            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            seekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);

                }
            });

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(player!=null) {
            player.stop();
            player = null;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(player!=null){
            player.stop();}
        finish();
    }
}
