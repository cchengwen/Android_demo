package com.android_ch54_myasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
//                Net net1 = new Net();
//                net1.net();

                //  使用 AsyncTask 异步操作
                NetAsyncTask asyncTask = new NetAsyncTask();
                asyncTask.execute();
                break;

            case R.id.btn2:
                System.out.println("www.baidu.com");
                break;
        }
    }
}
