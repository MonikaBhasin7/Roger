package com.m.roger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Second extends AppCompatActivity {

    InterstitialAd interstitialAd4;
    InterstitialAd interstitialAd3;
    InterstitialAd interstitialAd5;
    InterstitialAd interstitialAd1;
    InterstitialAd interstitialAd2;
    boolean displayAd = false;
    //String testDevice="26F29EC297F9AD5BCB9C78FE8DFC7A05";
    private static final String TAG = "Second";
    private AdView mAdView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mAdView3=(AdView)findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().build();


        mAdView3.setAdListener(new AdListener() {
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

        mAdView3.loadAd(adRequest);

        interstitialAd3=new InterstitialAd(this);
        interstitialAd3.setAdUnitId(getString(R.string.interstitial3));
        interstitialAd3.loadAd(adRequest);




        interstitialAd3.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                /*Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);*/

               Intent intent=new Intent(getApplicationContext(),Second.class);
               startActivity(intent);
            }
        });






    }

    public void int_ad(View view)
    {
        if(interstitialAd3.isLoaded() || interstitialAd3.isLoading())
        {
            displayAd=true;
            interstitialAd3.show();
        }
        else
        {
            Intent intent=new Intent(getApplicationContext(),Second.class);
            startActivity(intent);
        }
    }

    public  void third_page(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Third.class);
        startActivity(intent);
    }

}
