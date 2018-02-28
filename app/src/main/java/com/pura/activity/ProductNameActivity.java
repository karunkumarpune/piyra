package com.pura.activity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.pura.R;
import com.pura.adapter.ImageListAdapter;
import com.pura.fragment.ProductDetailsFragment;
import com.pura.model.Contaminants;
import com.pura.model.ImageList;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.O;

public class ProductNameActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ImageView ivBackImage;
    private TextView tvToolbarText;
    private RecyclerView recyclerView;
    private ArrayList<ImageList> imageLists;
    private ImageListAdapter imageListAdapter;
    private TextView tvDescriptionString;
    private FrameLayout frameLayout;
    private TextView tvBuyNow;
    private TextView tvCompare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_name);

        getId();
        setListener();
        setData();
    }

    private void getId() {
        toolbar = (Toolbar) findViewById(R.id.include_toolbar_product_name_activity);
        ivBackImage = toolbar.findViewById(R.id.iv_back_image);
        tvToolbarText = toolbar.findViewById(R.id.toolbar_text);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_horizontal);
        //tvDescriptionString = (TextView) findViewById(R.id.tv_description_string);
        frameLayout = (FrameLayout) findViewById(R.id.web_view_container);
        tvBuyNow = (TextView) findViewById(R.id.tv_buy_now);
        tvCompare = (TextView) findViewById(R.id.tv_compare);
    }

    private void setListener() {
        ivBackImage.setOnClickListener(this);
        tvBuyNow.setOnClickListener(this);
        tvCompare.setOnClickListener(this);
    }

    private void setData() {
        imageLists = getImageArrayList();
        tvToolbarText.setText("Product Name");
        imageListAdapter = new ImageListAdapter(this, imageLists);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        recyclerView.setAdapter(imageListAdapter);

        getSupportFragmentManager().beginTransaction().add(R.id.web_view_container, new ProductDetailsFragment()).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_image:
                onBackPressed();
                break;

            case R.id.tv_buy_now:
                startActivity(new Intent(this, OrderReviewActivity.class));
                break;

            case R.id.tv_compare:
                startActivity(new Intent(this, CompareProductsActivity.class));
                break;
        }
    }

    private ArrayList<ImageList> getImageArrayList() {
        //String imageUri = "drawable://" + R.drawable.temp_contaminant;

        String imageUri = getURLForResource(R.drawable.temp_contaminant);
        ArrayList<ImageList> imageListArrayList = new ArrayList<>();
        ImageList imageList = new ImageList(imageUri);
        ImageList imageList1 = new ImageList(imageUri);
        ImageList imageList2 = new ImageList(imageUri);
        ImageList imageList3 = new ImageList(imageUri);
        ImageList imageList4 = new ImageList(imageUri);

        imageListArrayList.add(imageList);
        imageListArrayList.add(imageList1);
        imageListArrayList.add(imageList2);
        imageListArrayList.add(imageList3);
        imageListArrayList.add(imageList4);
        return imageListArrayList;
    }


    public String getURLForResource(int resourceId) {
        return Uri.parse("android.resource://" + R.class.getPackage().getName() + "/" + resourceId).toString();
    }
}
