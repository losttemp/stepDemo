package com.example.administrator.utils;


public class Constants {

    // 测试接口 后期删除 测试接口放在最前面，方便后期删除
    // XiaoLaJiaoHTTP地址接口
    public static String XIAOLAJIAO_RECORD_URL = "http://sensor.hongniao.cn/jk/public/web/record";
    public static String HOST_SERVER = "/temperature?uid=1&member_id=1&member_type=1&token=c4ca4238a0b923820dcc509a6f75849b&page_type=record";

    // 公共、常用的常量
    public static final String XIAOLAJIAO_DATE_FORMATE = "yyyy年MM月dd日 HH:mm";
    public static final String THREVALUE = "threvalue";
    public static final String BLOODOXVALUE = "bloodoxvalue";
    // 用户相关信息块 历史记录和分享页面
    public static final String XIAOLAJIAO_PAGE_TYPE_RECORD = "record";
    public static final String XIAOLAJIAO_PAGE_TYPE_SHARE = "share";

    // WEB URI 相关信息块
    // 血压
    public static final String XIAOLAJIAO_BLOODPRESURE_URL = "http://sensor.hongniao.cn/jk/public/web/record/bloodpressure";
    // 血氧
    public static final String XIAOLAJIAO_BLOODOXYGEN_URL = "http://sensor.hongniao.cn/jk/public/web/record/bloodoxygen";
    // 呼吸率
    public static final String XIAOLAJIAO_RESPIRAT_URL = "http://sensor.hongniao.cn/jk/public/web/record/respiratoryrate";
    // 心率
    public static final String XIAOLAJIAO_HEARTRATE_URL = "http://sensor.hongniao.cn/jk/public/web/record/heartrate";
    // 心电
    public static final String XIAOLAJIAO_ELECTORCARDIO_URL = "http://sensor.hongniao.cn/jk/public/web/record/electrocardio";
    // 酒精
    public static final String XIAOLAJIAO_ALCOHOL_URL = "http://sensor.hongniao.cn/jk/public/web/record/alcohol";
    // 体温
    public static final String XIAOLAJIAO_TEMPERATURE_URL = "http://sensor.hongniao.cn/jk/public/web/record/temperature";
    // 计步
    public static final String XIAOLAJIAO_STEP_URL = "http://sensor.hongniao.cn/jk/public/web/record/step";
    // 快速测量血压
    public static final String XIAOLAJIAO_QUICK_URL = "http://sensor.hongniao.cn/jk/public/web/record/bloodpressurequick";

    // 了解相关知识
    public static final String KNOW_HEAD = "http://sensor.hongniao.cn/jk/public/template/knowledge/";
    // 了解相关知识环境测量
    public static final String KNOW_HEAD_ENVIRONMENT = "http://sensor.hongniao.cn/jk/public/web/record/";

    // 了解相关知识的TYPE
    public static final String KNOW_KEY = "knowlege";
    // 血压
    public static final String KNOW_PRESSURE = "pressure.html";
    // 血氧
    public static final String KNOW_OXYGEN = "oxygen.html";
    // 呼吸率
    public static final String KNOW_BREATHE = "breathe.html";
    // 心率
    public static final String KNOW_HEART_RATE = "heart-rate.html";
    // 心电
    public static final String KNOW_ELECTROCARDIO = "electrocardio.html";
    // 酒精
    public static final String KNOW_ALCOHOL = "alcohol.html";
    // 体温
    public static final String KNOW_TEMPERATURE = "temperature.html";
    // 温湿度
    public static final String KNOW_HUMIDITY = "temperature-circumstance.html";
    // 气压海拔
    public static final String KNOW_BAROMETRIC = "barometric-altitude.html";
    // 紫外线
    public static final String KNOW_UV = "ultraviolet.html";
    // 登录时需要的uri
    public static final String LOGIN = "content://com.xiaolajiao.loginmanager.provider/info";
    // 字符拼接时需要用到的

