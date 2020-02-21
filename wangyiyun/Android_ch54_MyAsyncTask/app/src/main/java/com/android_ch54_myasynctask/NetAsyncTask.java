package com.android_ch54_myasynctask;

import android.os.AsyncTask;

public class NetAsyncTask extends AsyncTask<Void, Void, Void> {

    // 这是一个独立的线程(注：以后连网后，要异步操作的都放在此，在别处调用)
    @Override
    protected Void doInBackground(Void... voids) {
        Net net2 = new Net();
        net2.net();
        return null;
    }
}
