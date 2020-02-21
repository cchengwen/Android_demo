package com.android_ch32_canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  引入 View 视图
        setContentView(new MyView(this));
    }

    //  实例化画笔
    private Paint paint = new Paint();

    //  创建 View，用来承载当前视图
    public class MyView extends View {

        public MyView(Context context) {
            super(context);
        }

        //  重写 onDraw 方法
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            //  设置画布背景颜色(白色）
            canvas.drawColor(0XFFFFFFFF);

            //  保存当前图形的一个可编辑或者可剪辑的状态
            canvas.save();

            //  设置画笔颜色
            paint.setColor(Color.RED);
            canvas.drawRect(0,0,100,50, paint);

            //  释放资源
            canvas.restore();
        }
    }
}
