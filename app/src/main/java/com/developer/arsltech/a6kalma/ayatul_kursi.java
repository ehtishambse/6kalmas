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

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class ayatul_kursi extends Activity {

    MediaPlayer player;
    Button backBtn,Btnplay,Btnstop,Btnpause;
    PhotoView photoView;
    int pause;
    private InterstitialAd mInterstitialAd;
    SeekBar seekBar;
    AudioManager audioManager;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayatul_kursi);

        Btnplay=(Button)findViewById(R.id.btn_play);
        Btnpause=(Button)findViewById(R.id.btn_pause);
        Btnstop=(Button)findViewById(R.id.btn_stop);
        photoView=(PhotoView) findViewById(R.id.photo);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8863088720647115/9484958266");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        VolumeSB();

        seekBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.main), PorterDuff.Mode.MULTIPLY);
        seekBar.getThumb().setColorFilter(getResources().getColor(R.color.main), PorterDuff.Mode.SRC_IN);


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Window window=getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorAction));
        }
        backBtn=(Button) findViewById(R.id.backayat);



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(ayatul_kursi.this,MainActivity.class);
                startActivity(ii);
                if(player!=null){
                player.stop();}
                ayatul_kursi.this.finish();
            }
        });


        Btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player==null) {
                    player = MediaPlayer.create(ayatul_kursi.this, R.raw.ayatul_kursi_2);
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

        if(player!=null){
            player.stop();}

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    finish();
                }
            });
        }
        else{
            super.onBackPressed();
        }
    }

}
