package com.example.administrator.utils;

import android.content.Context;

import com.example.administrator.stepdemo.R;

import com.example.administrator.bean.UserBean;

public class WebUtils {

    private static String urlString;
    private static String[] urlIdname = {
            Constants.UID_STR,
            Constants.MEMBER_ID_STR,
            Constants.MEMBER_TYPE_STR,
            Constants.TOKEN_STR,
            Constants.PAGE_TYPE_STR};

    public static String webUrl(Context context, String type, String[] urlData) {
        if (urlData.length < 4) {
            return null;
        }
        if (urlData.length == 4) {
            for (int i = 0; i < urlIdname.length; i++) {
                if (i == 0) {
                    // 添加type
                    urlString = type
                            + context.getResources().getString(
                                    R.string.questionMark)
                            + context.getResources().getString(
                                    R.string.equalsSign)
                            + urlData[i];
                } else if (i == 3) {
                    // 空出token
                    urlString = urlString
                            + context.getResources().getString(
                                    R.string.questionMark)
                            + context.getResources().getString(
                                    R.string.equalsSign) + "";
                } else if (i == 4) {
                    // 匹配page_type
                    urlString = urlString
                            + context.getResources().getString(
                                    R.string.questionMark)
                            + context.getResources().getString(
                                    R.string.equalsSign)
                            + urlData[3];
                } else {
                    // 匹配相应数据
                    urlString = urlString
                            + context.getResources().getString(
                                    R.string.questionMark)
                            + context.getResources().getString(
                                    R.string.equalsSign)
                            + urlData[i];
                }
            }
        } else {
            for (int i = 0; i < urlIdname.length; i++) {
                if (i == 0) {
                    urlString = type
                            + context.getResources().getString(
                                    R.string.questionMark)
                            + context.getResources().getString(
                                    R.string.equalsSign)
                            + urlData[i];
                } else {
                    urlString = urlString
                            + context.getResources().getString(
                                    R.string.questionMark)
                            + context.getResources().getString(
                                    R.string.equalsSign)
                            + urlData[i];
                }
            }
        }
        return urlString;
    }

    /*
	 * 
	 */
    public static String webKnowlegeUrl(String knowlege) {
        urlString = null;
        urlString = Constants.KNOW_HEAD + knowlege;
        return urlString;
    }

    /*
     * 创建历史记录URI 访问 testType: 体检类型： 体温/酒精/血压/血氧... isShare true：分享页url， false
     * 历史记录
     */
    public static String createHistoryWebUrl(UserBean user,
                                             int testType, boolean isShare) {
        String retVal = null;
        // 体检类型不同处理
        switch (testType) {
        // 血压
        case Constants.TEST_TYPE_BLOODPRESURE:
            retVal = Constants.BLOODPRESURE_URL;
            break;
        // 血氧
        case Constants.TEST_TYPE_BLOODOXYGEN:
            retVal = Constants.BLOODOXYGEN_URL;
            break;
        // 呼吸率
        case Constants.TEST_TYPE_RESPIRAT:
            retVal = Constants.RESPIRAT_URL;
            break;
        // 心率
        case Constants.TEST_TYPE_HEARTRATE:
            retVal = Constants.HEARTRATE_URL;
            break;
        // 心电
        case Constants.TEST_TYPE_ELECTORCARDIO:
            retVal = Constants.ELECTORCARDIO_URL;
            break;
        // 酒精
        case Constants.TEST_TYPE_ALCOHOL:
            retVal = Constants.ALCOHOL_URL;
            break;
        // 体温
        case Constants.TEST_TYPE_TEMPERATURE:
            retVal = Constants.TEMPERATURE_URL;
            break;
        // 计步
        case Constants.TEST_TYPE_STEP:
            retVal = Constants.STEP_URL;
            break;
        case Constants.TEST_TYPE_QUICK:
            retVal = Constants.QUICK_URL;
            break;
        default:
            break;
        }

        // 体检类型相同数据处理
        // 问号
        String questionMark = "?";
        // app.getResources().getString(R.string.questionMark);
        // 等于号
        String equalsSign = "=";
        // app.getResources().getString(R.string.equalsSign);
        // & 号
        String and = "&";
        // .getResources().getString(R.string.and);
        // 合并
        retVal += questionMark + Constants.UID_STR
                + equalsSign + user.getUid() + and
                + Constants.MEMBER_ID_STR + equalsSign
                + user.getMemberId() + and
                + Constants.MEMBER_TYPE_STR + equalsSign
                + user.getMemberType() + and
                + Constants.TOKEN_STR + equalsSign
                + user.getToken();
        // 判断是否是分享
        if (isShare) {
            retVal += and + Constants.PAGE_TYPE_STR
                    + equalsSign
                    + Constants.PAGE_TYPE_SHARE;
        } else {
            retVal += and + Constants.PAGE_TYPE_STR
                    + equalsSign
                    + Constants.PAGE_TYPE_RECORD;
        }

        return retVal;
    }
}