package com.app.temp.base.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Windows 7 on 7/11/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public static String TAG = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTagLog();
    }

    /**
     * setup for log
     */
    public abstract void initTagLog();

    public void printLog(String log) {
        Log.d(TAG, log);
    }


}
