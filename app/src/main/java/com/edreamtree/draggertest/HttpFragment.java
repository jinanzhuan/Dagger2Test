package com.edreamtree.draggertest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.edreamtree.draggertest.di.RetrofitManager;
import com.edreamtree.draggertest.di.di3.DaggerHttpFragmentComponent;
import com.edreamtree.draggertest.di.di3.HttpFragmentActivityComponent;

import javax.inject.Inject;

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

public class HttpFragment extends Fragment {
    @InjectView(R.id.tv_name)
    TextView mTvName;

    @Inject
    RetrofitManager mRetrofitManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_http, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int tag = getArguments().getInt("tag", 0);
        if(tag == 1) {
            HttpFragmentActivityComponent httpFragmentActivityComponent = ((HttpFragmentActivity) getActivity()).getHttpFragmentActivityComponent();
            DaggerHttpFragmentComponent
                    .builder()
                    .httpFragmentActivityComponent(httpFragmentActivityComponent)
                    .build()
                    .inject(this);
        }else if(tag == 2) {
            ((HttpFragmentActivity) getActivity()).getHttpFragmentActivity2Component()
                    .httpFragment21Component()
                    .inject(this);
        }


        String content = mRetrofitManager.hashCode()
                + "\n"+mRetrofitManager.getClient().hashCode()
                +"\n"+mRetrofitManager.getClient().getCacheSize();
        mTvName.setText(content);
        Toast.makeText(getActivity(), content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
