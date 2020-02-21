package com.android_ch36_surfaceviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    // 定义画笔
    private Paint paint = new Paint();

    public MySurfaceView(Context context) {
        super(context);
        //  回调函数
        getHolder().addCallback(this);

        //  设置画笔颜色
        paint.setColor(Color.BLUE);
    }

    // 绘制方法,(注：无法使用重写的onDraw()方法，原因是会传的参数Canvas，在以下几个方法中没有此参数)
    public void draw(){
        //  锁定画布
        Canvas canvas = getHolder().lockCanvas();

        canvas.drawColor(Color.WHITE);
        canvas.drawText("这一个 SurfaceView 的使用", 50, 50, paint);


        //  解锁画布
        getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        draw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
