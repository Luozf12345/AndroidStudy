package com.luozf.main.plugin;



import android.os.Environment;
import android.util.Log;
import com.example.plugin_library.PluginManager;
import com.luozf.main.MyApplication;

/**
 * 插件化工具，用于管理插件。
 * 后面需自己实现的，当前先用DroidPlugin:DroidPlugin已不维护，放弃该方案
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
    }

    /**
     * 插件安装
     *
     * @author luozf
     * @date 2020/4/11
     */
    public static void installPlugin(String pluginName){

        String path = getPluginPath(pluginName);
        PluginManager.getInstance().installPlugin(path);
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
     * @author luozf
     * @date 2020/4/13
     */
    public static void startPluginActivity(String pluginName,String activityName){

        String apkPath = getPluginPath(pluginName);
        PluginManager.getInstance().startPluginActivity(apkPath,activityName);

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
