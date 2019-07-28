package com.example.administrator.bean;

public class ChackUserBean {
    private int status;
    private String info;
    private data data;

    public ChackUserBean() {
        super();
    }

    public ChackUserBean(int status, String info,
                         ChackUserBean.data data) {
        super();
        this.status = status;
        this.info = info;
        this.data = data;
    }

    public synchronized int getStatus() {
        return status;
    }

    public synchronized void setStatus(int status) {
        this.status = status;
    }

    public synchronized String getInfo() {
        return info;
    }

    public synchronized void setInfo(String info) {
        this.info = info;
    }

    public synchronized data getData() {
        return data;
    }

    public synchronized void setData(data data) {
        this.data = data;
    }

    public class data {
        private int user_id;

        public synchronized int getUser_id() {
            return user_id;
        }

        public synchronized void setUser_id(int user_id) {
            this.user_id = user_id;
        }

    }
}
