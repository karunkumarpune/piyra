package com.pura.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pura.R;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {


    private Toolbar toolbar;
    private ImageView ivBackImage;
    private TextView tvChangeLanguage;
    private TextView tvAboutUs;
    private TextView tvTermsOfUse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getId();
        setListeners();
    }

    private void getId() {
        toolbar = (Toolbar) findViewById(R.id.include_toolbar_settings);
        ivBackImage = toolbar.findViewById(R.id.iv_back_image);
        TextView tvToolbarText = toolbar.findViewById(R.id.toolbar_text);
        tvToolbarText.setText("Settings");

        tvChangeLanguage = (TextView) findViewById(R.id.tv_change_language);
        tvAboutUs = (TextView) findViewById(R.id.tv_about_us);
        tvTermsOfUse = (TextView) findViewById(R.id.tv_terms_use);
    }

    private void setListeners() {
        ivBackImage.setOnClickListener(this);
        tvChangeLanguage.setOnClickListener(this);
        tvAboutUs.setOnClickListener(this);
        tvTermsOfUse.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.iv_back_image:
                onBackPressed();
                break;
            case R.id.tv_change_language:
                openChangeLanguageActivity();
                break;
            case R.id.tv_about_us:
                break;
            case R.id.tv_terms_use:
                break;
        }
    }

    private void openChangeLanguageActivity() {
        Intent changeLanguageIntent = new Intent(this, ChangeLanguageActivity.class);
        startActivity(changeLanguageIntent);
    }
}
