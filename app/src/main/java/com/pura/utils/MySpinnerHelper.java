package com.pura.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.pura.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Manish-Pc on 17/02/2018.
 */

public class MySpinnerHelper implements AdapterView.OnItemSelectedListener {
    private MySpinnerAdapter mySpinnerAdapter;
    private ArrayList<String> itemList;
    private Context context;
    private String selectedItem;

    public MySpinnerHelper(Context context, Spinner spinner, String[] spinnerItems, String title) {
        this.context = context;
        itemList = new ArrayList<>(Arrays.asList(spinnerItems));
        itemList.add(0, title.trim());
        mySpinnerAdapter = new MySpinnerAdapter(context, android.R.layout.simple_spinner_item, itemList);
        spinner.setAdapter(mySpinnerAdapter);

        spinner.setOnItemSelectedListener(this);
    }


    public String getSelectedItem() {
        return selectedItem;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position > 0) {
            this.selectedItem = (String) parent.getItemAtPosition(position);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    class MySpinnerAdapter extends ArrayAdapter {
        public MySpinnerAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<String> itemList) {
            super(context, resource, itemList);
        }

        @Override
        public boolean isEnabled(int position) {
            if (position == 0) return false;
            else return true;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            TextView textView = (TextView) view;
            if (position == 0) {
                textView.setTextColor(ContextCompat.getColor(context, R.color.colorHint));
            } else {
                textView.setTextColor(ContextCompat.getColor(context, R.color.colorTextPrimary));
            }
            return view;
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = super.getDropDownView(position, convertView, parent);
            TextView spinnerTextView = (TextView) view;
            spinnerTextView.setPadding(80, 10, 40, 20);
            if (position == 0) spinnerTextView.setTextColor(Color.GRAY);
            else
                spinnerTextView.setTextColor(ContextCompat.getColor(context, R.color.colorTextPrimary));
            return view;
        }
    }
}