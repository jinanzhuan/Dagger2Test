package com.edreamtree.draggertest;

import android.app.Application;

import com.edreamtree.draggertest.di.di5.AppComponent;
import com.edreamtree.draggertest.di.di5.DaggerAppComponent;
import com.edreamtree.draggertest.di.di6.AppModule;
import com.edreamtree.draggertest.di.di6.ApplicationComponent;
import com.edreamtree.draggertest.di.di6.DaggerApplicationComponent;


/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2018/6/7
 *     desc   :
 *     modify :
 * </pre>
 */

public class App extends Application {
    private AppComponent mAppComponent;
    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.create();
        mComponent = DaggerApplicationComponent.builder().appModule(new AppModule("token")).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
