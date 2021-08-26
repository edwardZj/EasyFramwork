package tv.douyu.base.event
const val EVENT_BOTTOM_BAR_REFRESH = "event_bottom_bar_refresh"
const val EVENT_REFRESH_HOME_PAGE_DATA = "event_refresh_home_page_data"
const val EVENT_UPDATE_HOME_PAGE_TAG = "event_update_home_page_tag"
const val EVENT_START_SHANK_ANIM = "event_start_shank_anim"
const val EVENT_AD = "event_ad"
const val EVENT_USER_LOGIN_CHANGE = "event_user_login_change"//用户登录状态变更事件
const val EVENT_CHANGE_VIDEO = "event_change_video"
const val EVENT_REFRESH_USER = "event_refresh_user"
const val EVENT_UPDATE_USER_INFO = "event_update_user_info"
const val EVENT_UPDATE_EGAN_INFO = "event_update_egan_info"
const val EVENT_USER_LOGIN = "event_user_login"//用户之前没有登录,第一次登录发出此事件
const val EVENT_CLOSE_LOGIN = "event_close_login"  //旧版登录成功以
// 后关闭登陆界面
const val EVENT_H5_LOGIN_REFRESH = "event_h5_login_refresh" //登录与h5交互
const val EVENT_RECALL_USER = "event_recall_user" //好友召回
const val EVENT_LOGIN_SUCCESS_MSG = "event_login_success_msg"
const val EVENT_LOGIN_SUCCESS_BIND_PHONE = "event_login_success_bind_phone" //用户登录成功回到原有页面弹出绑定手机对话框
const val EVENT_REFRESH_MSG = "event_refresh_msg"
const val EVENT_CLOSE_SCORE = "event_close_score"
const val EVENT_PK_STATUS_CHANGE = "event_pk_status_change" //线上赛事pk状态更改event
const val EVENT_DEMAND_PAY = "EVENT_DEMAND_PAY" //收到礼物消息
const val EVENT_RED_PACKET_ENTRANCE = "EVENT_RED_PACKET_ENTRANCE" //红包雨通知跳转入口

const val EVENT_THEME_CHANGE = "EVENT_THEME_CHANGE" //切换皮肤
//1关闭
const val EVENT_FLOAT_VIDEO_VIEW = "EVENT_FLOAT_VIDEO_VIEW" //小窗控制
//普通直播间半屏播放器control显示(隐藏)
const val EVENT_VIDEO_PLAYER_CONTROL_SHOW_OR_HIDE = "event_video_player_control_show_or_hide"
//普通直播间全屏播放器control显示(隐藏)
const val EVENT_VIDEO_PLAYER_CONTROL_SHOW_OR_HIDE_FULLSCREEN = "EVENT_VIDEO_PLAYER_CONTROL_SHOW_OR_HIDE_FULLSCREEN"
//刷新关注状态
const val EVENT_REFRESH_FOLLOW_STATE = "event_refresh_follow_state"
//直播间H5抽奖 onActivityResult 回调
const val EVENT_H5_PRIZE_ON_RESULT = "event_h5_prize_on_result"
//显示礼物键盘活动图
const val EVENT_GIFT_KEYBOARD_SHOW_ACTIVE_PIC = "event_gift_keyboard_show_active_pic"
//隐藏礼物键盘活动图
const val EVENT_GIFT_KEYBOARD_HIDE_ACTIVE_PIC = "event_gift_keyboard_hide_active_pic"
//关闭直播
const val EVENT_CLOSE_RECORDER = "event_close_event"
// PK等待接受弹窗收起
const val EVENT_WAITTING_PK_VIEW= "event_waitting_pk_view"
// 开始推流
const val EVENT_STRART_PUISH_STREAM= "event_start_push_stream"
// 旋转直播间屏幕方向
const val EVENT_CHANGE_PLAYER_SCREEN_ORIENTATION = "event_change_player_screen_orientation"
// 直播间控件显示隐藏通知
const val EVENT_PLAYER_WIDGET_SHOW = "event_player_widget_show"
// 竖屏模式显示礼物键盘
const val EVENT_SHOW_GIFT_WIDGET = "event_show_gift_widget"
// 横屏模式下显示礼物键盘
const val EVENT_SHOW_GIFT_WIDGET_LANDSCAPE = "event_show_gift_widget_landscape"
// 主播PK连麦状态改变
const val EVENT_ANCHOR_PK_STATUS_CHANGE = "event_anchor_pk_status_change"
// 跳转首页女神模块
const val EVENT_JUMP_TO_GODDESS = "event_jump_to_goddess"
// 弹幕区域系统广播
const val EVENT_DANMU_CONTENT= "event_danmu_content"

