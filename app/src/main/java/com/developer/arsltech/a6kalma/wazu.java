package com.developer.arsltech.a6kalma;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class wazu extends Activity {

    PhotoView photoView;
    Button wazu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wazu);


        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Window window=getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorAction));
        }
        photoView=(PhotoView) findViewById(R.id.wazophoto);
        wazu=(Button) findViewById(R.id.backwazu);
        wazu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iiii=new Intent(wazu.this,MainActivity.class);
                startActivity(iiii);
             wazu.this.finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
          super.onBackPressed();
        wazu.this.finish();
    }
}
