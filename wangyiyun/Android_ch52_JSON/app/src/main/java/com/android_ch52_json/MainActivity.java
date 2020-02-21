package com.android_ch52_json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println(Data.jsonStr);


        //  解析
        try {
            JSONObject jsonObject = new JSONObject(Data.jsonStr);
            System.out.println("jsonObject = "+jsonObject);

            JSONArray jsonArray = jsonObject.getJSONArray("arr");
            JSONArray jsonArray1 = jsonObject.getJSONArray("dat");
            System.out.println("jsonArray = "+jsonArray);
            System.out.println("jsonArray1 = "+jsonArray1);

            for (int i = 0; i < jsonArray.length(); i++) {
                System.out.println(jsonArray.get(i));
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
