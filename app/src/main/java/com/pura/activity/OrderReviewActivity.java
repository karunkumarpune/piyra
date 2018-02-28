package com.pura.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pura.R;
import com.pura.adapter.OrderReviewAdapter;
import com.pura.model.OrderItem;

import java.util.ArrayList;

import static android.R.attr.order;

public class OrderReviewActivity extends AppCompatActivity implements View.OnClickListener {


    private Toolbar toolbar;
    private ImageView ivBackImage;
    private TextView tvToolbarText;

    private ArrayList<OrderItem> orderItemArrayList;
    private ListView listView;
    private OrderReviewAdapter orderReviewAdapter;
    private Button btnSelectDeliveryOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_review);

        getId();
        setListener();
        setData();
    }

    private void getId() {
        toolbar = (Toolbar) findViewById(R.id.include_toolbar_order_review);
        tvToolbarText = toolbar.findViewById(R.id.toolbar_text);
        ivBackImage = toolbar.findViewById(R.id.iv_back_image);

        listView = (ListView) findViewById(R.id.list_view_order_review);
        btnSelectDeliveryOption = (Button) findViewById(R.id.btn_select_delivery_options);

    }

    private void setListener() {
        btnSelectDeliveryOption.setOnClickListener(this);
        ivBackImage.setOnClickListener(this);
    }

    private void setData() {
        tvToolbarText.setText("Order Review");
        orderItemArrayList = getOrderItemList();

        if (orderItemArrayList.isEmpty()) {
            btnSelectDeliveryOption.setText("Explore More");
        }
        orderReviewAdapter = new OrderReviewAdapter(this, R.layout.single_row_order_review, orderItemArrayList);
        listView.setAdapter(orderReviewAdapter);


    }

    private ArrayList<OrderItem> getOrderItemList() {
        ArrayList<OrderItem> orderItemsList = new ArrayList<>();
        OrderItem orderItem = new OrderItem("Item Name", "$90", "3");
        OrderItem orderItem2 = new OrderItem("Item Name", "$60", "1");

        orderItemsList.add(orderItem);
        orderItemsList.add(orderItem2);

        return orderItemsList;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_image:
                onBackPressed();
                break;

            case R.id.btn_select_delivery_options:

                break;
        }
    }
}
