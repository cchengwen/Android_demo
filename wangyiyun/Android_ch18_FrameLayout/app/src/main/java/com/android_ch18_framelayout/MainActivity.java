package com.android_ch18_framelayout;

        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

public class MainActivity extends AppCompatActivity implements Runnable {

    //  定义五个颜色值
    private int[] colors = new int[]{0xFFFF0000, 0xff0000FF, 0xFF00FFFF, 0xFFFF00FF, 0xFF00FF00};

    //  正义每个颜色值的索引
    private int[] nextColorsPoints = new int[]{1, 2, 3, 4, 0};

    private View[] view;

    //  定义当前值的索引
    private int currentColorPoint = 0;

    // Handler
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("MainActivity  ============》 onCreate() ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = new View[]{findViewById(R.id.tv5), findViewById(R.id.tv4),
                findViewById(R.id.tv3), findViewById(R.id.tv2), findViewById(R.id.tv1)};
        handler = new Handler();
        handler.postDelayed(this, 300);

    }

    @Override
    public void run() {
        System.out.println("MainActivity  ============》 run() ");
        int nextPoint = currentColorPoint;
        for (int i = view.length - 1; i >= 0; i--) {
            view[i].setBackgroundColor(colors[nextColorsPoints[nextPoint]]);
            nextPoint = nextColorsPoints[nextPoint];
        }
        currentColorPoint++;
        if (currentColorPoint == 5) {
            currentColorPoint = 0;
        }
        //
        handler.postDelayed(this, 300);
    }
}
