package com.zj.demo;

import android.content.Context;

import com.zj.image.Image;
import com.zj.utils.app.AppUtils;

public class Demo1 {

    public void test1(Context iv){
        Image.with(iv);


        AppUtils.INSTANCE.isDebug();
        AppUtils.isDebug();

    }



}
