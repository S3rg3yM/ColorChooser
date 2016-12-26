package com.example.admin.colorchooser;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by Admin on 23.12.2016.
 */

public class ColorChooser extends FrameLayout implements View.OnClickListener{

    private final int count = 12;
    private CircleView[] circleViews;
    private ImageView markerView;
    private ImageView chooserView;
    private int selected = 1;
    private int padding = 10;

    public ColorChooser(Context context) {
        super(context);
        init();
    }

    public ColorChooser(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ColorChooser(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        initCircleViews();
        initMarkerView();
        initChooserView();
    }

    private void initCircleViews() {
        circleViews = new CircleView[count-1];

        for (int i = 0; i < circleViews.length; i++) {
            circleViews[i] = new CircleView(getContext(), ColorUtil.instance().getColorFromCollections(i));
            circleViews[i].setOnClickListener(this);
            circleViews[i].setCircleId(i);
            addView(circleViews[i]);
        }
    }

    private void initChooserView() {
        chooserView = new ImageView(getContext());
        chooserView.setImageResource(R.drawable.ic_add_circle_outline_white_24dp);
        chooserView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(chooserView);
        chooserView.setX(padding);
        chooserView.setY(padding);
    }

    private void initMarkerView() {
        markerView = new ImageView(getContext());
        markerView.setImageResource(R.drawable.ic_done_grey_300_24dp);
        markerView.setScaleType(ImageView.ScaleType.CENTER);
        addView(markerView);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            int width = getWidth();
            int height = getHeight();
            int vWidth = width / 6;
            int vHeight = height /2;
            for (int i = 0; i < circleViews.length; i++) {
                float x = 0;
                float y = 0;

                if (i<((circleViews.length+1)/2-1)) {
                    x = (i+1)*vWidth;
                    y = 0;
                } else {
                    x = (i-count/2+1)*vWidth;
                    y = vHeight;
                }
                circleViews[i].setX(x+padding);
                circleViews[i].setY(y+padding);

                circleViews[i].getLayoutParams().width = vWidth-padding*2;
                circleViews[i].getLayoutParams().height = vHeight-padding*2;
            }
            markerView.getLayoutParams().width = vWidth-padding*2;
            markerView.getLayoutParams().height = vHeight-padding*2;

            chooserView.getLayoutParams().width =vWidth-padding*2;
            chooserView.getLayoutParams().height = vHeight-padding*2;

            invalidateMarker(selected);
        }
    }

    @Override
    public void onClick(View v) {
        int mId = ((CircleView)v).getCircleId();
        selected = mId;
        invalidateMarker(selected);
    }

    private void invalidateMarker(int id) {
        markerView.setX(circleViews[id].getX());
        markerView.setY(circleViews[id].getY());
        markerView.postInvalidate();
    }

    public int getSelectedColor(){
        return circleViews[getSelectedId()].getColor();
    }

    public void setSelectedColor(int color) {
        circleViews[getSelectedId()].setColor(color);
    }

    public int getSelectedId() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;

    }
}
