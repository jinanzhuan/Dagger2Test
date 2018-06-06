package com.edreamtree.draggertest.di;

import com.edreamtree.draggertest.HttpActivity;

import dagger.Component;

/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2018/6/6
 *     desc   :
 *     modify :
 * </pre>
 */

@Component(modules = HttpActivityModule.class)
public interface HttpActivityComponent {
    void inject(HttpActivity httpActivity);
}
