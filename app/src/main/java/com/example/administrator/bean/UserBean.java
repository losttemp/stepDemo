package com.example.administrator.bean;

import java.io.Serializable;

import com.example.administrator.utils.Constants;

/*
 * 体检用户类
 */
public class UserBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 6931048827889246342L;
    private String mUid = "";
    private String mToken = "";
    // 1：代表用户自己 2：代表是家庭成员
    private int mMemberType;
    // 体检用户id 与UID 不同，用来区分家庭成员
    private int mMemberId;
    // page type: recored:历史记录 share：历史记录分享页
    private String mPageType = Constants.XIAOLAJIAO_PAGE_TYPE_RECORD;
    // 性别 1 男 2 女
    private int mSex = 0;

    // // 血氧
    // private int mBloodOxygen;
    // // 心率
    // private int mHeartRate;
    // // 呼吸率
    // private int mRespiratoryRate;
    // // 体温
    // private int mTemperature;

    // // 高压
    // private int mHighBloodPressure;
    // // 低压
    // private int mLowBloodPressure;
    // // PR最大值
    // private int mMaxPr;
    // // PR最小值
    // private int mMinPr;
    // // 心率变异性
    // private int mHeartRateVariability;
    // // 心电波动数据 json格式
    // private String mExtraData;
    // // 体检时间 格式：2017-01-17 13:10:10不传则默认取系统时间
    // private String mCreateTime;

    // 用户性别
    // private int mUserSex;
    // // 用户头像
    // private String mUserAvatar;
    //
    // // 体检报告id
    // private int mReportId;
    // 身高
    private int mHeight = 0;
    // 出生日期
    private String mUserBirthday = "";
    // 姓名
    private String mName = "";
    // 体重
    private int mWeight = 0;

    // // 目标步数
    // private int mSteps;
    // // 消耗能量
    // private int mUsesEnergy;

    /*
     * Set/Get 方法区
     */
    public String getUid() {
        return mUid;
    }

    public void setUid(String uid) {
        this.mUid = uid;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        this.mToken = token;
    }

    public int getMemberType() {
        return mMemberType;
    }

    public void setMemberType(int memberType) {
        this.mMemberType = memberType;
    }

    public int getMemberId() {
        return mMemberId;
    }

    public void setMemberId(int memberId) {
        this.mMemberId = memberId;
    }

    public String getPageType() {
        return mPageType;
    }

    public void setPageType(String pageType) {
        this.mPageType = pageType;
    }

    public int getSex() {
        return mSex;
    }

    public void setSex(int sex) {
        this.mSex = sex;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmHeight() {
        return mHeight;
    }

    public void setmHeight(int mHeight) {
        this.mHeight = mHeight;
    }

    public String getmUserBirthday() {
        return mUserBirthday;
    }

    public void setmUserBirthday(String mUserBirthday) {
        this.mUserBirthday = mUserBirthday;
    }

    public int getmWeight() {
        return mWeight;
    }

    public void setmWeight(int mWeight) {
        this.mWeight = mWeight;
    }
}
