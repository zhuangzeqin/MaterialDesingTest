package com.eeepay.cn.zzq.demo.ui.materia_design;

import android.app.Application;
import android.content.Context;


/**
 * 描述：自定义 application 类
 * 作者：zhuangzeqin
 * 时间: 2017/9/29-10:18
 * 邮箱：zzq@eeepay.cn
 */
public class APP extends Application {
    private static volatile Context mContext;//提供全局的Context
    @Override
    public void onCreate() {
        super.onCreate();
        APP.mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
