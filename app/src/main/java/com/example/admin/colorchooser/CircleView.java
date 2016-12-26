package com.example.admin.colorchooser;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Admin on 23.12.2016.
 */

public class CircleView extends View {
    private int color = Color.RED;
    private Paint paint;
    int x;
    int y;
    int radius;
    private int circleId;

    public CircleView(Context context, int color) {
        super(context);
        this.color = color;
        init();
    }

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LogUtil.info(this, "Initialize");
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        paint.setColor(color);
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        LogUtil.info(this, "Canvas: "+canvas);
        canvas.drawCircle(x/2, y/2, radius, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        LogUtil.info(this, "w: "+widthMeasureSpec+" h: "+heightMeasureSpec);
        LogUtil.info(this, "onMeasure width: "+getWidth()+" height: "+getHeight());
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        LogUtil.info(this, "changed: "+changed+" l: "+left+" r: "+right);
        LogUtil.info(this, "onLayout width: "+getWidth()+" height: "+getHeight());
        if (changed) {
            x = getWidth();
            y = getHeight();
            radius = Math.min(x/2, y/2);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtil.info(this, "onAttachedToWindow");
    }

    public int getCircleId() {
        return circleId;
    }

    public void setCircleId(int circleId) {
        this.circleId = circleId;
    }
}
