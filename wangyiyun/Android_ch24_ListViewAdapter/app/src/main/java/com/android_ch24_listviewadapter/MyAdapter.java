package com.android_ch24_listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private String[] data;

    public MyAdapter(Context context, String[] data){
        this.context = context;
        this.data = data;
    }

    //  当前你的数据长度
    @Override
    public int getCount() {
        return data.length;
    }

    //  获得当前每一条数据的item
    @Override
    public Object getItem(int position) {
        return data[position];
    }

    //  获取每一条数据的id
    @Override
    public long getItemId(int position) {
        return position;
    }

    //  需要加载的视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 如果当前视图为空，表示没有视图
        if (convertView == null){
            //  通过以下方式加载一个视图
            convertView = LayoutInflater.from(context).inflate(R.layout.cell, null);
        }

        TextView tv = convertView.findViewById(R.id.tv);
        tv.setText(data[position]);
        return convertView;
    }
}
