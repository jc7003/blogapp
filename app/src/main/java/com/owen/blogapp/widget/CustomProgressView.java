package com.owen.blogapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

import androidx.appcompat.widget.AppCompatImageView;

import android.util.AttributeSet;

/**
 * Created by owen on 2018/1/23.
 */

public class CustomProgressView extends AppCompatImageView {

    private Paint mPaint = new Paint();
    private final float default_arc_angle = 360 * 0.8f;
    private RectF rectF = new RectF();
    private int strokeWidth = 20;

    public CustomProgressView(Context context) {
        super(context);
        initPain();
    }

    public CustomProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    private void initPain() {
        mPaint = new Paint();

        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(strokeWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        LinearGradient linearGradient = new LinearGradient(getMeasuredWidth() / 2f, getMeasuredHeight(), getMeasuredWidth() / 2f, 0, Color.GRAY, Color.TRANSPARENT, Shader.TileMode.CLAMP);
        mPaint.setShader(linearGradient);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        rectF.set(strokeWidth / 2f, strokeWidth / 2f, width - strokeWidth / 2f, MeasureSpec.getSize(heightMeasureSpec) - strokeWidth / 2f);
        initPain();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float startAngle = 90 - default_arc_angle / 2f;
        float finishedStartAngle = startAngle;

        canvas.drawArc(rectF, finishedStartAngle, default_arc_angle, false, mPaint);
    }
}
