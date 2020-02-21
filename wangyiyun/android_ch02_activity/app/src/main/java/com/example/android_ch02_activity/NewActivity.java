package com.example.android_ch02_activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class NewActivity extends Activity {
    private final String TAG = this.getClass().getSimpleName();

/**
 * 运行：OnCreate -> onStart -> onResume
 * 暂停： onResume -> onPause     再次重新运行： onResume
 * 停止： onPause -> onStop -> onDestroy      : 重新执行： onRestart -> onStart -> onResume
 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        //  需要加载一个视图（xml）
        setContentView(R.layout.newactivity);
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy" );
        super.onDestroy();
    }
    @Override
    protected void onRestart() {
        Log.i(TAG, "onRestart");
        super.onRestart();
    }
}
