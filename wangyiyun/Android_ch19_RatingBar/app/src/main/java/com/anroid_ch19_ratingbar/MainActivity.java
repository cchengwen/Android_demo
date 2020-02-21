package com.anroid_ch19_ratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener {

    private RatingBar rb;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb = findViewById(R.id.rb1);
        tv = findViewById(R.id.tv);
        //  监听星星控件的改变
        rb.setOnRatingBarChangeListener(this);
    }

   @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser){
        //  得到(设置)当前星星的数量
        ratingBar.setRating(rating);
        //  如果当前星星的ID与用户操作的ID是同一个，则设置到TextView中
        if (ratingBar.getId() ==  R.id.rb1){
            tv.setText("分数为："+rating);
        }
    }
}
