package com.tencent.tv.qie.util.event;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ExternalLiveData;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;

import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 3.0版本,事件格式通用,可以用一个EventObserver来监听各个业务的事件,不用分开监听了
 * Created by ZhuJun on 2019/4/18.
 */
public class EasyEventBus {
    public static Handler handler = new Handler(Looper.getMainLooper());

    public static void post(String eventName, Object bean) {
        LiveEventBus.get(eventName).post(bean);
    }

    /**
     * 发送闭包,但是谨慎使用,不可以传入匿名内部类imp,会引起内存泄露
     *
     * @param eventName
     * @param imp
     */
    public static void postImp(String eventName, EventImplement imp) {
        LiveEventBus.get(eventName).post(imp);
    }

    /**
     * 此事件仅被本activity内的observer监听,其他监听同样事件的不会收到
     *
     * @param activity
     * @param eventName
     * @param bean
     */
    public static void postActivity(Activity activity, String eventName, Object bean) {
        if (activity != null && !activity.isFinishing()) {
            LiveEventBus.get(eventName).post(new ActivityEvent(activity, bean));
        }
    }

    public static void postSpecify(Object specify, String eventName, Object bean) {
        LiveEventBus.get(eventName).post(new SpecifyEvent(specify, bean));
    }

    /**
     * 延迟发送
     *
     * @param owner     为null则不关联生命周期,要注意内存泄露.绑定则destory时自动取消
     * @param eventName
     * @param bean
     * @param delay
     */
    public static void postDelay(LifecycleOwner owner, String eventName, Object bean, long delay) {
        LiveEventBus.get(eventName).postDelay(bean,delay);
    }

    /**
     * 间隔循环调用
     *
     * @param owner    为null则不关联生命周期,要注意内存泄露.绑定则destory时自动取消
     * @param runnable
     * @param delay    多久循环一次
     */
    public static void postCircle(LifecycleOwner owner, Runnable runnable, long delay) {
        Runnable cr = new Runnable() {
            @Override
            public void run() {
                runnable.run();
                delayRun(owner, this, delay);
            }
        };
        delayRun(owner, cr, 0);
    }

    /**
     * 延迟执行,绑定生命周期,省却自己remove的麻烦
     *
     * @param owner    如果为null,则表示不绑定生命周期
     * @param runnable
     * @param delay
     */
    public static void delayRun(LifecycleOwner owner, Runnable runnable, long delay) {
        EventRunnable eventRunnable = new EventRunnable() {
            @Override
            public void run() {
                if (owner != null) {
                    owner.getLifecycle().removeObserver(observer);
                    observer = null;
                    //如果已经销毁,但是Runnable正在进行中,则停止执行,防止Runnable是轮询结构导致结束不了
                    if (Lifecycle.Event.ON_DESTROY.equals(owner.getLifecycle().getCurrentState())) {
                        return;
                    }
                }
                if (runnable != null) {
                    runnable.run();
                }
                //如果已经销毁,但是Runnable正在进行中,则停止执行,防止Runnable是轮询结构导致结束不了
                if (owner != null && Lifecycle.Event.ON_DESTROY.equals(owner.getLifecycle().getCurrentState())) {
                    handler.removeCallbacks(this);
                }
            }
        };
        handler.postDelayed(eventRunnable, delay);
        if (owner != null) {
            LifecycleObserver observer = new LifecycleObserver() {
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public void onDestory() {
                    handler.removeCallbacks(eventRunnable);
                    eventRunnable.observer = null;
                    if (owner != null) {
                        owner.getLifecycle().removeObserver(this);
                    }
                }
            };
            eventRunnable.observer = observer;
            owner.getLifecycle().addObserver(observer);
        }
    }

