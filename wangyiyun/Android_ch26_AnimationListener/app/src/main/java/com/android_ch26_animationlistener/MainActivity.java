package com.android_ch26_animationlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    //  声明动画并实例化
    private AlphaAnimation alpha_1 = new AlphaAnimation(1, 0); //  从什么样的透明度到什么样的透明度
    private AlphaAnimation alpha_2 = new AlphaAnimation(0, 1);

    private ScaleAnimation scale = new ScaleAnimation(1,
            0.1f,1,0.1f, Animation.RELATIVE_TO_PARENT, 1f,
            Animation.RELATIVE_TO_PARENT, 0);
    private Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alpha_1.setDuration(2000);
        alpha_2.setDuration(2000);

        scale.setDuration(2000);

        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.startAnimation(alpha_1);
            }
        });

        alpha_1.setAnimationListener(this);
//        //  动画监听
//        alpha_1.setAnimationListener(new Animation.AnimationListener() {
//            //  动画开始的时候触发
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//            // 动画结束的时候触发
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                //  第一个动画结束的时候开始第二个动画
//                btn.startAnimation(alpha_2);
//            }
//
//            //  动画重新执行的时候触发
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });

    }

    @Override
    public void onAnimationStart(Animation animation) {
        btn2.startAnimation(scale);

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        btn.startAnimation(alpha_2);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
