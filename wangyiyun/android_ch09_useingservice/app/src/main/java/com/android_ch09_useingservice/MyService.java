package com.android_ch09_useingservice;
import	java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Timer;

public class MyService extends Service {

    private Timer timer;//  定时器（秒表）
    private TimerTask task;  //  Time 与 TimeTask 配合使用
    private int index = 0;

    // 与 Activity 进行邦定
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("MyService ==============》 onBind()");
        return binder;
    }

    MyBinder binder = new MyBinder();

    //  自定义MyBuinder，继承 Binder 实现通信
    public class MyBinder extends Binder {
        // 获得当前 service 的状态
        public MyService getMyService() {
            return MyService.this;
        }
    }



    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("MyService ==============》 onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("MyService ==============》 onStartCommand()");
        startTimer();
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("MyService ==============》 onDestroy()");
        stopTimer();
    }

    /**
     * @deprecated  开始执行计时器timer
     */
    public void startTimer(){
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                index ++;
                System.out.println("MyService ==============》 startTimer() =========》 "+index);
            }
        };
        /**
         * @deprecated  第一个参数为 TimeTask 对象， 第二个参数为延时（间隔）多少秒执行，第三个参数为每隔多少秒执行一次
         */
        timer.schedule(task, 1000, 1000);
    }

    /**
     * @deprecated  停止执行计时器timer
     */
    public void stopTimer(){
        System.out.println("MyService ==============》 stopTimer() ");
        timer.cancel();
    }

    // index 的get方法， 实现index 的可读性
    public int getIndex(){
        return index;
    }
}
