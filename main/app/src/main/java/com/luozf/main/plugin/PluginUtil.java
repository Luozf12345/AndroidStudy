package com.luozf.main.plugin;


import android.os.Environment;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import com.luozf.main.MainActivity;
import com.luozf.main.MyApplication;
import com.luozf.main.R;
import com.morgoo.droidplugin.pm.PluginManager;

import java.io.File;
import java.security.Permission;

/**
 * 插件化工具，用于管理插件。
 * TODO: 后面需自己实现的，当前先用DroidPlugin
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
    }

    /**
     * 插件安装
     *
     * @author luozf
     * @date 2020/4/11
     */
    public static void installPlugin(String pluginName){
        try {

            String path = getPluginPath(pluginName);
            Toast.makeText(MyApplication.getContext(), path,Toast.LENGTH_LONG).show();
            PluginManager.getInstance().installPackage(path,  0);
            Log.e("Test","install success " + path);

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除插件
     *
     * @author luozf
     * @date 2020/4/11
     */
    public static void deletePlugin(String pluginName){
        try {
            String path = getPluginPath(pluginName);
            File file = new File(path);
            if (!file.exists()){
                Toast.makeText(MyApplication.getContext(),"file not find",Toast.LENGTH_LONG).show();
                return;
            }
            PluginManager.getInstance().deletePackage(path,  0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

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
