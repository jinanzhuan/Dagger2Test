package com.edreamtree.draggertest.di.di5;

import com.edreamtree.draggertest.MainActivity;

import dagger.Subcomponent;

/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2018/6/7
 *     desc   :
 *     modify :
 * </pre>
 */
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent {

    @Subcomponent.Builder
    interface MainBuilder {
        MainBuilder mainActivityModule(MainActivityModule module);
        MainActivityComponent build();
    }

    void inject(MainActivity mainActivity);
}
