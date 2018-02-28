package com.pura.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pura.R;
import com.pura.utils.MyPreferences;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnSignup;
    private MyPreferences myPreferences;
    private TextView tvSignIn;
    RelativeLayout rlFbSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        gettingId();
        setListeners();
        setData();
    }

    private void gettingId() {
        myPreferences = new MyPreferences(this);
        tvSignIn = (TextView) findViewById(R.id.tv_sign_in);
        btnSignup = (Button) findViewById(R.id.btn_sign_up);
        rlFbSignup = (RelativeLayout) findViewById(R.id.layout_btn_fb_signup);
    }

    private void setListeners() {
        btnSignup.setOnClickListener(this);

        // Sign In Below the Screen.
        tvSignIn.setOnClickListener(this);
        rlFbSignup.setOnClickListener(this);
    }

    private void setData() {
        //myPreferences.saveBooleanData(MyPreferences.IS_LANGUAGE_SELECTED, true);
    }

    private void openSignInActivity() {
        Intent signInIntent = new Intent(this, SignInActivity.class);
        startActivity(signInIntent);
        finish();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_up:
                openEnterOtpActivity();
                break;

            case R.id.tv_sign_in:
                openSignInActivity();
                break;

            case R.id.layout_btn_fb_signup:
                startActivity(new Intent(this, FacebookLoginActivity.class));
                break;
        }
    }

    private void openEnterOtpActivity() {
        Intent enterOtpIntent = new Intent(this, EnterOptActivity.class);
        startActivity(enterOtpIntent);
    }
}
