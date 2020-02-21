package com.android_ch37_surfaceviewdemo02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MySurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        surfaceView = new MySurfaceView(this);
        setContentView(surfaceView);
    }

    @Override
    protected void onStop() {
        super.onStop();
        surfaceView.stop();
    }
}
