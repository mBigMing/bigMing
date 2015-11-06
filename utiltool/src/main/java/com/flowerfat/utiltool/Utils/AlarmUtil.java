package com.flowerfat.utiltool.Utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.flowerfat.utiltool.others.AlarmReceiver;

import java.util.Calendar;

/**
 * for a sample alarm, we need three steps:
 * 1. a Receiver to get the time when the alarm is ring
 * 2. alarm time . we can make a right time or make a delay.
 * 3. start the alarm . we have many mode to start the alarm
 */
public class AlarmUtil {

    private final static int REQUEST_CODE = 123 ;
    private static final int INTERVAL = 1000 * 60 * 60 * 24;// 24h

    private Context mContext ;

    public AlarmUtil(Context context){
        mContext = context ;
    }

    public void OnceSecond(int second){
        OnceSecond(second, REQUEST_CODE);
    }

    public void OnceSecond(int second, int requestCode){
        setAlarm(offSecond(second), getPendingIntent(requestCode));
    }

//    /**
//     * @param second
//     * @param requestCode
//     * @param repeatime
//     */
//    public void repeatSecond(int second, int requestCode, int repeatime){
//        repeatAlarm(offSecond(second), getPendingIntent(requestCode), repeatime);
//    }

    ///////////////////////////////////////////////////////////////////////////////

    /**
     * We want the alarm to go off _second seconds from now.
     * @param _second
     * @return
     */
    private Calendar offSecond(int _second){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, _second);
        return calendar ;
    }

    /**
     * a Receiver to get the time when the alarm is ring
     * the default Receiver is in the .others/
     *
     * and I set the default requestCode is 123
     * @return
     */
    private PendingIntent getPendingIntent(){
        return getPendingIntent(REQUEST_CODE);
    }

    /**
     *
     * @param requestCode the alarm's markNumber, we catch the alarm by it ;
     * @return
     */
    private PendingIntent getPendingIntent(int requestCode){
        Intent intent = new Intent(mContext, AlarmReceiver.class);
        return PendingIntent.getBroadcast(
                mContext, requestCode, intent, 0);
    }

    /**
     * make the alarm GO !
     * @param calendar
     * @param sender
     */
    private void setAlarm(Calendar calendar, PendingIntent sender){
        AlarmManager am = (AlarmManager) mContext.getSystemService(mContext.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
    }

    private void repeatAlarm(Calendar calendar, PendingIntent sender, long intervalMillis){
        AlarmManager am = (AlarmManager) mContext.getSystemService(mContext.ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), intervalMillis, sender);
    }


    public void Cancel(){
        Cancel(REQUEST_CODE);
    }
    /**
     * TODO 取消到底是用am取消还是用pi取消？
     */
    public void Cancel(int requestCode){
        getPendingIntent(requestCode).cancel();
    }

    public void release(){
        mContext = null ;
    }
}
