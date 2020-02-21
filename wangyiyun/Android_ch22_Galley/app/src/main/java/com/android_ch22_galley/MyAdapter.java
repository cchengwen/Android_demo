package com.android_ch22_galley;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int[] imageIds;

    public MyAdapter(Context context, int[] imageIds){
        this.context= context;
        this.imageIds = imageIds;
    }

    @Override
    public int getCount() {
        //  返回图片资源的长度
        return imageIds.length;
    }

    @Override
    public Object getItem(int position) {
        //  返回元素指定的值
        return imageIds[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource((Integer) getItem(position));
        imageView.setPadding(10,10,10,10);
        //  设置Gallery在xml文件中的大小
        imageView.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return imageView;
    }
}
