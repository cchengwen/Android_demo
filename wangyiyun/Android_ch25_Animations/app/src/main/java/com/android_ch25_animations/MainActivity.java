package com.android_ch25_animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.*;
import android.widget.Button;

import java.lang.annotation.Annotation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button alpha_btn, scale_btn, rotate_btn, translate_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alpha_btn = findViewById(R.id.btn);
        scale_btn = findViewById(R.id.btn2);
        rotate_btn = findViewById(R.id.btn3);
        translate_btn = findViewById(R.id.btn4);

        alpha_btn.setOnClickListener(this);
        scale_btn.setOnClickListener(this);
        rotate_btn.setOnClickListener(this);
        translate_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn://  淡入淡出
                //  第一步：创建 AnimationSet 对象
                AnimationSet animationSet_1 = new AnimationSet(true);//  表示动画是否加载，true为加载
                // 第二步：创建相应的动画
                AlphaAnimation animation = new AlphaAnimation(1, 0);// 当前从什么样的透明度到什么样的透明度
                //  第三步：设置动画执行的时间
                animation.setDuration(2000);
                // 第四步：将动画加入到动画集中
                animationSet_1.addAnimation(animation);
                //  第五步：直接作用在控件之上
                alpha_btn.startAnimation(animationSet_1);
                break;

            case R.id.btn2: //  缩放
                AnimationSet animationSet_2 = new AnimationSet(true);
//                ScaleAnimation scale = new ScaleAnimation(1,
//                        0.1f,1,0.1f, Animation.RELATIVE_TO_SELF, 1,
//                        Animation.RELATIVE_TO_SELF, 1f);
                ScaleAnimation scale = new ScaleAnimation(1,
                        0.1f,1,0.1f, Animation.RELATIVE_TO_PARENT, 1f,
                        Animation.RELATIVE_TO_PARENT, 0);
                scale.setDuration(2000);
                animationSet_2.addAnimation(scale);
                scale_btn.startAnimation(animationSet_2);
                break;

            case R.id.btn3:  //  旋转
                AnimationSet animationSet_3 = new AnimationSet(true);
                RotateAnimation rotate = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,
                        0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(2000);
                animationSet_3.addAnimation(rotate);
                rotate_btn.startAnimation(animationSet_3);
                break;

            case R.id.btn4:  //  移动
                AnimationSet animationSet_4 = new AnimationSet(true);
                TranslateAnimation trans = new TranslateAnimation(
                        Animation.RELATIVE_TO_PARENT, 0f,
                        Animation.RELATIVE_TO_PARENT, 1f,
                        Animation.RELATIVE_TO_PARENT, 0f,
                        Animation.RELATIVE_TO_PARENT, 1f);
                trans.setDuration(2000);
                animationSet_4.addAnimation(trans);
                translate_btn.startAnimation(animationSet_4);
                break;
        }
    }
}
