package com.flesh.themechanger;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by aaronfleshner on 6/28/15.
 */
public class ThemeUtils {

    public static final int THEME_BASE = 0;
    public static final int THEME_RED = 1;
    public static final int THEME_BLUE = 2;

    public static void setTheme(Context cxt, int theme){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(cxt);
        prefs.edit().putInt(cxt.getString(R.string.prefs_themes_key),theme).apply();
    }
    public static int getTheme(Context cxt){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(cxt);
        return prefs.getInt(cxt.getString(R.string.prefs_themes_key),0);
    }



}
