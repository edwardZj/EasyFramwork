package com.zj.baseui.view;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 用于图片宽高比例比view宽高比例小的情况(同等宽度尺寸下,图片要更高),这种情况下,总是把图片缩放到相同宽度然后下端对齐,顶部裁剪
 * 其他情况同CENTER_CROP
 * 一般用于显示全屏图片(splash,广告等)
 */
public class BottomCropImageView extends androidx.appcompat.widget.AppCompatImageView {
    public BottomCropImageView(@NonNull Context context) {
        super(context);
        init();
    }

    public BottomCropImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BottomCropImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setScaleType(ScaleType.CENTER_CROP);
    }

    @Override
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setImgBottom();
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }

    public void setImgBottom(){
        if (getImageMatrix() != null) {
            final int dwidth = getDrawable().getIntrinsicWidth();
            final int dheight = getDrawable().getIntrinsicHeight();

            final int vwidth = getWidth() - getPaddingLeft() - getPaddingRight();
            final int vheight = getHeight() - getTop() - getPaddingBottom();
            if (dwidth * vheight > vwidth * dheight) {
            } else {
                //图片缩放到和view等宽后,图片比view要高
                float scale = (float) vwidth / (float) dwidth;
                float dy = (vheight - dheight * scale);
                getImageMatrix().postTranslate(0, Math.round(dy));
            }
            invalidate();
        }
    }

}
