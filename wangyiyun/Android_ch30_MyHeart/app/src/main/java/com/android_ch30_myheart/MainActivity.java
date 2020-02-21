package com.android_ch30_myheart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    private ImageView iv_anim;
    private Animation large, small;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_anim = findViewById(R.id.iv);

        // 引入xml配置动画
        large = AnimationUtils.loadAnimation(MainActivity.this, R.anim.large);
        small = AnimationUtils.loadAnimation(MainActivity.this, R.anim.small);

        large.setAnimationListener(this);
        small.setAnimationListener(this);
        iv_anim.startAnimation(small);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        //  判断当前状态
        if (animation.hashCode() == large.hashCode()){
            //  如果当前状态为最大的，则执行此
            iv_anim.startAnimation(small);
        }else {
            //  反之执行执行此
            iv_anim.startAnimation(large);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
