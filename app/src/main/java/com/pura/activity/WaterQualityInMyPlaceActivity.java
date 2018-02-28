package com.pura.activity;

import android.content.Intent;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pura.R;
import com.pura.utils.Utils;

public class WaterQualityInMyPlaceActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ImageView ivBackImage;
    private ImageView ivCurrentLocation;
    private TextView tvToolbarText;
    private LinearLayout bottomMenuLayout;
    private LinearLayout layoutHome;
    private LinearLayout layoutBusinessSolutions;
    private LinearLayout layoutWaterOnTheGo;
    private Utils utils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_quality_in_my_place);

        getId();
        setListener();
        setData();
    }

    private void getId() {
        utils = new Utils(this);
        toolbar = (Toolbar) findViewById(R.id.include_toolbar_water_quality_in_my_place);
        ivBackImage = toolbar.findViewById(R.id.iv_hamburger);
        ivCurrentLocation = toolbar.findViewById(R.id.iv_notification);
        tvToolbarText = toolbar.findViewById(R.id.toolbar_text);
        bottomMenuLayout = (LinearLayout) findViewById(R.id.include_bottom_menu);
        layoutHome = bottomMenuLayout.findViewById(R.id.layout_bottom_home);
        layoutBusinessSolutions = bottomMenuLayout.findViewById(R.id.layout_bottom_business_solution);
        layoutWaterOnTheGo = bottomMenuLayout.findViewById(R.id.layout_bottom_water_on_the_go);
    }

    private void setListener() {
        ivBackImage.setOnClickListener(this);
        ivCurrentLocation.setOnClickListener(this);
        layoutHome.setOnClickListener(this);
        layoutBusinessSolutions.setOnClickListener(this);
        layoutWaterOnTheGo.setOnClickListener(this);
    }

    private void setData() {
        ivBackImage.setImageResource(R.drawable.back_white);
        tvToolbarText.setText("Water Quality in My Place");
        ivCurrentLocation.setImageResource(R.drawable.location);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_hamburger:
                onBackPressed();
                break;

            case R.id.iv_notification:
                // Open Current Location.
                break;

            case R.id.layout_bottom_home:
                openHomeSolutionsActivity();
                //utils.toast("Home");
                break;

            case R.id.layout_bottom_business_solution:
                openBusinessSolutionsActivity();
                //utils.toast("Business Solution");
                break;
            case R.id.layout_bottom_water_on_the_go:
                openWaterOnTheGoActivity();
                //utils.toast("Water On the Go");
                break;
        }
    }

    private void openHomeSolutionsActivity() {
        Intent intent = new Intent(this, HomeSolutionsActivity.class);
        startActivity(intent);
    }

    private void openWaterOnTheGoActivity() {
        Intent intent = new Intent(this, WaterOnTheGoActivity.class);
        startActivity(intent);
    }

    private void openBusinessSolutionsActivity() {
        Intent intent = new Intent(this, BusinessSolutionActivity.class);
        startActivity(intent);
    }
}
