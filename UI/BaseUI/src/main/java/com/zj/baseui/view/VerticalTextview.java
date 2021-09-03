package com.zj.baseui.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

/**
 * User: xiehehe
 * 上下轮播的textview
 * Date: 2016-07-19
 * Time: 22:45
 */
public class VerticalTextview extends TextSwitcher implements ViewSwitcher.ViewFactory {

    private static final int FLAG_START_AUTO_SCROLL = 0;
    private static final int FLAG_STOP_AUTO_SCROLL = 1;

    private static final int STATE_PAUSE = 2;
    private static final int STATE_SCROLL = 3;

    private float mTextSize = 16;
    private int mPadding = 5;
    private int textColor = Color.BLACK;
    //1f表示每行文字高度占满0.5f表示一行文字还没消失时就能看到下一行
    public static float showMode = 1f;

    private int mScrollState = STATE_PAUSE;
    private long delayTime = 0;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case FLAG_START_AUTO_SCROLL:
                    if (textList.size() == 1) {
                        setCurrentText(textList.get(0));
                    } else {
                        if (textList.size() > 0) {
                            currentId++;
                            setText(textList.get(currentId % textList.size()));
                            handler.sendEmptyMessageDelayed(FLAG_START_AUTO_SCROLL, delayTime);
                        }
                    }
                    break;
                case FLAG_STOP_AUTO_SCROLL:
                    handler.removeMessages(FLAG_START_AUTO_SCROLL);
                    break;
            }
        }
    };
    private AnimationSet inSet;
    private AnimationSet outSet;
    private OnItemClickListener itemClickListener;
    private Context mContext;
    private int currentId = 0;
    private ArrayList<String> textList;
    private long animDuration = 400;
    private boolean isInited = false;

    public VerticalTextview(Context context) {
        this(context, null);
    }

    public VerticalTextview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        textList = new ArrayList<String>();

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });

        Animation in = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, showMode, Animation.RELATIVE_TO_SELF, 0);
        in.setInterpolator(new AccelerateDecelerateInterpolator());
        inSet = new AnimationSet(true);
        inSet.addAnimation(in);
        inSet.addAnimation(new AlphaAnimation(0, 1));
        inSet.setDuration(animDuration);

        Animation out = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -showMode);
        out.setInterpolator(new AccelerateDecelerateInterpolator());
        outSet = new AnimationSet(true);
        outSet.addAnimation(out);
        outSet.addAnimation(new AlphaAnimation(1, 0));
        outSet.setDuration(animDuration);

        setInAnimation(inSet);
        setOutAnimation(outSet);
    }

    /**
     * 初始化方法,必须调用
     *
     * @param textSize  textsize
     * @param padding   padding
     * @param textColor textcolor
     */
    public void setText(float textSize, int padding, int textColor) {
        mTextSize = textSize;
        mPadding = padding;
        this.textColor = textColor;

        if (isInited) {
            setTextView((TextView) getCurrentView());
            setTextView((TextView) getNextView());
        } else {
            removeAllViews();
            setFactory(this);
            isInited = true;
        }
    }

    private void setTextView(TextView tv) {
        tv.setPadding(mPadding, mPadding, mPadding, mPadding);
        tv.setTextColor(textColor);
        tv.setTextSize(mTextSize);
    }

    public void setAnimTime(long animDuration) {
        this.animDuration = animDuration;
        inSet.setDuration(animDuration);
        outSet.setDuration(animDuration);
    }

    /**
     * set time.
     *
     * @param time
     */
    public void setTextStillTime(final long time) {
        delayTime = time;
    }

    /**
     * set Data list.
     *
     * @param titles
     */
    public void setTextList(ArrayList<String> titles) {
        textList.clear();
        textList.addAll(titles);
    }

    /**
     * start auto scroll
     */
    public void startAutoScroll() {
        startAutoScroll(currentId);
    }

    /**
     * start auto scroll
     */
    public void startAutoScroll(int index) {
        currentId = index;
        mScrollState = STATE_SCROLL;
        handler.removeCallbacksAndMessages(null);
        if (getCurrentView() != null) {
            String txt = textList.get(currentId % textList.size());
            if (!TextUtils.equals(txt, ((TextView) getCurrentView()).getText())) {
//                getNextView().clearAnimation();
                getCurrentView().clearAnimation();
                setCurrentText(txt);
            }
        }
        if (textList.size() > 1) {
            handler.sendEmptyMessageDelayed(FLAG_START_AUTO_SCROLL, delayTime);
        }
    }

    /**
     * stop auto scroll
     */
    public void stopAutoScroll() {
        mScrollState = STATE_PAUSE;
        handler.sendEmptyMessage(FLAG_STOP_AUTO_SCROLL);
    }

    @Override
    public View makeView() {
        TextView t = new TextView(mContext);
        t.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        t.setMaxLines(1);
        setTextView(t);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        t.setLayoutParams(lp);
        return t;
    }

    /**
     * set onclick listener
     *
     * @param itemClickListener listener
     */
    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        if (itemClickListener!=null){
            getCurrentView().setClickable(true);
            getCurrentView().setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null && textList.size() > 0) {
                        itemClickListener.onItemClick(currentId % textList.size());
                    }
                }
            });

            getNextView().setClickable(true);
            getNextView().setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null && textList.size() > 0) {
                        itemClickListener.onItemClick(currentId % textList.size());
                    }
                }
            });
        }
    }

    /**
     * item click listener
     */
    public interface OnItemClickListener {
        /**
         * callback
         *
         * @param position position
         */
        void onItemClick(int position);
    }

    public boolean isScroll() {
        return mScrollState == STATE_SCROLL;
    }

    public boolean isPause() {
        return mScrollState == STATE_PAUSE;
    }

    //memory leancks.
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (handler != null && mScrollState == STATE_SCROLL) {
            startAutoScroll();
        }
    }

}
