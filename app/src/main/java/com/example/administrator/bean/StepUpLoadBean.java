package com.example.administrator.bean;

public class StepUpLoadBean {
    private String uid;
    private String token;
    private int steps;
    private int active_time;
    private String distance;
    private String uses_energy;
    private long create_time;

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

    public StepUpLoadBean(int steps, int active_time,
                          String distance, String user_energy, long create_time) {
        super();
        this.steps = steps;
        this.active_time = active_time;
        this.distance = distance;
        this.uses_energy = user_energy;
        this.create_time = create_time;
    }

    public synchronized int getSteps() {
        return steps;
    }

    public synchronized void setSteps(int steps) {
        this.steps = steps;
    }

    public synchronized int getActive_time() {
        return active_time;
    }

    public synchronized void setActive_time(int active_time) {
        this.active_time = active_time;
    }

    public synchronized String getDistance() {
        return distance;
    }

    public synchronized void setDistance(String distance) {
        this.distance = distance;
    }

    public synchronized String getUser_energy() {
        return uses_energy;
    }

    public synchronized void setUser_energy(String user_energy) {
        this.uses_energy = user_energy;
    }

    public synchronized long getCreate_time() {
        return create_time;
    }

    public synchronized void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public StepUpLoadBean() {
        super();
    }
}
