package com.example.common;

import java.util.Calendar;

/*
* 日期时间工具类
*
* */
public class SuperDateUtil {
    public static int currentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
