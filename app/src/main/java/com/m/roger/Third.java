package com.m.roger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Third extends AppCompatActivity {

    InterstitialAd interstitialAd3;
    InterstitialAd interstitialAd4;
    InterstitialAd interstitialAd5;
    InterstitialAd interstitialAd1;
    InterstitialAd interstitialAd2;
    boolean displayAd = false;
    //String testDevice="26F29EC297F9AD5BCB9C78FE8DFC7A05";
    private static final String TAG = "First";
    private AdView mAdView5;
    private AdView mAdView1;
    private AdView mAdView2;
    private AdView mAdView3;
    private AdView mAdView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        mAdView4=(AdView)findViewById(R.id.adView4);
        AdRequest adRequest = new AdRequest.Builder().build();


        mAdView4.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                displayAd = true;
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                if (!displayAd) {
                }
            }

            @Override
            public void onAdClosed() {
            }
        });

        mAdView4.loadAd(adRequest);


        interstitialAd4=new InterstitialAd(this);
        interstitialAd4.setAdUnitId(getString(R.string.interstitial4));
        interstitialAd4.loadAd(adRequest);




        interstitialAd4.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                /*Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);*/

                Intent intent = new Intent(getApplicationContext(), Third.class);
                startActivity(intent);

            }
        });




    }

    public void int_ad(View view)
    {
        if(interstitialAd4.isLoaded() || interstitialAd4.isLoading())
        {
            displayAd=true;
            interstitialAd4.show();
        }
        else
        {
            Intent intent=new Intent(getApplicationContext(),Third.class);
            startActivity(intent);
        }
    }

    public  void fourth_page(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Fourth
                .class);
        startActivity(intent);
    }
}
