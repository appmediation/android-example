package com.appmediation.demo_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import com.appmediation.sdk.AMBanner;
import com.appmediation.sdk.AMInterstitial;
import com.appmediation.sdk.AMRewardedVideo;
import com.appmediation.sdk.AMSDK;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AMSDK.init(this, "4ccbacd3-5ddf-4884-bbe8-ca6f1feba482");

        findViewById(R.id.interstitialButton).setOnClickListener(this);
        findViewById(R.id.rewardedVideoButton).setOnClickListener(this);
        findViewById(R.id.showBannerButton).setOnClickListener(this);
        findViewById(R.id.hideBannerButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.interstitialButton:
                AMInterstitial.show(this);
                return;
            case R.id.rewardedVideoButton:
                AMRewardedVideo.show(this);
                return;
            case R.id.showBannerButton:
                AMBanner.show(this, Gravity.BOTTOM);
                return;
            case R.id.hideBannerButton:
                AMBanner.hide(this);
                return;
            default:
                return;
        }
    }
}
