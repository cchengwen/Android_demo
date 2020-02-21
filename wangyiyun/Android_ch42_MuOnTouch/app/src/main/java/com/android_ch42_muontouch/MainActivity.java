package com.android_ch42_muontouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private MyView view;
    private float tance = 0;  //  初始值，用作比较

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = new MyView(this);
        setContentView(view);
        //  监听整个屏幕
        view.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //  获得多个手指的数量
        if (event.getPointerCount() >= 2) {
            float p1_x = event.getX();
            float p1_y = event.getY();
            float p2_x = event.getX();
            float p2_y = event.getY();

            float diff_x = p1_x - p2_x;
            float diff_y = p2_y - p2_y;

            // 得到两点间的距离
            float distancre = (float) Math.sqrt(diff_x * diff_x + diff_y + diff_y);
            // 输出两点间的距离
            System.out.println("两点间的距离 = " + distancre);

            if (tance == 0) {
                // 等等于0， 即没有放大也没有缩小
                tance = distancre;
            } else {
                if (distancre - tance > 10) {
                    //  放大
                    view.scale(view.getScale().x + 0.1f, view.getScale().y + 0.1f);
                    tance = distancre;
                } else if (distancre - tance < -10) {
                    // 缩小
                    view.scale(view.getScale().x - 0.1f, view.getScale().y - 0.1f);
                    tance = distancre;
                }
            }

            //  如果手指放开
            if (event.getAction() == MotionEvent.ACTION_UP) {
                tance = 0;
            }
        }
        return true;
    }
}
