package com.edreamtree.draggertest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.edreamtree.draggertest.di.DaggerHttpActivityComponent;

import javax.inject.Inject;

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

public class HttpActivity extends AppCompatActivity {
    @Inject
    OkHttpClient mOkHttpClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        DaggerHttpActivityComponent.create().inject(this);
        Toast.makeText(HttpActivity.this, ""+mOkHttpClient.hashCode(), Toast.LENGTH_SHORT).show();
    }

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, HttpActivity.class);
        context.startActivity(starter);
    }
}
