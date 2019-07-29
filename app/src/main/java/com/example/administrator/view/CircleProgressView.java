package com.example.administrator.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.administrator.stepdemo.R;


public class CircleProgressView extends View {
    private static final String TAG = "CircleProgressBar";

    private int mMaxProgress = 0;

    private int mProgress = 30;
    private String progressText;
    private final int mCircleLineStrokeWidth = 12;

    private final int mTxtStrokeWidth = 2;

    // 画圆所在的距形区域
    private final RectF mRectF;

    private final Paint mPaint;

    private final Context mContext;

    private String mTxtHint1;

    private String mTxtHint2;

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        mRectF = new RectF();
        mPaint = new Paint();
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = this.getWidth();
        int height = this.getHeight();

        if (width != height) {
            int min = Math.min(width, height);
            width = min;
            height = min;
        }

        // 设置画笔相关属性
        mPaint.setAntiAlias(true);
        // mPaint.setColor(Color.rgb(0xe9, 0xe9, 0xe9));
        mPaint.setStrokeWidth(mCircleLineStrokeWidth);
        mPaint.setStyle(Style.STROKE);
        // 位置
        mRectF.left = mCircleLineStrokeWidth / 2; // 左上角x
        mRectF.top = mCircleLineStrokeWidth / 2; // 左上角y
        mRectF.right = width - mCircleLineStrokeWidth / 2; // 左下角x
        mRectF.bottom = height - mCircleLineStrokeWidth / 2; // 右下角y

        mPaint.setColor(getResources()
                .getColor(R.color.brown_d1aa71));
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        if (mMaxProgress > 0) {
            canvas.drawArc(mRectF, -90,
                    ((float) mProgress / mMaxProgress) * 360, false, mPaint);
        }

        // 绘制进度文案显示
        mPaint.setStrokeWidth(mTxtStrokeWidth);

        // int textHeight = height / 4;
        int textHeight = dp2px(mContext, 53);
        mPaint.setTextSize(textHeight);
        int textWidth;
        if (!TextUtils.isEmpty(progressText)) {
//            mPaint.setTypeface(Typeface.createFromAsset(mContext.getAssets(),
//                    "font/spiral.ttf"));
            textWidth = (int) mPaint.measureText(progressText, 0,
                    progressText.length());
            mPaint.setStyle(Style.FILL);
            canvas.drawText(progressText, width / 2 - textWidth / 2, height / 2
                    + textHeight / 3, mPaint);
        }

        if (!TextUtils.isEmpty(mTxtHint1)) {
            mPaint.setStrokeWidth(mTxtStrokeWidth);
            mPaint.setTypeface(Typeface.DEFAULT);
            // textHeight = height / 8;
            textHeight = dp2px(mContext, 14);
            mPaint.setTextSize(textHeight);
            mPaint.setColor(getResources().getColor(
                    R.color.brown_99d1aa71));
            textWidth = (int) mPaint.measureText(mTxtHint1, 0,
                    mTxtHint1.length());
            mPaint.setStyle(Style.FILL);
            canvas.drawText(mTxtHint1, width / 2 - textWidth / 2, height / 4
                    + textHeight / 2, mPaint);
        }

        if (!TextUtils.isEmpty(mTxtHint2)) {
            mPaint.setStrokeWidth(mTxtStrokeWidth);
            mPaint.setTypeface(Typeface.DEFAULT);
            // textHeight = height / 8;
            textHeight = dp2px(mContext, 14);
            mPaint.setTextSize(textHeight);
            mPaint.setColor(getResources().getColor(
                    R.color.brown_99d1aa71));
            textWidth = (int) mPaint.measureText(mTxtHint2, 0,
                    mTxtHint2.length());
            mPaint.setStyle(Style.FILL);
            canvas.drawText(mTxtHint2, width / 2 - textWidth / 2, 3 * height
                    / 4 + textHeight / 4, mPaint);
        }
    }

    public int getMaxProgress() {
        return mMaxProgress;
    }

    public void setMaxProgress(int maxProgress) {
        this.mMaxProgress = maxProgress;
    }

    public void setProgress(int progress) {
        this.mProgress = progress;
        if (null == String.valueOf(progress)) {
            progressText = "0";
        } else {
            progressText = String.valueOf(progress);
        }
        this.invalidate();
    }

    public void setProgressNotInUiThread(int progress) {
        this.mProgress = progress;
        this.postInvalidate();
    }

    public String getmTxtHint1() {
        return mTxtHint1;
    }

    public void setmTxtHint1(String mTxtHint1) {
        this.mTxtHint1 = mTxtHint1;
    }

    public String getmTxtHint2() {
        return mTxtHint2;
    }

    public void setmTxtHint2(String mTxtHint2) {
        this.mTxtHint2 = mTxtHint2;
    }

    public static int dp2px(Context context, int dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());

    }
}
