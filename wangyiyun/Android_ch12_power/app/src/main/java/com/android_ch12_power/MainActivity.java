package com.android_ch12_power;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView power_tv;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
                //  系统中取到电量的键：level
                int level = intent.getIntExtra("level", 0);

                int scale = intent.getIntExtra("scale", 100);

                power_tv.setText("电池电量：" + (level * 100 / scale) + "%");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        power_tv = findViewById(R.id.tv);

        //  动态注册,第一参数： BroadcastReceiver 的对象，  第二个参数：权限（与AndroidManifest.xml中的<intent-filter>
        //                <action android:name="android.intent.action.MAIN"/>
        //
        //                <category android:name="android.intent.category.LAUNCHER"/>
        //            </intent-filter> 的权限标签）
        registerReceiver(receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //  取消注册
        unregisterReceiver(receiver);
    }
}
