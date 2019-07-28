package com.example.administrator.utils;

import com.example.administrator.stepdemo.OkHttpClientManager;
import com.squareup.okhttp.Request;

public class HealthResultCallback<T> extends
        OkHttpClientManager.ResultCallback<T> {

    @Override
    public void onError(Request request, Exception e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onResponse(T response) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onBefore(Request request) {
    }

    @Override
    public void onAfter() {
    }
}
