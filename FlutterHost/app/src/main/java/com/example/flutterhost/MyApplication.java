package com.example.flutterhost;

import android.app.Application;
import android.content.Context;

import luozf.UtilsComm;

/**
 *  自定义Application
 * @author luozf
 * @date 2020/4/11
 */
public class MyApplication extends Application {

    private static Context mContext;

    public static Context getContext(){
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        UtilsComm.init(this, true);
    }
}
