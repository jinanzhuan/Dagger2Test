package com.edreamtree.draggertest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.edreamtree.draggertest.di.HttpActivityModule;
import com.edreamtree.draggertest.di.di3.DaggerHttpFragmentActivityComponent;
import com.edreamtree.draggertest.di.di3.HttpFragmentActivityComponent;
import com.edreamtree.draggertest.di.di4.DaggerHttpFragmentActivity2Component;
import com.edreamtree.draggertest.di.di4.HttpFragmentActivity2Component;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2018/6/7
 *     desc   :
 *     modify :
 * </pre>
 */

public class HttpFragmentActivity extends AppCompatActivity {
    @InjectView(R.id.fl_fragment)
    FrameLayout mFlFragment;

    private HttpFragmentActivityComponent mHttpFragmentActivityComponent;
    private HttpFragmentActivity2Component mHttpFragmentActivity2Component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_fragment);
        ButterKnife.inject(this);
        initView();
        initData();
    }

    public static void actionStart(Context context, int tag) {
        Intent starter = new Intent(context, HttpFragmentActivity.class);
        starter.putExtra("tag", tag);
        context.startActivity(starter);
    }

    private void initView() {
        int tag = getIntent().getIntExtra("tag", 0);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        HttpFragment fragment = new HttpFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("tag", tag);
        fragment.setArguments(bundle);
        transaction.replace(R.id.fl_fragment, fragment);
        transaction.commit();
    }

    private void initData() {
        mHttpFragmentActivityComponent = DaggerHttpFragmentActivityComponent
                                        .builder()
                                        .httpActivityModule(new HttpActivityModule(100))
                                        .build();

        mHttpFragmentActivity2Component = DaggerHttpFragmentActivity2Component
                                            .builder()
                                            .httpActivityModule(new HttpActivityModule(200))
                                            .build();
    }

    public HttpFragmentActivityComponent getHttpFragmentActivityComponent() {
        return mHttpFragmentActivityComponent;
    }

    public HttpFragmentActivity2Component getHttpFragmentActivity2Component() {
        return mHttpFragmentActivity2Component;
    }
}