    // 数据存储KEY 相关块
    // SP文件的名字
    public static final String XIAOLAJIAO_SP_FILE_NAME = "xiaolajiao";
    public static final String XIAOLAJIAO_LIST_BG = "list_bg";
    // uid
    public static final String XIAOLAJIAO_UID_STR = "uid";
    // member_id
    public static final String XIAOLAJIAO_MEMBER_ID_STR = "member_id";
    // member_type
    public static final String XIAOLAJIAO_MEMBER_TYPE_STR = "member_type";
    // token
    public static final String XIAOLAJIAO_TOKEN_STR = "token";
    // page_type
    public static final String XIAOLAJIAO_PAGE_TYPE_STR = "page_type";

    // 测量类型 常量块
    // 非法类型
    public static final int XIAOLAJIAO_TEST_TYPE_INVALID = -1;
    // 血压
    public static final int XIAOLAJIAO_TEST_TYPE_BLOODPRESURE = 0;
    // 血氧
    public static final int XIAOLAJIAO_TEST_TYPE_BLOODOXYGEN = 1;
    // 呼吸率
    public static final int XIAOLAJIAO_TEST_TYPE_RESPIRAT = 2;
    // 心率
    public static final int XIAOLAJIAO_TEST_TYPE_HEARTRATE = 3;
    // 心电
    public static final int XIAOLAJIAO_TEST_TYPE_ELECTORCARDIO = 4;
    // 酒精
    public static final int XIAOLAJIAO_TEST_TYPE_ALCOHOL = 5;
    // 体温
    public static final int XIAOLAJIAO_TEST_TYPE_TEMPERATURE = 6;
    // 计步
    public static final int XIAOLAJIAO_TEST_TYPE_STEP = 7;
    // 快捷测血压
    public static final int XIAOLAJIAO_TEST_TYPE_QUICK = 8;
    public static final String HISTORICAL = "historical";
    public static final String ITEM_BACK = "item_back";
    public static final String MESUREMENT = "mesurement";
    public static final String EDIT_TITLE = "edit_title";
    // 体温数值
    public static final double TEMPERTURA = 36.5;
    public static final double TEMPERTURB = 37.2;
    public static final double TEMPERTURC = 36;
    public static final double TEMPERTURD = 38;
    public static final double TEMPERTURE = 38.1;
    public static final double TEMPERTURF = 39;
    public static final double TEMPERTURG = 39.1;
    public static final double TEMPERTURH = 41;
    public static final double TEMPERTURI = 42;
    public static final double TEMPERTURJ = 28;
    // 血氧数值
    public static final int BLOODOXYGENA = 80;
    public static final int BLOODOXYGENB = 95;

    public static final int BLOODOXYGENC = 99;
    // 血压数值
    public static final int BLOODPRESSUREA = 60;
    public static final int BLOODPRESSUREB = 80;
    public static final int BLOODPRESSUREC = 85;
    public static final int BLOODPRESSURED = 89;
    public static final int BLOODPRESSUREE = 90;
    public static final int BLOODPRESSUREF = 99;
    public static final int BLOODPRESSUREG = 100;
    public static final int BLOODPRESSUREH = 109;
    public static final int BLOODPRESSUREI = 120;
    public static final int BLOODPRESSUREJ = 130;
    public static final int BLOODPRESSUREk = 139;
    public static final int BLOODPRESSUREL = 140;
    public static final int BLOODPRESSUREM = 159;
    public static final int BLOODPRESSUREN = 160;
    public static final int BLOODPRESSUREO = 179;
    public static final int BLOODPRESSUREP = 180;
    // 心电数值/心率/呼吸
    public static final int CARDIOGRAMIN = 40;
    public static final int CARDIOGRAMA = 60;
    public static final int CARDIOGRAMB = 100;
    public static final int CARDIOGRAMC = 160;
    public static final int CARDIOGRAMNUMAL = 180;
    public static final int RESPIRATORYRATA = 12;
    public static final int RESPIRATORYRATB = 16;
    public static final int RESPIRATORYRATC = 20;
    // 知识页面

