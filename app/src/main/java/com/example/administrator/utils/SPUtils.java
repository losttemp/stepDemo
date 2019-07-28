package com.example.administrator.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * ClassName:SPUtils <br/>
 * Function: SharedPreferences的工具类. <br/>
 * Date: 2016年8月6日 上午10:15:12 <br/>
 * 
 * @author Alpha
 * @version
 */
public class SPUtils {

    // 获取一个boolean值,默认值为false
    public static boolean getBoolean(Context context, String key) {
        return getBoolean(context, key, false);

    }

    // 获取一个boolean 值
    public static boolean getBoolean(Context context, String key,
            boolean defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(
                Constants.XIAOLAJIAO_SP_FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getBoolean(key, defaultValue);

    }

    // 保存一个boolean 值
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(
                Constants.XIAOLAJIAO_SP_FILE_NAME,
                Context.MODE_PRIVATE);

        Editor editor = sp.edit();
        editor.putBoolean(key, value);

        editor.commit();
    }

    // 获取一个String值,默认值为null
    public static String getString(Context context, String key) {
        return getString(context, key, null);

    }

    // 获取一个String值
    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = context.getSharedPreferences(
                Constants.XIAOLAJIAO_SP_FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getString(key, defValue);

    }

    // 保存一个String值
    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(
                Constants.XIAOLAJIAO_SP_FILE_NAME,
                Context.MODE_PRIVATE);

        Editor editor = sp.edit();
        editor.putString(key, value);

        editor.commit();
    }

    // 获取一个int值,默认值为-1
    public static int getInt(Context context, String key) {
        return getInt(context, key, -1);

    }

    // 获取一个int值
    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences(
                Constants.XIAOLAJIAO_SP_FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);

    }

    // 保存一个int值
    public static void putInt(Context context, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(
                Constants.XIAOLAJIAO_SP_FILE_NAME,
                Context.MODE_PRIVATE);

        Editor editor = sp.edit();
        editor.putInt(key, value);

        editor.commit();
    }

    public static void put(Context context, String name, Object object) {
        SharedPreferences sp = context.getSharedPreferences(
                Constants.XIAOLAJIAO_SP_FILE_NAME,
                Context.MODE_PRIVATE);
        Editor edit = sp.edit();
        if (object instanceof Boolean) {
            edit.putBoolean(name, (Boolean) object);
        } else if (object instanceof Integer) {
            edit.putInt(name, (Integer) object);
        } else if (object instanceof String) {
            edit.putString(name, (String) object);
        }
        edit.commit();
    }
}
