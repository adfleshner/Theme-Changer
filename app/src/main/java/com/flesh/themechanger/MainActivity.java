package com.flesh.themechanger;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity implements View.OnClickListener{

    //Buttons
    private Button bRed,bBlue,bBase;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    //initalize Views
    private void init() {
        bRed = (Button) findViewById(R.id.btn_theme_red);
        bBlue = (Button) findViewById(R.id.btn_theme_blue);
        bBase = (Button) findViewById(R.id.btn_theme_base);
        setOnClickListeners();
    }

    //Connect On Click Listeners.
    private void setOnClickListeners() {
        bRed.setOnClickListener(this);
        bBlue.setOnClickListener(this);
        bBase.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_theme_red:
                //Set to red theme
                ThemeUtils.setTheme(getApplicationContext(),ThemeUtils.THEME_RED);
                recreateActivity(MainActivity.class);
                break;
            case R.id.btn_theme_blue:
                //Set to blue theme
                ThemeUtils.setTheme(getApplicationContext(),ThemeUtils.THEME_BLUE);
                recreateActivity(MainActivity.class);
                break;
            case R.id.btn_theme_base:
                //ser to base theme
                ThemeUtils.setTheme(getApplicationContext(),ThemeUtils.THEME_BASE);
                recreateActivity(MainActivity.class);
                break;
        }
    }

}
