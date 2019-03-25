package com.app.temp.features.splash;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.app.temp.R;
import com.app.temp.base.activity.BaseActivity;
import com.app.temp.features.home.HomeActivity;
import com.app.temp.utils.CommonUtil;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (CommonUtil.isInternetAvailable(this)) {
            checkAllPermissions();
        } else {
            showMessageWithCallback(getString(R.string.no_internet), this::finish);
        }
    }

    @Override
    public void initTagLog() {
        TAG = "SplashActivity";
    }

    @TargetApi(Build.VERSION_CODES.M)
    private boolean isEnoughPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                    ;
        }
        return true;
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void checkAllPermissions() {
        if (!isEnoughPermissions()) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE},
                    1001);
        } else {
            goToHome();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1001:
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                            grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                        // permission was granted, yay! Do the
                        // contacts-related task you need to do.
                        goToHome();
                    } else if (grantResults[1] == PackageManager.PERMISSION_DENIED) {
                        finish();
                    }
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    finish();
                }
        }
    }

    private void goToHome() {
        new CountDownTimer(3000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                finish();
            }
        }.start();
    }
}
