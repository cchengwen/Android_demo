package com.android_ch42_muontouch;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyView extends SurfaceView implements SurfaceHolder.Callback {

    private Bitmap bitmap;
    private Rect rect = new Rect();
    private RectF rectF = new RectF();
    private PointF scale = new PointF(1,1);


    public MyView(Context context) {
        super(context);

        //  回调函数
        getHolder().addCallback(this);

      bitmap = ((BitmapDrawable) getResources().getDrawable(R.mipmap.p12)).getBitmap();
      rect.right = bitmap.getWidth();
      rect.bottom = bitmap.getHeight();

      rectF.right = rect.right;
      rectF.bottom = rect.bottom;
    }

    //  绘制方法
    public void draw(){
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(0xFFFFFFFF);
        canvas.save();  //  图片可剪辑

        /**
         * 第三、四个参数：从图片的中间开始变化
         */
        canvas.scale(getScale().x, getScale().y, getWidth()/2, getHeight()/2);

        //  绘制到屏幕上
        canvas.drawBitmap(bitmap, rect, rectF, null);


        canvas.restore();  //  资源释放（还原）

        //  解锁画布
        getHolder().unlockCanvasAndPost(canvas);
    }

    //  控制图片的变化
    public void scale(float scaleX,float scaleY){
        getScale().x = scaleX;
        getScale().y = scaleY;
    }

    public PointF getScale() {
        return scale;
    }

    public void setScale(PointF scale) {
        this.scale = scale;
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
}
