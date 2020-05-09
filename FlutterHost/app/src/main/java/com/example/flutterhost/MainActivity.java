package com.example.flutterhost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.flutterhost.flutter.FlutterManager;

import io.flutter.app.FlutterActivity;
import io.flutter.view.FlutterMain;
import luozf.base.BaseActivity;

public class MainActivity extends BaseActivity {

    /**
     * 启动Flutter
     */
    private TextView startFlutterTv;
    /**
     * 启动Flutter
     */
    private TextView startFlutterActivityTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startFlutterTv = findViewById(R.id.main_start_flutter);
        startFlutterTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlutterManager.getInstance().startFlutterActivity(MainActivity.this);
            }
        });

        startFlutterActivityTv = findViewById(R.id.main_start_flutter_old);
        startFlutterActivityTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FlutterMain.startInitialization(MyApplication.getContext());
                Intent intent = new Intent(MainActivity.this, FlutterActivity.class);
                startActivity(intent);
            }
        });

    }
}
