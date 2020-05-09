package com.example.flutterhost;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.example.flutterhost.flutter.FlutterManager;

import io.flutter.app.FlutterActivity;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterView;
import luozf.base.BaseActivity;

public class MyFlutterActivity extends FlutterActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        FlutterMain.ensureInitializationComplete(getApplicationContext(), null);
//        setContentView(R.layout.activity_my_flutter);
//        View flutterView = FlutterManager.getInstance().createFlutterView(this);
//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this,null);
//        layoutParams.width = RelativeLayout.LayoutParams.MATCH_PARENT;
//        layoutParams.height = RelativeLayout.LayoutParams.MATCH_PARENT;
//        addContentView(flutterView,layoutParams);
    }
}
