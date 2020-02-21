package com.android_ch54_myasynctask;

//  模拟网络的操作
public class Net {

    public void net() {
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
