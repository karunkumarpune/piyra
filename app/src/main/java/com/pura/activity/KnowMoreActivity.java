package com.pura.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.pura.R;

public class KnowMoreActivity extends BaseActivity {


    private LinearLayout layoutWaterQualityInMyPlace;
    private LinearLayout layoutKnowAboutWater;
    private LinearLayout layoutAboutOtherPlaces;
    private LinearLayout layoutHomeSolutions;
    private LinearLayout layoutBusinessSolutions;
    private LinearLayout layoutWaterOnTheGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_know_more);
        getId();
        setListener();
        setData();

    }

    private void getId() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_know_more, frameLayout);
        layoutWaterQualityInMyPlace = view.findViewById(R.id.layout_water_quality_in_my_place);
        layoutKnowAboutWater = view.findViewById(R.id.layout_know_about_water);
        layoutAboutOtherPlaces = view.findViewById(R.id.layout_about_other_places);
        layoutHomeSolutions = view.findViewById(R.id.layout_home_solutions);
        layoutBusinessSolutions = view.findViewById(R.id.layout_business_solutions);
        layoutWaterOnTheGo = view.findViewById(R.id.layout_water_on_the_go);
    }

    private void setListener() {
        layoutWaterQualityInMyPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KnowMoreActivity.this, WaterQualityInMyPlaceActivity.class));
            }
        });

        layoutKnowAboutWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KnowMoreActivity.this, WaterContaminatsActivity.class);
                startActivity(intent);
            }
        });
        layoutAboutOtherPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(KnowMoreActivity.this, AboutOtherPlacesActivity.class));
            }
        });
        layoutHomeSolutions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KnowMoreActivity.this, HomeSolutionsActivity.class));
            }
        });
        layoutBusinessSolutions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KnowMoreActivity.this, BusinessSolutionActivity.class));
            }
        });
        layoutWaterOnTheGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KnowMoreActivity.this, WaterOnTheGoActivity.class));
            }
        });
    }

    private void setData() {

    }


   /* @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_water_quality_in_my_place:
                openWaterQualityInMyPlaceActivity();
                break;

            case R.id.layout_know_about_water:
                Intent intent = new Intent(this, WaterContaminatsActivity.class);
                startActivity(intent);
                break;

            case R.id.layout_about_other_places:
                //startActivity(new Intent(this, AboutOtherPlacesActivity.class));
                break;
            case R.id.layout_home_solutions:
                startActivity(new Intent(this, HomeSolutionsActivity.class));
                break;
            case R.id.layout_business_solutions:
                startActivity(new Intent(this, BusinessSolutionActivity.class));
                break;
            case R.id.layout_water_on_the_go:
                startActivity(new Intent(this, WaterOnTheGoActivity.class));
                break;
        }

    }*/

    private void openWaterQualityInMyPlaceActivity() {
        startActivity(new Intent(this, WaterQualityInMyPlaceActivity.class));
    }
}
