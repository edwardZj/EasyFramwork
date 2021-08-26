package com.tencent.tv.qie.base;

import com.tencent.tv.qie.util.event.QieBaseEventBus;

/**
 * Created by ZhuJun on 2019/4/18.
 */
public class QieEvent extends QieBaseEventBus {
    private static final String QIE_EVENT = "QIE_EVENT_";
    //网络情况变化的监听,NetChangeBean
    public static final String NET_CHANGE = QIE_EVENT + "0";
    //动态轮询数据分发
    public static final String DYNAMIC_NOTICE = QIE_EVENT + "DYNAMIC_NOTICE";
    //跳转动态tab
    public static final String DYNAMIC_TAB = QIE_EVENT + "DYNAMIC_TAB";
    //发布动态成功通知
    public static final String DYNAMIC_PUBLISH_SUCCESS = QIE_EVENT + "DYNAMIC_PUBLISH_SUCCESS";
    //搜索框消息红点
    public static final String EVENT_HAVE_UNREAD_MESSAGES = "event_have_unread_message";

}


