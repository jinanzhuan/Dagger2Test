package com.edreamtree.draggertest.di.di6;

import com.edreamtree.draggertest.net.ErrorInterceptor;
import com.edreamtree.draggertest.net.LoggerInterceptor;
import com.edreamtree.draggertest.net.TokenInterceptor;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
    private String accessToken;

    public AppModule(String accessToken) {
        this.accessToken = accessToken;
    }

    @Provides
    IApiService provideIApiService(Retrofit retrofit){
        return retrofit.create(IApiService.class);
    }

    @Named("file")
    @Provides
    IApiService provideFileIApiService(@Named("file")Retrofit retrofit){
        return retrofit.create(IApiService.class);
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl("http://api.eheartcare.net/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Named("file")
    @Provides
    Retrofit provideFileRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("http://dtr-test.oss-cn-beijing.aliyuncs.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    OkHttpClient provideOkHttpClient(LoggerInterceptor loggerInterceptor
            , ErrorInterceptor errorInterceptor
            , TokenInterceptor tokenInterceptor){

        return new OkHttpClient.Builder()
                .addInterceptor(loggerInterceptor)
                .addInterceptor(errorInterceptor)
                .addInterceptor(tokenInterceptor)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();

    }

    @Provides
    LoggerInterceptor provideLoggerInterceptor(){
        return new LoggerInterceptor("Tag", true, true);
    }

    @Provides
    ErrorInterceptor provideErrorInterceptor(Gson gson){
        return new ErrorInterceptor(gson);
    }

    @Provides
    TokenInterceptor provideTokenInterceptor(){
        return new TokenInterceptor(accessToken);
    }

    @Provides
    Gson provideGson(){
        return new Gson();
    }
}
