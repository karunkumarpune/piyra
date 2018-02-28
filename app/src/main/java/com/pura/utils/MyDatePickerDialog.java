package com.pura.utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.support.v4.content.ContextCompat;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.TextView;

import com.pura.R;


/**
 * Created by Manish-Pc on 17/02/2018.
 */

public class MyDatePickerDialog implements DatePickerDialog.OnDateSetListener {

    private Context context;
    private TextView textView;
    private DatePickerDialog datePickerDialog;
    private String formattedDate;

    private Calendar calendar = Calendar.getInstance();
    private int day = calendar.get(Calendar.DAY_OF_MONTH);
    private int month = calendar.get(Calendar.MONTH);
    private int year = calendar.get(Calendar.YEAR);

    public MyDatePickerDialog(Context context, TextView textView) {
        this.context = context;
        this.textView = textView;
        datePickerDialog = new DatePickerDialog(context, this, year, month, day);
        hideKeyboard();
    }


    public void show() {
        if (datePickerDialog != null) {
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis() - 1000);
            datePickerDialog.show();
        }
    }

    public String getSelectedDate() {
        if (datePickerDialog != null) {
            return formattedDate;
        } else return null;
    }

    private void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(((Activity) context).findViewById(android.R.id.content).getWindowToken(), 0);
    }


    private String formatDate(int year, int month, int dayOfMonth) {
        ++month;
        String formattedMonthValue = "";
        String currentMonthValue = String.valueOf(month);
        if (month > 0 && month < 10) {
            formattedMonthValue = "0" + currentMonthValue;
        } else {
            formattedMonthValue = currentMonthValue;
        }

        String currentDateValue = String.valueOf(dayOfMonth);
        String formattedDayValue = "";
        if (dayOfMonth > 0 && dayOfMonth < 10) {
            formattedDayValue = "0" + currentDateValue;
        } else {
            formattedDayValue = currentDateValue;
        }

        String formattedDate = year + "-" + formattedMonthValue + "-" + formattedDayValue;
        return formattedDate;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        formattedDate = formatDate(year, month, dayOfMonth);
        if (textView != null) {
            textView.setText(formattedDate);
            textView.setTextColor(ContextCompat.getColor(context, R.color.colorTextPrimary));
        }
    }
}
