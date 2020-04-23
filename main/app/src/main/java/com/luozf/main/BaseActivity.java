package com.luozf.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import luozf.utils.PermissionU;
import luozf.utils.ToastU;

public class BaseActivity extends Activity implements View.OnClickListener {
    public BaseActivity() {
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.checkSavePermission();
    }

    private void checkSavePermission() {
        if (this.needCheckSavePermission()) {
            PermissionU.init(this);
            PermissionU.checkSavePermission(new PermissionU.PermissionCallBack() {
                public void onSuccess() {
                    onCheckPermissionSuccess();
                }

                public void onDenied() {
                    onCheckPermissionDenied();
                }
            });
        }

    }

    protected boolean needCheckSavePermission() {
        return false;
    }

    protected void onCheckPermissionSuccess() {
    }

    protected void onCheckPermissionDenied() {
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionU.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public final void onClick(View view) {
        try {
            this.onBaseClick(view);
        } catch (Exception var3) {
            var3.printStackTrace();
            ToastU.showd("点击事件出错了");
        }

    }

    protected void onBaseClick(View view) {
    }
}

