package com.developer.arsltech.a6kalma;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class six_kalmas extends Activity  {
    private AdView mAdView;
    Button one,two,three,four,five,six;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_kalmas);

        MobileAds.initialize(this,"ca-app-pub-8863088720647115~8400528181");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Window win=getWindow();
            win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            win.setStatusBarColor(getResources().getColor(R.color.action2));

                 }
        one=(Button) findViewById(R.id.firstkalma);
        two=(Button) findViewById(R.id.secondkalma);
        three=(Button) findViewById(R.id.thirdkalma);
        four=(Button) findViewById(R.id.forthkalma);
        five=(Button) findViewById(R.id.fifthkalma);
        six=(Button) findViewById(R.id.sixkalma);



        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(six_kalmas.this,first_kalma.class);
                startActivity(i);
                six_kalmas.this.finish();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o =new Intent(six_kalmas.this,second_kalma.class);
                startActivity(o);
                six_kalmas.this.finish();
            }
        });
       three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent tw=new Intent(six_kalmas.this,third_kalma.class);
                startActivity(tw);
                six_kalmas.this.finish();
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent th =new Intent(six_kalmas.this,forth_kalma.class);
                startActivity(th);
                six_kalmas.this.finish();
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f =new Intent(six_kalmas.this,fifth_kalma.class);
                startActivity(f);
                six_kalmas.this.finish();
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fi =new Intent(six_kalmas.this,six_kalma.class);
                startActivity(fi);
                six_kalmas.this.finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
            super.onBackPressed();
            six_kalmas.this.finish();
    }
}
