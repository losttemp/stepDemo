package com.example.administrator.stepdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.administrator.step.StepService;
import com.example.administrator.step.UpdateUiCallBack;
import com.example.administrator.utils.SPUtils;
import com.example.administrator.utils.ServiceWorkUtils;
import com.example.administrator.utils.TimeAndShareUtils;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.administrator.bean.StepRecordBean;
import com.example.administrator.bean.StepRecordPersonBean;
import com.example.administrator.bean.StepRecordRecultBean;
import com.example.administrator.utils.CalculationUtils;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.HeadBgUtils;
import com.example.administrator.utils.LoginUtils;
import com.example.administrator.utils.NetworkUtils;
import com.example.administrator.utils.SaveFileUtils;
import com.example.administrator.utils.UpLoadUtils;
import com.example.administrator.utils.HealthResultCallback;
import com.example.administrator.view.CircleProgressView;
import com.example.administrator.view.ThreeTextView;
import com.example.administrator.view.WeekTextView;

public class PedometerActivity extends Activity implements
        OnClickListener, OnWeekClickListener {
    private TextView mMore;
    private TextView mConcal;
    private TextView mTitle;
    private TextView mTime;
    private String week = "";
    private WeekTextView mWeek;
    private CircleProgressView mCircleProgress;
    private com.example.administrator.view.ThreeTextView mThreeTVL;
    private com.example.administrator.view.ThreeTextView mThreeTVR;
    private BroadcastReceiver receiver;
    private int mProgress = 0;
    private int index = 0;
    private ArrayList<StepRecordPersonBean> list;
    public static String WEBURI = "webUri";
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0:
                    day = TimeAndShareUtils.getDayTime();
                    mTime.setText(day.split("-")[0]
                            + getResources().getString(
                            R.string.year)
                            + day.split("-")[1]
                            + getResources().getString(
                            R.string.month)
                            + day.split("-")[2]
                            + getResources().getString(
                            R.string.day)
                            + day.split("-")[3]);
                    if (index == 0) {
                        setData(getSeekProgress(), mProgress);
                    }
                    break;

                default:
                    break;
            }
        }

        ;
    };
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedometer);
        HeadBgUtils.headTransparent(this);
        initView();
        initData();
        initReceiver();
    }

    private void initView() {
        mTitle = (TextView) findViewById(R.id.xiaolajiao_head_tv_title);
        mConcal = (TextView) findViewById(R.id.xiaolajiao_head_tv_concal);
        mTv = findViewById(R.id.xiaolajiao_head_tv_text);
        findViewById(R.id.xiaolajiao_head_tv_text)
                .setVisibility(View.INVISIBLE);

        mMore = (TextView) findViewById(R.id.xiaolajiao_more_motion);
        mTime = (TextView) findViewById(R.id.xiaolajiao_time);

        mCircleProgress = (CircleProgressView) findViewById(R.id.xiaolajiao_CircleProgressView);
        mWeek = (WeekTextView) findViewById(R.id.xiaolajiao_week_text);

        mThreeTVL = (ThreeTextView) findViewById(R.id.xiaolajiao_3tv_left);
        mThreeTVR = (ThreeTextView) findViewById(R.id.xiaolajiao_3tv_reight);
    }

    private void initData() {
        day = TimeAndShareUtils.getDayTime();
        mTime.setText(day.split("-")[0]
                + getResources().getString(R.string.year)
                + day.split("-")[1]
                + getResources().getString(R.string.month)
                + day.split("-")[2]
                + getResources().getString(R.string.day)
                + day.split("-")[3]);
        weekStr = new String[]{
                getResources().getString(R.string.monday),
                getResources().getString(R.string.tuesday),
                getResources().getString(R.string.wednesday),
                getResources().getString(R.string.thursday),
                getResources().getString(R.string.friday),
                getResources().getString(R.string.saturday),
                getResources().getString(R.string.sunday)};
        mThreeTVL.setLeftAndRight(
                getResources().getString(R.string.distance),
                getResources().getString(R.string.kilometre));
        mThreeTVR
                .setLeftAndRight(
                        getResources().getString(
                                R.string.quantityHeat),
                        getResources().getString(
                                R.string.kilocalorie));

        mTitle.setText(getResources().getString(
                R.string.movingobjects));
        mConcal.setText(getResources().getString(
                R.string.install));
        mTv.setVisibility(View.VISIBLE);
        mTv.setText("记录");
        //设置当前步数为0
        mCircleProgress.setmTxtHint1(getResources().getString(
                R.string.step_num));
        mWeek.setXiaoLaJiaoWeekOnclickListener(this);
        mMore.setOnClickListener(this);
        mConcal.setOnClickListener(this);
        mTv.setOnClickListener(this);
        initService();
        onShow();
    }

    private void initReceiver() {
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (NetworkUtils.checkNetWork(context)
                        && LoginUtils.isLogin(context)
                        && !PedometerActivity.this.isFinishing()) {
                    LoginUtils.checkLogin(context,
                            new OkHttpResultListener() {

                                @Override
                                public void loginSuccess() {
                                    initRecord();
                                }

                                @Override
                                public void loginFail() {
                                    LoginUtils
                                            .startLogin(PedometerActivity.this);
                                }

                                @Override
                                public void error() {
                                }
                            });

                }
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, filter);
    }

    private void readFile() {
        int[] success = getSuccess();
        if (success != null && success.length > 0) {
            mWeek.setSuccessView(success);
        }
    }


    private void initService() {
        setupService(!ServiceWorkUtils.isServiceWork(this,
                StepService.class.getName()));
    }

    /**
     * 启动service
     *
     * @param flag true-bind和start两种方式一起执行 false-只执行bind方式
     */
    private void setupService(boolean flag) {
        Intent intent = new Intent(this, StepService.class);
        bindService(intent, connStep, Context.BIND_AUTO_CREATE);
        if (flag) {
            startService(intent);
        }
    }
    /**
     * 启动service
     *
     * @param flag
     *            true-bind和start两种方式一起执行 false-只执行bind方式
     */

    /**
     * 用于查询应用服务（application Service）的状态的一种interface，
     * 更详细的信息可以参考Service 和 context.bindService()中的描述，
     * 和许多来自系统的回调方式一样，ServiceConnection的方法都是进程的主线程中调用的。
     */
    private ServiceConnection connStep = new ServiceConnection() {
        /**
         * 在建立起于Service的连接时会调用该方法，目前Android是通过IBind机制实现与服务的连接。
         * @param name 实际所连接到的Service组件名称
         * @param service 服务的通信信道的IBind，可以通过Service访问对应服务
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            StepService stepService = ((StepService.StepBinder) service).getService();
            setData(getSeekProgress(), stepService.getStepCount());
            //设置步数监听回调
            stepService.registerCallback(new UpdateUiCallBack() {
                @Override
                public void updateUi(int stepCount) {
                    setData(getSeekProgress(), stepCount);
                }
            });
        }

        /**
         * 当与Service之间的连接丢失的时候会调用该方法，
         * 这种情况经常发生在Service所在的进程崩溃或者被Kill的时候调用，
         * 此方法不会移除与Service的连接，当服务重新启动的时候仍然会调用 onServiceConnected()。
         * @param name 丢失连接的组件名称
         */
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private Map<String, String> beanMap = null;

    protected void onStart() {
        super.onStart();
        if (!TextUtils.equals(TimeAndShareUtils.getWeek(), week)) {
            setweek();
        }
        if (beanMap == null) {
            beanMap = new HashMap<>();
            beanMap.clear();
            addToMap();
        }

    }

    ;

    public void setweek() {
        week = TimeAndShareUtils.getWeek();
        for (int i = 0; i < weekStr.length; i++) {
            if (TextUtils.equals(weekStr[i], week)) {
                mWeek.setToday(i);
            }
        }
    }

    private void addToMap() {
        for (int i = 0; i < weekStr.length; i++) {
            String fileData = SaveFileUtils.getString(
                    PedometerActivity.this, weekStr[i] + ".txt");
            if (!TextUtils.isEmpty(fileData)) {
                String[] datas = fileData.split("-");
                long time = Long.valueOf(datas[2]) * 1000L;
                String day = TimeAndShareUtils.getStringByDate(time);
                beanMap.put(day, datas[0]);
            }
        }
    }


    private void onShow() {
        if (0 == index) {
            mCircleProgress.setProgress(getSeekProgress());
        } else {
            weekData(index);
        }
    }

    private int getSeekProgress() {
        return SPUtils.getInt(this, Constants.SEEK_PROGRESS) - 1;
    }

    private void weekData(int weekIndex) {
        if (beanMap != null && !beanMap.isEmpty()) {
            String indexString = null;
            for (String time : beanMap.keySet()) {
                if (TextUtils.equals(
                        TimeAndShareUtils.getDayOfWeek(time),
                        getWeek(weekIndex))) {
                    indexString = time;
                }
            }
            if (indexString != null && !TextUtils.isEmpty(indexString)) {
                setData(getSeekProgress(),
                        Integer.valueOf(beanMap.get(indexString)));
            } else {
                setData(-1, 0);
            }
        } else {
            setData(-1, 0);
        }
    }

    private String getWeek(int weekIndex) {
        if (weekIndex < 7) {
            return getWeekList()[6 - weekIndex];
        }
        return "null";
    }

    private void setData(int seekProgress, int progress) {
        Log.d("TAG","seekProgress="+seekProgress+"=progress="+progress);
        if (seekProgress > 0) {
            String kilometreStr = CalculationUtils
                    .floatToStr(CalculationUtils
                            .getKilometre((seekProgress) * 1000 - progress));
            String circleStr = CalculationUtils
                    .floatToStr(CalculationUtils
                            .getCircle(CalculationUtils
                                    .getKilometre((seekProgress) * 1000
                                            - progress)));

            String energyStr = CalculationUtils
                    .floatToStr(CalculationUtils.getEnergy(progress));
            String caloriesStr = CalculationUtils
                    .floatToStr(CalculationUtils
                            .getCalories(CalculationUtils
                                    .getEnergy(progress)));
            setThreeTvText(toZeroOrData(kilometreStr), toZeroOrData(energyStr),
                    circleStr, caloriesStr);
            Log.d("TAG","=1="+circleStr+"=2="+caloriesStr);
            mCircleProgress.setmTxtHint2(getResources().getString(
                    R.string.target)
                    + seekProgress
                    + getResources().getString(R.string.zer));
            mCircleProgress.setMaxProgress(seekProgress * 1000);
            mCircleProgress.setProgress(progress);
        } else if (seekProgress < 0) {
            setThreeTvText("0", "0", "0", "0");
            mCircleProgress.setmTxtHint2(getResources().getString(
                    R.string.target) + 0);
            mCircleProgress.setMaxProgress(0);
            mCircleProgress.setProgress(0);
            index = 7;
        } else {
            String energyStr = CalculationUtils
                    .floatToStr(CalculationUtils.getEnergy(progress));
            String caloriesStr = CalculationUtils
                    .floatToStr(CalculationUtils
                            .getCalories(CalculationUtils
                                    .getEnergy(progress)));

            setThreeTvText("0", toZeroOrData(energyStr), "0",
                    toZeroOrData(caloriesStr));
            mCircleProgress.setmTxtHint2(getResources().getString(
                    R.string.target) + 0);
            mCircleProgress.setMaxProgress(0);
            mCircleProgress.setProgress(progress);
        }
    }

    private String toZeroOrData(String data) {
        return TextUtils.equals("0.0", data) ? "0" : data;
    }

    @Override
    protected void onPause() {
        super.onPause();
        SPUtils.put(this, Constants.STEPS_DATA, mProgress);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xiaolajiao_more_motion:
                if (LoginUtils.isLogin(this)) {
                    Intent tendencyIntent = new Intent(this,
                            MovementTendencyActivity.class);
                    startActivity(tendencyIntent);
                } else {
                    LoginUtils.startLogin(this);
                }
                break;
            case R.id.xiaolajiao_head_tv_concal:
                Intent movingIntent = new Intent(this,
                        MovingobjectsActivity.class);
                movingIntent.putExtra(Constants.STEPS_FIRST, 1);
                startActivity(movingIntent);
                break;
            case R.id.xiaolajiao_head_tv_text:
                startActivity(new Intent(this, HistoryActivity.class));
                break;
            default:
                break;
        }
    }

    private String[] weekStr;

    private int[] getSuccess() {
        String[] weekList2 = getWeekList();
        // 完成目标的角标
        List<String> weekList = new ArrayList<>();
        List<Integer> indextList = new ArrayList<>();
        if (beanMap != null && beanMap.size() > 0) {
            for (String key : beanMap.keySet()) {
                if (Integer.valueOf(beanMap.get(key)) >= getSeekProgress() * 1000) {
                    weekList.add(key);
                }
            }
        } else {
            return null;
        }
        for (int i = 0; i < weekList.size(); i++) {
            for (int j = 0; j < weekList2.length; j++) {
                if (TextUtils.equals(TimeAndShareUtils
                        .getDayOfWeek(weekList.get(i)), weekList2[j])) {
                    indextList.add(j);
                }
            }
        }
        if (indextList.size() <= 0) {
            return null;
        }
        int[] j = new int[indextList.size()];
        for (int i = 0; i < indextList.size(); i++) {
            j[i] = indextList.get(i);
        }
        return j;
    }

    private String[] getWeekList() {
        String week = TimeAndShareUtils.getWeek();
        String[] weekArrayStrings = null;
        if (weekStr != null && weekStr.length > 0) {
            for (int i = 0; i < weekStr.length; i++) {
                if (TextUtils.equals(weekStr[i], week)) {
                    weekArrayStrings = TimeAndShareUtils.getWeekList(
                            i, weekStr);
                }
            }
        }
        return weekArrayStrings;
    }

    @Override
    public void OnWeekClickListener(View v, int position) {
        index = position;
        onShow();
    }

    private void setThreeTvText(String kilometreStr, String energyStr,
                                String circleStr, String caloriesStr) {
        mThreeTVL.setTv_Num(kilometreStr);
        mThreeTVL.setTv_BottomText(getResources().getString(
                R.string.circle1)
                + circleStr
                + getResources().getString(R.string.circle2));
        mThreeTVR.setTv_Num(energyStr);
        mThreeTVR.setTv_BottomText(caloriesStr
                + getResources().getString(R.string.rice));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        unbindService(connStep);
    }

    private void initRecord() {
        // uid
        // token
        // date_time
        Map<String, String> paramMap = new HashMap<String, String>();
        long t = System.currentTimeMillis() / 1000L;
        // 参数处理
        paramMap.put(Constants.UPLOAD_METHOD_KEY,
                Constants.STEPS_RECORD_METHOD_VALUE);
        StepRecordBean recordBean = new StepRecordBean(t);
        recordBean.setUid(LoginUtils.getUser(this).get(
                Constants.XIAOLAJIAO_UID_STR));
        recordBean.setToken(LoginUtils.getUser(this).get(
                Constants.XIAOLAJIAO_TOKEN_STR));
        String sign = "date_time=" + recordBean.getDate_time() + "&token="
                + recordBean.getToken() + "&uid=" + recordBean.getUid() + "&"
                + t;
        Log.e("Health", "initRecord  sign: " + sign);
        paramMap = UpLoadUtils.putParamAndEncrypted(paramMap,
                recordBean, sign, t);
        OkHttpClientManager.postAsyn(Constants.COMMON_URL, paramMap,
                callback, this);
    }

    HealthResultCallback<String> callback = new HealthResultCallback<String>() {

        @Override
        public void onError(Request request, Exception e) {
            Log.e("Health", "onError == " + e.toString());
        }

        @Override
        public void onResponse(String response) {
            Log.e("aaaa", response);
            if (response.contains("succ") && response.contains("10000")) {
                StepRecordRecultBean recultBean = new Gson()
                        .fromJson(response,
                                StepRecordRecultBean.class);
                if (10000 == Integer.valueOf(recultBean.getStatus())
                        && TextUtils.equals("succ", recultBean.getInfo())) {
                    ArrayList<String> dates = recultBean.getData().getDates();
                    list = recultBean.getData().getList();
                    if (dates != null && dates.size() > 0) {
                        // deleteFile();
                        saveDay(dates, list);
                        if (beanMap == null) {
                            beanMap = new HashMap<>();
                        }
                        beanMap.clear();
                        addToMap();
                    }
                }
                // Xiaolajiao <NullPointException> <lizhi> <20170425> modify
                // begin
                if (list != null && list.size() > 0) {
                    readFile();
                }
                // Xiaolajiao <NullPointException> <lizhi> <20170425> modify end
            }
        }

        @Override
        public void onBefore(Request request) {
            // 网络数据上传开始
        }

        @Override
        public void onAfter() {
            // 网络数据上传结束。
        }
    };
    private String day;

    protected void saveDay(ArrayList<String> dates,
                           ArrayList<StepRecordPersonBean> list2) {
        String week2;
        for (int j = 0; j < list2.size(); j++) {
            for (int i = 0; i < dates.size(); i++) {
                if (TextUtils.equals(dates.get(i), list2.get(j)
                        .getCreate_time())) {
                    week2 = TimeAndShareUtils.getDayOfWeek(dates
                            .get(i));
                    String week3 = TimeAndShareUtils.getWeek();
                    if (!TextUtils.equals(week2, week3)) {
                        SaveFileUtils
                                .saveString(
                                        PedometerActivity.this,
                                        week2 + ".txt",
                                        list2.get(j).getSteps()
                                                + "-"
                                                + getSeekProgress()
                                                * 1000
                                                + "-"
                                                + TimeAndShareUtils
                                                .getDateByStr2(
                                                        list2.get(j)
                                                                .getCreate_time())
                                                .getTime() / 1000 + "-"
                                                + String.valueOf(true));
                        Log.e("fileName", list2.get(j).toString());
                    }
                }
            }
        }
    }
}
