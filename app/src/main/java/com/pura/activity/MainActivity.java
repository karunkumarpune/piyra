package com.pura.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.pura.R;
import com.pura.utils.MyPreferences;
import com.pura.utils.Utils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Utils utils;
    private RelativeLayout rlHomeWater;
    private RelativeLayout rlHomePura;
    private MyPreferences myPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getId();
        setListeners();
        setData();

    }

    private void getId() {
        utils = new Utils(this);
        myPreferences = new MyPreferences(this);
        rlHomeWater = (RelativeLayout) findViewById(R.id.rl_home_water);
        rlHomePura = (RelativeLayout) findViewById(R.id.rl_home_pura);
    }

    private void setListeners() {
        rlHomeWater.setOnClickListener(this);
        rlHomePura.setOnClickListener(this);
    }


    private void setData() {
        //myPreferences.saveBooleanData(MyPreferences.IS_LANGUAGE_SELECTED, true);
    }

    //Press Once Again to Exit.
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        utils.snackbar("Press once again to exit");
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 1000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_home_water:
                openKnowMoreActivity();
                break;

            case R.id.rl_home_pura:
                openHavePuraActivity();
                break;
        }
    }

    private void openHavePuraActivity() {
        Intent havePuraIntent = new Intent(this, HavePuraActivity.class);
        startActivity(havePuraIntent);
        finish();
    }

    private void openKnowMoreActivity() {
        Intent knowMoreIntent = new Intent(this, KnowMoreActivity.class);
        startActivity(knowMoreIntent);
        finish();
    }
}
