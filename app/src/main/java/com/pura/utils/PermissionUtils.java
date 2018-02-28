package com.pura.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Manish-Pc on 18/02/2018.
 */

public class PermissionUtils {
    private static final int REQUEST_PERMISSION_SETTING = 87;
    private Context context;
    private Activity activity;
    private SharedPreferences permissionPreferences;
    private boolean sentToSettings = false;


    public PermissionUtils(Context context) {
        this.context = context;
        activity = (Activity) context;
        permissionPreferences = context.getSharedPreferences("permission_pref", MODE_PRIVATE);
    }

    public boolean checkPermission(final String permissionName, final int permissionConstant,
                                    String alertMessageTitle, String alertMessageDescription) {
        boolean permissionStatus = false;
        if (ActivityCompat.checkSelfPermission(context, permissionName) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permissionName)) {
                //Show In-formation about why you need the permission
                showAlertDialog(alertMessageTitle, alertMessageDescription, permissionName, permissionConstant);
            } else if (permissionPreferences.getBoolean(permissionName, false)) {
                //Previously Permission Request was cancelled with Don't Ask Again,
                // Redirect to Settings after showing Information about why you need the permission
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(alertMessageTitle);
                builder.setMessage(alertMessageDescription);
                builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        sentToSettings = true;
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                        intent.setData(uri);

                        activity.startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            } else {
                // Request Permission
                ActivityCompat.requestPermissions(activity, new String[]{permissionName}, permissionConstant);
            }

            SharedPreferences.Editor editor = permissionPreferences.edit();
            editor.putBoolean(permissionName, true);
            editor.commit();
        } else {
            permissionStatus = true;
        }
        return permissionStatus;
    }


    private void showAlertDialog(String alertMessageTitle, String alertMessageDescription,
                                 final String permissionName, final int permissionConstant) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(alertMessageTitle);
        builder.setMessage(alertMessageDescription);
        builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                ActivityCompat.requestPermissions(activity, new String[]{permissionName}, permissionConstant);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }


    public boolean checkPermissionOnActivityResult(int[] grantResults, final String permissionName, final int permissionConstant, String alertTitle, String alertMessage) {
        boolean permissionStatus = false;
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //The External Storage Write Permission is granted to you... Continue your left job...
            //displayPlacePicker();
            permissionStatus = true;
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permissionName)) {
                //Show Information about why you need the permission
                showAlertDialog(alertTitle, alertMessage, permissionName, permissionConstant);
            } else {
                //AppUtils.showToast(CompleteProfileActivityRecorder.this, "Unable to get Permission");
            }
        }
        return permissionStatus;
    }
}