// 登录上传极光Tag
const val LOGIN_JPUSH_EVENT = "login_jpush_event"

//直播间贡献榜更新数据
const val UPDATE_RANK_LIST = "update_rank_list"

//更新贵宾列表
const val UPDATE_NOBLE_LIST = "update_noble_list"

//token失效
const val TOKEN_USELESS= "token_useless"

//退出登录
const val EVENT_LOGOUT = "event_logout"

//更新头像
const val EVENT_UPDATE_AVATAR = "event_update_avatar"


//华为支付成功event
const val EVENT_HMS_PAY_SUCCESS = "event_hms_pay_success"

//支付成功event
const val EVENT_PAY_SUCCESS = "event_pay_success"

//截屏分享
const val EVENT_SHARE_SCREENSHOTS = "event_share_screenshots"

//摄像头或录屏直播
const val EVENT_VIDEO_SOURCE_CAMERA_OR_SCREEN = "event_video_source_camera_or_screen"

const val EVENT_CHANGE_BETTING_TAB = "event_change_betting_tab"

const val EVENT_UPDATE_USER_DATA = "event_update_user_data"
//更改indicator背景色
const val CHANGE_INDICATOR_BACKGROUND_EVENT = "change_indicator_background_event"
//更改二级indicator item背景色
const val CHANGE_INDICATOR_ITEM_BG_EVENT = "change_indicator_item_bg_event"
/**
 * 切换MainActivity tab
 */
const val EVENT_CHANGE_MAIN_TAB = "event_change_main_tab"

const val EVENT_CHANGE_LEGUESS_CARD = "event_change_leguess_card"

/**
 * 搜索点播页面跳转时,关闭搜索页面
 */
const val EVENT_SEARCH_VIDEO_JUMP_CLOSE = "event_search_video_jump_close"

/**
 * 搜索房间
 */
const val EVENT_SEARCH_SEARCH_ROOM = "event_search_search_room"

/**
 * 切换搜索tab栏
 */
const val EVENT_SEARCH_CHANGE_TAB = "event_search_change_tab"

//playeractivity中
object PlayerEvent{

    //红包雨页面初始化
    const val RED_PACKET_VIEW_INIT="RED_PACKET_VIEW_INIT"
    //评分数据bean
    const val PING_FEN_BEAN= "PING_FEN_BEAN"
    //控制评分icon的显示隐藏  0隐藏 1评分进行中 2评分汇总中 3结果公布啦
    const val PING_FEN_ICON= "PING_FEN_ICON"
    //评分页面 0:隐藏 1:显示
    const val PING_FEN_WIDGET= "PING_FEN_WIDGET"
    /**
     * 趣猜记录或规则对话框消失
     */
    const val GUESS_RECORD_RULE_DIALOG_DISMISS= "GUESS_RECORD_RULE_DIALOG_DISMISS"
    /**
     * 趣猜记录,规则,投注对话框消失
     */
    const val GUESS_RECORD_RULE_BET_DIALOG_DISMISS= "GUESS_RECORD_RULE_BET_DIALOG_DISMISS"
    /**
     * 王者猜猜投注成功
     */
    const val KING_GUESS_BET_SUCCESS= "KING_GUESS_BET_SUCCESS"
    const val AUTO_SHOW_PINGFEN = false
    const val PLAYER_ROOM_ID= "PLAYER_ROOM_ID"
    const val PLAYER_LAND_WIDGET_SHOW= "PLAYER_LAND_WIDGET_SHOW"

