package com.luozf.main.plugin;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import com.example.plugin_library.PluginConst;
import com.example.plugin_library.PluginManager;
import com.luozf.main.MainActivity;
import com.luozf.main.MyApplication;
import com.luozf.main.R;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.model.PluginInfo;

import java.io.File;
import java.security.Permission;

import luozf.utils.ToastU;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * 插件化工具，用于管理插件。
 * TODO: 后面需自己实现的，当前先用DroidPlugin:
 * DroidPlugin接入问题：
 * 1.没有创建PM权限。因此放弃该方案。
 *
 * RePlugin接入问题：
 * 1.gradle冲突：需引入2.3.3，否则低版本可能和gradle4.+冲突
 * 2.androidx冲突：暂未兼容，放弃Androidx
 * 3.Failed to apply plugin [id 'replugin-plugin-gradle']：降级classpath 'com.android.tools.build:gradle:3.2.0'
 * 4.电脑警告Android_Syringe.T病毒：电脑问题，重启后可以运行
 * 5.ActivityNotFoundException:不能用context.startActivity，用Replugin.startActivity后正常；而且Context只能用Activity，用Application会报错
 * 6.TODO：Replugin直接打开Flutter会黑屏，无法展示。后面再处理。
 *
 * @author luozf
 * @date 2020/4/11
 */
public class PluginUtil {

    /**
     * 初始化
     *
     * @author luozf
     * @date 2020/4/11
     */
    public static void init(){
        com.example.plugin_library.PluginManager.getInstance().init(MyApplication.getContext());
        Log.i("Test","plugin util init");
        RePlugin.App.onCreate();
    }

    /**
     * 插件安装
     *
     * @author luozf
     * @date 2020/4/11
     */
    public static void installPlugin(String pluginName){

        PluginInfo info = RePlugin.install(getPluginPath(pluginName));
        if (info == null){
            ToastU.showd("安装失败");
        } else {
            ToastU.showd(info.getName());
        }

//        String path = getPluginPath(pluginName);
//        PluginManager.getInstance().installPlugin(path);


//        try {
//
//            String path = getPluginPath(pluginName);
//            Toast.makeText(MyApplication.getContext(), path,Toast.LENGTH_LONG).show();
//            PluginManager.getInstance().installPackage(path,  0);
//            Log.e("Test","install success " + path);
//
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }

    }

    /**
     * 删除插件
     *
     * @author luozf
     * @date 2020/4/11
     */
    public static void deletePlugin(String pluginName){
//        try {
//            String path = getPluginPath(pluginName);
//            File file = new File(path);
//            if (!file.exists()){
//                Toast.makeText(MyApplication.getContext(),"file not find",Toast.LENGTH_LONG).show();
//                return;
//            }
//            PluginManager.getInstance().deletePackage(path,  0);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }

    }


    /**
     * 跳转插件页
     *
     * @param context 上下文，目前只能传Activity，传Application会报错
     * @author luozf
     * @date 2020/4/13
     */
    public static void startPluginActivity(Context context, String pluginName, String activityName){

        //
//        Intent intent = RePlugin.createIntent("com.qihoo360.replugin.sample.demo1", "com.qihoo360.replugin.sample.demo1.MainActivity");
//        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
//        intent.setComponent(new ComponentName("com.qihoo360.replugin.sample.demo1", "com.qihoo360.replugin.sample.demo1.MainActivity"));
//        mainActivity.startActivity(intent);
        RePlugin.startActivity(context, RePlugin.createIntent(pluginName, activityName));

//        String apkPath = getPluginPath(pluginName);
//        PluginManager.getInstance().startPluginActivity(apkPath,activityName);

//        PackageInfo info = MyApplication.getContext().getPackageManager().getPackageArchiveInfo(PluginUtil.getPluginPath("TestPlugin-debug.apk"), PackageManager.GET_ACTIVITIES);
////                    PackageManager pm = getPackageManager();
////                    Intent intent = pm.getLaunchIntentForPackage(info.packageName);
//
////                    Intent intent = new Intent();
////                    intent.setClassName("com.example.TestPlugin","MainActivity");
//        PackageManager pm =  MyApplication.getContext().getPackageManager();
//        Intent intent = pm.getLaunchIntentForPackage("com.example.TestPlugin");
//        if (intent != null) {
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            MyApplication.getContext().startActivity(intent);
//        } else {
//            com.morgoo.helper.Log.e("Test","intent is null");
//        }
    }

    /**
     * 获取插件路径
     *
     * @author luozf
     * @date 2020/4/11
     */
    public static String getPluginPath(String pluginName) {
        String basePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String filePath = basePath + "/a_story/" + pluginName;
        return filePath;
    }
}
