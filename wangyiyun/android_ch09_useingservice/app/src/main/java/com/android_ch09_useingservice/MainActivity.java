package com.android_ch09_useingservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {
    // 声明 Button
    private Button start_service, stop_service;
    private Intent intent;
    private Button binder_service, unBinder_service, getService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  获取
        start_service = findViewById(R.id.start);
        stop_service = findViewById(R.id.stop);
        binder_service = findViewById(R.id.bindService);
        unBinder_service = findViewById(R.id.unBindService);
        getService = findViewById(R.id.getServiceStatus);

        //  实现监听
        start_service.setOnClickListener(this);
        stop_service.setOnClickListener(this);

        binder_service.setOnClickListener(this);
        unBinder_service.setOnClickListener(this);
        getService.setOnClickListener(this);
        intent = new Intent(MainActivity.this, MyService.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                startService(intent);
                break;
            case R.id.stop:
                stopService(intent);
                break;
            case R.id.bindService:
                /**
                 * @deprecated 邦定service ; 第一个参数为：intent,  第二个参数为：当前类的上下文，  第三个参数为：是否自动创建，（可以多选，在此让它自动创建）
                 */
                bindService(intent, this, BIND_AUTO_CREATE);
                break;
            case R.id.unBindService:
                //  解除邦定
                unbindService(this);
                break;
            case R.id.getServiceStatus:
                /**
                 * @deprecated 第一个参数：当前类， 第二个参数 ： 显示的内容， 第三个参数： 显示的时间
                 */
                Toast.makeText(MainActivity.this, "当前 Service 状态： "+my.getIndex(), Toast.LENGTH_LONG).show();
                break;
        }
    }

    //  如何得到 service 状态
    private MyService my;
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("MainActivity ================》 onServiceConnected() ");
        MyService.MyBinder m = (MyService.MyBinder) service;
        //  获取当前 service 状态
        my = m.getMyService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
