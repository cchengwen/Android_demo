package com.android_ch28_frameanimations;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] frameIds = new int[]{R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4,
            R.drawable.p5, R.drawable.p6, R.drawable.p7, R.drawable.p8, R.drawable.p10,
            R.drawable.p11, R.drawable.p12, R.drawable.p13, R.drawable.p14};

    private Button start_btn, stop_btn;
    private ImageView iv;

    //  创建 AnimationDrawable 序列的对象
    private AnimationDrawable anim;
    //  资源
    private Resources res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_btn = findViewById(R.id.btn1);
        stop_btn = findViewById(R.id.btn2);

        iv = findViewById(R.id.iv);

        start_btn.setOnClickListener(this);
        stop_btn.setOnClickListener(this);

        //  获得图片的资源
        res = getResources();
        //  实例化
        anim = new AnimationDrawable();

        for (int i = 0; i < frameIds.length; i++) {
            //  参数1：图片的资源， 参数2：第一张图片之间执行的时间间隔
            anim.addFrame(res.getDrawable(frameIds[i]), 100);
        }
        //  设置图片（加载动画)
        iv.setBackgroundDrawable(anim);

        //  设置动画是否可见
        anim.setVisible(true, true);

        //  设置动画是否执行一次
        anim.setOneShot(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                anim.start();
                break;

            case R.id.btn2:
                anim.stop();
                break;
        }
    }
}