    /**
     * 注解方式Observe多个事件
     *
     * @param owner
     * @param observe 参数为obj数组可变参数的,使用EventObserver的getAt方法取obj参数
     */
    public static void observe(LifecycleOwner owner, EventObserver observe) {
        try {
            Method method = observe.getClass().getDeclaredMethod("onReceive", String.class, Object.class);
            EventObserve anno = method.getAnnotation(EventObserve.class);
            if (anno != null) {
                String[] value = anno.value();
                for (String eventName : value) {
                    observe(owner, eventName, observe);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void observeImp(LifecycleOwner owner, String eventName, SimpleEventView thisIns) {
        EasyEventBus.observe(owner, eventName, new Observer<EventImplement>() {
            @Override
            public void onChanged(@Nullable EventImplement imp) {
                imp.implement(thisIns);
            }
        });
    }

    public static void observeImpSticky(LifecycleOwner owner, String eventName, SimpleEventView thisIns) {
        EasyEventBus.observeSticky(owner, eventName, new Observer<EventImplement>() {
            @Override
            public void onChanged(@Nullable EventImplement imp) {
                imp.implement(thisIns);
            }
        });
    }

    /**
     * 注解方式Observe多个事件
     * 如果当前有值,会立马收到此值的回调
     *
     * @param owner
     * @param observe
     */
    public static void observeSticky(LifecycleOwner owner, EventObserver observe) {
        try {
            Method method = observe.getClass().getDeclaredMethod("onReceive", String.class, Object.class);
            EventObserve anno = method.getAnnotation(EventObserve.class);
            if (anno != null) {
                String[] value = anno.value();
                for (String eventName : value) {
                    observeSticky(owner, eventName, observe);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * observe单个事件
     *
     * @param owner
     * @param eventName
     * @param observe
     */
    public static void observe(LifecycleOwner owner, String eventName, Observer<?> observe) {
        LiveEventBus.get(eventName).observe(owner, proxyObserver(owner, eventName, observe));
    }

    /**
     * observe单个事件
     * 如果当前有值,会立马收到此值的回调
     *
     * @param owner
     * @param eventName
     * @param observe
     */
    public static void observeSticky(LifecycleOwner owner, String eventName, Observer observe) {
        LiveEventBus.get(eventName).observeSticky(owner, proxyObserver(owner, eventName, observe));
    }

    /**
     * 永久监听,需要自行调用removeObserver
     *
     * @param eventName
     * @param observe
     */
    public static void observeForever(String eventName, Observer observe) {
        LiveEventBus.get(eventName).observeForever(proxyObserver(null, eventName, observe));
    }

    /**
     * 永久监听,需要自行调用removeObserver
     * 如果当前有值,会立马收到此值的回调
     *
     * @param eventName
     * @param observe
     */
    public static void observeStickyForever(String eventName, Observer observe) {
        LiveEventBus.get(eventName).observeStickyForever(proxyObserver(null, eventName, observe));
    }

    /**
     * observeForever之后自行调用移出监听
     *
     * @param eventName
     * @param observe
     */
    public static void removeObserver(String eventName, Observer observe) {
        LiveEventBus.get(eventName).removeObserver(observe);
    }

    private static Observer proxyObserver(LifecycleOwner owner, String eventName, Observer observe) {
        return new Observer<Object>() {
            @Override
            public void onChanged(@Nullable Object o) {
                //observe中如果crash,则之后的消息都会阻断,因为正在分发的状态没有重置,life框架以为分发没结束
                try {
                    if (owner != null) {
                        //ZhuJun 初步解决解决activity销毁不及时的情况下,待销毁的activity依然能收到当前activity发出的事件,从而影响业务逻辑和性能,所以在事件分发器QieBaseEventBus底层做isFinishing判断,在activity进入finish之后,他和他的组件不再接收事件 2020/5/20 15:34
                        Activity act = getAct(owner);
                        if (act == null) {
                            return;
                        }
                        if (act != null && act.isFinishing()) {
                            LiveEventBus.get(eventName).removeObserver(this);
                            return;
                        }
                        //此事件仅被本activity内的observer监听,其他监听同样事件的不会收到
                        if (o != null && o instanceof ActivityEvent) {
                            if (!TextUtils.equals(((ActivityEvent) o).activity, act.toString())) {
                                return;
                            } else {
                                o = ((ActivityEvent) o).obj;
                            }
                        }
                    }
                    if (observe instanceof EventObserver) {
                        ((EventObserver) observe).onReceive(eventName, o);
                    } else {
                        observe.onChanged(o);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

//    private static Observer proxyObserver(LifecycleOwner owner, String eventName, Observer observe) {
//        return new Observer<Object>() {
//            @Override
//            public void onChanged(@Nullable Object o) {
//                //observe中如果crash,则之后的消息都会阻断,因为正在分发的状态没有重置,life框架以为分发没结束
//                try {
//                    if (owner != null) {
//                        // 初步解决解决activity销毁不及时的情况下,待销毁的activity依然能收到当前activity发出的事件,从而影响业务逻辑和性能,所以在事件分发器BaseEventBus底层做isFinishing判断,在activity进入finish之后,他和他的组件不再接收事件 2020/5/20 15:34
//                        Activity act = getAct(owner);
//                        if (act == null) {
//                            return;
//                        }
//                        if (act != null && act.isFinishing()) {
//                            LiveEventBus.get(eventName).removeObserver(this);
//                            return;
//                        }
//                        //此事件仅被本activity内的observer监听,其他监听同样事件的不会收到
//                        if (o != null && o instanceof SpecifyEvent) {
//                            if (!TextUtils.equals(((SpecifyEvent) o).specify, owner.getClass().getName() + "@" + owner.hashCode())) {
//                                return;
//                            } else {
//                                o = ((SpecifyEvent) o).obj;
//                            }
//                        }
//                    }
//                    if (observe instanceof EventObserver) {
//                        ((EventObserver) observe).onReceive(eventName, o);
//                    } else {
//                        observe.onChanged(o);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//    }

    private static Activity getAct(LifecycleOwner owner) {
        if (owner instanceof Activity) {
            return (Activity) owner;
        }
        if (owner instanceof Fragment && ((Fragment) owner).getActivity() != null) {
            return ((Fragment) owner).getActivity();
        }
        return null;
    }

    /**
     * 获取当前事件的当前值,用户只需要一次性获取值,不需要长时间observe的情况
     *
     * @param eventName
     * @return
     */
    public static Object getData(String eventName) {
        Observable event = (Observable) LiveEventBus.get(eventName);
        try {
            Field field = event.getClass().getDeclaredField("liveData");
            field.setAccessible(true);
            ExternalLiveData data = (ExternalLiveData) field.get(event);
            Object value = data.getValue();
            if (value != null && value instanceof ActivityEvent) {
                return ((ActivityEvent) value).obj;
            } else {
                return value;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected static abstract class EventRunnable implements Runnable {
        LifecycleObserver observer = null;
    }

}


