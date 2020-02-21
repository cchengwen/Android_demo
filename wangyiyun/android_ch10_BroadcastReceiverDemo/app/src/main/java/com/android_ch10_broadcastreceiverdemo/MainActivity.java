package com.android_ch10_broadcastreceiverdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 *  BoradcasetReeceiver 没有用户界面，所以不会涉及到xml文件
 */
public class MainActivity extends AppCompatActivity {

    private Button send_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send_btn = findViewById(R.id.btn);

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MyRecevier.class);
                i.putExtra("name", "我的第一个广播！");
                //  发送广播的方法
                sendBroadcast(i);
            }
        });


    }
}
