package com.android_ch43_sendms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num, content;
    private Button send_btn;
    private SmsManager smsManager; //  发送短信（系统带的）

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.num);
        content = findViewById(R.id.content);

        send_btn = findViewById(R.id.send);

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();

                //  发送成功提示
                Toast.makeText(MainActivity.this, "发送成功", Toast.LENGTH_LONG).show();
            }
        });
    }


    //  发送短信（自定义方法）
    public void sendSMS(){
        smsManager = SmsManager.getDefault();
        /**
         * 参数1：发送给谁（电话号码）
         * 参数2：
         * 参数3：发送内容
         * 参数4：
         * 参数5：
         */
        smsManager.sendTextMessage(num.getText().toString(), null, content.getText().toString(), null, null);
    }
}
