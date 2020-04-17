package com.example.plugin_library;

/**
 * 常量
 */
public interface PluginConst {

     String APK_PATH = "dex_path";

    String LAUNCH_MODEL = "launch_model";

    String REALLY_ACTIVITY_NAME = "reallyActivityName";

    String isPlugin = "isPlugin";

    /**
     * 四种启动模式
     */
    interface LaunchModel {
        int STANDARD = 0;

        int SINGLE_TOP = 1;

        int SINGLE_TASK = 2;

        int SINGLE_INSTANCE = 3;
    }
}
