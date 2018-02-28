package com.pura.activity;

import com.hanks.htextview.scale.ScaleTextView;


import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.hanks.htextview.scale.ScaleTextView;
import com.pura.R;
import com.pura.utils.MyPreferences;
import com.pura.utils.Utils;

public class SplashActivity extends AppCompatActivity {
    ScaleTextView view;

    String[] texts = {
            "Hello!..",
            "Hola!...",
            "Bonjour!...",
            "Ciao!..",
            "Hallo!..",
            "Ni hao!...",
            "Olá!..."
    };


    private RelativeLayout rlSelectLanguage;
    private MyPreferences myPreferences;
    private Utils utils;
    //private TextSwitcher textSwitcher;
    private FrameLayout frameLayout;
    private int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        myPreferences = new MyPreferences(this);
        rlSelectLanguage = (RelativeLayout) findViewById(R.id.layout_select_your_language);
        //tvShuffleText = (TextView) findViewById(R.id.tv_shuffle_text);
        view = new ScaleTextView(this);


        /*rlShuffleTextContainer = (RelativeLayout) findViewById(R.id.shuffle_text_container);
        TransitionManager.beginDelayedTransition(rlShuffleTextContainer);*/

        boolean languageSelectStatus = myPreferences.getBooleanData(MyPreferences.IS_LANGUAGE_SELECTED);
        if (languageSelectStatus == true) {
            // Disable Select Your Language Text from Splash
            rlSelectLanguage.setVisibility(View.INVISIBLE);
            // Move to Sign up Page after 3 seconds
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            }, 3000);
        }

        rlSelectLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Move to Select Language Page.
                Intent languageListIntent = new Intent(SplashActivity.this, SelectLanguageActivity.class);
                startActivity(languageListIntent);
                finish();
            }
        });

        frameLayout = (FrameLayout) findViewById(R.id.container);
        view.setText("Using a Library Project means that my overall project will have two manifests");
        view.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        view.setTextSize(getResources().getDimension(R.dimen.textsize));
        frameLayout.addView(view);


        new CountDownTimer(190000, 2000) {

            public void onTick(long millisUntilFinished) {
                //here you can have your logic to set text to edittext

                //Log.d("TAGS", "seconds remaining: " + millisUntilFinished / 1000);

                index++;
                if (index >= texts.length) {
                    index = 0;
                }
                view.animateText(texts[index]);
            }

            public void onFinish() {
                //Log.d("TAGS", "done");
            }

        }.start();


    }


    // Disable Back Button
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void showMovingText() {

    }
}