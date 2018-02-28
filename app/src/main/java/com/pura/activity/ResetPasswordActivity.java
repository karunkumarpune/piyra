package com.pura.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pura.R;

public class ResetPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSubmit;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        getId();
        setListener();
    }

    private void getId() {
        btnSubmit = (Button) findViewById(R.id.btn_submit_reset_password);
        btnCancel = (Button) findViewById(R.id.btn_cancel_reset_password);
    }

    private void setListener() {
        btnSubmit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit_reset_password:
                openSignInActivity();
                break;

            case R.id.btn_cancel_reset_password:
                break;
        }
    }

    private void openSignInActivity() {
        Intent signInIntent = new Intent(this, SignInActivity.class);
        signInIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(signInIntent);
    }
}
