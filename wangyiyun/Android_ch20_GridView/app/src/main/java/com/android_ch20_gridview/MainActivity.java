package com.android_ch20_gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private int[] ids = new int[]{R.drawable.i1, R.drawable.i2, R.drawable.i3,
            R.drawable.i4, R.drawable.i5, R.drawable.i6, R.drawable.i7, R.drawable.i8};

    private GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv = findViewById(R.id.gv);

        //  所有资源
        List<Map<String, Object>> cellList = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("imagelog", ids[i]);
            cellList.add(map);
        }

        /**
         * 使用适配器
         * 第一个参数：承接上下文， 第二个参数：集合的数据，第三个参数：布局文件， 第四个参数：new一个字符串类型的数组, 第一个参数：布局文件中的控件
         */
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, cellList, R.layout.cell, new String[]{"imagelog"}, new int[]{R.id.iv});

        //  邦定适配器
        gv.setAdapter(simpleAdapter);
    }

}
