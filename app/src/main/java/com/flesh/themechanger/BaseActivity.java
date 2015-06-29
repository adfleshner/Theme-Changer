package com.flesh.themechanger;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.WindowManager;

/**
 * Created by aaronfleshner on 6/28/15.
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateTheme();
    }

    private void updateTheme() {
        if (ThemeUtils.getTheme(getApplicationContext()) == ThemeUtils.THEME_BASE) {
            Log.d("Theme Updated","Base");
            setTheme(R.style.AppTheme);
        } else if (ThemeUtils.getTheme(getApplicationContext()) == ThemeUtils.THEME_RED) {
            Log.d("Theme Updated","Red");
            setTheme(R.style.AppTheme_Red);
        } else if (ThemeUtils.getTheme(getApplicationContext()) == ThemeUtils.THEME_BLUE) {
            Log.d("Theme Updated","Blue");
            setTheme(R.style.AppTheme_Blue);
        }
        updateSystemBar();


    }

    //If lollipop change the status bar color to the colorPrimaryDark Attr
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void updateSystemBar() {
        if (isLollipop()) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = getTheme();
            theme.resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
            int color = typedValue.data;
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(color);
        }

    }
    //Check for lollipop
    private boolean isLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    //Recreate the activity to Set the new theme
    public void recreateActivity(final Class clazz) {
        //Add a 250 ms delay so that it has a nicer transition.
        SleepyTime(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(BaseActivity.this,clazz);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        },250);
    }

    //add time before actually running the code.
    public static void SleepyTime(final Runnable run,final int SleepyTime){
        final Handler h = new Handler();
        Thread sleepyTime = new Thread(){
            public void run() {
                try {
                    Thread.sleep(SleepyTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                h.post(run);
            }
        };
        sleepyTime.start();
    }

}
