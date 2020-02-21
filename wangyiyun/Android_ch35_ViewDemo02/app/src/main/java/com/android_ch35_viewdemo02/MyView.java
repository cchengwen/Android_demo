package com.android_ch35_viewdemo02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.View;


public class MyView extends View implements View.OnClickListener {

    private float x = 0;
    private float y = 0;
    private float speedX = 50;
    private float speedY = 50;
    private float addX = 2;
    private float addY = 2;

    private Paint paint = new Paint();

    private boolean flag = false; //  设置停止值，默认为false

    public MyView(Context context) {
        super(context);

        // 定义画笔属性
        paint.setColor(Color.RED);
        //  监听
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0xFFFFFFFF);
        canvas.drawRect(x, y, speedX + x, speedY + y, paint);
        x += addX;
        y += addY;

        // 判断是否到边界
        if (x < 0) {
            addX = Math.abs(addX);
        }
        if (y < 0) {
            addY = Math.abs(addY);
        }

        if (x > (getWidth() - speedX)) {
            addX = -Math.abs(addX);
        }
        if (y > (getHeight() - speedY)) {
            addY = -Math.abs(addY);
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // 重绘
            invalidate();
            handler.sendEmptyMessageDelayed(0, 20);
        }
    };


    public void start() {
        if (!flag) {
            handler.sendEmptyMessage(0);
            flag = true;
        }
    }

    public void stop() {
        if (flag) {
            handler.removeMessages(0);
            flag = false;
        }
    }

    @Override
    public void onClick(View v) {
        if (flag) {
            stop();
        } else {
            start();
        }
    }


    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}

























