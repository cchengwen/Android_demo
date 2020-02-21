package com.android_ch53_usingjson2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("\"hello\"");  //  "hello"

        JSONObject object = new JSONObject();
        try {
            object.put("wen01", "ch0001");
            object.put("wen02", "ch0002");

            System.out.println(object);  //   {"wen01":"ch0001","wen02":"ch0002"}
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
