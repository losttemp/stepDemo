package com.example.administrator.stepdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.example.administrator.utils.CalculationUtils;
import com.example.administrator.utils.Constants;
import com.example.administrator.utils.HeadBgUtils;
import com.example.administrator.utils.SPUtils;


public class MovingobjectsActivity<T> extends Activity implements
        OnClickListener, OnSeekBarChangeListener {
    private TextView mMovingObjects;
    private SeekBar mMovingSeek;
    private int mProgress;
    // max改变时对应progress也需要微调，在监听中也需要对限定做出改变
    // 改变后以界面实际效果为准
    // 一般max相对用户要求要大一点，方便在后面限制时可以符合相对客户对max的要求
    // 如客户要求50，我取54，对起始点限制对终点限制，去除限制的两端，中间的progress还剩50
    //
    private int mMax = 32;
    private TextView mProgressConsume;
    private int firstLogin;

    // private ResultCallback<T> callback = new ResultCallback<T>() {
    //
    // @Override
    // public void onError(Request request, Exception e) {
    // }
    //
    // @Override
    // public void onResponse(T response) {
    // }
    // };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moving_objects);
        HeadBgUtils.headTransparent(this);
        initActivity();
    }

    private void initActivity() {
        // 从桌面跳转：0，从计步界面跳转：1
        firstLogin = getIntent()
                .getIntExtra(Constants.STEPS_FIRST, 0);
        if (firstLogin == 0) {
            if (SPUtils.getInt(this, Constants.STEPS_FIRST,
                    0) == 0) {
                initViewFirst();
            } else {
                startActivity(new Intent(this,
                        PedometerActivity.class));
                finish();
            }
        } else {
            initView();
        }
    }

    private void initViewFirst() {
        findViewById(R.id.activity_chooseuser_finish).setVisibility(
                View.INVISIBLE);
        TextView mTitle = (TextView) findViewById(R.id.xiaolajiao_head_tv_title);
        mTitle.setText(getResources().getString(
                R.string.daytarget));
    }

    private void initView() {
        Button mFinish = (Button) findViewById(R.id.activity_chooseuser_finish);
        TextView title = (TextView) findViewById(R.id.xiaolajiao_head_tv_title);
        title.setText(getResources().getString(
                R.string.install));
        findViewById(R.id.xiaolajiao_moving_objects_tv).setVisibility(
                View.VISIBLE);
        mFinish.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (SPUtils.getInt(this, Constants.STEPS_FIRST, 0) == 0
                && SPUtils.getInt(this,
                        Constants.SEEK_PROGRESS, 0) - 1 != 0) {
            SPUtils.put(this, Constants.STEPS_FIRST, 1);
        }
    }

    private void initData() {
        Button mEnsure = (Button) findViewById(R.id.activity_chooseuser_ensure);
        mProgressConsume = (TextView) findViewById(R.id.xiaolajiao_moving_progress_tv_consume);
        mMovingObjects = (TextView) findViewById(R.id.xiaolajiao_moving_objects);
        mMovingSeek = (SeekBar) findViewById(R.id.xiaolajiao_moving_progress);
        mEnsure.setText(getResources().getString(
                R.string.finish));
        mEnsure.setOnClickListener(this);
        mMovingSeek.setOnSeekBarChangeListener(this);
        mMovingSeek.setMax(mMax);
        mProgress = SPUtils.getInt(this,
                Constants.SEEK_PROGRESS);
        calories((mProgress - 1) * 1000);
        if (mProgress < 1) {
            mProgress = 5;
            SPUtils.put(this, Constants.SEEK_PROGRESS, 5);
        }
        mMovingSeek.setProgress(mProgress);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.activity_chooseuser_finish:
            finish();
            break;
        case R.id.activity_chooseuser_ensure:
            SPUtils.put(this, Constants.SEEK_PROGRESS,
                    mMovingSeek.getProgress());
            if (firstLogin == 0) {
                startActivity(new Intent(MovingobjectsActivity.this,
                        PedometerActivity.class));
            }
            finish();
            break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        this.mProgress = progress;
        if (progress <= 1) {
            mMovingSeek.setProgress(1);
            mMovingObjects.setText(String.valueOf(0));
            this.mProgress = 0;
        } else if (progress >= 31) {
            mMovingSeek.setProgress(31);
            this.mProgress = 30;
            mMovingObjects.setText(mProgress
                    + getResources().getString(R.string.zer));
        } else {
            this.mProgress = progress - 1;
            mMovingObjects.setText(mProgress
                    + getResources().getString(R.string.zer));
        }
        calories(mProgress * 1000);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    /**
     * 设置消耗热量
     */
    private void calories(int steps) {
        float energy = CalculationUtils.getEnergy(steps);
        if (energy < 0) {
            energy = 0;
        }
        String energyStr = CalculationUtils.floatToStr(energy);
        if (TextUtils.equals("0.0", energyStr)) {
            energyStr = getResources()
                    .getString(R.string.zero);
        }
        mProgressConsume.setText(getResources().getString(
                R.string.energy)
                + energyStr
                + getResources().getString(R.string.calorie));
    }
}
