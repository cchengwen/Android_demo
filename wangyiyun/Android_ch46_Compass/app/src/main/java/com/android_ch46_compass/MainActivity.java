package com.android_ch46_compass;

import android.content.Context;
import android.hardware.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private ImageView iv;
    private SensorManager sensorManager;
    private Sensor sensor;
    private MyAnimation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.iv);

        //  使用传感器
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //  方向传感器
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        //  设置动画
        animation = new MyAnimation();
        animation.setDuration(200);
        animation.setFillAfter(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //  注册
        sensorManager.registerListener((SensorEventListener) this, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //  取消注册
        sensorManager.unregisterListener(this);
    }

    //  初始化位置
    float firstLocation = 0;


    //  传感器一执行就会触发
    @Override
    public void onSensorChanged(SensorEvent event) {
        //  获得当前变量的位置
        float nowLocation = -event.values[0];
        if (nowLocation == firstLocation){
            return;
        }
        //  执行动画
        iv.setAnimation(null);  //  初始化

        // 设置动画的起始点
        animation.setStartLocation(firstLocation);
        animation.setEndLocation(nowLocation);

        //  执行
        iv.startAnimation(animation);

        //
        firstLocation = nowLocation;//  动画连续执行
    }

    //  传感器发生改变的时候触发
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
