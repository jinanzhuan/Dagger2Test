package com.edreamtree.draggertest.di.di6;

import javax.inject.Named;

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
public interface ApplicationComponent {

    IApiService provideIApiService();

    @Named("file")
    IApiService provideFileIApiService();
}
