package com.pura.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pura.R;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvSignIn;
    private Button btnForgotPassword;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        // This method is used to find id of View components.
        this.getId();
        this.setListener();
    }

    private void getId() {
        tvSignIn = (TextView) findViewById(R.id.tv_sign_up);
        btnForgotPassword = (Button) findViewById(R.id.btn_forgot_password);
        btnSignIn = (Button) findViewById(R.id.btn_sign_in);
    }

    private void setListener() {
        tvSignIn.setOnClickListener(this);
        btnForgotPassword.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_forgot_password:
                openForgotPasswordActivity();
                break;
            case R.id.tv_sign_up:
                openSignUpActivity();
                break;

            case R.id.btn_sign_in:
                openMainActivity();
                break;
        }
    }

    private void openMainActivity() {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
        finishAffinity();
    }

    private void openSignUpActivity() {
        Intent signUpIntent = new Intent(this, SignupActivity.class);
        startActivity(signUpIntent);
        finish();
    }

    private void openForgotPasswordActivity() {
        Intent forgotPasswordIntent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(forgotPasswordIntent);
    }
}