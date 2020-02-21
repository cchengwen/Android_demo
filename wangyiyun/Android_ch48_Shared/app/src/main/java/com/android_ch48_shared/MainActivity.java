package com.android_ch48_shared;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edit;
    private CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.name);
        cb = findViewById(R.id.cb);

        //  得到 shared
        SharedPreferences sharedPreferences = getSharedPreferences("wen", MainActivity.MODE_PRIVATE);

        //  标记a
        edit.setText(sharedPreferences.getString("name", ""));
        cb.setChecked(sharedPreferences.getBoolean("sex", false));
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences sharedPreferences = getSharedPreferences("wen", MainActivity.MODE_PRIVATE);

        // 记录当前的对象数据
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //  做储存（要与"标记a" 的值相对应 ）
        editor.putString("name", edit.getText().toString());
        editor.putBoolean("sex", cb.isChecked());

        //  保存
        editor.commit();

    }
}
