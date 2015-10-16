package com.flowerfat.utiltool.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 明明大美女 on 2015/9/24.
 * <p>
 * 这个的使用像C语言中的sprintf， eg：%d  %s啥的
 * <p>
 * 年：yyyy
 * 月：MM
 * 日：dd
 * 时：HH
 * 分：mm
 * 秒：ss
 * 星期：E
 * 星期（长）：EEEE
 */
public class DateUtil {

    public static final String DATEMODE1 = "我擦yyyy呵呵MM嘻嘻dd";

    public static String getDate(String dateMode) {
        SimpleDateFormat format = new SimpleDateFormat(dateMode);
        return format.format(new Date());
    }

    /**
     * 判断是否到了第二天
     * 输入上次的日期，与今日比较
     *
     * @param lastDay 日期格式为年月日，eg：20151010
     * @return
     * 如果 lastDay 与 today相同，则说明没有跨天，返回值为“no”
     * 如果 lastDay 与 today不相同，则说明跨天了，返回值为今日的日期
     */
    public static String ifStepDay(String lastDay) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String today = format.format(new Date());
        return today.equals(lastDay) ? "no" : today;
    }

    /**
     * 自动判断是否是第二天了。使用了我默认的sp存时间
     * @param context
     * @return 是否跨天
     */
    public static boolean ifStepDay(Context context){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String today = format.format(new Date());

        SharedPreferences sp = context.getSharedPreferences("bigming", Context.MODE_PRIVATE);
        String lastDay = sp.getString("lastDay", null) ;

        // 如果之前没存lastDay ，或者today与lastDay相同，则没有跨天
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
