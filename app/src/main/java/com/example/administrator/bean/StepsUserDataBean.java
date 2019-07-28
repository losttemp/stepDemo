package com.example.administrator.bean;

public class StepsUserDataBean {
    private int status;
    private String info;
    private data data;

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(int status) {
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

    /**
	 * 
	 */
    public StepsUserDataBean() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param status
     * @param info
     * @param data
     */
    public StepsUserDataBean(int status, String info,
                             StepsUserDataBean.data data) {
        this.status = status;
        this.info = info;
        this.data = data;
    }

    public class data {
        private String user_name;
        private String user_sex;
        private String user_avatar;
        private int user_height;
        private int user_weight;
        private String user_birthday;
        private String blood_type;
        private String food_allergy;
        private String drug_allergy;

        /**
         * @param user_name
         * @param user_sex
         * @param user_avatar
         * @param user_height
         * @param user_weight
         * @param user_birthday
         * @param blood_type
         * @param food_allergy
         * @param drug_allergy
         */
        public data(String user_name, String user_sex, String user_avatar,
                    int user_height, int user_weight, String user_birthday,
                    String blood_type, String food_allergy, String drug_allergy) {
            this.user_name = user_name;
            this.user_sex = user_sex;
            this.user_avatar = user_avatar;
            this.user_height = user_height;
            this.user_weight = user_weight;
            this.user_birthday = user_birthday;
            this.blood_type = blood_type;
            this.food_allergy = food_allergy;
            this.drug_allergy = drug_allergy;
        }

        /**
		 * 
		 */
        public data() {
            // TODO Auto-generated constructor stub
        }

        /**
         * @return the user_name
         */
        public String getUser_name() {
            return user_name;
        }

        /**
         * @param user_name
         *            the user_name to set
         */
        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        /**
         * @return the user_sex
         */
        public String getUser_sex() {
            return user_sex;
        }

        /**
         * @param user_sex
         *            the user_sex to set
         */
        public void setUser_sex(String user_sex) {
            this.user_sex = user_sex;
        }

        /**
         * @return the user_avatar
         */
        public String getUser_avatar() {
            return user_avatar;
        }

        /**
         * @param user_avatar
         *            the user_avatar to set
         */
        public void setUser_avatar(String user_avatar) {
            this.user_avatar = user_avatar;
        }

        /**
         * @return the user_height
         */
        public int getUser_height() {
            return user_height;
        }

        /**
         * @param user_height
         *            the user_height to set
         */
        public void setUser_height(int user_height) {
            this.user_height = user_height;
        }

        /**
         * @return the user_weight
         */
        public int getUser_weight() {
            return user_weight;
        }

        /**
         * @param user_weight
         *            the user_weight to set
         */
        public void setUser_weight(int user_weight) {
            this.user_weight = user_weight;
        }

        /**
         * @return the user_birthday
         */
        public String getUser_birthday() {
            return user_birthday;
        }

        /**
         * @param user_birthday
         *            the user_birthday to set
         */
        public void setUser_birthday(String user_birthday) {
            this.user_birthday = user_birthday;
        }

        /**
         * @return the blood_type
         */
        public String getBlood_type() {
            return blood_type;
        }

        /**
         * @param blood_type
         *            the blood_type to set
         */
        public void setBlood_type(String blood_type) {
            this.blood_type = blood_type;
        }

        /**
         * @return the food_allergy
         */
        public String getFood_allergy() {
            return food_allergy;
        }

        /**
         * @param food_allergy
         *            the food_allergy to set
         */
        public void setFood_allergy(String food_allergy) {
            this.food_allergy = food_allergy;
        }

        /**
         * @return the drug_allergy
         */
        public String getDrug_allergy() {
            return drug_allergy;
        }

        /**
         * @param drug_allergy
         *            the drug_allergy to set
         */
        public void setDrug_allergy(String drug_allergy) {
            this.drug_allergy = drug_allergy;
        }

    }
}
