package com.edreamtree.draggertest.di.di6;

import com.edreamtree.draggertest.BaseActivity;

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

@Component(dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    void inject(BaseActivity activity);
}
