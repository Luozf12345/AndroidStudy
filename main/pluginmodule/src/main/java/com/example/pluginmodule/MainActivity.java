package com.example.pluginmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.plugin_library.IPluginActivity;
import com.example.plugin_library.PluginBaseActivity;

/**
 * 插件Activity，需继承PluginBaseActivity。接入麻烦，后面需优化
 *
 * @author luozf
 * @date 2020/4/17
 */
public class MainActivity extends PluginBaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
