package com.android_ch13_prograssbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button add_btn;
    private Button low_btn;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_btn = findViewById(R.id.btn);
        low_btn = findViewById(R.id.btn2);

        add_btn.setOnClickListener(this);
        low_btn.setOnClickListener(this);

        pb = findViewById(R.id.pro);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                //  设置进度条的属性（进度条的进度），pb.getProgress() 获取进度条里面的长度
                pb.setProgress((int) (pb.getProgress()*1.1));
                break;
            case R.id.btn2:
                pb.setProgress((int) (pb.getProgress()*0.9));
                break;
        }
    }
}
