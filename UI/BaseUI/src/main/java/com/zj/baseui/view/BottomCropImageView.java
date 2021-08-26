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
        setScaleType(ScaleType.MATRIX);
    }

    @Override
    public void setImageMatrix(Matrix matrix) {
        setImgBottom(matrix);
        super.setImageMatrix(matrix);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setImageMatrix(new Matrix());
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }

    public void setImgBottom(Matrix matrix){
        if (getImageMatrix() != null) {
            final int dwidth = getDrawable().getIntrinsicWidth();
            final int dheight = getDrawable().getIntrinsicHeight();

            final int vwidth = getWidth() - getPaddingLeft() - getPaddingRight();
            final int vheight = getHeight() - getTop() - getPaddingBottom();

            Matrix mDrawMatrix = matrix;

            float scale;
            float dx = 0, dy = 0;

            if (dwidth * vheight > vwidth * dheight) {
                scale = (float) vheight / (float) dheight;
                dx = (vwidth - dwidth * scale) * 0.5f;
                mDrawMatrix.setScale(scale, scale);
                mDrawMatrix.postTranslate(Math.round(dx), Math.round(dy));
            } else {
                scale = (float) vwidth / (float) dwidth;
                dy = (vheight - dheight * scale);
                mDrawMatrix.setScale(scale, scale);
                mDrawMatrix.postTranslate(0, Math.round(dy));
            }

            invalidate();
        }
    }

}
