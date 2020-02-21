package com.android_ch06_imageviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private int[] imageids = {R.drawable.i2, R.drawable.i3, R.drawable.i8};
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.iv);
        //  给 ImageView 设置图片
        iv.setBackgroundResource(R.drawable.i3);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i ++;
                if(i == imageids.length){
                    i = 0;
                }
                iv.setBackgroundResource(imageids[i]);
            }
        });


    }
}
