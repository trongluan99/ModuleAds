package com.zeros.ads.application;

import android.app.Application;

import com.zeros.ads.config.AmxAdConfig;
import com.zeros.ads.util.AppUtil;
import com.zeros.ads.util.SharePreferenceUtils;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class AdsApplication extends Application {

    protected AmxAdConfig gamAdConfig;
    protected List<String> listTestDevice;

    @Override
    public void onCreate() {
        super.onCreate();
        listTestDevice = new ArrayList<String>();
        gamAdConfig = new AmxAdConfig(this);
        if (SharePreferenceUtils.getInstallTime(this) == 0) {
            SharePreferenceUtils.setInstallTime(this);
        }
        AppUtil.currentTotalRevenue001Ad = SharePreferenceUtils.getCurrentTotalRevenue001Ad(this);
    }

}
