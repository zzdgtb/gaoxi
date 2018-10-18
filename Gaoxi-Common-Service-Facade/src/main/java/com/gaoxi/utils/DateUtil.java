package com.gaoxi.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * 时间转换成Unix格式
     *
     * @param d
     * @return
     * @throws ParseException
     */
    public static Long parseToUnix(Date d) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String t = df.format(d);
        return df.parse(t).getTime() / 1000;
    }

    /**
     * 当前时间的几小时之后
     *
     * @param afterhours
     * @return
     */
    public static Date getDateSomeHoursBehind(int afterhours) {
        long curren = System.currentTimeMillis();
        curren += 30 * 60 * 1000 * afterhours;
        Date da = new Date(curren);
        return da;
    }

    public static void main(String[] args) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 1361325960
        long epoch = df.parse("2013-02-20 10:06:00").getTime();
        System.out.println("should be 1361325960 ：" + epoch);

        Date d = new Date();
        String t = df.format(d);
        epoch = df.parse(t).getTime() / 1000;
        System.out.println("t is ：" + t + ",unix stamp is " + epoch);

    }

}
