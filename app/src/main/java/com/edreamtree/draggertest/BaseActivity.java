package com.edreamtree.draggertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.edreamtree.draggertest.di.di6.DaggerActivityComponent;
import com.edreamtree.draggertest.di.di6.IApiService;

import javax.inject.Inject;
import javax.inject.Named;


/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2018/6/7
 *     desc   :
 *     modify :
 * </pre>
 */

public class BaseActivity extends AppCompatActivity {
    @Inject
    IApiService mApiService;

    @Named("file")
    @Inject
    IApiService mFileApiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerActivityComponent.builder().applicationComponent(((App)getApplication())
                .getComponent())
                .build()
                .inject(this);

        Toast.makeText(BaseActivity.this, ""+mApiService.hashCode() + "\n"+mFileApiService.hashCode(), Toast.LENGTH_SHORT).show();
    }
}
