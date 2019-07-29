package com.example.administrator.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.example.administrator.stepdemo.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeAndShareUtils {
    private static String timeFormat = "EEEE";
    private static final String timeFormatDay = "yyyy-MM-dd HH:mm";
    private static final String timeFormatNDay = "yyyy-MM-dd-HH:mm";
    private static final String timeFormatSDay = "yyyy.M.d";
    private static final String timeSecond = "mm:ss";
    private static String g_timeFormat = "yyyy/MM";
    private static int default_time = Constants.DEFAULT_NOW_TIME;

    public static synchronized int getDefault_time() {
        return default_time;
    }

    public static synchronized void setDefault_time(int default_time) {
        TimeAndShareUtils.default_time = default_time;
    }

    public static String getCreateTime() {
        SimpleDateFormat format = new SimpleDateFormat(
                Constants.DATE_FORMATE);
        String str = format.format(new Date());
        return str;
    }

    public static String getCreateMinute() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String str = format.format(new Date());
        return str;
    }

    public static String getCreateSecond(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(timeSecond);
        String str = format.format(date);
        return str;
    }

    public static String getCurreTime() {
        SimpleDateFormat format = new SimpleDateFormat(timeFormatDay);
        String str = format.format(new Date());
        return str;
    }

    public static String getWeek() {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
        String week = sdf.format(new Date());
        return week;
    }

    public static String getDayOfWeek(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat(timeFormat);
        try {
            Date date = sdf.parse(time);
            String week = sdf2.format(date);
            return week;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static String getDay() {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormatDay);
        String day = sdf.format(new Date());
        return day;
    }

    public static String getDayTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormatNDay);
        String day = sdf.format(new Date());
        return day;
    }

    public static String getSDay() {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormatSDay);
        String day = sdf.format(new Date());
        return day;
    }

    public static String getMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat(g_timeFormat);
        String month = sdf.format(new Date());
        return month;
    }

    public static void shareMsg(Context context, String msg) {
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_SUBJECT, "");

        intent.putExtra(Intent.EXTRA_TEXT, msg);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(Intent.createChooser(intent, context
                .getResources().getString(R.string.share)));
    }

    // 由出生日期获得年龄
    public static String getAgeFromBirthTime(String birthTimeString) {
        if (birthTimeString == null || TextUtils.isEmpty(birthTimeString)) {
            return "";
        }
        // 先截取到字符串中的年、月、日
        String strs[] = birthTimeString.trim().split("-");
        int selectYear = Integer.parseInt(strs[0]);
        int selectMonth = Integer.parseInt(strs[1]);
        // 得到当前时间的年、月、日
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        if (yearNow < default_time) {
            yearNow = default_time;
        }
        int monthNow = cal.get(Calendar.MONTH) + 1;
        // 用当前年月日减去生日年月日
        int yearMinus = yearNow - selectYear;
        int monthMinus = monthNow - selectMonth;
        int age = yearMinus;// 先大致赋值
        if (yearMinus < 0) {// 选了未来的年份
            // age = 0;
            throw new IllegalArgumentException("年龄不能超过当前日期");
        } else if (yearMinus == 0) {// 同年的，要么为1，要么为0
            if (monthMinus < 0) {// 选了未来的月份
                // age = 0;
                throw new IllegalArgumentException("年龄不能超过当前日期");
            } else if (monthMinus > 0) {
                age = 1;
            }
        } else if (yearMinus > 0) {
            if (monthMinus < 0) {// 当前月>生日月
            } else if (monthMinus > 0) {
                age = age + 1;
            }
        }
        return age + "";
    }

    public static long getXTimes(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, i);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 1);
        return calendar.getTimeInMillis();
    }

    public static boolean isWeek(String data) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long tody = calendar.getTimeInMillis();
        long sevenDay = tody - 7 * 24 * 60 * 60 * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 此处会抛异常
        Date date;
        try {
            date = sdf.parse(data);
            long longDate = date.getTime();
            if (longDate > sevenDay) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    // public static int getDayOfWeek(String date) {
    // Calendar cal = Calendar.getInstance();
    // if (date.equals("")) {
    // cal.setTime(new Date(System.currentTimeMillis()));
    // } else {
    // cal.setTime(new Date(getDateByStr2(date).getTime()));
    // }
    // return cal.get(Calendar.DAY_OF_WEEK);
    // }

    public static Date getDateByStr2(String dd) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sd.parse(dd);
        } catch (ParseException e) {
            date = null;
            e.printStackTrace();
        }
        return date;
    }

    public static String getStringByDate(long t) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String date = sd.format(new Date(t));
        return date;
    }

    public static String getWeekOfTime(long t) {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
        String week = sdf.format(new Date(t));
        return week;
    }

    public static String[] getWeekList(int i, String[] week) {
        String[] weekArray = new String[7];
        int x = 0;
        if (i < 0 || i > 6) {
            i = 0;
        }
        for (int j = i + 1; j < week.length; j++) {
            weekArray[x] = week[j];
            x++;
        }
        if (x == (week.length - 1 - i)) {
            for (int j = 0; j <= i; j++) {
                weekArray[x] = week[j];
                x++;
            }
        }
        return weekArray;
    }
}
