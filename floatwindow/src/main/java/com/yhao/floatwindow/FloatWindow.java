package com.yhao.floatwindow;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

/**
 * Created by yhao on 2017/12/22.
 * https://github.com/yhaolpz
 */

public class FloatWindow {

    private FloatWindow() {

    }

    private static final String mDefaultTag = "default_float_window_tag";
    private static Map<String, IFloatWindow> mFloatWindowMap;

    public static IFloatWindow get() {
        return get(mDefaultTag);
    }

    public static IFloatWindow get(String tag) {
        return mFloatWindowMap == null ? null : mFloatWindowMap.get(tag);
    }

    private static B mBuilder = null;

    public static B with(Context applicationContext) {
        return mBuilder = new B(applicationContext);
    }

    public static void destroy() {
        destroy(mDefaultTag);
    }

    public static void destroy(String tag) {
        if (mFloatWindowMap == null || !mFloatWindowMap.containsKey(tag)) {
            return;
        }
        mFloatWindowMap.get(tag).dismiss();
        mFloatWindowMap.remove(tag);
    }

    public static class B {
        Context mApplicationContext;
        View mView;
        private int mLayoutId;
        int mWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
        int mHeight = ViewGroup.LayoutParams.WRAP_CONTENT;
        int gravity = Gravity.TOP | Gravity.START;
        int xOffset;
        int yOffset;
        boolean mShow = true;
        Class[] mActivities;
        int mSlideLeftMargin;
        int mSlideRightMargin;
        long mDuration = 300;
        TimeInterpolator mInterpolator;
        private String mTag = mDefaultTag;
        boolean mDesktopShow;

        private B() {

        }

        B(Context applicationContext) {
            mApplicationContext = applicationContext;
        }

        public B setView(View view) {
            return this;
        }

        public B setView(int layoutId) {
            return this;
        }

        public B setWidth(int width) {
            return this;
        }

        public B setHeight(int height) {
            return this;
        }

        public B setWidth(@Screen.screenType int screenType, float ratio) {
            return this;
        }

        public B setHeight(@Screen.screenType int screenType, float ratio) {
            return this;
        }

        public B setX(int x) {
            return this;
        }

        public B setY(int y) {
            yOffset = y;
            return this;
        }

        public B setX(@Screen.screenType int screenType, float ratio) {
            return this;
        }

        public B setY(@Screen.screenType int screenType, float ratio) {
            return this;
        }

        /**
         * 设置 Activity 过滤器，用于指定在哪些界面显示悬浮窗，默认全部界面都显示
         *
         * @param show       　过滤类型,子类类型也会生效
         * @param activities 　过滤界面
         */
        public B setFilter(boolean show, Class... activities) {
            return this;
        }

        public B setMoveStyle(long duration, TimeInterpolator interpolator) {
            mDuration = duration;
            mInterpolator = interpolator;
            return this;
        }

        public B setTag(String tag) {
            mTag = tag;
            return this;
        }

        public B setDesktopShow(boolean show) {
            mDesktopShow = show;
            return this;
        }

        public void build() {

        }
    }
}
