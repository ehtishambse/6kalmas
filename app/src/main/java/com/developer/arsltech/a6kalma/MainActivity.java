package com.developer.arsltech.a6kalma;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button btn1,btn4,btn5,btn6;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn1 = (Button) findViewById(R.id.btn_kalmas);
        btn4 = (Button) findViewById(R.id.btn_ayatulkursi);
        btn5 = (Button) findViewById(R.id.btn_pray);
        btn6 = (Button) findViewById(R.id.btn_Wazo);


        MobileAds.initialize(this,"ca-app-pub-8863088720647115~8400528181");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent first = new Intent(MainActivity.this, six_kalmas.class);
                startActivity(first);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sexond = new Intent(MainActivity.this, ayatul_kursi.class);
                startActivity(sexond);

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sthird = new Intent(MainActivity.this, Namaz.class);
                startActivity(sthird);

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sethird = new Intent(MainActivity.this, wazu.class);
                startActivity(sethird);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int id) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                finishAffinity();
                            }
                            System.exit(0);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
            alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorPrimaryDark));


        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) { onBackPressed(); }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_six_kalma) {
            startActivity(new Intent(getApplicationContext(),six_kalmas.class));

        } else if (id == R.id.nav_ayatul_kursi) {
            startActivity(new Intent(getApplicationContext(),ayatul_kursi.class));

        } else if (id == R.id.nav_namaz) {
            startActivity(new Intent(getApplicationContext(),Namaz.class));

        } else if (id == R.id.nav_wazo) {
            startActivity(new Intent(getApplicationContext(),wazu.class));

        } else if (id == R.id.nav_RateThisApp) {

            try{

                Uri uri = Uri.parse("market://details?id="+getPackageName());
                Intent gotoMarket = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(gotoMarket);
            }
            catch (ActivityNotFoundException e) {

                Uri uri = Uri.parse("http://play.google.com/store/apps/details?id="+getPackageName());
                Intent gotoMarket = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(gotoMarket);
            }

        } else if (id == R.id.nav_MoreApps) {
            try{
                Uri uri = Uri.parse("market://search?q=pub:ArslTech");
                Intent gotoMarket = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(gotoMarket);
            }
            catch (ActivityNotFoundException e) {

                Uri uri = Uri.parse("http://play.google.com/store/search?q=pub:ArslTech");
                Intent gotoMarket = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(gotoMarket);
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
