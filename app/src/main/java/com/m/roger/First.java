package com.m.roger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class First extends AppCompatActivity {


    InterstitialAd interstitialAd1;
    InterstitialAd interstitialAd2;
    boolean displayAd = false;
    //String testDevice="26F29EC297F9AD5BCB9C78FE8DFC7A05";
    private static final String TAG = "First";
    private AdView mAdView1;
    private AdView mAdView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mAdView1=(AdView)findViewById(R.id.adView1);
        mAdView2=(AdView)findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();


        mAdView1.setAdListener(new AdListener() {
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

        mAdView1.loadAd(adRequest);
        mAdView2.loadAd(adRequest);

        interstitialAd1=new InterstitialAd(this);
        interstitialAd1.setAdUnitId(getString(R.string.interstitial1));
        interstitialAd1.loadAd(adRequest);

        interstitialAd2=new InterstitialAd(this);
        interstitialAd2.setAdUnitId(getString(R.string.interstitial2));
        interstitialAd2.loadAd(adRequest);



        interstitialAd1.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                /*Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);*/

                if(interstitialAd2.isLoaded() || interstitialAd2.isLoading())
                {
                    displayAd=true;
                    interstitialAd2.show();
                }
            }
        });

        interstitialAd2.setAdListener(new AdListener()
        {
            @Override
            public void onAdClosed() {
                super.onAdClosed();

                Intent intent = new Intent(getApplicationContext(), First.class);
                startActivity(intent);
            }
        });


    }

    public void int_ad(View view)
    {
        if(interstitialAd1.isLoaded() || interstitialAd1.isLoading())
        {
            displayAd=true;
            interstitialAd1.show();
        }
        else
        {
            Intent intent=new Intent(getApplicationContext(),First.class);
            startActivity(intent);
        }
    }

    public  void second_page(View view)
    {
        Intent intent=new Intent(getApplicationContext(),Second.class);
        startActivity(intent);

    }
}
