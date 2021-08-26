package com.tencent.tv.qie.util.event;

import android.app.Activity;

/**
 * Created by ZhuJun on 2020/7/2.
 * 这个event对应于本activity内的事件而生
 * 即此事件仅被本activity内的observer监听,其他监听同样事件的不会收到
 */

class ActivityEvent {
    String activity;
    Object obj;

    public ActivityEvent() {
    }

    public ActivityEvent(Activity activity, Object obj) {
        this.activity = activity.toString();
        this.obj = obj;
    }

}
