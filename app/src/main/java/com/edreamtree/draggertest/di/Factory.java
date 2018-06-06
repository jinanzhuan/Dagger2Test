package com.edreamtree.draggertest.di;

import javax.inject.Inject;

/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2018/6/6
 *     desc   :
 *     modify :
 * </pre>
 */

public class Factory {
    public Product mProduct;

    @Inject
    public Factory(Product product) {
        mProduct = product;
    }
}
