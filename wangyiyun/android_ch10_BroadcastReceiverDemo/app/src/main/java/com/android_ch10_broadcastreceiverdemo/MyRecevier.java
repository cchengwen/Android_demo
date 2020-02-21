package com.android_ch10_broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyRecevier extends BroadcastReceiver {

    /**
     * @deprecated   重写方法；此方法也是该 BroadcastReceiver 的生命周期
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        //  接收广播  intent.getStringExtra("name")
        System.out.println(intent.getStringExtra("name"));
    }
}
