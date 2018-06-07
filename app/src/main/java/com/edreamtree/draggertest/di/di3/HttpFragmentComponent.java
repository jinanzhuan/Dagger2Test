package com.edreamtree.draggertest.di.di3;

import com.edreamtree.draggertest.HttpFragment;

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
@Component(dependencies = HttpFragmentActivityComponent.class)
public interface HttpFragmentComponent {
    void inject(HttpFragment httpFragment);
}
