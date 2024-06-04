package com.example.modulelibads

import com.example.ads.admob.Admob
import com.example.ads.ads.AmxAd
import com.example.ads.application.AdsMultiDexApplication
import com.example.ads.config.AdjustConfig
import com.example.ads.config.AmxAdConfig

class App : AdsMultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        initAds()
    }

    private fun initAds() {
        val environment =
            if (BuildConfig.DEBUG) AmxAdConfig.ENVIRONMENT_DEVELOP else AmxAdConfig.ENVIRONMENT_PRODUCTION
        amxAdConfig = AmxAdConfig(this, environment)
        amxAdConfig = AmxAdConfig(this, AmxAdConfig.ENVIRONMENT_DEVELOP)
        val adjustConfig = AdjustConfig(true, getString(R.string.adjust_token))
        amxAdConfig.adjustConfig = adjustConfig
        amxAdConfig.facebookClientToken = getString(R.string.facebook_client_token)
        amxAdConfig.adjustTokenTiktok = getString(R.string.tiktok_token)

        AmxAd.getInstance().init(this, amxAdConfig)

        Admob.getInstance().setDisableAdResumeWhenClickAds(true)
        Admob.getInstance().setOpenActivityAfterShowInterAds(true)
    }
}