package com.ahav.reserve.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class meetingUtils {
    //获得下一天的开始时间,参数日期
    public static Date getEndTime(Date date){
        DateFormat b=new SimpleDateFormat("yyyy年MM月dd日");
        try{
            date = b.parse(b.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +1);//+1今天的时间加一天
        date = calendar.getTime();
        System.out.println(date);
        return date;
    }

    //获得当天的开始时间
    public static Date getStartTime(Date date){
        DateFormat b=new SimpleDateFormat("yyyy年MM月dd日");
        try{
            date = b.parse(b.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
