package com.example.administrator.bean;

public class UserDataBean {
    private String token;
    private String uid;

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     *            the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid
     *            the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @param token
     * @param uid
     */
    public UserDataBean(String token, String uid) {
        this.token = token;
        this.uid = uid;
    }

    /**
	 * 
	 */
    public UserDataBean() {
    }

}