    // 系统默认时间
    public static final int DEFAULT_NOW_TIME = 2017;
    // 体温
    public static final String TEMPERATURE = "temperature";
    // 心电
    public static final String HEARTRATE = "heart-rate";
    // 文件名
    // twzd
    // 您好，点击开始按钮后，将手机背面体温计对准额头1.5-3厘米（约拇指宽度），倒计时结束后，测量会自动开始
    public static final String g_BEFORE_TEMPERATURE = "twzd.ogg";
    // twdz
    // 请将体温计对准额头
    public static final String g_COUNT_BROW = "twdz.ogg";
    // 321
    // 3，2，1(S)
    public static final String g_COUNT_DOWN = "321.ogg";
    // clks
    // 测量开始
    public static final String g_START_TEMPERATURE = "clks.ogg";
    public static final String g_START_BLOODPRESSURE = "clks.ogg";
    // clsb
    // 测量失败，请重新测量
    public static final String g_FAIL = "clsb.ogg";
    // cljsxx
    // 测量结束，谢谢
    public static final String g_END_THANKS = "cljsxx.ogg";
    // xdzd
    // 您好，请将手机横握，两手食指分别摁压在体温和血氧的两个触片上，测量开始后保持20-30秒不动
    public static final String g_BLOODPRESSURE_BLOODOXYGEN = "xdzd.ogg";
    // xdclks
    // 测量开始，请不要移开您的手指
    public static final String g_STARTS = "xdclks.ogg";
    // jjclks
    // 您好，首次点击“开始测量”按钮后，传感器将预热10S
    public static final String g_FIRST_START = "jjclks.ogg";
    // jjzd
    // 请对准手机下端橘红色酒杯口不间断吹气3到5秒
    public static final String g_BLOWING = "jjzd.ogg";
    // kscq
    // 请开始吹气
    public static final String g_START_BLOW = "kscq.ogg";
    // xyzd
    // 您好，请将食指轻搭在血氧传感器上，测量开始后保持10S不动
    public static final String g_BLOODOXYGEN = "xyzd.ogg";
    // xazd1
    // 您好，请打开血压计外设开关，确保蓝牙连接成功
    public static final String g_BLUETOOTH = "xazd1.ogg";
    // xazd2
    // 将袖套戴在胳膊上，捆绑臂带时，臂带不可过松或者过紧，也不要留有缝隙
    public static final String g_TONOMETER = "xazd2.ogg";
    // xazd3
    // 点击开始后，袖套开始充气，测量过程历时约30S。测量过程中请坐正，使臂带与心脏处于同一高度。手掌不要用力、不要握拳，自然张开
    public static final String g_INFLATION = "xazd3.ogg";
    // cljs1
    // 测量结束
    public static final String g_END = "cljs1.ogg";
    // xajgd
    // 您的血压值低于国际正常标准，请复测，如结果依旧偏低，建议尽快就医。
    public static final String g_LOWBLOODPRESSURE = "xajgd.ogg";

