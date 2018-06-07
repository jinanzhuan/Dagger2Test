package com.edreamtree.draggertest.di.di4;

import com.edreamtree.draggertest.di.HttpActivityModule;

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
public interface HttpFragmentActivity2Component {
    HttpFragment2Component httpFragment2Component();
    HttpFragment21Component httpFragment21Component();
}
