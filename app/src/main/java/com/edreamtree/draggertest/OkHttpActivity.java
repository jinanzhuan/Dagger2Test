package com.edreamtree.draggertest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

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

public class OkHttpActivity extends BaseActivity {

    @InjectView(R.id.tv_name)
    TextView mTvName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        ButterKnife.inject(this);
        mTvName.setText("mApiService's hashCode="+mApiService.hashCode()+"\n mFileApiService's hashCode="+mFileApiService.hashCode());
    }

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, OkHttpActivity.class);
        context.startActivity(starter);
    }
}
