package com.edreamtree.draggertest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.edreamtree.draggertest.di.HttpActivityModule;
import com.edreamtree.draggertest.di.OkHttpClient;
import com.edreamtree.draggertest.di.RetrofitManager;
import com.edreamtree.draggertest.di.di2.DaggerHttpActivityComponent;

import javax.inject.Inject;



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
    
    @Inject
    RetrofitManager mRetrofitManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        int tag = getIntent().getIntExtra("tag", 0);
        DaggerHttpActivityComponent.builder().httpActivityModule(new HttpActivityModule(100)).build().inject(this);
        if(tag == 1) {
            Toast.makeText(HttpActivity.this, ""+mOkHttpClient.hashCode(), Toast.LENGTH_SHORT).show();
        }else if(tag == 2) {
            Toast.makeText(HttpActivity.this, ""+mOkHttpClient.hashCode()
                    +"\n"+mRetrofitManager.getClient().hashCode()
                    +"\n"+mRetrofitManager.getClient().getCacheSize(), Toast.LENGTH_SHORT).show();
        }
    }
    

    public static void actionStart(Context context, int tag) {
        Intent starter = new Intent(context, HttpActivity.class);
        starter.putExtra("tag", tag);
        context.startActivity(starter);
    }
}
