package tv.douyu.view.view.player;

import android.content.Context;
import android.content.res.Configuration;

import androidx.lifecycle.LifecycleOwner;

import com.tencent.tv.qie.util.event.QieBaseEventBus;

/**
 * Created by ZhuJun on 2019/4/18.
 */
public class PlayerActivityControl extends QieBaseEventBus {
    public static final String PLAYER_CONTROL = "PLAYER_CONTROL_";

    public static final String BACK = PLAYER_CONTROL + "0";
    //关闭直播间
    public static final String CLOSE = PLAYER_CONTROL + "2";
    //这两个是命令横竖屏
    public static final String DO_PORTRAIT = PLAYER_CONTROL + "3";
    public static final String DO_LANDSCAPE = PLAYER_CONTROL + "4";
    //data  PORTRAIT = 0,LANDSCAPE = 1 这个是横竖屏状态提示,比如如果是传感器导致的横竖屏,就不会有DO_LANDSCAPE,但是会有ScreenOrientation
    //虽然可以直接用isLandscape方法判断,但是在刚刚切换的瞬间,isLandscape判断会还是之前的值,所以尽量使用传的data判断
    public static final String
            ScreenOrientation = PLAYER_CONTROL + "5";
    //data[0] 为roomid(null或者不传表示冲不行加载当前房间),data[1]为roomType,data[2]为cateType,data[3]为跳转来源,data[4]为跳转来源位置 如果data传空,则重新加载当前房间,cateType可不传,roomType如不传,则加载当前直播间类型
    public static final String CHANGE_ROOM = PLAYER_CONTROL + "6";
    //隐藏所有输入框
    public static final String HIDE_ALL_KEYBOARD = PLAYER_CONTROL + "7";

    public static final String VIDEO_PLAY = PLAYER_CONTROL + "8";
    public static final String VIDEO_PAUSE = PLAYER_CONTROL + "9";
    //IVideoPlayer.STATE_NORMAL
    //int STATE_NORMAL = 0;//未播放
    //int STATE_PREPARING = 1;//初始化中
    //int STATE_PLAYING = 2;//播放中
    //int STATE_PAUSE = 4;//暂停中
    //int STATE_AUTO_COMPLETE = 5;//播放完成
    //int STATE_ERROR = 6;//播放出错
    public static final String VIDEO_STATUS = PLAYER_CONTROL + "10";
    //彻底销毁,因为activity的ondestory调用时机不及时,所以大的资源主动销毁
    public static final String PLAYER_DESTORY = PLAYER_CONTROL + "11";
    //public static final String RELEASE_ALL = PLAYER_CONTROL+"12";
    //刷新,切换清晰度,data[0]软硬解切换 false软解
    public static final String RELOAD_RTMP = PLAYER_CONTROL + "13";
    public static final String VIDEO_SWITCH_PLAY_PAUSE = PLAYER_CONTROL + "14";
    //data[0] true 为显示,false为隐藏,data[1] 为loading的文字
    public static final String SHOW_LOADING = PLAYER_CONTROL + "15";
    public static final String SHOW_ERROR = PLAYER_CONTROL + "16";
    //主播关播
    public static final String LIVE_CLOSE = PLAYER_CONTROL + "17";
    //关闭播放器
    public static final String VIDEO_CLOSE = PLAYER_CONTROL + "18";
    //设置播放器画面比例
    public static final String VIDEO_RATIO = PLAYER_CONTROL + "19";
    //设置缓冲的loading  data[0] true 为显示,false为隐藏,data[1] 为speed  long
    public static final String SHOW_BUFFERING = PLAYER_CONTROL + "20";
    //直播间tab栏索引
    public static final String PLAYER_TAB_INDEX = PLAYER_CONTROL + "21";
    //屏幕方向随传感器变化开关data[0] true 为enable
    public static final String ORIENTATION_SENSOR_ENABLE = PLAYER_CONTROL + "22";
    //切换横屏控件的显示隐藏
    public static final String PLAYER_LAND_WIDGET_SHOW = PLAYER_CONTROL + "23";
    //键盘显示隐藏事件,0隐藏,1显示
    public static final String PLAYER_KEYBOARD_SHOW = PLAYER_CONTROL + "24";
    //分发RTMP数据
    public static final String PLAYER_RTMP = PLAYER_CONTROL + "25";
    //播放器进度,用于点播,data[0]  progress  double(0-1)
    public static final String PLAYER_PROGRESS = PLAYER_CONTROL + "26";
    //通知播放器播放url
    public static final String PLAYER_URL = PLAYER_CONTROL + "27";
    //播放完成
    public static final String PLAY_COMPLETE = PLAYER_CONTROL + "28";
    //分发房间roombean,为免去判断的繁琐,值一律不为空
    public static final String PLAYER_ROOMBEAN = PLAYER_CONTROL + "29";
    //控制领鹅蛋是否显示
    public static final String PLAYER_EGG_SHOW = PLAYER_CONTROL + "30";
    //用于直播间横竖屏邮轮宝箱状态同步
    public static final String PLAYER_CHEST_SYNC = PLAYER_CONTROL + "31";
    /**
     * 趣猜入口点击
     */
    public static final String GUESS_ENTRANCE_ONCLICK = PLAYER_CONTROL + "32";
    /**
     * 房间有趣猜投注
     */
    public static final String GUESS_BET_BEGIN = PLAYER_CONTROL + "33";
    /**
     * 打开送礼列表
     */
    public static final String PLAYER_GIFT_LIST_SHOW = PLAYER_CONTROL + "34";
    //分发房间room/me接口个人数据
    public static final String PLAYER_ROOM_ME = PLAYER_CONTROL + "35";
    //分发房间抽奖数据
    public static final String PLAYER_LOTTERY_BEAN = PLAYER_CONTROL + "36";
    //抽奖dialog消失控制  1抽奖参与弹窗2抽奖底部弹窗3抽奖底部弹窗隐藏导航栏
    public static final String PLAYER_LOTTERY_DISMISS = PLAYER_CONTROL + "37";

    /**
     * 显示或者隐藏底部竞猜,广告,超级弹幕弹窗
     * widget发出
     * 第一个参数true显示false隐藏
     * 第二个参数传显示或者隐藏的view的数据
     */
    public static final String PLAYER_BOTTOM_WIDGET_SHOW = PLAYER_CONTROL + "38";
    //刷新room/me接口
    public static final String REFRESH_ROOM_ME = PLAYER_CONTROL + "39";

    public static final String ROOMINFO_WIDGET_HEIGHT = PLAYER_CONTROL + "40";

    //-----------语音房start-----------//
    public static final String VOICEROOM_BACK_TO_FORGREN = PLAYER_CONTROL + "41";
    public static final String VOICEROOM_FORGREN_TO_BACK = PLAYER_CONTROL + "42";
    public static final String VOICEROOM_DISABLE_BACKGROUND_PLAY = PLAYER_CONTROL + "43";
    public static final String VOICEROOM_ENTER_BACKGROUND_PLAY = PLAYER_CONTROL + "44";
    public static final String VOICEROOM_REQUEST_PERMISSION = PLAYER_CONTROL + "45";
    public static final String VOICEROOM_CHANGE_SMALL_WINDOW = PLAYER_CONTROL + "46";
    //-----------语音房end-------------//

    public static void post(String eventName, Object... obj) {
        QieBaseEventBus.post(eventName, obj);
    }

    public static void postDelay(LifecycleOwner owner, String eventName, long delay, Object... obj) {
        QieBaseEventBus.postDelay(owner, eventName, obj, delay);
    }

    public static boolean isLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

}


