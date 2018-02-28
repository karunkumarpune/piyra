package com.pura.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.pura.R;

import java.util.ArrayList;

/**
 * Created by Manish-Pc on 13/02/2018.
 */

public class LanguageListAdapter extends ArrayAdapter {

    private ArrayList<String> languageList;
    private RadioGroup radioGroup;
    private LinearLayout linearLayout;


    public LanguageListAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<String> languageList) {
        super(context, resource, languageList);
        this.languageList = languageList;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return languageList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            view = layoutInflater.inflate(R.layout.single_row_language_list, parent, false);
            radioGroup = view.findViewById(R.id.rg_language_list);
        }
        RadioButton radioButton = view.findViewById(R.id.rb_language_list);
        radioGroup.addView(radioButton);
        radioButton.setText(languageList.get(position));
        return view;
    }
}
