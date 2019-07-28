package com.example.administrator.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.stepdemo.R;
import com.example.administrator.stepdemo.OnWeekClickListener;

import java.util.ArrayList;
import java.util.List;

import com.example.administrator.utils.TimeAndShareUtils;

public class WeekTextView extends LinearLayout implements
        OnClickListener {

    private View inflate;
    private List<TextView> list;
    private OnWeekClickListener XiaoLaJiaoWeekOnclickListener;
    private String[] week = { "一", "二", "三", "四", "五", "六", "日" };
    private Context context;
    // private int today;
    private int[] successArray;

    public synchronized void setXiaoLaJiaoWeekOnclickListener(
            OnWeekClickListener xiaoLaJiaoWeekOnclickListener) {
        XiaoLaJiaoWeekOnclickListener = xiaoLaJiaoWeekOnclickListener;
    }

    protected WeekTextView(Context context) {
        super(context);
    }

    public WeekTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflate = inflater.inflate(R.layout.week, this);
        initView(inflate);
        initData();
    }

    private void initView(View inflate2) {
        TextView xiaolajiao_text_week_center = (TextView) inflate2
                .findViewById(R.id.xiaolajiao_text_week_center);
        TextView xiaolajiao_text_week_left_one = (TextView) inflate2
                .findViewById(R.id.xiaolajiao_text_week_left_one);
        TextView xiaolajiao_text_week_left_two = (TextView) inflate2
                .findViewById(R.id.xiaolajiao_text_week_left_two);
        TextView xiaolajiao_text_week_left_three = (TextView) inflate2
                .findViewById(R.id.xiaolajiao_text_week_left_three);
        TextView xiaolajiao_text_week_right_one = (TextView) inflate2
                .findViewById(R.id.xiaolajiao_text_week_right_one);
        TextView xiaolajiao_text_week_right_two = (TextView) inflate2
                .findViewById(R.id.xiaolajiao_text_week_right_two);
        TextView xiaolajiao_text_week_right_three = (TextView) inflate2
                .findViewById(R.id.xiaolajiao_text_week_right_three);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.clear();
        list.add(xiaolajiao_text_week_left_three);
        list.add(xiaolajiao_text_week_left_two);
        list.add(xiaolajiao_text_week_left_one);
        list.add(xiaolajiao_text_week_center);
        list.add(xiaolajiao_text_week_right_one);
        list.add(xiaolajiao_text_week_right_two);
        list.add(xiaolajiao_text_week_right_three);
    }

    private void initData() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.xiaolajiao_text_week_center:
            if (XiaoLaJiaoWeekOnclickListener != null) {
                XiaoLaJiaoWeekOnclickListener.OnWeekClickListener(v, 3);
            }
            setTextColor((TextView) v);
            break;
        case R.id.xiaolajiao_text_week_left_one:
            if (XiaoLaJiaoWeekOnclickListener != null) {
                XiaoLaJiaoWeekOnclickListener.OnWeekClickListener(v, 4);
            }
            setTextColor((TextView) v);
            break;
        case R.id.xiaolajiao_text_week_left_two:
            if (XiaoLaJiaoWeekOnclickListener != null) {
                XiaoLaJiaoWeekOnclickListener.OnWeekClickListener(v, 5);
            }
            setTextColor((TextView) v);
            break;
        case R.id.xiaolajiao_text_week_left_three:
            if (XiaoLaJiaoWeekOnclickListener != null) {
                XiaoLaJiaoWeekOnclickListener.OnWeekClickListener(v, 6);
            }
            setTextColor((TextView) v);
            break;
        case R.id.xiaolajiao_text_week_right_one:
            if (XiaoLaJiaoWeekOnclickListener != null) {
                XiaoLaJiaoWeekOnclickListener.OnWeekClickListener(v, 2);
            }
            setTextColor((TextView) v);
            break;
        case R.id.xiaolajiao_text_week_right_two:
            if (XiaoLaJiaoWeekOnclickListener != null) {
                XiaoLaJiaoWeekOnclickListener.OnWeekClickListener(v, 1);
            }
            setTextColor((TextView) v);
            break;
        case R.id.xiaolajiao_text_week_right_three:
            if (XiaoLaJiaoWeekOnclickListener != null) {
                XiaoLaJiaoWeekOnclickListener.OnWeekClickListener(v, 0);
            }
            setTextColor((TextView) v);
            break;

        default:
            break;
        }
    }

    @SuppressWarnings("deprecation")
    private void setTextColor(TextView v) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                list.get(i).setTextColor(
                        context.getResources().getColor(
                                R.color.brown_d1aa71));
                list.get(i).setBackgroundResource(
                        R.drawable.text_ring_today);
            } else {
                list.get(i).setTextColor(
                        context.getResources().getColor(
                                R.color.brown_d1aa71));
                list.get(i).setBackgroundResource(
                        R.drawable.text_ring_normal);
                if (successArray != null) {
                    setSuccessView(successArray);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (v == list.get(i)) {
                list.get(i).setTextColor(
                        context.getResources().getColor(
                                R.color.white_fff));
                list.get(i).setBackgroundResource(
                        R.drawable.text_ring_pressed);
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void setSuccessView(int[] i) {
        this.successArray = i;
        for (int k = 0; k < list.size(); k++) {
            for (int k2 = 0; k2 < i.length; k2++) {
                if (k == successArray[k2]) {
                    list.get(k).setTextColor(
                            context.getResources().getColor(
                                    R.color.title_333333));
                    list.get(k).setBackgroundResource(
                            R.drawable.text_ring_success);
                }
            }
        }

    }

    private String[] weekArray;

    public void setToday(int i) {
        onClick(list.get(list.size() - 1));
        weekArray = TimeAndShareUtils.getWeekList(i, week);
        for (int j = 0; j < weekArray.length; j++) {
            list.get(j).setText(weekArray[j]);
        }
    }
}
