package com.pura.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Manish-Pc on 13/02/2018.
 */

public class MyPreferences {

    private static final String FILE_NAME = "pura_pref";
    public static final String IS_LANGUAGE_SELECTED = "is_language_selected";


    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public MyPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveStringData(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String getStringData(String key) {
        return sharedPreferences.getString(key, "---");
    }

    public void saveBooleanData(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }


    public boolean getBooleanData(String key) {
        return sharedPreferences.getBoolean(key, false);
    }
}