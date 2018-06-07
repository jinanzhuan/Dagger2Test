package com.edreamtree.draggertest.di.di3;

import com.edreamtree.draggertest.di.HttpActivityModule;
import com.edreamtree.draggertest.di.RetrofitManager;

import dagger.Component;

/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2018/6/7
 *     desc   :
 *     modify :
 * </pre>
 */
@Component(modules = HttpActivityModule.class)
public interface HttpFragmentActivityComponent {
    RetrofitManager provideRetrofitManager();
}
