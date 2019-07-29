package com.example.administrator.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import com.example.administrator.stepdemo.OkHttpClientManager;
import com.example.administrator.stepdemo.OkHttpResultListener;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.administrator.bean.ChackUserBean;

/*
 * 判断用户是否登录工具类
 */
public class LoginUtils {
    private final static String URL = "http://sensor.hong-niao.com/login/?s=api/check";
    private final static String APP_KEY = "f58efa91746c07d122493225801aa4bf";
    private final static String LOGIN_URL = "content://com.loginmanager.provider/info";
    private final static String V = "1.0";
    private final static int CHECK_SUCCESS = 10000;
    private final static int CHECK_SIGNERROR = 30001;
    private final static int INCOMPLETE_PARAMTERS = 30002;
    private final static int MISMATCH = 30003;
    private final static int NOINTERFACE = 30004;

    public static Map<String, String> getUser(Context context) {
        Map<String, String> mUserMap = new HashMap<>();
        Uri uri = Uri.parse(LOGIN_URL);
        Cursor cursor = context.getContentResolver().query(uri, null, null,
                null, null);
        try {
            if (cursor != null) {
                if (cursor.moveToNext()) {
                    String uid = cursor.getString(1);
                    String token = cursor.getString(4);
                    if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(token)) {
                        mUserMap.clear();
                        mUserMap.put(Constants.UID_STR,
                                uid);
                        mUserMap.put(Constants.TOKEN_STR,
                                token);
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return mUserMap;
    }

    /*
     * 判断用户是否登录方法
     */
    public static boolean isLogin(Context context) {
        return true;
    }

    /*
     * 第三方登录app方法
     */
    public static void startLogin(Activity context) {
        PackageInfo pi;
        try {
            pi = context.getPackageManager().getPackageInfo(
                    "com.loginmanager", 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return;
        }
        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(pi.packageName);
        List<ResolveInfo> pps = context.getPackageManager()
                .queryIntentActivities(resolveIntent, 0);
        ResolveInfo ri = pps.iterator().next();
        if (ri != null) {
            String className = ri.activityInfo.name;
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.putExtra("type", "0");
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            ComponentName cn = new ComponentName("com.loginmanager",
                    className);
            intent.setComponent(cn);
            context.startActivityForResult(intent,
                    Constants.REQUSET_RESULT, null);
        }
    }

    public static void checkLogin(Context context,
            OkHttpResultListener httpListener) {
        // try {
        String uid = null;
        String token = null;
        try {
            Uri uri = Uri.parse(LOGIN_URL);
            Cursor cursor = context.getContentResolver().query(uri, null, null,
                    null, null);
            try {
                if (cursor != null) {
                    if (cursor.moveToNext()) {
                        uid = cursor.getString(1);
                        token = cursor.getString(4);
                    }
                }
            } catch (Exception e) {
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
            if (uid == null || token == null) {
                httpListener.loginFail();
                return;
            }
            long t = System.currentTimeMillis() / 1000L;
            String md5 = Md5.string2MD5(APP_KEY + uid + token
                    + String.valueOf(t), "utf-8");
            String sign = md5.substring(8, md5.length());
            Map<String, String> map = new HashMap<String, String>();
            map.put("app_key", APP_KEY);
            map.put("user_id", "1");
            map.put("token", "c4ca4238a0b923820dcc509a6f75849b");
            map.put("t", String.valueOf(t));
            map.put("v", V);
            map.put("sign", sign);
            postAsyn(context, map, httpListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void postAsyn(Context context, Map<String, String> map,
                                 final OkHttpResultListener httpListener) {
        OkHttpClientManager.postAsyn(URL, map,
                new HealthResultCallback<String>() {

                    @Override
                    public void onError(com.squareup.okhttp.Request request,
                            Exception e) {
                        super.onError(request, e);
                        if (httpListener != null) {
                            httpListener.error();
                        }
                    }

            @Override
            public void onResponse(String response) {
                super.onResponse(response);
                Log.e("chack", response);
                try {
                    ChackUserBean chackUserBean =
                            new Gson().fromJson(response, ChackUserBean.class);
                    if (chackUserBean != null) {
                        switch (chackUserBean.getStatus()) {
                            case CHECK_SUCCESS:
                                if (httpListener != null) {
                                    httpListener.loginSuccess();
                                }
                                break;
                            case CHECK_SIGNERROR:
                            case INCOMPLETE_PARAMTERS:
                            case MISMATCH:
                            case NOINTERFACE:
                                if (httpListener != null) {
                                    httpListener.loginFail();
                                }
                                break;
                            default:
                                break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

                    @Override
                    public void onBefore(com.squareup.okhttp.Request request) {
                        super.onBefore(request);
                    }

                    @Override
                    public void onAfter() {
                        super.onAfter();
                    }
                }, context);

    }
}
