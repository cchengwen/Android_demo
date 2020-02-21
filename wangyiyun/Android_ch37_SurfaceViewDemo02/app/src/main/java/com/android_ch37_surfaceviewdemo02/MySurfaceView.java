package com.android_ch37_surfaceviewdemo02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Timer;
import java.util.TimerTask;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    // 定义画笔并实例化
    private Paint paint = new Paint();

    private float x = 0;
    private float y = 0;
    private float speedX = 100;
    private float speedY = 100;
    private float addX = 2;
    private float addY = 2;

    // 计时器
    private Timer timer;
    private TimerTask task;

    public MySurfaceView(Context context) {
        super(context);

        //  添加回调函数
        getHolder().addCallback(this);
        paint.setColor(Color.RED);
    }

    // 自定义绘制方法
    public void draw() {
        //  锁定画布
        Canvas canvas = getHolder().lockCanvas();
        //  初始化，把画布设置成白色
        canvas.drawColor(0xFFFFFFFF);
        canvas.drawRect(x, y, speedX + x, speedY + y, paint);

        x += addX;
        y += addY;

        //  边界判断
        if (x < 0){
            addX = Math.abs(addX);
        }
        if (y < 0){
            addY = Math.abs(addY);
        }
        if (x > getWidth() - speedX){
            addX = -Math.abs(addX);
        }
        if (y > getHeight() - speedY){
            addY = -Math.abs(addY);
        }

        //  解锁画布
        getHolder().unlockCanvasAndPost(canvas);
    }

    //  定义开启方法
    public void start(){
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                draw();
            }
        };
        timer.schedule(task, 1000, 10);
    }
    //  定义停止方法
    public void stop(){
        timer.cancel();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
//        start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }
}
