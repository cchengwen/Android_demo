package com.android_ch23_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    // 声明一个适配器(系统提供的)
    private ArrayAdapter<String> adapter;
    // 数据
    private String[] data = new String[]{"广东", "广西", "北京"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        /**
         * 使用， 先实例化
         * 第一个参数：承接上下文；第二个参数：是为显示的资源id，以什么样的方式来显示（用系统提供的）；第三个参数：数据
         */
        adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, data);

        //  邦定Adapter
        lv.setAdapter(adapter);
    }
}
