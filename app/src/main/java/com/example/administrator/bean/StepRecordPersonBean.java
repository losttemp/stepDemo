package com.example.administrator.bean;

import java.io.Serializable;

public class StepRecordPersonBean implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -6873470500190413056L;
    private String record_id;
    private String uid;
    private int steps;
    private String active_time;
    private String distance;
    private String uses_energy;
    private String create_time;
    private String update_time;

    public StepRecordPersonBean() {
    }

    public StepRecordPersonBean(String record_id, String uid,
                                int steps, String active_time, String distance, String uses_energy,
                                String create_time, String update_time) {
        this.record_id = record_id;
        this.uid = uid;
        this.steps = steps;
        this.active_time = active_time;
        this.distance = distance;
        this.uses_energy = uses_energy;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public synchronized String getRecord_id() {
        return record_id;
    }

    public synchronized void setRecord_id(String record_id) {
        this.record_id = record_id;
    }

    public synchronized String getUid() {
        return uid;
    }

    public synchronized void setUid(String uid) {
        this.uid = uid;
    }

    public synchronized int getSteps() {
        return steps;
    }

    public synchronized void setSteps(int steps) {
        this.steps = steps;
    }

    public synchronized String getActive_time() {
        return active_time;
    }

    public synchronized void setActive_time(String active_time) {
        this.active_time = active_time;
    }

    public synchronized String getDistance() {
        return distance;
    }

    public synchronized void setDistance(String distance) {
        this.distance = distance;
    }

    public synchronized String getUses_energy() {
        return uses_energy;
    }

    public synchronized void setUses_energy(String uses_energy) {
        this.uses_energy = uses_energy;
    }

    public synchronized String getCreate_time() {
        return create_time;
    }

    public synchronized void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public synchronized String getUpdate_time() {
        return update_time;
    }

    public synchronized void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
