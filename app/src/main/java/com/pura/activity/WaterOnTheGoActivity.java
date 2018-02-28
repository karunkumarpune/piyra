package com.pura.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pura.R;
import com.pura.adapter.ProductAdapter;
import com.pura.model.Product;

import java.util.ArrayList;

public class WaterOnTheGoActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private ImageView ivBackImage;
    private TextView tvToolbarText;
    private ProductAdapter productAdapter;
    private ArrayList<Product> productArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_on_the_go);


        getId();
        setListener();
        setData();
    }

    private void getId() {
        toolbar = (Toolbar) findViewById(R.id.include_toolbar_water_on_the_go);
        tvToolbarText = toolbar.findViewById(R.id.toolbar_text);
        ivBackImage = toolbar.findViewById(R.id.iv_back_image);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_solutions);
    }

    private void setListener() {
        ivBackImage.setOnClickListener(this);
    }

    private void setData() {
        productArrayList = getProductArrayList();
        tvToolbarText.setText("Water On The Go");
        productAdapter = new ProductAdapter(this, productArrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(productAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_image:
                onBackPressed();
                break;


        }
    }


    private ArrayList<Product> getProductArrayList() {
        ArrayList<Product> productList = new ArrayList<>();
        Product p1 = new Product("Product Name", "$90", "20 %");
        Product p2 = new Product("Product Name", "$90", "30 %");
        Product p3 = new Product("Product Name", "$90", "10 %");
        Product p4 = new Product("Product Name", "$90", "50 %");
        Product p5 = new Product("Product Name", "$90", "80 %");
        Product p6 = new Product("Product Name", "$90", "20 %");
        Product p7 = new Product("Product Name", "$90", "10 %");
        Product p8 = new Product("Product Name", "$90", "40 %");
        Product p9 = new Product("Product Name", "$90", "20 %");

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        productList.add(p6);
        productList.add(p7);
        productList.add(p8);
        productList.add(p9);

        return productList;
    }

}
