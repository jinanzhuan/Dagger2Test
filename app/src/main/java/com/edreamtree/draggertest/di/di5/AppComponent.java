package com.edreamtree.draggertest.di.di5;

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
@Component(modules = AppModule.class)
public interface AppComponent {
    MainActivityComponent.MainBuilder mainBuilder();
}
