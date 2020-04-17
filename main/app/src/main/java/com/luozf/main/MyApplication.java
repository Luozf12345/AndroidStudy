package com.luozf.main;

import android.app.Application;
import android.content.Context;

import com.luozf.main.plugin.PluginUtil;
import com.morgoo.droidplugin.PluginHelper;

import luozf.UtilsComm;

/**
 *  自定义Application,为了方便插件化，后面应该要方便替换插件化方案
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
        PluginUtil.init();
//        // DroidPlugin插件处理
//        //这里必须在super.onCreate方法之后，顺序不能变
//        PluginHelper.getInstance().applicationOnCreate(getBaseContext());
    }

    @Override
    protected void attachBaseContext(Context base) {
//        // DroidPlugin插件处理
//        PluginHelper.getInstance().applicationAttachBaseContext(base);
        super.attachBaseContext(base);
    }
}
