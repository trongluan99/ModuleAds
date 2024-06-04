package com.example.modulelibads

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ads.admob.Admob
import com.example.ads.funtion.AdCallback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Admob.getInstance().loadSplashInterstitialAds(
            this,
            BuildConfig.ad_interstitial_splash,
            25000,
            5000,
            object : AdCallback() {
                override fun onNextAction() {
                    super.onNextAction()

                }
            })
    }
}