package com.example.administrator.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.stepdemo.R;

public class ThreeTextView extends RelativeLayout {

    private TextView pedometer_tv_num;
    private TextView pedometer_tv_distances;
    private TextView pedometer_tv_kilometre;
    private TextView pedometer_tv_appoint;

    public ThreeTextView(Context context) {
        super(context);
    }

    public ThreeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.three_tv, this);
        initView();
    }

    private void initView() {
        pedometer_tv_num = (TextView) findViewById(R.id.pedometer_tv_num);
        pedometer_tv_distances = (TextView) findViewById(R.id.pedometer_tv_distances);
        pedometer_tv_kilometre = (TextView) findViewById(R.id.pedometer_tv_kilometre);
        pedometer_tv_appoint = (TextView) findViewById(R.id.pedometer_tv_appoint);
    }

    public void setTv_Num(String text) {
        pedometer_tv_num.setText(text);
    }

    public void setLeftAndRight(String text1, String text2) {
        pedometer_tv_distances.setText(text1);
        pedometer_tv_kilometre.setText(text2);
    }

    public void setTv_BottomText(String text) {
        pedometer_tv_appoint.setText(text);
    }
}
