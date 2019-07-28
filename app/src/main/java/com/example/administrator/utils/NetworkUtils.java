package com.example.administrator.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.administrator.stepdemo.NetworkListener;

public class NetworkUtils {

    public static boolean checkNetWork(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo == null) {
            return false;
        }
        if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE
                    || networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            }
        }
        return false;
    }

    public static BroadcastReceiver registerNetworkReceiver(Context context,
                                                            final NetworkListener networkListener) {
        BroadcastReceiver networkReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (networkListener != null) {
                    networkListener.networkListener();
                }
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(networkReceiver, filter);
        return networkReceiver;
    }
}
