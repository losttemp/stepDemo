package com.example.administrator.bean;

public class StepRecordBean {
    private String uid;
    private String token;
    private long date_time;

    public StepRecordBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public StepRecordBean(long date_time) {
        super();
        this.date_time = date_time;
    }

    public synchronized String getUid() {
        return uid;
    }

    public synchronized void setUid(String uid) {
        this.uid = uid;
    }

    public synchronized String getToken() {
        return token;
    }

    public synchronized void setToken(String token) {
        this.token = token;
    }

    public synchronized long getDate_time() {
        return date_time;
    }

    public synchronized void setDate_time(long date_time) {
        this.date_time = date_time;
    }
}
