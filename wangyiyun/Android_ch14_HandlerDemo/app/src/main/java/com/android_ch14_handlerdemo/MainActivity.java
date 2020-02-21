package com.android_ch14_handlerdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start_btn, stop_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_btn = findViewById(R.id.start);
        stop_btn = findViewById(R.id.stop);
        //  监听按钮
        start_btn.setOnClickListener(this);
        stop_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.start:
                //  通达post启动runnable
                handler.post(runnable);
                break;
            case R.id.stop:
                // 移动掉 runnable
                handler.removeCallbacks(runnable);
                i=0;
                break;
        }

    }

    // 创建 Handle,  Handle 本身是一个消息队列的传递
    int i = 0;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {

        @Override
        public void run() {
            System.out.println("runnable  ============>  "+ i);
            /**
             * 消息队列
             * 第一参数：Runnable对象，  第二个参数：每隔多少毫秒执行一次
             */
            handler.postDelayed(runnable, 3000);
            i++;
        }
    };
}
