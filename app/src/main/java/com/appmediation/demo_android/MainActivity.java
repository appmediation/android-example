package com.appmediation.demo_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.appmediation.sdk.AMBanner;
import com.appmediation.sdk.AMInterstitial;
import com.appmediation.sdk.AMRewardedVideo;
import com.appmediation.sdk.AMSDK;
import com.appmediation.sdk.listeners.AMBannerListener;
import com.appmediation.sdk.listeners.AMListener;
import com.appmediation.sdk.listeners.AMRewardedListener;
import com.appmediation.sdk.models.AMError;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AMSDK.init(this, "a1cdd0c4-de3b-421f-a7b3-5c264c16df91");

        findViewById(R.id.interstitialButton).setOnClickListener(this);
        findViewById(R.id.rewardedVideoButton).setOnClickListener(this);

        setNewBannerListener();
        setNewInterstitialListener();
        setNewRewardedListener();
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

    private void showMessage(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    private void setNewBannerListener() {
        AMBanner.setListener(new AMBannerListener() {
            @Override
            public void onLoaded() {
                showMessage("Banner ad: onLoaded");
            }

            @Override
            public void onFailed(AMError error) {
                showMessage("Banner ad: onFailed: " + error.name());
            }

            @Override
            public void onShowed() {
                showMessage("Banner ad: onShowed");
            }

            @Override
            public void onClicked() {
                showMessage("Banner ad: onClicked");
            }
        });
    }

    private void setNewInterstitialListener() {
        AMInterstitial.setListener(new AMListener() {
            @Override
            public void onLoaded() {
                showMessage("Interstitial ad: onLoaded");
            }
            @Override
            public void onFailed(AMError error) {
                showMessage("Interstitial ad: onFailed: " + error.name());
            }

            @Override
            public void onShowed() {
                showMessage("Interstitial ad: onShowed");
            }

            @Override
            public void onClosed() {
                showMessage("Interstitial ad: onClosed");
            }

            @Override
            public void onClicked() {
                showMessage("Interstitial ad: onClicked");
            }
        });
    }

    private void setNewRewardedListener() {
        AMRewardedVideo.setListener(new AMRewardedListener() {
            @Override
            public void onLoaded(String currency, String amount) {
                String rewardInfo = amount + " " + currency;
                showMessage("Rewarded ad: onLoaded: " + rewardInfo);
            }

            @Override
            public void onCompleted(String currency, String amount) {
                String rewardInfo = amount + " " + currency;
                showMessage("Rewarded ad: onCompleted: " + rewardInfo);
            }

            @Override
            public void onFailed(AMError error) {
                showMessage("Rewarded ad: onFailed: " + error.name());
            }

            @Override
            public void onShowed() {
                showMessage("Rewarded ad: onShowed");
            }

            @Override
            public void onClosed() {
                showMessage("Rewarded ad: onClosed");
            }

            @Override
            public void onClicked() {
                showMessage("Rewarded ad: onClicked");
            }
        });
    }
}
