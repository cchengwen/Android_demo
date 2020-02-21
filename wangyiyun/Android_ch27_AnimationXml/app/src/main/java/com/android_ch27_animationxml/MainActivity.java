package com.android_ch27_animationxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.lang.annotation.Annotation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button alpha_btn, rotate_btn, scale_btn, translate_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alpha_btn = findViewById(R.id.btn1);
        rotate_btn = findViewById(R.id.btn2);
        scale_btn = findViewById(R.id.btn3);
        translate_btn = findViewById(R.id.btn4);


        alpha_btn.setOnClickListener(this);
        rotate_btn.setOnClickListener(this);
        scale_btn.setOnClickListener(this);
        translate_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:// 淡入淡出
                //  引入xml文件(如果引入？：AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha)通过该方法加载xml文件)
                Animation animation_1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
                //  加载动画
                alpha_btn.startAnimation(animation_1);
                break;

            case R.id.btn2: //  旋转
                Animation animation_2 =  AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
                rotate_btn.startAnimation(animation_2);

                break;

            case R.id.btn3: //  缩放
                Animation animation_3 =AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);
                scale_btn.startAnimation(animation_3);
                break;

            case R.id.btn4: //  移动
                Animation animation_4 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.trinsale);
                translate_btn.startAnimation(animation_4);
                break;
        }
    }
}
