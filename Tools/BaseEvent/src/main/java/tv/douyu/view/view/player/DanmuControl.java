package tv.douyu.view.view.player;

import com.tencent.tv.qie.util.event.QieBaseEventBus;

/**
 * Created by ZhuJun on 2019/4/18.
 */
public class DanmuControl extends QieBaseEventBus {
    public static final String DANMU_CONTROL = "DANMU_CONTROL";

    public static boolean isDanmakuShowed = true;//弹幕显示的标志位
    public static boolean isBroadShowed = true;//广播显示的标志位
    public static boolean isGiftShowed = true;//礼物特效的标志位
    public static int danmuColorType = 0; //彩色弹幕颜色标志
    //不选择超级弹幕
    public final static String SEND_WU = "0";

    public static final String DANMU_POSITION_CHANGE = DANMU_CONTROL + "0";
    public static final String DANMU_TRAN_CHANGE = DANMU_CONTROL + "1";
    //弹幕显示开关
    public static final String DANMU_SWITCH = DANMU_CONTROL + "3";
    public static final String DANMU_SIZE = DANMU_CONTROL + "4";
    public static final String BROADCAST_SWITCH = DANMU_CONTROL + "6";
    public static final String GIFT_SWITCH = DANMU_CONTROL + "7";
    //弹幕连接编码切换等需要提示的信息,横屏显示在屏幕左下角,第一个为横屏信息,第二个竖屏
    public static final String NOTICE_MSG = DANMU_CONTROL + "8";
    //删除指定弹幕
    public static final String DELETE_DANMU = DANMU_CONTROL + "9";
    //改变弹幕大小,手播大字幕使用
    public static final String CHANGE_DANMU_SIZE = DANMU_CONTROL + "10";
    //彩色弹幕切换
    public static final String COLOR_DANMU_SWITCH = DANMU_CONTROL + "11";
    //超级弹幕选择
    public static final String SUPER_DANMU_SWITCH = DANMU_CONTROL + "12";
    //超级弹幕卡信息
    public static final String SUPER_DANMU_BEAN = DANMU_CONTROL + "13";
    //清空弹幕输入框文字
    public static final String CLEAR_DANMU_EDIT = DANMU_CONTROL + "14";
    //贵族气泡切换,根彩色弹幕互斥
    public static final String NOBLE_DANMU_SWITCH = DANMU_CONTROL + "15";

    public static void post(String eventName, Object... obj) {
        QieBaseEventBus.post(eventName, obj);
    }


}


