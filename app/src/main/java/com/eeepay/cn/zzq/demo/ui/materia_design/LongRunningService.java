package com.eeepay.cn.zzq.demo.ui.materia_design;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 描述：模拟在长时间在后台运行的的一个服务
 * 作者：zhuangzeqin
 * 时间: 2017/9/29-14:27
 * 邮箱：zzq@eeepay.cn
 */
public class LongRunningService extends Service {
    private static final String TAG  = "LongRunningService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
           //这里执行具体的逻辑操作
                Log.d(TAG, "run: LongRunningService++");
            }
        }).start();
//        long triggerAtTime = SystemClock.currentThreadTimeMillis()+ 5*1000;//比如每隔5s 就执行一次
        Intent i = new Intent(this,LongRunningService.class);
        PendingIntent pi = PendingIntent.getService(this,0,i,0);
        AlarmManager manger =(AlarmManager)getSystemService(Context.ALARM_SERVICE);
        manger.set(AlarmManager.RTC_WAKEUP,AlarmManager.INTERVAL_HOUR,pi);//比如一小时执行一次
        return super.onStartCommand(intent, flags, startId);
    }
}
