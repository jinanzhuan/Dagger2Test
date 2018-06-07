package com.edreamtree.draggertest.di.di5;

import dagger.Module;
import dagger.Provides;

/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2018/6/7
 *     desc   :
 *     modify :
 * </pre>
 */

@Module
public class AppModule {

    @Provides
    AppBean provideAppBean(){
        return new AppBean();
    }
}
