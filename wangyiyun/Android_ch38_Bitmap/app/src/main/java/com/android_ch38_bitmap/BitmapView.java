package com.android_ch38_bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class BitmapView extends SurfaceView implements SurfaceHolder.Callback {
    //  声明 Bitmap 对象
    private Bitmap bitmap;

    private BitmapDrawable bitmapDrawable;
    private int bitmapWidth = 0;
    private int bitmapHeight = 0;


    public BitmapView(Context context) {
        super(context);
        //  通过 BitmapDrawable 引入图片资源
        bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher);

        // getBitmap() 方法将图片转换成 Bitmap类型
        bitmap = bitmapDrawable.getBitmap();

        //  获得图片的宽和高
        bitmapWidth = bitmap.getWidth();
        bitmapHeight = bitmap.getHeight();


        // 添加回调函数
        getHolder().addCallback(this);
    }

    //  自定义绘制方法
    public void draw() {
        // 锁定画布
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(0xFFFFFFFF);

        // 第一种： 使用 Bitmap 直接绘图
//        bitmapDrawable.setBounds(0,0,bitmapWidth, bitmapHeight);
//        bitmapDrawable.draw(canvas);

        // 第二种： 使用 Canvas 绘制 bitmap
//        canvas.drawBitmap(bitmap, 50, 0, null);

        //  第三种：将原图绘制在指定的矩形区域中
        Rect rect = new Rect(0, 0, 60, 60); //  指定大小
        RectF rectF = new RectF(0, 0, 60, 60);  //  指定区域
        canvas.drawBitmap(bitmap, rect, rectF, null);

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