    // xajgz
    // 您的血压值处于国际正常标准，祝您身体健康。
    public static final String g_BLOODPRESSURE = "xajgz.ogg";
    // xajgg
    // 您的血压值高于国际正常标准，请复测，如结果依旧偏高，建议立即就医。
    public static final String g_HIGHBLOODPRESSURE = "xajgg.ogg";
    // xyjgd
    // 您的血氧值低于国际正常标准，请复测，如结果依旧偏低，建议尽快就医。
    public static final String g_LOWOXYGENVALUE = "xyjgd.ogg";
    // xyjgz
    // 您的血氧值处于国际正常标准，祝您身体健康。
    public static final String g_OXYGENVALUE = "xyjgz.ogg";
    // twjgd
    // 您的体温低于国际正常标准，请复测，如结果依旧偏低，建议尽快就医。
    public static final String g_LOWTEMPERATURE = "twjgd.ogg";
    // twjgz
    // 您的体温处于国际正常标准，祝您身体健康。
    public static final String g_TEMPERATURE = "twjgz.ogg";
    // twjgdr
    // 您的体温处于低热范围，建议尽快就医。
    public static final String g_LOWHEATTEMPERATURE = "twjgdr.ogg";
    // twjgzr
    // 您的体温处于中热范围，建议尽快就医。
    public static final String g_MIDDLETEMPERATURE = "twjgzr.ogg";
    // twjggr
    // 您的体温处于高热范围，请复测，如结果依旧偏高，建议立即就医。
    public static final String g_HIGHHEATTTEMPERATURE = "twjggr.ogg";
    // twjgcgr
    // 您的体温处于超高热范围，请复测，如结果依旧偏高，建议立即就医。
    public static final String g_MAXHEATTEMPERATURE = "twjgcgr.ogg";
    // xljgd
    // 您的心率值低于国际正常标准，请复测，如结果依旧偏低，建议尽快就医。
    public static final String g_LOWHEARTRATE = "xljgd.ogg";
    // xljgz
    // 您的心率值处于国际正常标准，祝您身体健康。
    public static final String g_HEARTRATE = "xljgz.ogg";
    // xljgg
    // 您的心率值高于国际正常标准，请复测，如结果依旧偏高，建议立即就医。
    public static final String g_HIGTHEARTRATE = "xljgg.ogg";
    // hxjgd
    // 您的呼吸率低于国际正常标准，请复测，如结果依旧偏低，建议尽快就医。
    public static final String g_LOWRESPIRATORYRATE = "hxjgd.ogg";
    // hxjgz
    // 您的呼吸率处于国际正常标准，祝您身体健康。
    public static final String g_RESPIRATORYRATE = "hxjgz.ogg";
    // hxjgg
    // 您的呼吸率高于国际正常标准，请复测，如结果依旧偏高，建议立即就医。
    public static final String g_HIGHRESPIRATORYRATE = "hxjgg.ogg";
    // xazd4
    // 为了能完成测量，请先选择测量人并完善信息；准备好测量姿势后按下“开始测量”按钮
    public static final String g_QUICKBLOODPRESSED_ONE = "xazd4.ogg";
    // xazd5
    // 请将手机横握，左手手指放置在触片A上，右手手指放置在触片B上，测量开始后保持20-30秒不动
    public static final String g_QUICKBLOODPRESSED_TWO = "xazd5.ogg";

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
    public static final String BOOLDOXYGEN_UPLOAD_METHOD_VALUE = "com.set.bloodoxygen.upload";
    public static final String GET_MEDICAL_EXAM_LIST = "com.get.physical.list";
    public static final String BOOLDPRESSURE_UPLOAD_METHOD_VALUE = "com.set.bloodpressure.upload";
    public static final String RESPIRATORYRATE_UPLOAD_METHOD_VALUE = "com.set.respiratoryrate.upload";
    public static final String HEARTRATE_UPLOAD_METHOD_VALUE = "com.set.heartrate.upload";
    public static final String PHYSICAL_EXAM_UPLOAD_METHOD_VALUE = "com.set.physical.upload";
    public static final String GET_CONTACTS_LIST = "com.get.contacts.list";
    public static final String GET_USER_DETAIL = "com.get.user.detail";
    public static final String DELTE_MEDIA_EXAM = "com.set.physical.del";
    // 快速测血压
    public static final String DATA_USER_LIST = "com.get.contacts.listquick";
    public static final String NEW_USER_UPLOAD_QUICK = "com.set.contacts.record";
    public static final String PERSON_DATA_QUICK = "com.set.contacts.update";
    public static final String USER_DATA_QUICK = "com.get.user.detailquick";
    public static final String UPLOAD_DATA_QUICK = "com.set.bloodpressurequick.upload";
    // 体温
    public static final String TEMPERATUR_UPLOAD_METHOD_VALUE = "com.set.temperature.upload";
    // 心电
    public static final String ELECTROCARDIO_UPLOAD_METHOD_VALUE = "com.set.electrocardio.upload";
    public static final int REQUSET_RESULT = 13;
    public static final int REQUSET_ARCH = 10;
    public static final String CHOOSE_USER = "choose_user";
    public static final String CARD_VALUE = "card_value";
    public static final String HR_VALUR = "hr_valur";
    public static final String BR_VALUE = "br_value";
    public static final String HIS_CHOOSE_USER = "his_choose_user";
    public static final String STEPS_UPLOAD_METHOD_VALUE = "com.set.step.upload";
    public static final String STEPS_USER_METHOD_VALUE = "com.get.step.target";
    public static final String STEPS_TARGET_METHOD_VALUE = "com.set.step.target";
    public static final String STEPS_RECORD_METHOD_VALUE = "com.get.step.record";
    public static final String ALCOHOL_UPLOAD_METHOD_VALUE = "com.set.alcohol.upload";
    public static final String PHYSICAL_RECORD_METHOD_VALUE = "com.get.physical.record";
    public static final String BLOODSUGAR_UPLOAD_METHOD_VALUE = "com.set.bloodsugar.upload";
    public static final String NEW_USER_UPLOAD = "com.set.contacts.add";
    public static final String NEW_USER_PERSONAL_UPDATA = "com.set.contacts.update";
    public static final String DELETE_UPLOAD = "com.set.record.del";

