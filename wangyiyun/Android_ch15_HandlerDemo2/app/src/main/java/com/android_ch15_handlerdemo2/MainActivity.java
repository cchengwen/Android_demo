package com.android_ch15_handlerdemo2;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start_btn, stop_btn;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_btn = findViewById(R.id.start);
        stop_btn = findViewById(R.id.stop);

        pb = findViewById(R.id.pb);

        start_btn.setOnClickListener(this);
        stop_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                handler.post(runable);
                break;
            /**
             * 在实际在，此停止按钮没有实际意义，因为如果程序在Runnable中运行，该按钮没有起作用，如果程序在Handle中运行的，该按钮才会起效
             * 因此，在实际中不建议使用，如果使用，需要另找方法
             */
            case R.id.stop:
                handler.removeCallbacks(runable);
                break;
        }
    }

    //  创建 Handle
    Handler handler = new Handler(){
        //  接收消息
        @Override
        public void handleMessage(Message msg) {
            //   在handle中就接收一次消息
            System.out.println("接收消息  handleMessage ==========》 "+msg);
            System.out.println("接收消息  handleMessage ==========》 "+msg.arg1);
            pb.setProgress(msg.arg1);
            // 在此调用该方法为，每增加一次就执行一次
            handler.post(runable);

            //  判断是否达到100，达到则停止执行
            if (msg.arg1 == 100){
                handler.removeCallbacks(runable);
            }

        }
    };
    Runnable runable = new Runnable() {
        int i = 0;
        public void run(){
            i += 5;
            //  Message是Android系统提供的（消息对象）
            Message message = handler.obtainMessage();
            /**
             *  arg1 的优点，在于他是系统提供的，并且会节省系统的资源消耗
             *  （通过以下方式来存储i的值）
             */
            message.arg1 = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //  往handler 发送一次消息
            handler.sendMessage(message);
        }
    };
}
