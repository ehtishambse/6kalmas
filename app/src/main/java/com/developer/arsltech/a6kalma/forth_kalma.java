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

public class forth_kalma extends Activity {

    Button next4Kalma,previous4Kalma;
    MediaPlayer player;
    Button backBtn,Btnplay,Btnstop,Btnpause;
    int pause;
    SeekBar seekBar;
    AudioManager audioManager;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth_kalma);


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


        next4Kalma= (Button) findViewById(R.id.forthnext);
        previous4Kalma=(Button) findViewById(R.id.previous4);
        seekBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.main), PorterDuff.Mode.MULTIPLY);
        seekBar.getThumb().setColorFilter(getResources().getColor(R.color.main), PorterDuff.Mode.SRC_IN);

        next4Kalma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent next3=new Intent(forth_kalma.this,fifth_kalma.class);
                startActivity(next3);
                forth_kalma.this.finish();
            }
        });

        previous4Kalma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent previous3=new Intent(forth_kalma.this,third_kalma.class);
                startActivity(previous3);

                if(player!=null){
                    player.stop();}
                forth_kalma.this.finish();
            }
        });



        Btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player==null) {
                    player = MediaPlayer.create(forth_kalma.this, R.raw.four_kalma);
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