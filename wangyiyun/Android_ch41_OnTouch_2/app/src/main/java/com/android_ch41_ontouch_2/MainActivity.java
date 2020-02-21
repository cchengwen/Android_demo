package com.android_ch41_ontouch_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private RelativeLayout layout;
    //  屏幕改变时所获得的值
    private RelativeLayout.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.mainlayout);
        iv = findViewById(R.id.iv);

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    params = (RelativeLayout.LayoutParams) iv.getLayoutParams();
                    params.topMargin = (int) event.getY();
                    params.leftMargin = (int) event.getX();
                    iv.setLayoutParams(params);

                }
                return true;
            }
        });

    }
}
