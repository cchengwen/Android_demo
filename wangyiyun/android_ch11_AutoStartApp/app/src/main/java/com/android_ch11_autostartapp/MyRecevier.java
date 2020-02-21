package com.android_ch11_autostartapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyRecevier extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
     Intent i = new Intent(context, MainActivity.class);
     //  如果当前的 Activity 已经存在了，再次运行应用程序，重新创建当前的 Activity (注: 它比默认的优先级要高一些）
     i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

     context.startActivity(i);
    }
}
