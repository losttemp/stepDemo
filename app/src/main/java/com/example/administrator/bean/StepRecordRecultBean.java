package com.example.administrator.bean;

import java.util.ArrayList;

public class StepRecordRecultBean {
    private String status;
    private String info;
    private data data;

    public class data {
        ArrayList<String> dates;
        ArrayList<StepRecordPersonBean> list;

        public data(ArrayList<String> dates,
                ArrayList<StepRecordPersonBean> list) {
            this.dates = dates;
            this.list = list;
        }

        public data() {
            // TODO Auto-generated constructor stub
        }

        /**
         * @return the dates
         */
        public ArrayList<String> getDates() {
            return dates;
        }

        /**
         * @param dates
         *            the dates to set
         */
        public void setDates(ArrayList<String> dates) {
            this.dates = dates;
        }

        /**
         * @return the list
         */
        public ArrayList<StepRecordPersonBean> getList() {
            return list;
        }

        /**
         * @param list
         *            the list to set
         */
        public void setList(ArrayList<StepRecordPersonBean> list) {
            this.list = list;
        }

    }

    public StepRecordRecultBean(String status, String info,
                                StepRecordRecultBean.data data) {
        this.status = status;
        this.info = info;
        this.data = data;
    }

    public StepRecordRecultBean() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info
     *            the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return the data
     */
    public data getData() {
        return data;
    }

    /**
     * @param data
     *            the data to set
     */
    public void setData(data data) {
        this.data = data;
    }
}
