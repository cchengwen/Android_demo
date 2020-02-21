package com.android_ch49_readstream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 创建 File
        File file = new File("/mnt/sdcard/text.txt");
        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream(file);
            // 缓冲读取
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            //  开始读取
            String line = null;
            String content = null;
            while ((line = br.readLine()) != null){
                content += line;
            }
            System.out.println(content);
            // 关闭流
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
