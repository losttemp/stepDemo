package com.example.administrator.utils;

import android.content.Context;

import com.example.administrator.stepdemo.OkHttpClientManager;

import java.util.HashMap;
import java.util.Map;

/*
 * 网络请求工具类
 */
public class OkHttpUtils {
    @SuppressWarnings({ "unused", "rawtypes" })
    /*
     * 网络请求post方法
     */
    public static void post(Context context, String url,
                            Map<String, String> params, final OkHttpClientManager.ResultCallback callback) {
        String userid = SPUtils.getString(context,
                Constants.UID);
        String usertoken = SPUtils.getString(context,
                Constants.TOKEN);
        Map<String, String> requestMap = new HashMap<>();
        params.put("userid", userid);
        params.put("usertoken", usertoken);
        OkHttpClientManager.postAsyn(url, params, callback);
    }
}
