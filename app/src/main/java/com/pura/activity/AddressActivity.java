package com.pura.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.pura.R;
import com.pura.utils.CountryDetails;
import com.pura.utils.MySpinnerHelper;
import com.pura.utils.Utils;

public class AddressActivity extends AppCompatActivity implements View.OnClickListener {


    private Toolbar toolbar;
    private Button btnSave;
    private ImageView ivBackImage;
    private TextView tvToolbarText;
    private Spinner spinnerCountry;
    private String[] countryList;
    private MySpinnerHelper spinnerHelper;
    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        getId();

        setListeners();
    }

    private void getId() {
        utils = new Utils(this);
        toolbar = (Toolbar) findViewById(R.id.include_toolbar_address);
        ivBackImage = (ImageView) findViewById(R.id.iv_back_image);
        tvToolbarText = (TextView) findViewById(R.id.toolbar_text);
        spinnerCountry = (Spinner) findViewById(R.id.spinner_country);
        countryList = CountryDetails.country;
        btnSave = (Button) findViewById(R.id.btn_save_address);
    }

    private void setListeners() {
        ivBackImage.setOnClickListener(this);
        tvToolbarText.setText("Address");
        spinnerHelper = new MySpinnerHelper(this, spinnerCountry, countryList, "Country");
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_image:
                onBackPressed();
                break;

            case R.id.btn_save_address:
                if (spinnerHelper != null) {
                    String selectedCountry = spinnerHelper.getSelectedItem();
                    utils.log("TEST", "Selected Country : " + selectedCountry);
                }
                finish();
                break;


        }
    }
}
