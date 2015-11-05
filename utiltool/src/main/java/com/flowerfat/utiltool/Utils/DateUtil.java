package com.flowerfat.utiltool.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * year：yyyy
 * month：MM
 * day：dd
 * hour：HH
 * minute：mm
 * second：ss
 * week：E
 * longweek：EEEE
 */
public class DateUtil {

    public static final String DATEMODE1 = "yyyyMMdd";

    public static String getDate(String dateMode) {
        SimpleDateFormat format = new SimpleDateFormat(dateMode);
        return format.format(new Date());
    }

    public static String yesterday(String dateMode){
        SimpleDateFormat format = new SimpleDateFormat(dateMode);
        return format.format(shifting(new Date(), -1));
    }

    /**
     * get
     * @param date 基准日期
     * @param offsite >0 means add, and <0 means
     * @return 偏移后的日期
     */
    public static Date shifting(Date date, int offsite){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, offsite);
        return cal.getTime();
    }

    /**
     * if come into a new day
     *
     * @return if new ,today; if old ,no
     */
    public static String ifStepDay(String lastDay) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String today = format.format(new Date());
        return today.equals(lastDay) ? "no" : today;
    }

    /**
     * auto decide if come into a new day
     * @param context nothing
     * @return yes or not
     */
    public static boolean ifStepDay(Context context){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String today = format.format(new Date());

        SharedPreferences sp = context.getSharedPreferences("bigming", Context.MODE_PRIVATE);
        String lastDay = sp.getString("lastDay", null) ;


        if(!StringUtil.isEmpty(lastDay) && today.equals(lastDay)){
            return false ;
        }
        sp.edit().putString("lastDay", today).apply() ;
        return true ;

//        if(StringUtil.isEmpty(lastDay)){
//            sp.edit().putString("lastDay", today).apply() ;
//            return true ;
//        } else {
//            if(today.equals(lastDay)){
//                return false ;
//            } else {
//                sp.edit().putString("lastDay", today).apply() ;
//                return true ;
//            }
//        }
    }

}
