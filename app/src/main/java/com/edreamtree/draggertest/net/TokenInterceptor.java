package com.edreamtree.draggertest.net;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by songyuqiang on 16/11/3.
 */
public class TokenInterceptor implements Interceptor {

    private String accessToken;

    public TokenInterceptor(String accessToken){
        this.accessToken = accessToken;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String tokenHeader = chain.request().header("Authorization");
        Request.Builder requestBuilder = chain
                .request()
                .newBuilder();
        if(TextUtils.isEmpty(tokenHeader)&&!TextUtils.isEmpty(accessToken)){
            requestBuilder
                    .removeHeader("Authorization")
                    .addHeader("Authorization", accessToken);
        }
        requestBuilder.addHeader("Accept","application/json;version=1.2");
        return chain.proceed(requestBuilder.build());
    }
}
