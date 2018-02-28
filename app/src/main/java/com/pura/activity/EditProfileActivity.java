package com.pura.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.pura.R;
import com.pura.utils.MyDatePickerDialog;
import com.pura.utils.MySpinnerHelper;
import com.pura.utils.Utils;

import org.w3c.dom.Text;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView tvDob;
    private TextView tvAddress;
    private TextView tvChangePassword;
    private Utils utils;
    private MyDatePickerDialog myDatePickerDialog;
    private Spinner spGender;
    private ImageView ivOk;
    private ImageView ivBackImage;

    private MySpinnerHelper mySpinnerHelper;
    private LinearLayout layoutSpinner;
    private String[] genderItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        getId();
        setListeners();
        setData();
    }


    private void getId() {
        tvDob = (TextView) findViewById(R.id.tv_dob);
        utils = new Utils(this);
        spGender = (Spinner) findViewById(R.id.spinner_gender);
        layoutSpinner = (LinearLayout) findViewById(R.id.layout_spinner);
        genderItems = getResources().getStringArray(R.array.gender_list);
        ivOk = (ImageView) findViewById(R.id.iv_ok_edit);
        tvAddress = (TextView) findViewById(R.id.tv_address);
        ivBackImage = (ImageView) findViewById(R.id.iv_back_image_edit_profile);
        tvChangePassword = (TextView) findViewById(R.id.tv_change_password_edit_profile);
    }

    private void setListeners() {
        tvDob.setOnClickListener(this);
        layoutSpinner.setOnClickListener(this);
        mySpinnerHelper = new MySpinnerHelper(this, spGender, genderItems, "Gender");
        ivOk.setOnClickListener(this);
        tvAddress.setOnClickListener(this);
        ivBackImage.setOnClickListener(this);
        tvChangePassword.setOnClickListener(this);
    }

    private void setData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_dob:
                myDatePickerDialog = new MyDatePickerDialog(this, tvDob);
                myDatePickerDialog.show();
                break;

            case R.id.iv_back_image_edit_profile:
                onBackPressed();
                break;

            case R.id.iv_ok_edit:

                if (myDatePickerDialog != null) {
                    String selectedDate = myDatePickerDialog.getSelectedDate();
                    utils.log("TEST", "Selected Date : " + selectedDate);
                }

                if (mySpinnerHelper != null) {
                    String selectedItem = mySpinnerHelper.getSelectedItem();
                    utils.log("TEST", "Selected Item : " + selectedItem);
                }

                finish();

                break;

            case R.id.tv_address:
                openAddressActivity();
                break;

            case R.id.tv_change_password_edit_profile:
                openChangePasswordActivity();
                break;
        }
    }

    private void openChangePasswordActivity() {
        Intent changePasswordIntent = new Intent(this, ChangePasswordActivity.class);
        startActivity(changePasswordIntent);
    }

    private void openAddressActivity() {
        Intent addressIntent = new Intent(this, AddressActivity.class);
        startActivity(addressIntent);
    }
}
