package com.android_ch46_compass;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class MyAnimation extends Animation {

    //  动画必须定义初始化值
    private float startLocation = 0;
    private float endLocation = 0;
    private int width = 0;
    private int height = 0;

    //  初始化

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.width = width;
        this.height = height;
    }


    /**
     *
     * @param interpolatedTime 时间区间（0~1），是动画的时间区间
     * @param t
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);

        //  得到两个角度差值；
        float distanca = endLocation - startLocation;
        System.out.println("角度差值："+distanca);
        t.getMatrix().setRotate(startLocation + distanca * interpolatedTime, width / 2, height / 2);
    }


    public float getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(float startLocation) {
        this.startLocation = startLocation;
    }

    public float getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(float endLocation) {
        this.endLocation = endLocation;
    }
}
