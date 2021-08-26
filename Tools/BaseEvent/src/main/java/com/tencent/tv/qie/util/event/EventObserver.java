package com.tencent.tv.qie.util.event;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

/**
 * QieBaseEventBus的多事件Observer,通过注解的方式来选择监听事件,参见EventObserve
 * 用abstract class而不用interface是因为这样可以避免被提示改成lambda,从而导致丢失注解
 * implements Observer也让他的身份更明显
 * @author zhujun
 */
public abstract class EventObserver implements Observer {

    /**
     * 在这个方法上添加注解@EventObserve来监听事件
     * @param eventName
     * @param obj
     */
    public abstract void onReceive(String eventName, @Nullable Object obj);

    @Deprecated
    @Override
    public void onChanged(@Nullable Object o) {

    }

    /**
     * 用于方便的从object数组中取数据,处理意外情况和强转
     * 如果不是数组,返回自身
     *
     * @return
     */
    public static Object getAt(@Nullable Object obj, int index) {
        Object result = null;
        if (obj != null) {
            if (obj instanceof Object[]) {
                Object[] array = (Object[]) obj;
                if (array.length > index) {
                    result = array[index];
                }
            } else {
                result = obj;
            }
        }
        return result;
    }

}