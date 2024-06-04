package com.zeros.modulelibads

import com.zeros.ads.admob.Admob
import com.zeros.ads.ads.AmxAd
import com.zeros.ads.application.AdsMultiDexApplication
import com.zeros.ads.config.AdjustConfig
import com.zeros.ads.config.AmxAdConfig

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