package com.wen;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    // 声明一个 btn 对象
    Button IntentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 通过 Activity 的 findViewById()找到btn
        IntentBtn = findViewById(R.id.btn);
        IntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Act2.class);
                //  传值
                intent.putExtra("name", "第一次练习传值！！！！");
                //  跳转到另一个Act2的activity
                startActivity(intent);
            }
        });
    }
}
