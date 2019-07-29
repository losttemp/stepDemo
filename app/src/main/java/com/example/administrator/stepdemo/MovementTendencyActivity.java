package com.example.administrator.stepdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.utils.Constants;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;

import com.example.administrator.bean.StepsUserDataBean;
import com.example.administrator.bean.UserBean;
import com.example.administrator.utils.HeadBgUtils;
import com.example.administrator.utils.LoginUtils;
import com.example.administrator.utils.NetworkUtils;
import com.example.administrator.utils.UpLoadUtils;
import com.example.administrator.utils.WebUtils;
import com.example.administrator.utils.HealthResultCallback;


public class MovementTendencyActivity extends Activity
        implements OnClickListener {
    private TextView mTitle;
    private Button back;
    private Button mShare;
    private String mWebUrl;
    private UserBean muserbean;
    private BroadcastReceiver receiver;
    private LinearLayout mNoNetwork;
    private LinearLayout mHasNetwork;
    private TextView mSex;
    private TextView mName;
    private TextView mAge;
    private WebView wv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info_movement_tendency);
        HeadBgUtils.headTransparent(this);
        initView();
        initData();
        initReceiver();
    }

    private void initView() {
        findViewById(R.id.historical_record_send).setVisibility(View.GONE);

        mNoNetwork = (LinearLayout) findViewById(R.id.noNetwork);
        mHasNetwork = (LinearLayout) findViewById(R.id.hasNetwork);

        back = (Button) findViewById(R.id.historical_record_back);
        mTitle = (TextView) findViewById(R.id.head_tv_title);
        mShare = (Button) findViewById(R.id.historical_record_send);
        mSex = (TextView) findViewById(R.id.personal_info_sex);
        mName = (TextView) findViewById(R.id.personal_info_name);
        mAge = (TextView) findViewById(R.id.personal_info_age);
        wv = (WebView) findViewById(R.id.personal_info_wv);
        mWaiting = (LinearLayout) findViewById(R.id.l_waiting);
    }

    private void initData() {
        mTitle.setText(getResources().getString(
                R.string.personal_info_movement_tendency));
        back.setText(getResources().getString(
                R.string.my_return));
        mShare.setText(getResources().getString(
                R.string.share_text));
        back.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initPerson();
        hideOrShow();
    }

    private void initPerson() {
        if (muserbean == null) {
            muserbean = new UserBean();
        }
        String uid = LoginUtils.getUser(this).get(
                Constants.UID_STR);
        String token = LoginUtils.getUser(this).get(
                Constants.TOKEN_STR);
        if (null != uid && null != token && !TextUtils.isEmpty(uid)) {
            muserbean = new UserBean();
            muserbean.setUid(uid);
            muserbean.setToken(token);
            muserbean.setMemberId(Integer.valueOf(uid));
            muserbean.setMemberType(1);
        }
    }

    private void hideOrShow() {
        if (NetworkUtils.checkNetWork(this)) {
            mHasNetwork.setVisibility(View.VISIBLE);
            mNoNetwork.setVisibility(View.GONE);
            mShare.setVisibility(View.VISIBLE);
            mShare.setOnClickListener(this);
            LoginUtils.checkLogin(this,
                    new OkHttpResultListener() {
                        @Override
                        public void loginSuccess() {
                            initUserData();
                            mWebUrl = WebUtils
                                    .createHistoryWebUrl(
                                            muserbean,
                                            Constants.TEST_TYPE_STEP,
                                            false);
                            load(wv);
                        }

                        @Override
                        public void loginFail() {
                            LoginUtils
                                    .startLogin(MovementTendencyActivity.this);
                        }

                        @Override
                        public void error() {

                        }
                    });
        } else {
            mNoNetwork.setVisibility(View.VISIBLE);
            mHasNetwork.setVisibility(View.GONE);
            mShare.setVisibility(View.INVISIBLE);
            findViewById(R.id.tv_no_network)
                    .setOnClickListener(this);
        }
    }

    private void setData(String name, int sex, String birth) {
        mName.setText(name);
        mSex.setText(sex == 1 ? "男" : "女");
        if (!TextUtils.isEmpty(birth)) {
            String[] birthArray = birth.split("-");
            birth = birthArray[0] + "." + birthArray[1];
            mAge.setText(birth);
        } else {
            mAge.setText("");
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void load(WebView wv) {
        wv.loadUrl(mWebUrl);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mWaiting.setVisibility(View.INVISIBLE);
            }
        });
        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
    }

    private void initReceiver() {
        receiver = NetworkUtils.registerNetworkReceiver(this,
                new NetworkListener() {

                    @Override
                    public void networkListener() {
                        if (!NetworkUtils
                                .checkNetWork(MovementTendencyActivity.this)) {
                            hideOrShow();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.historical_record_back:
            MovementTendencyActivity.this.finish();
            break;
        case R.id.tv_no_network:
            hideOrShow();
            break;
        case R.id.historical_record_send:
            // TimeAndShareUtils.shareMsg(this,
            // getShareUri(Constants.TEST_TYPE_STEP));

            break;
        default:
            break;
        }
    }

    // private String getShareUri(int constants) {
    // return WebUtils.createHistoryWebUrl(muserbean, constants,
    // true);
    // }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    private void initUserData() {
        UpLoadUtils.getUserData(
                MovementTendencyActivity.this, callback);
    }

    HealthResultCallback<String> callback = new HealthResultCallback<String>() {

        @Override
        public void onError(Request request, Exception e) {
            Log.e("onError", e + "");
        }

        @Override
        public void onResponse(String response) {
            Log.e("onResponse", response);
            Log.e("uid",
                    LoginUtils
                            .getUser(
                                    MovementTendencyActivity.this)
                            .get(Constants.UID_STR));
            StepsUserDataBean userDataBean = new Gson().fromJson(
                    response, StepsUserDataBean.class);
            if (userDataBean != null && userDataBean.getStatus() == 10000) {
                setData(userDataBean.getData().getUser_name() == null ? (MovementTendencyActivity.this.getResources().getString(R.string.myselfe))
                        : userDataBean.getData().getUser_name(),
                        Integer.valueOf(TextUtils.isEmpty(userDataBean
                                .getData().getUser_sex()) ? "1" : userDataBean
                                .getData().getUser_sex()), userDataBean
                                .getData().getUser_birthday());
            }
        }

        @Override
        public void onBefore(Request request) {
            Log.e("onBefore", request + "");
        }

        @Override
        public void onAfter() {
            Log.e("onAfter", "onAfter");
        }
    };
    private LinearLayout mWaiting;
}
