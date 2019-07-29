package com.example.administrator.utils;

import android.content.Context;
import android.util.Log;

import com.example.administrator.stepdemo.OkHttpClientManager;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import com.example.administrator.bean.UserDataBean;

public class UpLoadUtils {
    public static Map<String, String> putParamAndEncrypted(
            Map<String, String> paramMap, Object object, String sign, long t) {
        paramMap.put(Constants.VERSION_KEY,
                Constants.VERSION_VALUE);
        paramMap.put(Constants.UPLOAD_TIME_KEY, String.valueOf(t));
        paramMap.put(Constants.UPLOAD_APPID_KEY,
                Constants.UPLOAD_APPID_VALUE);
        paramMap.put(Constants.UPLOAD_APP_SECRET_KEY,
                Constants.UPLOAD_APP_SECRET_VALUE);
        Log.e("Health", "initTarget == body: " + new Gson().toJson(object));
        String body = DES3.padding(new Gson().toJson(object));
        try {
            // body 处理
            paramMap.put(Constants.UPLOAD_BODY_KEY,
                    DES3.encode(body));
            Log.e("Health", "加密后 body==   " + DES3.encode(body));
        } catch (Exception e) {
            e.printStackTrace();
        }

        paramMap.put(Constants.UPLOAD_SIGN_KEY,
                Md5.string2MD5(sign, "utf-8"));

        Log.e("Health",
                "加密后 sign==    " + Md5.string2MD5(sign, "utf-8"));
        return paramMap;
    }

    public static void getUserData(Context context,
            HealthResultCallback<String> callback) {
        Map<String, String> paramMap = new HashMap<String, String>();
        long t = System.currentTimeMillis() / 1000L;
        // 参数处理
        paramMap.put(Constants.UPLOAD_METHOD_KEY,
                Constants.GET_USER_DETAIL);
        UserDataBean userDataBean = new UserDataBean(
                LoginUtils.getUser(context).get(
                        Constants.TOKEN_STR),
                LoginUtils.getUser(context).get(
                        Constants.UID_STR));
        String sign = "token="
                + LoginUtils.getUser(context).get(
                        Constants.TOKEN_STR)
                + "&uid="
                + LoginUtils.getUser(context).get(
                        Constants.UID_STR) + "&" + t;
        Log.e("Health", "initHttp == sign: " + sign);
        paramMap = UpLoadUtils.putParamAndEncrypted(paramMap,
                userDataBean, sign, t);
        OkHttpClientManager.postAsyn(Constants.COMMON_URL, paramMap,
                callback, context);
    }
}
