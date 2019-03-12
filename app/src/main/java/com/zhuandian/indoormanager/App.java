package com.zhuandian.indoormanager;

import android.app.Application;


import com.zhuandian.indoormanager.utils.Constant;

import cn.bmob.v3.Bmob;

/**
 * desc :
 * author：xiedong
 * date：2019/2/19
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, Constant.APP_ID);
    }
}
