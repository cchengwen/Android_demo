package com.android_ch24_listviewadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    //  适配器
    private MyAdapter adapter;
    // 数据
    private String[] data = {"北京","上海","广东","广西","湖北","湖南","新疆","云南","甘肃","黑龙江",
            "江西","杭州","江苏","吉林","辽宁","河北","河南","玉林","百色","博白","佛山","顺德","中山","深圳","广州","河源","清远","怀集"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        adapter = new MyAdapter(this, data);

        // 邦定adapter
        lv.setAdapter(adapter);
    }
}
