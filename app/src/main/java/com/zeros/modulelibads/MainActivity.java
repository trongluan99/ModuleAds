package com.zeros.modulelibads;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zeros.ads.ads.AmxAd;
import com.zeros.ads.ads.wrapper.ApInterstitialAd;
import com.zeros.ads.funtion.AdCallback;


public class MainActivity extends AppCompatActivity {
    private ApInterstitialAd mInterstitialAd;
    private Button btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AmxAd.getInstance().getInterstitialAds(this, BuildConfig.ad_interstitial_splash, new AdCallback(){
            @Override
            public void onApInterstitialLoad(@Nullable ApInterstitialAd apInterstitialAd) {
                super.onApInterstitialLoad(apInterstitialAd);
                mInterstitialAd = apInterstitialAd;
            }
        });

        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AmxAd.getInstance().forceShowInterstitial(MainActivity.this, mInterstitialAd, new AdCallback(){

                }, false);
            }
        });

    }
}
