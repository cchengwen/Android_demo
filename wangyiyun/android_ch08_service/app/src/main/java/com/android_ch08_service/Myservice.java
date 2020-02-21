package com.android_ch08_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class Myservice extends Service {

    //  创建Service时，需要重写的一个方法，主要是实现与Activity 进行绑定
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("Myservice =====================> onBind");
        return null;
    }

    //  创建（service 如果创建了，没有销毁，只执行一次）
    @Override
    public void onCreate() {
        System.out.println("Myservice =====================> onCreate");
        super.onCreate();
    }

    //  开始执行 Service（此方法会执行多次）
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("Myservice =====================> onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    //  销毁
    @Override
    public void onDestroy() {
        System.out.println("Myservice =====================> onDestroy");
        super.onDestroy();
    }
}
