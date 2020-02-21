package com.android_ch05_edittext;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class Actv2 extends Activity {

    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actv2);

        tv = findViewById(R.id.tv);

        String val = getIntent().getStringExtra("name");

        tv.setText(val);

    }
}
