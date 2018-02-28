package com.pura.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.pura.R;
import com.pura.utils.Utils;

public class ChangeLanguageActivity extends AppCompatActivity implements View.OnClickListener {


    private Toolbar toolbar;
    private TextView tvToolbar;
    private ImageView ivBackImage;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Utils utils;
    private String selectedLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_language);

        getId();
        setListener();
        setData();
    }

    private void getId() {
        utils = new Utils(this);
        toolbar = (Toolbar) findViewById(R.id.include_toolbar_change_language);
        tvToolbar = toolbar.findViewById(R.id.toolbar_text);
        ivBackImage = toolbar.findViewById(R.id.iv_back_image);
        radioGroup = (RadioGroup) findViewById(R.id.rb_language_list_change);
    }

    private void setListener() {
        ivBackImage.setOnClickListener(this);
    }

    private void setData() {
        tvToolbar.setText("Change Language");
        setSelectedLanguage();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_image:
                onBackPressed();
                break;
        }
    }

    private void setSelectedLanguage() {
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedRadioButtonId);
        if (radioButton != null)
            selectedLanguage = radioButton.getText().toString();
        if (!TextUtils.isEmpty(selectedLanguage)) {
            utils.toast("Selected Language : " + selectedLanguage);
            //Intent signupIntent = new Intent(this.this, SignupActivity.class);
            //startActivity(signupIntent);
            finish();
        } else {
            utils.toast("Please Select a Language");
        }
    }

}
