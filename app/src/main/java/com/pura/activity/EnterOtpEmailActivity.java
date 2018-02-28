package com.pura.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pura.R;

public class EnterOtpEmailActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp_email);


        getIds();
        setListeners();
    }

    private void getIds() {
        btnSubmit = (Button) findViewById(R.id.btn_submit_code);
    }

    private void setListeners() {
        btnSubmit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit_code:
                openResetPasswordActivity();
                break;
        }
    }

    private void openResetPasswordActivity() {
        Intent resetPasswordIntent = new Intent(this, ResetPasswordActivity.class);
        startActivity(resetPasswordIntent);
    }
}
