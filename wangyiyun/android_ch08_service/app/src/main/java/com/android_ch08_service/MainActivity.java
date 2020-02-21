package com.android_ch08_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startService, stopService;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService = findViewById(R.id.btn1);
        stopService = findViewById(R.id.btn2);

        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        i = new Intent(MainActivity.this, Myservice.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                //  启动service
                startService(i);
                break;
            case R.id.btn2:
                //  停止 service
                stopService(i);
                break;
        }
    }
}
