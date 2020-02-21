package com.android_ch22_galley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Gallery;

public class MainActivity extends AppCompatActivity {

    private Gallery gallery;
    private int[] ids = new int[]{R.drawable.i1, R.drawable.i2, R.drawable.i3,
            R.drawable.i4, R.drawable.i5, R.drawable.i6};

    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery = findViewById(R.id.gy);

        myAdapter = new MyAdapter(this, ids);

        //  邦定Adapter
        gallery.setAdapter(myAdapter);

    }
}
