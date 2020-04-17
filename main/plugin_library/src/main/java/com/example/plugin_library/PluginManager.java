package com.example.plugin_library;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import dalvik.system.DexClassLoader;
import luozf.utils.LogU;
import luozf.utils.ToastU;

/**
 * 插件管理器
 * @Author:luozf
 * @Date: 2020/4/13
 */
public class PluginManager {

    /**
     * 单例
     */
    private static PluginManager instance;
    private Context mContext;

    private Map<String,PluginItem> itemMap = new HashMap<>();

    /**
     * 获取单例
     *
     * @author luozf
     * @date 2020/4/13
     */
    public static PluginManager getInstance(){
        if (instance == null){
            synchronized (PluginManager.class){
                if (instance == null){
                    instance = new PluginManager();
                }
            }
        }
        return instance;
    }

    public void init(Context context){
        mContext = context;
    }

    /**
     * 启动插件Activity
     *
     * @author luozf
     * @date 2020/4/13
     * @param apkPath
     * @param activityName
     */
    public void startPluginActivity(String apkPath, String activityName){
        try {
            Bundle bundle = new Bundle();
            bundle.putString(PluginConst.APK_PATH, apkPath);
            bundle.putString(PluginConst.REALLY_ACTIVITY_NAME, activityName);
            bundle.putInt(PluginConst.LAUNCH_MODEL, PluginConst.LaunchModel.SINGLE_TASK);

            Intent intent = new Intent(mContext, PluginProxyActivity.class);
            intent.putExtra("bundle",bundle);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 安装插件
     *
     * @author luozf
     * @date 2020/4/13
     */
    public void installPlugin(String apkPath) {
        File file = new File(apkPath);
        if (!file.exists()){
            LogU.e("apk file not exists!");
            return;
        }
        //Dex优化后的缓存目录
        File odexFile = mContext.getDir("odex", Context.MODE_PRIVATE);
        //创建DexClassLoader加载器
        DexClassLoader dexClassLoader = new DexClassLoader(apkPath, odexFile.getAbsolutePath(), null, mContext.getClassLoader());
        //创建AssetManager，然后创建Resources
        Resources resources = null;
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method method = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            method.invoke(assetManager, apkPath);
            resources = new Resources(assetManager,
                    mContext.getResources().getDisplayMetrics(),
                    mContext.getResources().getConfiguration());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (dexClassLoader != null && resources != null) {
            itemMap.put(apkPath,new PluginItem(apkPath,dexClassLoader,resources));
            ToastU.showd("添加pluginItem");
        }
    }

    public PluginItem getPluginItem(String apkPath){
        return itemMap.get(apkPath);
    }

    /**
     * 检测插件是否存在
     */
    private boolean checkPluginActivityIsExit(Bundle bundle) {
        String dexPath = bundle.getString(PluginConst.APK_PATH);
        String reallyActivityName = bundle.getString(PluginConst.REALLY_ACTIVITY_NAME);
        ClassLoader classLoader = PluginManager.getInstance().getPluginItem(dexPath).getDexClassLoader();
        Class<?> aClass = null;
        try {
            aClass = classLoader.loadClass(reallyActivityName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return aClass == null ? false : true;
    }
}
