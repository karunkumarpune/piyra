package com.pura.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pura.R;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSubmit;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getId();
        setListeners();
    }

    private void getId() {
        btnSubmit = (Button) findViewById(R.id.btn_submit_code);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
    }

    private void setListeners() {
        btnSubmit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit_code:
                openEnterOtpEmailActivity();
                break;
        }
    }

    private void openEnterOtpEmailActivity() {
        Intent enterOtpEmailIntent = new Intent(this, EnterOtpEmailActivity.class);
        startActivity(enterOtpEmailIntent);
    }
}
