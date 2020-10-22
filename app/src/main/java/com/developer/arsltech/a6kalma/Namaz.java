package com.developer.arsltech.a6kalma;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Namaz extends Activity {

    ImageView v1,v2,v3,v4,v5;
    Button btn;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namaz);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Window window=getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorAction));
        }
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8863088720647115/9484958266");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

            btn=(Button) findViewById(R.id.backnamaz);
            v1=(ImageView) findViewById(R.id.imageView2);
            v2=(ImageView) findViewById(R.id.imageView3);
            v3=(ImageView) findViewById(R.id.imageView4);
            v4=(ImageView) findViewById(R.id.imageView5);
            v5=(ImageView) findViewById(R.id.imageView6);

            v1.setImageResource(R.drawable.first);
        v2.setImageResource(R.drawable.second);
        v3.setImageResource(R.drawable.third);
        v4.setImageResource(R.drawable.four);
        v5.setImageResource(R.drawable.five);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent iii=new Intent(Namaz.this,MainActivity.class);
            startActivity(iii);
            finish();
        }
    });


    }

    @Override
    public void onBackPressed() {
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
            Namaz.this.finish();
        }
    }
}
