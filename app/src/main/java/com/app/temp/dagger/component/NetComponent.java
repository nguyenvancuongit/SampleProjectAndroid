package com.app.temp.dagger.component;

import com.app.temp.base.activity.BaseActivity;
import com.app.temp.dagger.module.AppModule;
import com.app.temp.dagger.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by nguyen_van_cuong on 08/11/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent{
    void inject(BaseActivity activity);
}
