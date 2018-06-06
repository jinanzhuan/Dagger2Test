package com.edreamtree.draggertest.di;

import com.edreamtree.draggertest.FactoryActivity;

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

@Component
public interface FactoryActivityComponent {
    void inject(FactoryActivity factoryActivity);
}