    // 删除模块
    // 心电
    public static final String DELETE_ELECTROCARDIO = "electrocardio";
    // 血压
    public static final String DELETE_BLOODPRESSURE = "bloodpressure";
    // 血氧
    public static final String DELETE_BLOODOXYGEN = "bloodoxygen";
    // 呼吸率
    public static final String DELETE_RESPIRATORYRATE = "respiratoryrate";
    // 心率
    public static final String DELETE_HEARTRATE = "heartrate";
    // 体温
    public static final String DELETE_TEMPERATURE = "temperature";
    // 酒精
    public static final String DELETE_ALCOHOL = "alcohol";
    // 快捷血压
    public static final String DELETE_BLOODPRESSURE_QUICK = "bloodpressure_quick";

    // 测量结果关键字
    public static final String ALCOHOL_DATA = "alcohol";
    public static final String ENVIRON_UV = "environ_uv";
    public static final String FILENAME = "fileName";
    public static final String CHOOSE_PERSON = "choose_person";
    public static final String TV_SIZE = "textsize";
    public static final String HISTORY = "xiaolajiao_history";
    public static final String KNOWLEGE = "xiaolajiao_knowlege";
    public static final String VOICE = "xiaolajiao_voice";
    public static final String WAIT_TIME = "xiaolajiao_waitTime";
    public static final String COUNT_DOWN_TITLE = "xiaolajiao_countDownTitle";
    public static final String WANTCLASSNAME = "xiaolajiao_wantClassName";
    public static final String VOICE_URI = "xiaolajiao_voice_uri";
    public static final String PIC_RESID = "xiaolajiao_pic_resId";
    public static final String COUNT_DOWN_TEXT = "xiaolajiao_countdown_text";
    public static final String CHECKED_VIEW = "xiaolajiao_men_or_women";
    public static final String PERSONAL_INFO = "xiaolajiao_personal_info";
    public static final String Moving_TARGET = "xiaolajiao_moving_target";
    public static final String UID = "uid";
    public static final String TOKEN = "token";
    public static final String SEEK_PROGRESS = "seek_progress";
    public static final String STEPS_FIRST = "steps_first";
    public static final String ALCOHOL_KNOWLEGESTRING = "Alcohol_knowlege";
    public static final String RPE_FIRST_LOGIN = "rpe_first_login";
    public static final String MEASURE_FLAG = "measure_flag";
    public static final String THERMOMETER_FIST_LOGIN = "thermometer_fist_login";
    public static final String MEASURE_STATUS = "measure_status";
    public static final String PROGRESS = "progress";
    public static final String USERS = "users";
    public static final String USER = "user";
    public static final String RECURT = "recurt";
    public static final String IS_DEFAULT = "is_default";
    public static final String VOICE_KEY = "voice_key";

    // 文件名
    // 计步
    public static final String STEPS_FILE_NAME = "steps_file_name";
    public static final String STEP_RECORD = "step_record";
    public static final String STEPS_DATA = "step_data";
    public static final String STEPS_NOTI = "steps_noti";
    public static final String STEPS_WAITING = "steps_waiting";
}
