package com.android_ch33_canvas2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class MyView extends View {

    //  定义实例化画笔
    Paint p1 = new Paint();
    Paint p2 = new Paint();
    Paint p3 = new Paint();

    public MyView(Context context) {
        super(context);

        // 设置画笔
        p1.setColor(Color.BLUE);
        p1.setStrokeWidth(5);
        p2.setColor(Color.RED);
        p2.setStrokeWidth(4);
        p3.setColor(Color.GREEN);
        p3.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //  设置画布的背景颜色
        canvas.drawColor(0xFFFFFFFF);

        //  画直线
        canvas.drawLine(10,10,100,10,p1);
        canvas.drawLine(10,30,100,60,p2);

        // 点
        canvas.drawPoint(10, 50, p2);

        //  绘制圆
        canvas.drawCircle(300,200, 100, p3);

        //  绘制椭圆、
        RectF f = new RectF();
        f.left = 100;
        f.right = 700;
        f.top = 350;
        f.bottom = 700;
        canvas.drawOval(f, p2);

        //  绘制文字
        p3.setTextSize(100);  //  设置画笔的大小
        canvas.drawText("Canvas的使用", 30, 900, p3);


    }
}
