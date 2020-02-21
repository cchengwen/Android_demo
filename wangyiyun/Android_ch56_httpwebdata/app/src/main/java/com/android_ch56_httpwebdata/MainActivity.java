package com.android_ch56_httpwebdata;

import android.app.Activity;
import android.os.Bundle;

import java.net.HttpRetryException;

public class MainActivity extends Activity {

    private HttpResponse httpResponse = null;
    private HttpRetryException httpEntity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  生成一个请求对象
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
    }
}
