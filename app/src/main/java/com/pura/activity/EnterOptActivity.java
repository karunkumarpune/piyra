package com.pura.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pura.R;

public class EnterOptActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnSubmit;
    private Button btnChangeMobileNumber;
    private Button btnResendCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_opt);

        getId();
        setListener();
    }

    private void getId() {
        btnSubmit = (Button) findViewById(R.id.btn_submit_code);
        btnChangeMobileNumber = (Button) findViewById(R.id.btn_change_mobile_number);
        btnResendCode = (Button) findViewById(R.id.btn_resend_code);
    }

    private void setListener() {
        btnSubmit.setOnClickListener(this);
        btnChangeMobileNumber.setOnClickListener(this);
        btnResendCode.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit_code:
                openMainActivity();
                break;
        }
    }

    private void openMainActivity() {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
        finishAffinity();
    }
}
