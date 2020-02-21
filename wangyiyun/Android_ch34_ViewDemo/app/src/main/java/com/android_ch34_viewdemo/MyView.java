package com.android_ch34_viewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MyView extends View {

    private Paint paint = new Paint();

    //  定义矩形的边界
    private float x = 0;
    private float y = 0;
    private float speedX = 50;
    private float speedY = 50;

    //  变化的坐标值
    private float addy = 2;

    //  计时器
    private Timer timer;
    private TimerTask task;

    public MyView(Context context) {
        super(context);
        // 设置画笔属性
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0xFFFFFF);
        canvas.drawRect(x,y, speedX+x, speedY+y, paint);

        y += addy;
    }


    public void startTimer(){
        timer= new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        };
        timer.schedule(task, 1000, 100);
    }

    public void stopTimer(){
        timer.cancel(); // 停止
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //  重绘
            invalidate();
        }
    };
}
