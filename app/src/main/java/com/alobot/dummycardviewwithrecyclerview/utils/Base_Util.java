package com.alobot.dummycardviewwithrecyclerview.utils;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

public class Base_Util {
    public static Drawable changeDrawableColor(Context context, int id, int color) {
        Drawable drawable = ContextCompat.getDrawable(context, id).mutate();
        drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));

        return drawable;
    }
}