    //弹幕的控制事件
    const val DANMU_CONTROL= "DANMU_CONTROL"
    //传递对阵信息
    const val EVENT_BATTLE_INFO = "event_battle_info"
    const val DANMU_LANDSCAPE_POST = "DANMU_LANDSCAPE_POST"
    const val RTMP_END="player_rtmp_end"
    //更新礼物键盘的礼物
    const val UPDATE_GIFT = "update_gift"
    //刷新粉丝卡状态
    const val UPDATE_FAN_CARD = "UPDATE_FAN_CARD"
    //弹出彩经弹窗
    const val SHOW_LEGUESS_SCHEME_DIALOG = "show_leguess_scheme_dialog"
    const val SHOW_LOCAL_ADVANCE_GIFT_ANIMATION = "show_local_advance_gift_animation"
    const val CLOSE_RED_PACKET_COUNT_DOWN = "close_red_packet_count_down"
}

object NbPk {
    //pk模式（个人赛or pk赛）
    const val EVENT_RECORD_TYPE = "event_record_type"
    //socket 更新pk状态
    const val EVENT_SOCKET_UPDATE_PK_STATUS = "event_socket_update_pk_status"
    //选手入场，准备，完成状态更新 需要传 NbpkPlayerStatusBean
    const val EVENT_SHOW_PLAYER_PLAY_STATUS = "event_show_player_play_status"
    //特殊处理 处理虚伪以待,推流sdk召集人   需要传 NbpkPlayerNotJoinControlBean
    const val EVENT_JOIN_STATUS_PUSHSDK_CALL = "event_join_status_pushsdk_call"
    //特殊处理 处理虚伪以待,推流sdk主持人   需要传 NbpkPlayerNotJoinControlBean
    const val EVENT_JOIN_STATUS_PUSHSDK_HOST = "event_join_status_pushsdk_host"
    //弹出pk过程中的提示对话框，发送该event需要传一个String字符串
    const val EVENT_PK_TIP_DIALOG_SHOW = "event_pk_tip_dialog_show"

    //左边选手比赛状态更新
    const val EVENT_UPDATE_LEFT_PLAYER_STATUS = "event_update_left_player_status"
    //右边选手比赛状态更新
    const val EVENT_UPDATE_RIGHT_PLAYER_STATUS = "event_update_right_player_status"
    //左侧地址信息更新
    const val EVENT_UPDATE_LEFT_ADDRESS_INFO = "event_update_left_address_info"
    //右侧地址信息更新
    const val EVENT_UPDATE_RIGHT_ADDRESS_INFO = "event_update_right_address_info"
    //更新顶部比赛状态
    const val EVENT_UPDATE_TOP_PK_STATUS = "event_update_top_pk_status"


    //更新TopWidget event
    const val EVENT_PK_HOST_DOUYU_INIT = "event_pk_host_douyu_init"

    //更新TopWidget event
    const val EVENT_PK_DETAIL = "event_pk_detail"
    //更新主持人view
    const val EVENT_UPDATE_HOST_VIEW = "event_update_host_view"
    //展示或者隐藏选手检录tip
    const val EVENT_PLAYER_CHECK_IN_SHOW = "event_player_check_in_show"

    //截屏-准备
    const val EVENT_SCORE_SCREENSHOT_READY= "event_score_screenshot_ready"
    //截屏-开始
    const val EVENT_SCORE_SCREENSHOT_START= "event_score_screenshot_start"
    //截屏-结束
    const val EVENT_SCORE_SCREENSHOT_END= "event_score_screenshot_end"
    //截屏-取消
    const val EVENT_SCORE_SCREENSHOT_CANCEL= "event_score_screenshot_cancel"
    //截屏-重新截屏
    const val EVENT_SCORE_SCREENSHOT_RESTART= "event_score_screenshot_restart"

