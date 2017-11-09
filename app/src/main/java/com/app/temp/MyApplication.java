package com.app.temp;

import android.app.Application;

import com.app.temp.dagger.component.DaggerNetComponent;
import com.app.temp.dagger.component.NetComponent;
import com.app.temp.dagger.module.AppModule;
import com.app.temp.dagger.module.NetModule;

/**
 * Created by Windows 7 on 7/5/2016.
 */
public class MyApplication extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(BuildConfig.HOST_URL))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
