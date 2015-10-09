package com.flowerfat.utiltool.Utils;

import android.content.Context;

/**
 * Created by 明明大美女 on 2015/9/28.
 *
 * 定时器
 * 广播的形式，所以需要注册一个广播接收，用来做定时之后的事儿~
 */
public class AlarmUtil {

    public void Once(Context context){
//        Intent intent = new Intent(context, OneShotAlarm.class);
//        PendingIntent sender = PendingIntent.getBroadcast(
//                AlarmController.this, 0, intent, 0);
//
//        // We want the alarm to go off 10 seconds from now.
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(System.currentTimeMillis());
//        calendar.add(Calendar.SECOND, 10);
//
//        // Schedule the alarm!
//        AlarmManager am = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
//        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
    }

    public void Repeat(){

    }

    public void Cancel(){

    }

}
