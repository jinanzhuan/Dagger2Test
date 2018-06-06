package com.edreamtree.draggertest.di;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2018/6/6
 *     desc   :
 *     modify :
 * </pre>
 */

@Module
public class HttpActivityModule {

    @Provides
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }
}
