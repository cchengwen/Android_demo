package com.android_ch55_loadwebdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //  访问网络
            URL url = new URL("https://www.baidu.com");
            InputStream is = url.openStream();

            //  读取数据
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = null;
            String content = null;

            while ((line = br.readLine()) !=null){
                content += line;
            }
            br.close();
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
