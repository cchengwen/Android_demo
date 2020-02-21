package com.android_ch39_drawpath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;


public class MyView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {

    //  声明实例化Path对象
    private Path path = new Path();
    private Paint paint = new Paint();

    public MyView(Context context) {
        super(context);
        init();
    }

    //  定论两个参数的构造方法，是用于加载自定义控件使用的
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    //  定义初始化方法
    public void init() {
        setOnTouchListener(this);
        getHolder().addCallback(this);
    }

    // 定义绘制方法
    public void draw() {
        //  锁定画布
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(0xFFFFFFFF);

        canvas.drawPath(path, paint);

        //  解锁画布
        getHolder().unlockCanvasAndPost(canvas);
    }

    /**
     *   定义清理画布的方法
     */
    public void clearDraw(){
        path.reset();
        draw();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        draw();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:  //  按下的事件
                paint.setStyle(Style.STROKE); // 空心的
                paint.setColor(Color.RED);
                //  用户按下后，获取x、y坐标
                path.moveTo(event.getX(), event.getY());
                break;

            case MotionEvent.ACTION_MOVE:  //  滑动事件
                //  生成线条
                path.lineTo(event.getX(), event.getY());
                draw();
                break;
        }
        return true;
    }
}
