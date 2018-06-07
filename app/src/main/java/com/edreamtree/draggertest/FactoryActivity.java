package com.edreamtree.draggertest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.edreamtree.draggertest.di.Product;
import com.edreamtree.draggertest.di.di1.DaggerFactoryActivityComponent;
import com.edreamtree.draggertest.di.di1.Factory;

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

public class FactoryActivity extends AppCompatActivity {
    @Inject
    Product mProduct;

    @Inject
    Factory factory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory);
        DaggerFactoryActivityComponent.create().inject(this);
        int tag = getIntent().getIntExtra("tag", 0);
        if(tag == 1) {
            Toast.makeText(FactoryActivity.this, "" + mProduct.hashCode(), Toast.LENGTH_SHORT).show();
        }else if(tag == 2) {
            Toast.makeText(FactoryActivity.this, "" + mProduct.hashCode()+"\n"+factory.mProduct.hashCode(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void actionStart(Context context, int tag) {
        Intent starter = new Intent(context, FactoryActivity.class);
        starter.putExtra("tag", tag);
        context.startActivity(starter);
    }
}
