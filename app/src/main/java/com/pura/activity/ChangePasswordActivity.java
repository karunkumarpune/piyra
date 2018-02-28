package com.pura.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pura.R;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {


    private Toolbar toolbar;
    private ImageView ivBackImage;
    private TextView toolbarText;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        getId();
        setListener();
        setData();
    }

    private void getId() {
        toolbar = (Toolbar) findViewById(R.id.include_toolbar_change_password);
        ivBackImage = toolbar.findViewById(R.id.iv_back_image);
        toolbarText = toolbar.findViewById(R.id.toolbar_text);
        btnSave = (Button) findViewById(R.id.btn_save_change_password);
    }

    private void setListener() {
        ivBackImage.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }

    private void setData() {
        toolbarText.setText("Change Password");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_image:
                onBackPressed();
                break;

            case R.id.btn_save_change_password:
                finish();
                break;
        }
    }
}
