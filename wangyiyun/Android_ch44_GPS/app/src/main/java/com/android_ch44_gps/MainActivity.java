package com.android_ch44_gps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        openGPS();
        getLocation();

    }

    //  判断当前的 GPS 有没有打开(自定义方法)
    public boolean openGPS(){
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // 判断 gps 是否打开
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            return true;
        }
        Toast.makeText(this, "当前没有打开GPS！", Toast.LENGTH_LONG).show();
        return false;
    }

    // 获取位置（自定义方法）
    @SuppressLint("MissingPermission")
    public void getLocation(){
        LocationManager locationManager = null;

        //  获得服务名称
        String serviceName = Context.LOCATION_SERVICE;
        //  获得具体的位置
        locationManager = (LocationManager) getSystemService(serviceName);

        // 标准
        Criteria criteria = new Criteria();
        //  获得精度
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        //  海拔
        criteria.setAltitudeRequired(false);
        //  低功率
        criteria.setPowerRequirement(Criteria.POWER_LOW);

        //  获得GPS 信息
        String provide = locationManager.getBestProvider(criteria, true);

        //  最后一次获得位置
        @SuppressLint("MissingPermission")
        Location location = locationManager.getLastKnownLocation(provide);

        updateLocation(location);

        locationManager.requestLocationUpdates(provide, 10*1000, 50, listener);
    }

    //  监听
    private final LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    //  获得位置精维度
     private void updateLocation(Location location){
         if (location != null){
             double  weidu = location.getLatitude();  //  维度
             double jingdu = location.getLongitude();  //  精度
             tv.setText("维度："+weidu+"   精度："+ jingdu);
         }else {
             tv.setText("没有获取到信息！");
         }

     }
}
