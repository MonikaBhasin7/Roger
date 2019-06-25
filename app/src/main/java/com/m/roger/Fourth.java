package com.m.roger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Fourth extends AppCompatActivity {

    InterstitialAd interstitialAd5;
    InterstitialAd interstitialAd6;
    boolean displayAd = false;
    //String testDevice="26F29EC297F9AD5BCB9C78FE8DFC7A05";
    private static final String TAG = "First";
    private AdView mAdView5;
    private AdView mAdView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        mAdView5=(AdView)findViewById(R.id.adView5);
        AdRequest adRequest = new AdRequest.Builder().build();


        mAdView5.setAdListener(new AdListener() {
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

        mAdView5.loadAd(adRequest);

        interstitialAd5=new InterstitialAd(this);
        interstitialAd5.setAdUnitId(getString(R.string.interstitial5));
        interstitialAd5.loadAd(adRequest);




        interstitialAd5.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                /*Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);*/
                Intent intent = new Intent(getApplicationContext(), Fourth.class);
                startActivity(intent);

            }
        });




    }

    public void int_ad(View view)
    {
        if(interstitialAd5.isLoaded() || interstitialAd5.isLoading())
        {
            displayAd=true;
            interstitialAd5.show();
        }
        else
        {
            Intent intent=new Intent(getApplicationContext(),Fourth.class);
            startActivity(intent);
        }
    }

    public  void second_page(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Fifth.class);
        startActivity(intent);

    }

}
