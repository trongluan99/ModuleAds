package com.zeros.modulelibads;

import com.zeros.ads.admob.Admob;
import com.zeros.ads.admob.AppOpenManager;
import com.zeros.ads.ads.AmxAd;
import com.zeros.ads.application.AdsMultiDexApplication;
import com.zeros.ads.config.AdjustConfig;
import com.zeros.ads.config.AmxAdConfig;

public class App extends AdsMultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initAds();
    }

    private void initAds() {
        String environment = BuildConfig.DEBUG ? AmxAdConfig.ENVIRONMENT_DEVELOP : AmxAdConfig.ENVIRONMENT_PRODUCTION;
        amxAdConfig = new AmxAdConfig(this, environment);

        AdjustConfig adjustConfig = new AdjustConfig(true, getResources().getString(R.string.adjust_token));
        amxAdConfig.setAdjustConfig(adjustConfig);
        amxAdConfig.setFacebookClientToken(getResources().getString(R.string.facebook_client_token));

        // Optional: enable ads resume
        amxAdConfig.setIdAdResume("");

        AmxAd.getInstance().init(this, amxAdConfig);
        Admob.getInstance().setDisableAdResumeWhenClickAds(true);
        Admob.getInstance().setOpenActivityAfterShowInterAds(true);
        AppOpenManager.getInstance().disableAppResumeWithActivity(MainActivity.class);
    }
}
