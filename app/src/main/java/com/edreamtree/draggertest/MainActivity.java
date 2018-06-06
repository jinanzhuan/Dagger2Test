package com.edreamtree.draggertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initListener();
    }

    private void initListener() {
        mBtnFactory.setOnClickListener(this);
        mBtnFactory2.setOnClickListener(this);
        mBtnHttp.setOnClickListener(this);
        mBtnHttp2.setOnClickListener(this);
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
                HttpActivity.actionStart(this);
                break;
            case R.id.btn_http2:

                break;
        }
    }
}
