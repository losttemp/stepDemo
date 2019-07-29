package com.example.administrator.utils;


public class Constants {


    // 公共、常用的常量
    public static final String DATE_FORMATE = "yyyy年MM月dd日 HH:mm";

    // 用户相关信息块 历史记录和分享页面
    public static final String PAGE_TYPE_RECORD = "record";
    public static final String PAGE_TYPE_SHARE = "share";

    // WEB URI 相关信息块
    // 血压
    public static final String BLOODPRESURE_URL = "http://sensor.hongniao.cn/jk/public/web/record/bloodpressure";
    // 血氧
    public static final String BLOODOXYGEN_URL = "http://sensor.hongniao.cn/jk/public/web/record/bloodoxygen";
    // 呼吸率
    public static final String RESPIRAT_URL = "http://sensor.hongniao.cn/jk/public/web/record/respiratoryrate";
    // 心率
    public static final String HEARTRATE_URL = "http://sensor.hongniao.cn/jk/public/web/record/heartrate";
    // 心电
    public static final String ELECTORCARDIO_URL = "http://sensor.hongniao.cn/jk/public/web/record/electrocardio";
    // 酒精
    public static final String ALCOHOL_URL = "http://sensor.hongniao.cn/jk/public/web/record/alcohol";
    // 体温
    public static final String TEMPERATURE_URL = "http://sensor.hongniao.cn/jk/public/web/record/temperature";
    // 计步
    public static final String STEP_URL = "http://sensor.hongniao.cn/jk/public/web/record/step";
    // 快速测量血压
    public static final String QUICK_URL = "http://sensor.hongniao.cn/jk/public/web/record/bloodpressurequick";

    // 了解相关知识
    public static final String KNOW_HEAD = "http://sensor.hongniao.cn/jk/public/template/knowledge/";




    // 数据存储KEY 相关块
    // SP文件的名字
    public static final String SP_FILE_NAME = "sp_file";
    // uid
    public static final String UID_STR = "uid";
    // member_id
    public static final String MEMBER_ID_STR = "member_id";
    // member_type
    public static final String MEMBER_TYPE_STR = "member_type";
    // token
    public static final String TOKEN_STR = "token";
    // page_type
    public static final String PAGE_TYPE_STR = "page_type";


    // 血压
    public static final int TEST_TYPE_BLOODPRESURE = 0;
    // 血氧
    public static final int TEST_TYPE_BLOODOXYGEN = 1;
    // 呼吸率
    public static final int TEST_TYPE_RESPIRAT = 2;
    // 心率
    public static final int TEST_TYPE_HEARTRATE = 3;
    // 心电
    public static final int TEST_TYPE_ELECTORCARDIO = 4;
    // 酒精
    public static final int TEST_TYPE_ALCOHOL = 5;
    // 体温
    public static final int TEST_TYPE_TEMPERATURE = 6;
    // 计步
    public static final int TEST_TYPE_STEP = 7;
    // 快捷测血压
    public static final int TEST_TYPE_QUICK = 8;


    public static final int DEFAULT_NOW_TIME = 2017;






    // 网络接口模块
    // http://sensor.hongniao.cn/jk/public/
    // http://sensor.hong-niao.com/jk/public/api/1.0
    public static final String COMMON_URL = "http://sensor.hongniao.cn/jk/public/api/1.0";
    public static final String UPLOAD_METHOD_KEY = "method";
    public static final String VERSION_KEY = "v";
    public static final String VERSION_VALUE = "1.0";
    public static final String UPLOAD_TIME_KEY = "t";
    public static final String UPLOAD_APPID_KEY = "app_id";
    public static final String UPLOAD_APPID_VALUE = "1";
    public static final String UPLOAD_APP_SECRET_KEY = "app_secret";
    public static final String UPLOAD_APP_SECRET_VALUE = "3ebf775745ca680edeeb8f0a961800f9";
    public static final String UPLOAD_BODY_KEY = "body";
    public static final String UPLOAD_SIGN_KEY = "sign";
    public static final String GET_USER_DETAIL = "com.get.user.detail";

    public static final int REQUSET_RESULT = 13;

    public static final String STEPS_RECORD_METHOD_VALUE = "com.get.step.record";





    public static final String UID = "uid";
    public static final String TOKEN = "token";
    public static final String SEEK_PROGRESS = "seek_progress";
    public static final String STEPS_FIRST = "steps_first";


    // 计步
    public static final String STEPS_FILE_NAME = "steps_file_name";
    public static final String STEP_RECORD = "step_record";
    public static final String STEPS_DATA = "step_data";
    public static final String STEPS_NOTI = "steps_noti";
    public static final String STEPS_WAITING = "steps_waiting";
}
