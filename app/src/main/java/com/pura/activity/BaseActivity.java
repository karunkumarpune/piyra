package com.pura.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.util.CircularArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pura.R;
import com.pura.utils.Constants;
import com.pura.utils.Utils;

import de.hdodenhof.circleimageview.CircleImageView;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ImageView hamburger;
    private ImageView ivNotification;
    private Utils utils;
    private CircleImageView circleImageView;

    private RelativeLayout layoutHome;
    private RelativeLayout layoutMyOrders;
    private RelativeLayout layoutCompareProducts;
    private RelativeLayout layoutSettings;
    private RelativeLayout layoutLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        getId();
        setListeners();
    }

    private void getId() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        toolbar = (Toolbar) findViewById(R.id.include_toolbar_base_activity);


        // Hamburger
        hamburger = toolbar.findViewById(R.id.iv_hamburger);

        // Text on Center
        TextView toolbarText = toolbar.findViewById(R.id.toolbar_text);

        if (this instanceof HavePuraActivity) {
            toolbarText.setText(Constants.TXT_HAVE_PURA);
        } else if (this instanceof KnowMoreActivity) {
            toolbarText.setText(Constants.TXT_KNOW_MORE);
        }


        // Notification
        ivNotification = toolbar.findViewById(R.id.iv_notification);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        utils = new Utils(this);

        circleImageView = (CircleImageView) findViewById(R.id.civ_edit_profile);

        //Sidebar Items
        layoutHome = (RelativeLayout) findViewById(R.id.layout_sidebar_home);
        layoutMyOrders = (RelativeLayout) findViewById(R.id.layout_sidebar_my_orders);
        layoutCompareProducts = (RelativeLayout) findViewById(R.id.layout_sidebar_compare_products);
        layoutSettings = (RelativeLayout) findViewById(R.id.layout_sidebar_settings);
        layoutLogout = (RelativeLayout) findViewById(R.id.layout_sidebar_logout);

    }

    private void setListeners() {
        hamburger.setOnClickListener(this);
        ivNotification.setOnClickListener(this);
        circleImageView.setOnClickListener(this);

        layoutHome.setOnClickListener(this);
        layoutMyOrders.setOnClickListener(this);
        layoutCompareProducts.setOnClickListener(this);
        layoutSettings.setOnClickListener(this);
        layoutLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_hamburger:
                openDrawer();
                break;

            case R.id.iv_notification:
                openNotificationActivity();
                break;

            case R.id.civ_edit_profile:
                openEditProfileActivity();
                break;

            case R.id.layout_sidebar_home:
                openMainActivity();
                break;

            case R.id.layout_sidebar_my_orders:
                openMyOrdersActivity();
                break;

            case R.id.layout_sidebar_compare_products:
                openCompareProductsActivity();
                break;

            case R.id.layout_sidebar_settings:
                openSettingsActivity();
                break;

            case R.id.layout_sidebar_logout:
                logout();
                break;
        }
    }

    private void openCompareProductsActivity() {
        Intent compareProductsIntent = new Intent(this, CompareProductsActivity.class);
        startActivity(compareProductsIntent);
    }

    private void openMyOrdersActivity() {
        Intent myOrdersIntent = new Intent(this, MyOrdersActivity.class);
        startActivity(myOrdersIntent);
    }

    private void openSettingsActivity() {
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);
    }

    private void logout() {
        Intent signInIntent = new Intent(this, SignInActivity.class);
        signInIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(signInIntent);
        finish();
    }

    private void openMainActivity() {
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(mainActivityIntent);
        finish();
    }

    private void openEditProfileActivity() {
        drawerLayout.closeDrawer(Gravity.START);
        Intent editProfileIntent = new Intent(this, EditProfileActivity.class);
        startActivity(editProfileIntent);
    }

    private void openNotificationActivity() {
        utils.log("TEST", "Opening Notification Activity");
        Intent notificationIntent = new Intent(this, NotificationActivity.class);
        startActivity(notificationIntent);
    }

    private void openDrawer() {
        drawerLayout.openDrawer(Gravity.START);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.closeDrawer(Gravity.START);
        } else {
            super.onBackPressed();
        }
    }

    private void closeDrawer() {
        drawerLayout.closeDrawer(Gravity.START);
    }
}