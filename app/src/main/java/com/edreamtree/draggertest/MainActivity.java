package com.edreamtree.draggertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.edreamtree.draggertest.di.di5.ActivityBean;
import com.edreamtree.draggertest.di.di5.AppBean;
import com.edreamtree.draggertest.di.di5.MainActivityModule;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @InjectView(R.id.btn_factory)
    Button mBtnFactory;
    @InjectView(R.id.btn_factory2)
    Button mBtnFactory2;
    @InjectView(R.id.btn_http)
    Button mBtnHttp;
    @InjectView(R.id.btn_http2)
    Button mBtnHttp2;
    @InjectView(R.id.btn_http_fragment)
    Button mBtnHttpFragment;
    @InjectView(R.id.btn_http_fragment2)
    Button mBtnHttpFragment2;
    @InjectView(R.id.btn_okhttp)
    Button mBtnOkhttp;

    @Inject
    AppBean mAppBean;

    @Inject
    ActivityBean mActivityBean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initListener();
        initData();
    }

    private void initData() {
        ((App) getApplication()).getAppComponent()
                .mainBuilder()
                .mainActivityModule(new MainActivityModule(new ActivityBean()))
                .build()
                .inject(this);

        Toast.makeText(MainActivity.this, "appBean:" + mAppBean.toString() + "\n activityBean:" + mActivityBean.toString(), Toast.LENGTH_SHORT).show();

    }

    private void initListener() {
        mBtnFactory.setOnClickListener(this);
        mBtnFactory2.setOnClickListener(this);
        mBtnHttp.setOnClickListener(this);
        mBtnHttp2.setOnClickListener(this);
        mBtnHttpFragment.setOnClickListener(this);
        mBtnHttpFragment2.setOnClickListener(this);
        mBtnOkhttp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_factory:
                FactoryActivity.actionStart(this, 1);
                break;
            case R.id.btn_factory2:
                FactoryActivity.actionStart(this, 2);
                break;
            case R.id.btn_http:
                HttpActivity.actionStart(this, 1);
                break;
            case R.id.btn_http2:
                HttpActivity.actionStart(this, 2);
                break;
            case R.id.btn_http_fragment:
                HttpFragmentActivity.actionStart(this, 1);
                break;
            case R.id.btn_http_fragment2:
                HttpFragmentActivity.actionStart(this, 2);
                break;
            case R.id.btn_okhttp:
                OkHttpActivity.actionStart(this);
                break;
        }
    }
}
