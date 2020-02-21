package com.android_ch50_writestream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file = new File("/mnt/sdcard/wen/wen01.txt");
        // 判断当前的文件是否存在
        File dir = file.getParentFile();
        // 如果不存在则创建文件夹
        if (dir.exists()) {
            dir.mkdir();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 定义一个文件输出流
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(new String("BBSDDDDD").getBytes("UTF-8"));

            //  关闭流
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
