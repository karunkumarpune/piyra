package com.pura.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.pura.R;
import com.pura.adapter.LanguageListAdapter;
import com.pura.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectLanguageActivity extends AppCompatActivity {


    private View btnNext;
    private String TAG = "PURA";
    private Utils utils;
    private ArrayList<String> languageList;
    //private ListView listViewLanguageList;
    //private LanguageListAdapter languageListAdapter;

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    private String selectedLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        utils = new Utils(this);
        btnNext = findViewById(R.id.btn_next_select_language);

        radioGroup = (RadioGroup) findViewById(R.id.rb_language_list);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });
    }

    private void openSignUpActivity() {
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedRadioButtonId);
        if (radioButton != null)
            selectedLanguage = radioButton.getText().toString();
        if (!TextUtils.isEmpty(selectedLanguage)) {
            utils.toast("Selected Language : " + selectedLanguage);
            Intent signupIntent = new Intent(SelectLanguageActivity.this, SignupActivity.class);
            startActivity(signupIntent);
            finish();
        } else {
            utils.toast("Please Select a Language");
        }
    }
}
