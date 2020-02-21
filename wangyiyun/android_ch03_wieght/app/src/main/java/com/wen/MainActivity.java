package com.wen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //  声明一个对象
    private TextView tv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  通过 Activity　的方法（findViewById） 找到相应的id（R.id.btn）
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.bt);

        //  监听当前的btn
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("tdm，终于成功进来了！！！！");
            }
        });
    }
}
