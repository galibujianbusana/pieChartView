package com.guoxw.piechartview.com.guoxw.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.guoxw.piechartview.R;

import java.util.ArrayList;

public class MPieChartView extends View{
    private static final String TAG = "MPieChartView";
    private ArrayList<Integer> mColors=new ArrayList<>();
    private  ArrayList<Float> mPercent=new ArrayList<>();
    private ArrayList<Float> mAngle=new ArrayList<>();
    private ArrayList<String>mNames;
    private Paint mPaint;    //画笔
    private float mHeight;          //View宽高
    private float mWidth;
    private RectF rectF;    //矩形
    private int textSize;

    private int textColor;
    public MPieChartView(Context context) {
        super(context);
        Log.d(TAG, "MPieChartView: --1");

        initPaint();

    }

    public MPieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "MPieChartView: --2");
        initPaint();
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MPieChartView);
        mHeight = array.getDimension(R.styleable.MPieChartView_viewHeight, 200);
        mWidth = array.getDimension(R.styleable.MPieChartView_viewWidth, 200);
        Log.d(TAG, "MPieChartView: --"+mWidth+"---"+mHeight);
        array.recycle();
    }

    public MPieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();

    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(textSize);
        rectF = new RectF();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);
        float currentStartAngle = 0;
        float r = (Math.min(mWidth, mHeight) / 2);
        rectF.set(-r, -r, r, r);
        for (int i = 0; i < mColors.size(); i++) {
            mPaint.setColor(mColors.get(i));
            canvas.drawArc(rectF, currentStartAngle, mAngle.get(i), true, mPaint);
            float textAngle = currentStartAngle + mAngle.get(i) / 2;
            float x = (float) (r / 2 * Math.cos(textAngle * Math.PI / 180));
            float y = (float) (r / 2 * Math.sin(textAngle * Math.PI / 180));
            mPaint.setColor(textColor);
            mPaint.setTextSize(textSize);
            canvas.drawText(mNames.get(i), x, y, mPaint);
            currentStartAngle += mAngle.get(i);
        }
    }

    private void initAngle() {
        for(int i=0;i<mPercent.size();i++){
            mAngle.add(i,360*mPercent.get(i));
        }
    }

    public void setPieData(ArrayList<Float> mPercent,ArrayList<Integer> mColors,ArrayList<String> mNames){
        this.mPercent=mPercent;
        this.mColors=mColors;
        this.mNames=mNames;
        initAngle();
        postInvalidate();
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
}
