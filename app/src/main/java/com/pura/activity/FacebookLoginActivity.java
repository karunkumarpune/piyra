package com.pura.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pura.R;

public class FacebookLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login);

        getId();
        setListener();
        setData();
    }

    private void getId() {
        btnSubmit = (Button) findViewById(R.id.btn_submit_fb_login);
    }

    private void setListener() {
        btnSubmit.setOnClickListener(this);
    }

    private void setData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit_fb_login:
                startActivity(new Intent(this, MainActivity.class));
                finishAffinity();
                break;
        }
    }
}
