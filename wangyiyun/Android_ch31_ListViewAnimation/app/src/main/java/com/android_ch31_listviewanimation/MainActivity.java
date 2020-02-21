package com.android_ch31_listviewanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ListView lv;

    // 适配器(使用系统的适配器）
    private ArrayAdapter<String> adapter;

    //  数据
    private String[] data = {"北京","上海","广东","广西","江苏","河南","河北","湖南","湖北","江西","新疆","甘肃",
            "黑龙江","云南","澳门","香港","陕西"};

    //  布局动画管理
    private LayoutAnimationController controller;
    //  定义动画
    private RotateAnimation ra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        lv = findViewById(R.id.lv);

        //  使用适配器
        adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, data);

        //  邦定适配器
        lv.setAdapter(adapter);

        // 加载动画
        ra = new RotateAnimation(0, 360, 0.5f,0.5f);
        ra.setDuration(500);

        //  实例化管理器
        controller = new LayoutAnimationController(ra);
        // 设置动画的属性
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        //  给ListView 加载动画，  加载动画
        lv.setLayoutAnimation(controller);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv.startLayoutAnimation();
            }
        });





    }
}