    //主持比赛
    const val EVENT_HOST_MATCH_UPDATE_VIEW = "event_host_match_update_view"
    const val EVENT_HOST_MATCH = "event_host_match"

    //主持人view-点击事件处理:区分观众端和召集人、主持人端
    const val EVENT_HOST_VIEW_CLICK_VIEWER = "event_host_view_click_viewer"
    //观众端主持人view点击切换房间
    const val EVENT_HOST_VIEW_CHANGE_ROOM = "event_host_view_change_room"
    //观众端左边选手信息view点击切换房间
    const val EVENT_PLAYER_INFO_VIEW_CHANGE_ROOM_LEFT = "event_player_info_view_change_room_left"
    //观众端右边选手信息view点击切换房间
    const val EVENT_PLAYER_INFO_VIEW_CHANGE_ROOM_RIGHT = "event_player_info_view_change_room_right"
    //观众端当前房间是否为鹅赛场房间
    const val EVENT_NBPK_ROOM_TYPE = "event_nbpk_room_type"
    const val EVENT_NBPK_CHANGE_PUSH_STREAMING = "event_nbpk_change_push_streaming"

}

object PubPK {
    const val EVENT_PUB_WAITTING_PK_VIEW= "event_pub_waitting_pk_view"

}

object YTS {
    //青训页面首部背景色变换
    const val EVENT_YTS_RECO_BG_COLOR_CHANGE = "event_yts_reco_bg_color_change"
}

object Upload {
    //视频上传成功消息
    const val EVENT_UPLOAD_VIDEO_SUCCESS = "event_upload_video_success"
}

object DemandVideo{
    /**
     * 更新视频收藏
     */
    const val EVENT_UPDATA_COLLECT = "event_updata_collect"
}

/**
 * 手播端event
 */
object Recorder {
    //刷新开播信息
    const val EVENT_REFRESH_RECORDER_INFO = "event_refresh_recorder_info"
    //刷新收益记录-礼物-信息
    const val EVENT_REFRESH_GIFT_INCOME_INFO = "event_refresh_gift_income_info"

    /**
     * 更新发言限制等级
     */
    const val EVENT_UPDATA_LIMIT_LEVEL = "event_updata_limit_level"

    /**
     * 显示送礼键盘
     */
    const val EVENT_SHOW_VOICE_GIFT_WINDOW = "event_show_voice_gift_window"

    // 更新网速
    const val EVENT_UPDATE_SPEED= "event_update_speed"
}

/**
 * 粉丝牌event
 */
object FansGroup {
    //刷新主播端粉丝牌信息
    const val EVENT_REFRESH_ANCHOR_FANS_GROUP_INFO = "event_refresh_anchor_fans_group_info"
    //赠送粉丝牌礼物刷新信息
    const val EVENT_JOIN_FANS_GROUP_REFRESH = "event_join_fans_group_refresh"
}

object MagicBoxEvent {
    /**
     * 广告位切换魔盒位置
     */
    const val EVENT_AD_MAGIC_DISMISS = "event_ad_magic_dismiss"
    /**
     * 切换房间打开魔盒页面
     */
    const val EVENT_MAGIC_BOX_CHANGE_ROOM_OPEN = "event_magic_box_change_room_open"

    /**
     * 当前房间内点击横幅打开魔盒主页面
     */
    const val EVENT_MAGIC_BOX_OPEN = "event_magic_box_open"
    /**
     * 点击房间气泡
     */
    const val EVENT_MAGIC_BOX_HINT_CLICKED = "event_magic_box_open_hint_clicked"
    /**
     * 互动合集显示
     */
    const val EVENT_ACT_COLLECTION_SHOW = "event_act_collection_show"
    /**
     * 趣猜页面显示 隐藏互动合集红点
     */
    const val EVENT_GUESS_BET_SHOW = "event_guess_bet_show"
}


