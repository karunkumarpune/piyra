package com.pura.utils;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.pura.R;

/**
 * Created by Manish-Pc on 13/02/2018.
 */

public class Utils {

    private boolean SHOW_LOG = true;

    private Context context;

    public Utils(Context context) {
        this.context = context;
    }

    public void toast(String message) {
        Toast.makeText(context, "" + message, Toast.LENGTH_SHORT).show();
    }

    public void log(String tag, String message) {
        if (SHOW_LOG)
            Log.d(String.valueOf(tag), String.valueOf(message));
    }

    public void snackbar(String message) {
        Snackbar snackbar = Snackbar.make(((Activity) context).findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        snackbar.show();
    }


    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(((Activity) context).findViewById(android.R.id.content).getWindowToken(), 0);
    }
}
