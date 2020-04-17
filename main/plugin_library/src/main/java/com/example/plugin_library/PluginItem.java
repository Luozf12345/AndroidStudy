package com.example.plugin_library;

import android.content.res.Resources;

import dalvik.system.DexClassLoader;

/**
 * 保存插件选项
 *
 * @author luozf
 * @date 2020/4/17
 */
public class PluginItem {

    /*
     * 插件apk路径
     */
    private String apkPath;

    private DexClassLoader dexClassLoader;

    private Resources resources;

    public PluginItem(String apkPath, DexClassLoader dexClassLoader, Resources resources){
        this.apkPath = apkPath;
        this.dexClassLoader = dexClassLoader;
        this.resources = resources;
    }

    public String getApkPath() {
        return apkPath;
    }

    public void setApkPath(String apkPath) {
        this.apkPath = apkPath;
    }

    public DexClassLoader getDexClassLoader() {
        return dexClassLoader;
    }

    public void setDexClassLoader(DexClassLoader dexClassLoader) {
        this.dexClassLoader = dexClassLoader;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }
}
