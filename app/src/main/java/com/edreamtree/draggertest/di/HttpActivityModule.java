package com.edreamtree.draggertest.di;

import dagger.Module;
import dagger.Provides;

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
    private int cacheSize;

    public HttpActivityModule(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    @Provides
    OkHttpClient provideOkHttpClient(){
        OkHttpClient client = new OkHttpClient();
        client.setCacheSize(cacheSize);
        return client;
    }

    @Provides
    RetrofitManager provideRetrofitManager(OkHttpClient client){
        return new RetrofitManager(client);
    }
}
