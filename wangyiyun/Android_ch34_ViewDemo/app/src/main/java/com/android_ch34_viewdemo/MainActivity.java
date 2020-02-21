package com.android_ch34_viewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MyView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view =new MyView(this);
        setContentView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        view.startTimer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        view.stopTimer();
    }
}
