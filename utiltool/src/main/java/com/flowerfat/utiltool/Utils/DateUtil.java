package com.flowerfat.utiltool.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 明明大美女 on 2015/9/24.
 *
 * 这个的使用像C语言中的sprintf， eg：%d  %s啥的
 *
 * 年：yyyy
 * 月：MM
 * 日：dd
 * 时：HH
 * 分：mm
 * 秒：ss
 * 星期：E
 * 星期（长）：EEEE
 *
 */
public class DateUtil {

    public static final String DATEMODE1 = "我擦yyyy呵呵MM嘻嘻dd";

    public static String getDate(String dateMode) {
        SimpleDateFormat format = new SimpleDateFormat(dateMode);
        return format.format(new Date());
    }

}
