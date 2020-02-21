package com.wen;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class Act2 extends Activity {

    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act2);

        tv = findViewById(R.id.tv);

//        Bundle extras = getIntent().getExtras();
//        String val = (String) extras.get("name");
        String val = getIntent().getStringExtra("name");

        tv.setText(val);
    }
}
