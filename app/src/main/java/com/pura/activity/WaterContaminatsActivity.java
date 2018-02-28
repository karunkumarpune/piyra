package com.pura.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pura.R;
import com.pura.adapter.ContaminantAdapter;
import com.pura.model.Contaminants;
import com.pura.utils.Utils;

import java.util.ArrayList;

public class WaterContaminatsActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView tvToolbarText;
    private ImageView ivBackImage;
    private RecyclerView recyclerView;
    private ArrayList<Contaminants> contaminantsArrayList;
    private ContaminantAdapter adapter;
    private Utils utils;
    private LinearLayout bottomMenuLayout;
    private LinearLayout layoutHome;
    private LinearLayout layoutBusinessSolutions;
    private LinearLayout layoutWaterOnTheGo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_contaminats);

        getId();
        setListener();
        setData();
    }

    private void getId() {
        toolbar = (Toolbar) findViewById(R.id.include_toolbar_water_contaminates);
        ivBackImage = toolbar.findViewById(R.id.iv_back_image);
        tvToolbarText = toolbar.findViewById(R.id.toolbar_text);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_water_contaminant);

        bottomMenuLayout = (LinearLayout) findViewById(R.id.include_bottom_menu_contaminats);
        layoutHome = bottomMenuLayout.findViewById(R.id.layout_bottom_home);
        layoutBusinessSolutions = bottomMenuLayout.findViewById(R.id.layout_bottom_business_solution);
        layoutWaterOnTheGo = bottomMenuLayout.findViewById(R.id.layout_bottom_water_on_the_go);

    }

    private void setListener() {
        ivBackImage.setOnClickListener(this);
        layoutHome.setOnClickListener(this);
        layoutBusinessSolutions.setOnClickListener(this);
        layoutWaterOnTheGo.setOnClickListener(this);
    }

    private void setData() {
        utils = new Utils(this);
        contaminantsArrayList = getContaminantsArrayList();
        tvToolbarText.setText("Water Contaminants");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContaminantAdapter(this, contaminantsArrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_image:
                onBackPressed();
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


    private ArrayList<Contaminants> getContaminantsArrayList() {
        //String imageUri = "drawable://" + R.drawable.temp_contaminant;

        String imageUri = getURLForResource(R.drawable.temp_contaminant);
        utils.log("TEST", "Image Uri : " + imageUri);
        ArrayList<Contaminants> contaminantsArrayList = new ArrayList<>();
        Contaminants contaminants = new Contaminants(imageUri);
        Contaminants contaminants2 = new Contaminants(imageUri);
        Contaminants contaminant3 = new Contaminants(imageUri);
        Contaminants contaminant4 = new Contaminants(imageUri);
        Contaminants contaminant5 = new Contaminants(imageUri);
        contaminantsArrayList.add(contaminants);
        contaminantsArrayList.add(contaminants2);
        contaminantsArrayList.add(contaminant3);
        contaminantsArrayList.add(contaminant4);
        contaminantsArrayList.add(contaminant5);
        return contaminantsArrayList;
    }

    public String getURLForResource(int resourceId) {
        return Uri.parse("android.resource://" + R.class.getPackage().getName() + "/" + resourceId).toString();
    }
}
