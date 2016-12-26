package com.example.admin.colorchooser;

import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by Admin on 23.12.2016.
 */

public class ColorUtil {
    private static ColorUtil colorUtil;
    private ArrayList<Integer> colors;

    public static ColorUtil instance(){
        if (colorUtil==null) {
            colorUtil = new ColorUtil();
        }
        return colorUtil;
    }

    /*[UIColor colorWithRed:255/255.f green:255/255.f blue:255/255.f alpha:1.f],
            [UIColor colorWithRed:60/255.f green:3/255.f blue:5/255.f alpha:1.f],
            [UIColor colorWithRed:249/255.f green:216/255.f blue:83/255.f alpha:1.f],
            [UIColor colorWithRed:0/255.f green:78/255.f blue:136/255.f alpha:1.f],
            [UIColor colorWithRed:0/255.f green:196/255.f blue:158/255.f alpha:1.f],
            [UIColor colorWithRed:0/255.f green:178/255.f blue:170/255.f alpha:1.f],
            [UIColor colorWithRed:0/255.f green:156/255.f blue:197/255.f alpha:1.f],
            [UIColor colorWithRed:197/255.f green:44/255.f blue:43/255.f alpha:1.f],
            [UIColor colorWithRed:204/255.f green:7/255.f blue:37/255.f alpha:1.f],
            [UIColor colorWithRed:3/255.f green:16/255.f blue:60/255.f alpha:1.f]]];*/
    private ColorUtil() {
        colors = new ArrayList<>();
        colors.add(Color.rgb(255,255,255));
        colors.add(Color.rgb(60,3,5));
        colors.add(Color.rgb(249,216,83));
        colors.add(Color.rgb(0,78,136));
        colors.add(Color.rgb(0,196,158));
        colors.add(Color.rgb(0,178,170));
        colors.add(Color.rgb(0,156,197));
        colors.add(Color.rgb(197,44,43));
        colors.add(Color.rgb(204,7,37));
        colors.add(Color.rgb(3,16,60));
        colors.add(Color.rgb(55,55,55)); //random
    }

    public int getColorFromCollections(int id){
        if (id>=colors.size()) {
            return Color.rgb(255,255,255);
        }
        return colors.get(id);
    }

    public void addNewColor(int color) {
        for (int i = 0; i < colors.size(); i++) {
            if (color == colors.get(i)) {
                return;
            }
        }
        colors.add(0, color);
        colors.remove(colors.size()-1);
    }
}
