package com.android_ch39_drawpath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(this);
        // 将自定义的控件引入
        view = findViewById(R.id.draw);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                view.clearDraw();
                break;
        }
    }
}
